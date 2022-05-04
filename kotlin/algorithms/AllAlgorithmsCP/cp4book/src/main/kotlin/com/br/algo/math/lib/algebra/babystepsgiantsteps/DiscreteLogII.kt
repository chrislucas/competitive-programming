package com.br.algo.math.lib.algebra.babystepsgiantsteps

import kotlin.math.sqrt

/**
 * https://www.geeksforgeeks.org/discrete-logarithm-find-integer-k-ak-congruent-modulo-b/
 * Dado 3 inteiros, a b e m, sendo a e m coprimos, verificar se existe um numero k tal que
 * a ^ k congruente b (mod m)
 *
 * Se exister retorne o do contrario retornar -1
 *
 * Um algoritmo ingenuo seria tentar um valor k dentro do intervalo [0, m].
 * Esse algoritmo tem complexidade O(m)
 *
 * Algoritmo baby-step giant-step
 */


fun discreteLogSolverI(a: Int, b: Int, m: Int): Int {
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
    val values = mutableMapOf<Int, Int>()

    return -1
}

fun main() {

}