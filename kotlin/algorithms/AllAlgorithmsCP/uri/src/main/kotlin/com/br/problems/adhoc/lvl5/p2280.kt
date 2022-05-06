package com.br.problems.adhoc.lvl5

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2280
 * */
private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun main(args: Array<String>) {
    val (requests, t) = readValues { it.toInt() }
    repeat(requests) {
        val cost = readValues { it.toInt() }
    }

}