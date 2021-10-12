package com.br.studies.dp.bitmask.problems.pa


/**
 * Dado um conjunto, conte quantos subconjuntos possuem a soma de seus elementos maior ou igual a um dado valor K
 */

private infix fun Int.isSet(nth: Int) = this and (1 shl nth) > 0

fun howManySubsetSumIsEqualToK(set: Array<Int>, k: Int): Int {
    var result = 0
    val size = set.size
    val limit = (1 shl size) - 1
    for (i in 1 .. limit) {
        var acc = 0
        for (j in size - 1 downTo 0) {
            if (i isSet j)
                acc += set[j]
        }
        if (acc == k)
            result += 1
    }
    return result
}

fun checkSolver() {
    println(howManySubsetSumIsEqualToK(arrayOf(1,2,3,4), 5))
}

fun main() {
    checkSolver()
}