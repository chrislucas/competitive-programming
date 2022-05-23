package com.br.algo.bsearch

fun <C : Comparable<C>> nearest(value: C, values: List<C>): C {
    var le = 0
    var ri = values.size - 1
    var p = values[0]
    while (le <= ri) {
        val mi = (ri - le) / 2 + le
        val np = values[mi]
        if (np == value) {
            p = np
            break
        } else if (p.compareTo(value) < np.compareTo(value)) {
            ri = mi - 1 // Testar esse algoritmo para
        } else {
            le = mi + 1
        }
        p = np
    }
    return p
}

fun main() {
    val values = listOf(
        listOf(1, 3, 10, 15, 19),
        listOf(1, 2, 4, 5, 6, 6, 8, 9)
    )

    val idx = 1
    println(nearest(5, values[idx]))
    println(nearest(11, values[idx]))
    println(nearest(14, values[idx]))
}