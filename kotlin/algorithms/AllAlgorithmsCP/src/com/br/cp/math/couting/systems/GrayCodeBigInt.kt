package src.com.br.cp.math.couting.systems

import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

typealias BigInt = BigInteger

/**
 * fonte
 * https://www.tutorialspoint.com/what-is-gray-code
 *
 * Gray Code = Reflected Binary Code
 *
 * */

infix fun BigInt.mod(value: String): BigInt = this.mod(BigInt(value))

fun String.toBigInt(): BigInt = BigInt(this)

val BigInt.binary: String
    get() {
        var value = this
        val buffer = StringBuilder()

        while (value > ZERO) {
            buffer.append(value mod "2")
            value = value shr 1
        }

        return buffer.toString().reversed()
    }

val BigInt.grayEncode: BigInt
    get() = this xor (this shr 1)


val BigInt.grayDecode: BigInt
    get() {
        var g = this
        var decoded = ZERO
        while (g > ZERO) {
            decoded = decoded xor g
            g = g shr 1
        }
        return decoded
    }

private fun test() {
    println("1023".toBigInt().binary)
    println("127".toBigInt().binary)
    println("128".toBigInt().binary)
    println("132456487".toBigInt().binary)
}

infix fun BigInt.until(other: BigInt): ClosedRange<BigInt> = this..(other - ONE)

val BigInt.rangeBit: ClosedRange<BigInt>
    get() {
        return if (this < BigInt("2")) {
            ZERO..ONE

        } else {
            ONE.shl((this - ONE).toInt())..ONE.shl(this.toInt())
        }
    }


val Int.rangeBit: ClosedRange<BigInt>
    get() {
        return if (this < 2) {
            ZERO..ONE

        } else {
            ONE.shl((this - 1).toInt()) until ONE.shl(this.toInt())
        }
    }

private fun testGrayEncodeDecode() {
    testRangeBitsGrayEncodeDecode(1..5)
}

private fun testRangeBitsGrayEncodeDecode(rangeOfBits: IntRange) {
    for (i in rangeOfBits) {
        val range = i.rangeBits
        println("Bits: $i, Range: $range")
        range.forEach { int ->
            val bigInt = BigInt("$int")
            println("$bigInt(${bigInt.binary}) | GrayEnc: ${bigInt.grayEncode}(${bigInt.grayEncode.binary}) | GrayDec: ${bigInt.grayDecode}")
        }
        println("")
    }
}


fun main() {
    testRangeBitsGrayEncodeDecode(31..32)
}