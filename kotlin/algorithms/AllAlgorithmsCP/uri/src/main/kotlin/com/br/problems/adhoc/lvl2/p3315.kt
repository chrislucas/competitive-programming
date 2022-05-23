package com.br.problems.adhoc.lvl2

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/3315
 * DONE
 */

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)


fun main(args: Array<String>) {

    fun Int.binary() : String {
        var c = this
        val buffer = StringBuilder()
        while (c > 0) {
           buffer.append(if(c and 1 == 1) "1" else "0")
            c = c shr 1
        }
        return buffer.reverse().toString()
    }

    var max = 0
    for (i in 0 until 4) {
        val sum = readValues { it.toInt() }.sum()
        if (sum > max)
            max = sum
    }

    println("$max = ${max.binary()}")
}
