package src.com.br.cp.bitwise.rangebit.inttype

import src.com.br.cp.bitwise.systems.rangeBit
import src.com.br.cp.bitwise.systems.until
import java.math.BigInteger

typealias BigInt = BigInteger

val Int.rangeBit: ClosedRange<BigInt>
    get() {
        return if (this < 2) {
            BigInteger.ZERO..BigInteger.ONE
        } else {
            BigInteger.ONE.shl((this - 1).toInt()) until BigInteger.ONE.shl(this.toInt())
        }
    }


fun main() {
    println(64.rangeBit)
    println(128.rangeBit)
    println(512.rangeBit)
}