package com.br.competitions.c1621

inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun callTestCases() {
    testCases(readValue(String::toInt)) {
        val size = readValue(String::toInt)
        val values = readValues(transform = String::toInt)
    }
}


fun main() {
    testCases(readValue(String::toInt)) {
        val (n, k) = readValues(transform = String::toInt)

        if(n - k >= 2) {
            // possível
        } else {
            println(-1)
        }
    }
}