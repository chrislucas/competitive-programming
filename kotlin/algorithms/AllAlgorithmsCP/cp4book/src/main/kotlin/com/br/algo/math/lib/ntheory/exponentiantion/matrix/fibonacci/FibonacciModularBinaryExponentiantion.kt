package com.br.algo.math.lib.ntheory.exponentiantion.matrix.fibonacci

import kotlin.system.measureTimeMillis

/**
 * https://cp-algorithms.com/algebra/binary-exp.html
 * https://cp-algorithms.com/algebra/fibonacci-numbers.html
 */


fun fastdoubling(n: Int): Array<Int> {
    /**
     * representacao matricial
     */
    val matrix = arrayOf(0, 1)
    var cn = n
    while (cn > 0) {
        val a = matrix[0] * (2 * matrix[1] - matrix[0])
        val b = matrix[0] * matrix[0] + matrix[1] * matrix[1]
        if (cn and 1 == 1) {
            matrix[0] = b
            matrix[1] = a + b
        } else {
            matrix[0] = a
            matrix[1] = b
        }
        cn = cn shr 1
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

private fun checkFastdoubling() {
    (1..20).forEach {
        val (a, b) = fastdoubling(it)
        val (c, d) = recursiveFastDoubling(it)
        println(
            "FastDoubling(%d) = [%d, %d] - RecFastDoubling(%d)[%d, %d] %s|%s"
                .format(it, a, b, it, c, d, a == c, b == d)
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
    checkFastdoubling()
}