package com.br.problems.adhoc.lvl5

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/1678
 * */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun main(args: Array<String>) {

    do {
        val (q, problems) = readValues { it.toInt() }

        // capacity[i] = capacidade intelectual do ith time
        val capacity = readValues { it.toInt() }
        val members = Array(q) { 0 }

        val values = mutableListOf<List<Int>>()
        repeat(problems) {
            values += readValues { it.toInt() }
        }

    } while (q > 0 && problems > 0)

}