package src.com.br.sites.usaco.book.chp13

import kotlin.math.sqrt

// https://darrenyao.com/usacobook/java.pdf#page=73
/**
 * Calculadora online
 * https://www.calculatorsoup.com/calculators/math/prime-factors.php
 */

fun Int.primeFactors(): MutableList<Int> {
    val factors = mutableListOf<Int>()
    var cpy = this
    val lim = sqrt(this * 1.0).toInt() + 1
    for (i in 2..lim) {
        while (cpy % i == 0) {
            cpy /= i
            factors.add(i)
        }
    }
    if (cpy > 1)
        factors.add(cpy)
    return factors
}

private fun checkIntPrimerFactors() {
    (2..1000).forEach {
        println("$it: ${it.primeFactors()}")
    }
}

fun Int.mapPrimeFactors(): MutableMap<Int, Int> {
    val factors = mutableMapOf<Int, Int>()
    var cpy = this
    val lim = sqrt(this * 1.0).toInt() + 1
    for (i in 2..lim) {
        while (cpy % i == 0) {
            factors[i] = (factors[i]?.plus(1)) ?: 1
            cpy /= i
        }
    }
    if (cpy > 1)
        factors[cpy] = (factors[cpy]?.plus(1)) ?: 1
    return factors
}


private fun checkMapPrimeFactors() {
    (1..100000).forEach {
        println("$it: ${it.mapPrimeFactors()}")
    }
}


fun main() {
    //checkIntPrimerFactors()
    checkMapPrimeFactors()
}