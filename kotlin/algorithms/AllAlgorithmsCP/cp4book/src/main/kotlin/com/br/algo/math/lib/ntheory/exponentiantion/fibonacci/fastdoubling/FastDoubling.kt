package com.br.algo.math.lib.ntheory.exponentiantion.fibonacci.fastdoubling

import java.math.BigInteger

/**
 * https://www.geeksforgeeks.org/fast-doubling-method-to-find-the-nth-fibonacci-number/
 * https://www.nayuki.io/page/fast-fibonacci-algorithms
 * Demonstracao da prova do algoritmo
 * https://math.stackexchange.com/questions/1124590/need-help-understanding-fibonacci-fast-doubling-proof
 */

typealias BigInt = BigInteger
typealias BigIntMatrix = Array<Array<BigInt>>


fun bigIntfastDoubling(e: BigInt) : Array<BigInt> {
    val one = BigInt.ONE
    val two = BigInt("2")
    val zero = BigInt.ZERO
    val res = arrayOf(zero, one) // [f(i), f(i+1)]
    fun BigInt.toBinaryString(): String {
        var cpy = this
        val buffer = StringBuilder()
        while (cpy > zero) {
            buffer.append(if (cpy and one == one) "1" else "0")
            cpy = cpy shr 1
        }
        return buffer.reverse().toString()
    }

    for (s in e.toBinaryString()) {
        val p = res[1] * res[1] + res[0] * res[0] // f(2i+1)
        val q = res[0] * (two * res[1] - res[0])    // f(2i)
        if (s == '1') {
            res[0] = p      // f(2i+1)
            res[1] = q + p  // f(2i+2)
        } else {
            res[0] = q // f(2i)
            res[1] = p // f(2i+1)
        }
    }
    return res
}

private fun checkFastDoubling() {
    (1L .. 100L).forEach {
        val (a, b) = bigIntfastDoubling(BigInt.valueOf(it))
        println("fib(%d) [%d, %d]".format(it, a, b))
    }
}

/**
 * https://www.geeksforgeeks.org/fast-doubling-method-to-find-the-nth-fibonacci-number/
 * f(n) = f(n-1) + f(n-2)
 * f(n+1) = f(n) + f(n-1)
 * f(2n) = f(n) * [2f(n+1) - f(n)]
 *
 * [f(n+1), f(n)] = [1 1 , 1 0] ^ n * [f(1) , f(0)]
 */
private fun checkProve(e: BigInt) {

    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]

    fun exp(mat: BigIntMatrix, e: BigInt): BigIntMatrix {
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

        var cpy = mat
        var res = mat
        var ce = e
        while (ce > BigInt.ZERO) {
            if (ce and BigInt.ONE == BigInt.ONE) {
                res = multiply(res, cpy)
            }
            ce = ce shr 1
            cpy = multiply(cpy, cpy)
        }
        return res
    }

    val matrix = arrayOf(
        arrayOf(BigInt.ONE, BigInt.ONE),
        arrayOf(BigInt.ONE, BigInt.ZERO)
    )
    val res = exp(matrix, e)
    println(
        String.format(
            "fb(%d): %d, %d, %d, %d", e,
            res[0, 0], res[0, 1], res[1, 0], res[1, 1]
        )
    )
}


fun main() {
    //checkProve(BigInt("100"))
    checkFastDoubling()
}