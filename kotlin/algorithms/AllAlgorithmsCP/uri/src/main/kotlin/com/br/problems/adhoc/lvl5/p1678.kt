package com.br.problems.adhoc.lvl5

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/1678
 * */

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

fun main(args: Array<String>) {

}