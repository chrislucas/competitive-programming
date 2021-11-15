package src.com.br.cp.math.combinatorics.binomialcoefficient

// https://www.geeksforgeeks.org/sum-binomial-coefficients/

/*
    https://www.dcode.fr/binomial-coefficient
    https://www.calculatorsoup.com/calculators/discretemathematics/combinations.php

   Combinacao de N de P em P

   N! / (N - P)! * P!

    n * n - 1 * ... n - p + 1 /  p * (p - 1) * ... * 1
 */

private fun binomial(n: Long, p: Long): Long {
    var acc = 1L
    // C(n, p) = C(n, n - p) lembrando do triangulo de pascal
    val cP = if (p > n - p) {
        n - p
    } else {
        p
    }
    for (i in 0 until cP) {
        acc *= (n - i)
        acc /= (i + 1)
    }

    return acc
}


fun main() {
    println(binomial(8, 2))
    println(binomial(50, 6))
}