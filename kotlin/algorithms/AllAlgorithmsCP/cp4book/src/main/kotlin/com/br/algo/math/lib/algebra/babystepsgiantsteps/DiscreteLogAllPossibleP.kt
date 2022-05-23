package com.br.algo.math.lib.algebra.babystepsgiantsteps

import kotlin.math.sqrt

/**
 * https://cp-algorithms.com/algebra/discrete-log.html
 */

fun allSolutions(a: Int, b: Int, m: Int): List<Int> {
    fun exp(b: Int, e: Int, m: Int): Int {
        return when (e) {
            0 -> {
                1
            }
            1 -> {
                b % m
            }
            else -> {
                var acc = 1
                var ce = e
                var cb = b % m
                while (ce > 0) {
                    if (ce and 1 == 1) {
                        acc = (acc % m * cb % m) % m
                    }
                    cb = (cb % m * cb % m) % m
                    ce = ce shr 1
                }
                acc
            }
        }
    }

    val ca = a % m
    val cb = b % m
    val n = sqrt(m * 1.0).toInt() + 1 // o n da equacao

    val values = mutableMapOf<Int, MutableList<Int>>()

    // para todos os p's possiveis de 1 a n
    for (p in 1..n) {
        if (values[exp(ca, p * n, m)] == null) {
            values[exp(ca, p * n, m)] = mutableListOf(p)
        } else {
            values[exp(ca, p * n, m)]?.add(p)
        }
    }

    for (q in 0..n) {
        val current = (exp(a, q, m) % m * cb % m)
        if (values[current] != null) {
            return values[current]?.let {
                val list = mutableListOf<Int>()
                for (i in it) {
                    list.add(i * n - q)
                }
                list
            } ?: emptyList()
        }
    }
    return emptyList()
}


fun main() {

}