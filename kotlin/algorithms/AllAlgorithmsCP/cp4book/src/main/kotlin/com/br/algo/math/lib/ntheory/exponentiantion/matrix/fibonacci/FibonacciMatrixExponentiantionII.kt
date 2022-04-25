package com.br.algo.math.lib.ntheory.exponentiantion.matrix.fibonacci

// https://www.nayuki.io/res/fast-fibonacci-algorithms/FastFibonacci.java
import java.math.BigInteger

typealias BigInt = BigInteger
typealias BigIntMatrix = Array<Array<BigInt>>

fun nth(n: Int): BigIntMatrix {
    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]

    fun nth(mat: BigIntMatrix, n: Int) {

        fun multiply(p: BigIntMatrix, q: BigIntMatrix) {

        }

        var cn = n
        while (cn > 0) {
            if (cn and 1 == 1) {

            }
            cn = cn shr 1
        }
    }

    val matrix = arrayOf(
        arrayOf(BigInt.ONE, BigInt.ONE),
        arrayOf(BigInt.ONE, BigInt.ZERO)
    )

    nth(matrix, n)

    return matrix
}


fun main() {

}