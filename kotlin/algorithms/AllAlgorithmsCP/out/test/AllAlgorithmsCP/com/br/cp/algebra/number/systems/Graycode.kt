package com.br.cp.algebra.number.systems

import kotlin.math.log2

/**
 * https://youtu.be/LlEeD2WV5j8
 * https://pt.wikipedia.org/wiki/C%C3%B3digo_de_Gray
 *
 * https://mathworld.wolfram.com/GrayCode.html
 *
 * */

val Int.countBinaryDigits: Int
    get() = log2(this * 1.0).toInt() + 1

val Int.toBinary: String
    get() {
        var value = this
        val buffer = StringBuilder()
        while (value > 0) {
            buffer.append(value % 2)
            value = value shr 1
        }
        return buffer.toString().reversed()
    }

private val Int.binaryString: String
    get() {
        var value = this
        val buffer = StringBuilder()
        while (value > 0) {
            buffer.append(value % 2)
            value = value shr 1
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
        return if (buffer.length == countBinaryDigits(next)) {
            buffer.toString().reversed()
        } else {
            val zeros = StringBuilder()
            repeat(countBinaryDigits(next) - countBinaryDigits(this)) {
                zeros.append("0")
            }
            zeros.append(buffer.toString().reversed()).toString()
        }
    }


private fun test() {
    arrayOf(1, 2, 3, 4, 7, 10, 100, 127, 511, 512, 513).forEach {
        println("$it -> ${it.binaryString}, counter ${it.countDigits(10)}, counter ${it.countDigits(2)}")
    }
}

private fun grayEncodeDecInt(decInt: Int): String {
    val bin = decInt.toBinary
    val newString = StringBuilder()
    for (i in 1 until bin.length) {
        newString.append(if (bin[(bin.length - 1) - i] == '1') '0' else '1')
    }
    newString.append(bin[0])
    return newString.toString().reversed()
}

private fun testGrayEncodeDecInt() {
    (3..12).forEach {
        println("$it (${it.countBinaryDigits}) -> ${it.toBinary} -> ${grayEncodeDecInt(it)}")
    }
}

private fun grayDecodeBinInt(bin: String) {
    println(bin)
}

fun main() {
    test()
}