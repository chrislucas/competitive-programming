package com.br.competitions.c1615.pa


private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }


fun main() {

    testCases(readValue { it.toInt() }) {
        val quantity = readValue { it.toInt() }
        val values = readValues { it.toInt() }
        val r = values.sum() % quantity
        println(if (r == 0) "0" else "1")
    }
}