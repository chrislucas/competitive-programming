package src.com.br.cp.algebra.number.systems

import java.lang.Math.pow
import kotlin.math.log2
import kotlin.math.pow

/**
 * https://youtu.be/LlEeD2WV5j8
 * https://pt.wikipedia.org/wiki/C%C3%B3digo_de_Gray
 *
 * https://mathworld.wolfram.com/GrayCode.html
 *
 * */

fun Int.countDigits(base: Int): Int = (log2(this * 1.0) / log2(base * 1.0)).toInt() + 1

val Int.countBinaryDigits: Int
    get() = log2(this * 1.0).toInt() + 1

val Int.nextPowerOf2: Int
    get() {
        var value = this
        value -= 1
        value = value or (value shr 1)
        value = value or (value shr 2)
        value = value or (value shr 4)
        value = value or (value shr 8)
        value = value or (value shr 16)
        return value + 1
    }

val Int.grayEncode: Int
    get() = this xor (this shr 1)

val Int.grayDecode: Int
    get() {
        var g = this
        var decoded = 0
        while (g > 0) {
            decoded = decoded xor g
            g = g shr 1
        }
        return decoded
    }

val Int.binaryForm: String
    get() {
        if (this == 0)
            return "0"
        var value = this
        val buffer = StringBuilder()
        while (value > 0) {
            buffer.append(value and 1)
            value = value shr 1
        }
        return buffer.toString().reversed()
    }

private val Int.binaryWithTrailingZeros: String
    get() {
        if (this == 0)
            return "0"

        var number = this
        val buffer = StringBuilder()
        while (number > 0) {
            buffer.append(number and 1)
            number = number shr 1
        }

        fun countBinaryDigits(value: Int) = log2(value * 1.0).toInt() + 1

        fun nextPowerOf2(mValue: Int): Int {
            var value = mValue
            value -= 1
            value = value or (value shr 1)
            value = value or (value shr 2)
            value = value or (value shr 4)
            value = value or (value shr 8)
            value = value or (value shr 16)
            return value + 1
        }

        val next = nextPowerOf2(this)
        val bin = buffer.toString().reversed()
        return if (buffer.length == countBinaryDigits(next)) {
            bin
        } else {
            val zeros = StringBuilder()
            repeat(countBinaryDigits(next) - countBinaryDigits(this)) {
                zeros.append("0")
            }
            zeros.append(bin).toString()
        }
    }

private fun checkBinaryRepresentation() {
    arrayOf(1, 2, 3, 4, 7, 10, 100, 127, 511, 512, 513).forEach {
        println(
            "$it -> ${it.binaryWithTrailingZeros}, DigitsBase10 ${it.countDigits(10)}, DigitsBase2 ${
                it.countDigits(
                    2
                )
            }"
        )
    }
}

private fun checkGrayEncodeProperty() {
    val data = arrayOf(
        (0..7),
        (8..15),
        (16..31),
        (32..63),
    )
    data.forEach { range ->
        println(range)
        range.forEach {
            println("$it -> ${it.grayEncode} -> ${it.binaryForm} -> ${it.grayEncode.binaryForm} -> ${it.grayEncode.grayDecode}")
        }
        println("")
    }
}

private fun checkGrayEncodeDecode() {
    val qBits = 8
    var range = 0 .. 1
    for (i in 1 until qBits) {
        println("Bits: $i, Range: $range")
        range.forEach {
            println("$it(${it.binaryForm}) | GrayEnc: ${it.grayEncode}(${it.grayEncode.binaryForm}) | GrayDec: ${it.grayEncode.grayDecode}")
        }
        range = range.last + 1 until (1 shl i+1) // 2.0.pow((i + 1) * 1.0).toInt()
        println("")
    }
}

fun main() {
    checkGrayEncodeDecode()
}