package com.br.problems.adhoc.lvl3

/*
    https://www.beecrowd.com.br/judge/en/problems/view/3351
    TODO
    binary search
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Long, exec: () -> Unit) {
    for (i in 0 until times) {
        exec()
    }
}


fun main(args: Array<String>) {
    val (n, views) = readValues(transform = String::toLong)
    val values = mutableListOf<Long>()
    testCases(n) {
        val (first, timeWaiting) = readValues(transform = String::toLong)

        /*
            var acc = first
            for (i in 1..views) {
                values += acc
                acc += timeWaiting
            }
         */
        // println(first + (views - 1) * timeWaiting)

        for(t in 1 .. views) {
            1 + ((t - first) / timeWaiting)
        }
    }

    /*
        values.sort()
        val limit = 1 shl 30
        if (views < limit) {
            println(values[views.toInt() - 1])
        } else {
            println(values.last())
        }
     */
}