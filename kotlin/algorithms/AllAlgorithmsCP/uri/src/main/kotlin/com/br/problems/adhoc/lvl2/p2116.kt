package com.br.problems.adhoc.lvl2

import kotlin.math.abs
import kotlin.math.min

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2116
 * DONE
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun sieveOfSundaram(n: Int): MutableList<Int> {
    val lim = (n - 1) / 2
    val isPrime = Array(lim + 1) { false }
    for (i in 1..lim) {
        var j = i
        var s = i + j + 2 * i * j
        while (s <= lim) {
            isPrime[s] = true
            j += 1
            s = i + j + 2 * i * j
        }
    }
    val primes = mutableListOf<Int>()
    primes += 2
    for (i in 1..lim) {
        if (!isPrime[i]) {
            primes += i * 2 + 1
        }
    }
    return primes
}

private fun solver() {
    val (n, m) = readValues { it.toInt() }
    val primes = if (n < m) {
        sieveOfSundaram(m)
    } else {
        sieveOfSundaram(n)
    }
    val q = primes.last()
    primes.removeIf { it > min(n, m) }

    fun nearest(value: Int, list: List<Int>): Int {
        var le = 0
        var ri = list.size - 1
        var p = list[0]
        while (le <= ri) {
            val mi = (ri - le) / 2 + le
            val np = list[mi]
            if (np == value) {
                p = np
                break
            } else if (abs(p - value) < abs(np - value)) {
                ri = mi - 1
            } else {
                le = mi + 1
            }
            p = np
        }
        return p
    }

    val p = nearest(n, primes)
    println(p * q)
}

fun main(args: Array<String>) {
    solver()
}