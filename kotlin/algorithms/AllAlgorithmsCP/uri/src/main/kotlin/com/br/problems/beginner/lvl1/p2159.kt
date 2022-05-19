package com.br.problems.beginner.lvl1

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2159
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

fun main(args: Array<String>) {

}