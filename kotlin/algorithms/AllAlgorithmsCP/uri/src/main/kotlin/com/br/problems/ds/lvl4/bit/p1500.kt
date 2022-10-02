package com.br.problems.ds.lvl4.bit

// https://www.beecrowd.com.br/judge/en/problems/view/1500

// update range


private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private fun readString(delimiter: String = " ") = readLine()!!.split(delimiter)

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun main() {

}