package com.br.problems.ds.lvl3

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/1256
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

fun main() {

}