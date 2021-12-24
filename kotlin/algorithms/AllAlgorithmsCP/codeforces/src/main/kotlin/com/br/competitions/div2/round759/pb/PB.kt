package com.br.competitions.div2.round759.pb

// https://codeforces.com/contest/1591/problem/B


private fun readInt() = readLine()!!.toInt()

private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)


// TLE
private fun s1() {
    fun op(values: List<Int>) = values.partition { it <= values.last() }

    testCases(readInt()) {
        readInt()
        var values = readValues { it.toInt()}
        var k = 0
        while (true) {
            val (lessEqThan, greaterThan) = op(values)
            val newer = lessEqThan + greaterThan
            if (values == newer) {
                break
            }
            values = newer
            k += 1
        }
        println(k)
    }
}

private fun s2() {
    testCases(readInt()) {
        readInt()
        var values = readValues { it.toInt()}
        var k = 0
        val max = values.maxOrNull()

    }
}

fun main() {
    s1()
}