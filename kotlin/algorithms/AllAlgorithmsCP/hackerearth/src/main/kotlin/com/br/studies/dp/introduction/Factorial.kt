package com.br.studies.dp.introduction

/**
 * TEST YOUR UNDERSTANDING
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/
 */

inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun solver() {

    val MOD: Long = 1000000007
    val ans = Array(100010) { 0L }
    ans[0] = 1
    ans[1] = 1
    ans[2] = 2
    ans[3] = 6
    ans[4] = 24
    ans[5] = 120

    fun topDown(c: Int, map: Array<Long>): Long {
        return if (map[c] != 0L) {
            map[c]
        } else {
            map[c] = (topDown(c - 1, map) % MOD * c % MOD) % MOD
            map[c]
        }
    }

    fun bottomUp(c: Int, map: Array<Long>): Long {
        return if (map[c] > 0L) {
            map[c]
        } else if (map[c - 1] != 0L) {
            map[c] = (c % MOD * map[c - 1] % MOD) % MOD
            map[c]
        } else {
            var acc = c
            var aux = 1L
            while (acc > 1) {
                aux = (acc % MOD * aux % MOD) % MOD
                acc--
            }
            map[c] = aux
            map[c]
        }
    }

    testCases(readValue(String::toInt)) {
        val c = readValue(String::toInt)
        if (ans[c] > 0) {
            println(ans[c])
        } else {
            println(topDown(c, ans))
        }
    }
}


fun main() {
    solver()
}