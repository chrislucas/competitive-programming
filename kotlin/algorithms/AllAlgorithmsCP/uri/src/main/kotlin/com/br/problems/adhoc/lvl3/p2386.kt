package com.br.problems.adhoc.lvl3

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2386
 * DONE
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

fun main() {
    val abertura = readValue { it.toInt() }
    var acc = 0
    testCases(readValue { it.toInt() }) {
        val fotons = readValue { it.toInt() }
        if (fotons * abertura  >= 40000000)
            acc+=1
    }
    println(acc)
}

