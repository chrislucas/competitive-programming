package com.br.competitions.c1616


/*
    https://codeforces.com/contest/1616/problem/B
 */
private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun main() {

}