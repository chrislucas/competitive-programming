package com.br.algo.math.ntheory

import com.br.algo.BigInt
import java.math.BigInteger
import java.util.*


/**
 * https://www.geeksforgeeks.org/pollards-rho-algorithm-prime-factorization/?ref=lbp
 *
 * "Dado um inteiro positivo composto N, encontro um divisor dele"
 *
 * Algoritmo de fatoracao em numeros primos (um numero N pode ser escrito por uma sequencia unica
 * de numeros primos multiplicados). Ele eh particularme rapido para numeros compostos grandes
 *
 * */

typealias BigInt = BigInteger

/**
 * 2 ^ 256
 * https://en.wikipedia.org/wiki/Fermat_number
 * */
val eighthFermatNumber = BigInt("1238926361552897") *
        BigInt("93461639715357977769163558199606896584051237541638188580280321")

/**
 * Conceitos usadds no algoritmo
 *
 * 1 - 2 numeros x e y sao ditos congruentes a modulo z (x = y mod n) se
 *      a - o modulo de deles resulta num numero divisivel por n ou
 *      b - ambos deixa o mesmo resto ao serem dividos por n
 *
 * 2 - GCD
 * 3 - Birthday Paradox -
 * 4 - Algoritmo de deteccao de ciclos numa lista ligada - Floyd
 *      - usa-se 2 ponteiros para navegar na lista ligada
 *      - 1 deles se move 2x mais rapido, se o ponteiro chegar no fim da lista
 *      primeiro nao existe um ciclo
 *
 * */


private fun pollardRho(n: BigInt): BigInt {

    /**
     * passos
     *
     * 1 - comece com inteiros x e c aleatorios
     *     tome y = x e f(x) = x ^ 2 + c
     * 2 - Enquanto nao achar um divisor
     *      a - atualize x com f(x)
     *      b - y = f(f(x))
     *      c - calcular gcd(|x-y|, n)
     *      d - se GCD != 1
     *          - Se GCD = n, repetir com novos x, c e y
     *          - senao GCD e a resposta
     *
     */
    fun modularBigIntExp(b: BigInt, e: BigInt, m: BigInt): BigInt {
        return when (e) {
            BigInt.ZERO -> {
                BigInt.ONE
            }
            BigInt.ONE -> {
                b
            }
            else -> {
                var ce = e
                var cb = b
                var acc = BigInt.ONE
                while (ce > BigInt.ZERO) {
                    if (ce and BigInt.ONE == BigInt.ONE) {
                        acc = (acc % m * cb % m) % m
                    }
                    cb = (cb % m * cb % m) % m
                    ce = ce shr 1
                }
                acc
            }
        }
    }

    return if (n == BigInt.ONE) {
        n
    } else if (n and BigInt.ONE == BigInt.ZERO) {
        return BigInt("2")
    } else {

        val two = BigInt("2")
        val one = BigInt.ONE
        var x = BigInt(n.bitCount(), Random(System.currentTimeMillis())) % (n - two) + two
        var y = x
        val c = BigInt(n.bitCount(), Random(System.currentTimeMillis())) % (n - one) + one
        var candidate = one
        while (candidate == one) {
            // f(x)
            x = (modularBigIntExp(x, two, n) + c + n) % n

            // f(f(x))
            y = (modularBigIntExp(y, two, n) + c + n) % n
            y = (modularBigIntExp(y, two, n) + c + n) % n

            candidate = if (x - y < BigInt.ZERO) {
                (-(x - y)).gcd(n)
            } else {
                ((x - y)).gcd(n)
            }

            if (candidate == n)
                return pollardRho(candidate)
        }
        candidate
    }
}

fun main() {
    //println(eightFermatNumber)
    println(pollardRho(eighthFermatNumber))
    println(pollardRho(BigInt("10967535067")))
}