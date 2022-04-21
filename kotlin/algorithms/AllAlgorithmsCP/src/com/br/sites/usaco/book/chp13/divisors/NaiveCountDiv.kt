package src.com.br.sites.usaco.book.chp13.divisors

import kotlin.math.sqrt

/**
 * https://www.geeksforgeeks.org/count-divisors-n-on13/
 * https://www.dcode.fr/divisors-list-number
 */

private fun countDivisors(value: Int): Int {
    val limit = sqrt(value * 1.0).toInt()
    var counter = 0
    for (i in 1..limit) {
        if (value % i == 0) {
            /**
             * Como o loop vai ate a raiz quadrada do numero N fazemos
             * se N / I  == I (9 / 3 = 3, quadrado perfeito) contamos uma vez
             * do conttrario contamos os 2 divisores (12 / 3 == 4, 3 e 4 sao divisores)
             */
            counter += if (value / i == i) {
                1
            } else {
                2
            }
        }
    }
    return counter
}

private fun countDivisors(value: Long): Long {
    val limit = sqrt(value * 1.0).toLong()
    var counter = 0L
    for (i in 1..limit) {
        if (value % i == 0L) {
            counter += if (value / i == i) {
                1
            } else {
                2
            }
        }
    }
    return counter
}

private fun checkCountDivisors() {
    (1..200).forEach {
        println("$it: ${countDivisors(it)}")
    }
}

private fun checkPerfectSquares() {
    (1..100).forEach {
        println("$it -> ${it * it}: ${countDivisors(it * it)}")
    }
}

private fun checkSpecificValue() {
    val value = Array(100) { 0L }
    value[0] = 800000
    value[1] = 1000000
    value[2] = 10000000
    value[3] = 100000000
    value[4] = 1000000000000000000
    value[5] = 1000000000
    val idx = 3
    val s = System.currentTimeMillis()
    val r = countDivisors(value[idx])
    val e = System.currentTimeMillis()
    println("${value[idx]} $r")
    println("${(e - s) / 1000}")

}

fun main() {
    checkSpecificValue()
}