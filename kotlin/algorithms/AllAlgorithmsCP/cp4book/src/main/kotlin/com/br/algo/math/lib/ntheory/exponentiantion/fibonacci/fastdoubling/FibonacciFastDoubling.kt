package com.br.algo.math.lib.ntheory.exponentiantion.fibonacci.fastdoubling

import kotlin.system.measureTimeMillis

/**
 * https://cp-algorithms.com/algebra/binary-exp.html
 * https://cp-algorithms.com/algebra/fibonacci-numbers.html
 * https://www.geeksforgeeks.org/fast-doubling-method-to-find-the-nth-fibonacci-number/
 */

fun fastdoubling(n: Int): Array<Int> {
    /**
     * representacao matricial
     */
    val matrix = arrayOf(0, 1)  // [f(n), f(n+1)]
    fun Int.toBinaryString(): String {
        val res = StringBuilder()
        var cpy = this
        while (cpy > 0) {
            res.append(if (cpy and 1 == 1) "1" else "0")
            cpy = cpy shr 1
        }
        return res.reverse().toString()
    }

    for (c in n.toBinaryString()) {
        val a = matrix[0] * (2 * matrix[1] - matrix[0])             // f(2n)
        val b = matrix[0] * matrix[0] + matrix[1] * matrix[1]       // f(2n+1)
        if (c == '1') {
            matrix[0] = b       // f(2n + 1)
            matrix[1] = a + b   // f(2n + 2)
        } else {
            matrix[0] = a   // f(2n)
            matrix[1] = b   // f(2n+1)
        }
    }
    return matrix
}

fun recursiveFastDoubling(n: Int): Array<Int> {
    return if (n == 0) {
        arrayOf(0, 1) // f(0) e f(1)
    } else {
        val res = recursiveFastDoubling(n shr 1)
        val c = res[0] * (2 * res[1] - res[0])
        val d = res[0] * res[0] + res[1] * res[1]
        if (n and 1 == 1) {
            arrayOf(d, c + d)
        } else {
            arrayOf(c, d)
        }
    }
}

private fun checkRecursiveAndInterativeSolution() {
    (1..20).forEach {
        val (a, b) = fastdoubling(it)
        val (c, d) = recursiveFastDoubling(it)
        println(
            "FastDoubling(%d) = [%d, %d] - RecFastDoubling(%d)[%d, %d] %s|%s"
                .format(
                    it, a, b,
                    it, c, d,
                    a == c,
                    b == d
                )
        )
    }
}

private fun checkBenchmarkFastDoubling() {
    (4..100).forEach {
        measureTimeMillis {
            val (a, b) = fastdoubling(it)
            println(
                "FastDoubling(%d) = [%d, %d] "
                    .format(it, a, b)
            )
        }
    }
}

private fun checkBenchmarkRecursiveFastDoubling() {
    (1..100).forEach {
        measureTimeMillis {
            val (a, b) = recursiveFastDoubling(it)
            println(
                "RecursiveFastDoubling(%d) = [%d, %d] "
                    .format(it, a, b)
            )
        }
    }
}

fun main() {
    checkRecursiveAndInterativeSolution()
}