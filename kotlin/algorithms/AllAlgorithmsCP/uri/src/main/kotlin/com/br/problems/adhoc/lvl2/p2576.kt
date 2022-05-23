package com.br.problems.adhoc.lvl2


/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2567
 * DONE
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


private inline fun runUntilIf(fn: () -> Boolean) {
    while (true) {
        if (!fn())
            break
    }
}


fun main(args: Array<String>) {
    runUntilIf {
        readLine()?.toInt()?.let { viruses ->
            val values = readValues { it.toInt() }.sorted()
            var acc = 0
            var i = 0
            var j = viruses - 1
            while (i < j) {
                acc += values[j] - values[i]
                i += 1
                j -= 1
            }
            println(acc)
            true
        } ?: false
    }
}