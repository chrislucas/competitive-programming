package com.br.problems.adhoc.lvl6

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2672
 * */

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

fun main(args: Array<String>) {

}