package com.br.algo.math.lib.algebra.babystepsgiantsteps

import kotlin.math.sqrt

/***
 * https://cp-algorithms.com/algebra/discrete-log.html
 * O Logaritmo discreto é um inteiro X que satisfaz a seguinte equacao
 *
 * a ^ x congruente b modulo m
 * ambos a ^ x e b deixam o mesmo resto ao dividir por m
 *
 * O logaritmo discreto nem sempre existe, por exemplo para a equacao 2 ^ x congruente 3 mod 7, nao
 * ha uma simples condicao para determinar se existe ou nao
 *
 * O algoritmo baby-step giant-step computa o logaritmo discreto numa complexidade O(sqrt(m))
 *
 * Esse é um algoritmo do tipo meet-and-middle.
 *
 * Considere a seguinte equacao: a^x congruente b (mod m)
 * a e m sao coprimos
 * Seja x = np-q
 * p = conhecido como giant-step, pois aumentando p em 1 acaba aumentando x em n
 * q = conhecido como baby-step
 *
 * Qualquer numero x no intervalo 0 a m pode ser representado da seguinte forma
 *
 * p percente ao intervalo (1; limite_superior(m/n))
 * q pertence ao intervalo (0, n)
 *
 */

/**
 * a ^ x congruente b (mod m), queremos descobrir se a um x que satisfaça tao afirmacao
 * rescrevendo a equacao
 * a ^ (np - q) congruente b (mod m)
 *
 * como a e m sao coprimos podemos escrever a equacao da seguinte forma
 *
 * a ^ (np) congruente ba ^ q mod (m) e
 *
 * f1(p) == f2(q)
 *
 */
fun solver(a: Int, b: Int, m: Int): Int {
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

    // para todos os p's possiveis de 1 a n
    for (p in 1..n) {
        values[exp(ca, p * n, m)] = p// a ^ n % m
    }

    for (q in 0..n) {
        val current = (exp(a, q, m) % m * cb % m)
        if (values[current] != null) {
            return values[current]?.let { it * n - q } ?: -1
        }
    }

    return -1
}

/**
 * Quando a e m nao sao coprimos
 * https://cp-algorithms.com/algebra/discrete-log.html
 */

fun solverCheckCoprimality(a: Int, b: Int, m: Int): Int {
    fun gdc(a: Int, b: Int): Int {
        return if (a % b == 0) {
            b
        } else {
            gdc(b, a % b)
        }
    }

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

    fun coprimes(a: Int, b: Int, m: Int): Int {
        return -1
    }

    fun nocoprimes(a: Int, b: Int, m: Int): Int {
        return -1
    }

    return if (gdc(a, m) != 1) {
        nocoprimes(a, b, m)
    } else {
        coprimes(a, b, m)
    }
}

private fun check1() {
    arrayOf(
        arrayOf(512, 123, 15),
        arrayOf(2, 3, 5)    // saida 3
    ).forEach { (a, b, m) ->
        println(
            "(%d, %d, %d): %d, %d".format(
                a, b, m,
                solver(a, b, m),
                solverCheckCoprimality(a, b, m)
            )
        )
    }
}

fun main() {
    check1()
}