package com.br.competitions.div4.round784

/**
 * https://codeforces.com/contest/1669/problem/A
 *
 * */

inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)



fun main() {

}