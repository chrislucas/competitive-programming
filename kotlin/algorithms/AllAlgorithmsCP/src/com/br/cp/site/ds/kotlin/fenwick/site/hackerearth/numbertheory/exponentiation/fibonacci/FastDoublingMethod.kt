package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.numbertheory.exponentiation.fibonacci


import java.math.BigInteger

typealias BigInt = BigInteger


private fun fibonacciFastDoubling(n: BigInt): Pair<BigInt, BigInt> {
    /*
        https://cp-algorithms.com/algebra/fibonacci-numbers.html#matrix-form
     */

    val two = BigInt("2")

    // fast doubling method
    fun fdm(n: BigInt): Pair<BigInt, BigInt> {
        if (n == BigInteger.ZERO) {
            return BigInteger.ZERO to BigInteger.ONE
        }
        val (p, q) = fdm(n shr 1)
        val c = p * (two * q - p)
        val d = p * p + q * q

        return if (n and BigInteger.ONE == BigInteger.ONE) {
            d to c + d
        } else {
            c to d
        }
    }

    return fdm(n)
}

private fun checkFibonacciFastDoubling() {
    /*
        https://r-knott.surrey.ac.uk/Fibonacci/fibtable.html
     */
    println(fibonacciFastDoubling(BigInt("12")))
    println(fibonacciFastDoubling(BigInt("20")))
    println(fibonacciFastDoubling(BigInt("100")))
    println(fibonacciFastDoubling(BigInt("300")))
    println(fibonacciFastDoubling(BigInt("500")))
}

fun main() {
    checkFibonacciFastDoubling()
}