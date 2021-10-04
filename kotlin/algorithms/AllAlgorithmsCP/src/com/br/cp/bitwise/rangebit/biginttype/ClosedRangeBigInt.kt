package src.com.br.cp.bitwise.rangebit.biginttype


import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

typealias BigInt = BigInteger

val BigInt.rangeBit: ClosedRange<BigInt>
    get() {
        return if (this < BigInt("2")) {
            ZERO..ONE

        } else {
            ONE.shl((this - ONE).toInt())..ONE.shl(this.toInt())
        }
    }

fun main() {
    println(BigInt("64").rangeBit)
    println(BigInt("128").rangeBit)
    println(BigInt("512").rangeBit)
}