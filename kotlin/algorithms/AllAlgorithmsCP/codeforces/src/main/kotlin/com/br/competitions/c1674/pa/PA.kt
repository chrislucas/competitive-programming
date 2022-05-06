package com.br.competitions.c1674.pa

/**
 * https://codeforces.com/contest/1674/problem/A
 */


inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun <P, Q> makePair(p: P, q: Q) = Pair(p, q)

fun main() {
    val cases = readValue { it.toInt() }
    testCases(cases) {
        val (x, y) = readValues { it.toInt() }
        val (a, b) = if (y % x == 0) {
            if (x == y) {
                makePair(1, 1)
            } else {
                var quo = y / x
                var b = 2
                var a = 0
                while (quo > 1 && b <= quo) {
                    if (quo % b == 0) {
                        quo /= b
                        a += 1
                    } else {
                        b += 1
                    }
                }
                if (a > 0) makePair(a, b) else makePair(0, 0)
            }

        } else {
            makePair(0, 0)
        }
        println("$a $b")
    }
}