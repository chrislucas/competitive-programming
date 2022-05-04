package com.br.competitions.c1615.pb


private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }


fun main() {
    testCases(readValue(String::toInt)) {
        val (p, q) = readValues(transform = String::toInt)

        val size = q - p

        val table = Array(size) { Array(size) { 0 } }

    }
}