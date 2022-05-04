package com.br.algo.math.lib.ntheory.exponentiantion.matrix.fibonacci

// https://www.nayuki.io/res/fast-fibonacci-algorithms/FastFibonacci.java
import java.math.BigInteger

typealias BigInt = BigInteger
typealias BigIntMatrix = Array<Array<BigInt>>

fun nthBigInt(n: Long): BigIntMatrix {
    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]
    fun nth(mat: BigIntMatrix, n: Long): BigIntMatrix {
        fun multiply(p: BigIntMatrix, q: BigIntMatrix): BigIntMatrix {
            val r = arrayOf(
                p[0, 0] * q[0, 0] + p[0, 1] * q[1, 0],
                p[0, 0] * q[0, 1] + p[0, 1] * q[1, 1]
            )
            val s = arrayOf(
                p[1, 0] * q[0, 0] + p[1, 1] * q[1, 0],
                p[1, 0] * q[0, 1] + p[1, 1] * q[1, 1]
            )
            return arrayOf(r, s)
        }

        var cn = n
        var cpy = mat
        var res = arrayOf(
            arrayOf(BigInt.ONE, BigInt.ONE),
            arrayOf(BigInt.ONE, BigInt.ZERO)
        )
        while (cn > 0) {
            if (cn and 1L == 1L) {
                res = multiply(res, cpy)
            }
            cn = cn shr 1
            cpy = multiply(cpy, cpy)
        }
        return res
    }

    val s = arrayOf(
        arrayOf(arrayOf(BigInt.ONE, BigInt.ONE), arrayOf(BigInt.ONE, BigInt.ZERO)),
        arrayOf(arrayOf(BigInt.ZERO, BigInt.ZERO), arrayOf(BigInt.ZERO, BigInt.ONE))
    )
    return nth(s[0], n)
}

private fun checkNthBigInt() {
    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]
    (1L..100L).forEach {
        val arr = nthBigInt(it)
        println(
            String.format(
                "fb(%d): %d, %d, %d, %d", it,
                arr[0, 0], arr[0, 1], arr[1, 0], arr[1, 1]
            )
        )
    }
}

fun main() {
    checkNthBigInt()
}