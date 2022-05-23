package com.br.competitions.div3.round787

/***
 * https://codeforces.com/contest/1675/problem/C
 */
private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private inline fun <T> readValue(transform: String.() -> T) = transform(readLine()!!)


fun main() {
    testCases(readValue { toInt() }) {
        val s = readLine()!!
        // 0 = no, 1 = yes, ? = nao lembra
        if (s.length == 1) {
            println(1)
        } else if (s.all { it == '?' }) {
            println(s.length)
        } else {
            var acc = 1
            for (i in 1 .. s.length - 2) {
                for (j in i downTo 1) {
                    if (s[i] != s[j-1]) {
                        acc += 1
                    }
                }
            }
            println(acc)
        }
    }
}