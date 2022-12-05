package com.br.io


private typealias PII = Pair<Int, Int>
private typealias PLL = Pair<Long, Long>



private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private fun readString(delimiter: String = " ") = readLine()!!.split(delimiter)


private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun callTestCases() {
    testCases(readValue(String::toInt)) {
        val size = readValue(String::toInt)
        val values = readValues(transform = String::toInt)
    }
}

private inline fun runTestCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }

private inline fun solver(times: Int, exec: () -> Unit) = repeat(times) { exec() }

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

private fun <V> String.associate(
    map: MutableMap<Char, V>,
    aggregate: (MutableMap<Char, V>, Char) -> Unit
): Map<Char, V> {
    this.forEach {
        aggregate(map, it)
    }
    return map
}


private fun <V> String.associateIndexed(
    map: MutableMap<Char, V>,
    aggregate: (MutableMap<Char, V>, Int, Char) -> Unit
): Map<Char, V> {
    this.forEachIndexed { idx, c ->
        aggregate(map, idx, c)
    }
    return map
}

private fun String.half(): Pair<String, String> {
    return if (isNotEmpty()) {
        val mi = length / 2
        this.substring(0, mi) to this.substring(mi, length)
    } else {
        "" to ""
    }
}