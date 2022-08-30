package com.br.io

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun callTestCases() {
    testCases(readValue(String::toInt)) {
        val size = readValue(String::toInt)
        val values = readValues(transform = String::toInt)
    }
}

private inline fun runTestCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }

private inline fun runWhiteTruth(fn: () -> Boolean) {
    while (true) {
        if (!fn()) {
            break
        }
    }
}

private fun runUntilEndOfFile(fn: (String) -> Unit) {

    fun runWhiteTruth(fn: () -> Boolean) {
        while (true) {
            if (!fn()) {
                break
            }
        }
    }

    runWhiteTruth {
        readLine()?.let {
            fn(it)
            true
        } ?: false
    }
}