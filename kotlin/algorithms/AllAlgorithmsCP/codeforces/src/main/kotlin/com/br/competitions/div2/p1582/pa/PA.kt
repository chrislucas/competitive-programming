package com.br.competitions.div2.p1582.pa


// https://codeforces.com/contest/1582/problem/A
// DDNE

fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private fun solver() {
    var queries = readValue { it.toInt() }
    while (queries > 0) {
        val (a,b,c) = readValues { it.toLong() }.toTypedArray()
        val total = a + 2 * b + 3 * c
        println(total % 2L)
        queries-=1
    }
}

fun main() {
    solver()
}