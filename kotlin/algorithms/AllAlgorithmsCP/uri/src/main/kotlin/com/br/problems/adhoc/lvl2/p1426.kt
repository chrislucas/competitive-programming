package com.br.problems.adhoc.lvl2

/***
 * https://www.beecrowd.com.br/judge/en/problems/view/1426
 * DONE
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

fun main(args: Array<String>) {

    testCases(readValue { it.toInt() }) { it ->

        val map = mutableMapOf<Int, MutableList<Int>>()
        val (addresses, _) = readValues { it.toInt() }
        val keys = readValues { it.toInt() }

        for (i in 0 until addresses) {
            map[i] = mutableListOf()
        }

        for (k in keys) {
            map[k % addresses]?.add(k)
        }

        if (it > 0)
            println()

        for (i in 0 until addresses) {
            val message = if (map[i]?.isEmpty() == true) {
                "\\"
            } else {
                map[i]?.joinToString(" -> ")?.let {
                    "$it -> \\"
                }
            }
            //print(if (i == 0) "$i -> $message" else "\n$i -> $message")
            println("$i -> $message")
        }
    }
}
