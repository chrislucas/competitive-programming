package com.br.problems.dp

/*
    https://www.beecrowd.com.br/judge/en/problems/view/1310
    possivelmente solucionavel com kadane
 */

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun main(args: Array<String>) {

}