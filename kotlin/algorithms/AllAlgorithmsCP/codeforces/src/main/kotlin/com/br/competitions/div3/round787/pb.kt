package com.br.competitions.div3.round787

import java.util.LinkedList
import java.util.Queue

/**
 * https://codeforces.com/contest/1675/problem/B
 */
private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

fun main() {

    testCases(readValue { it.toInt() }) {
        val size = readValue { it.toInt() }
        val values = readValues { it.toInt() }
        val queue: Queue<Int> = LinkedList()

        val aux = Array(values.size) { -1 }


        for (a in values) {
            queue.add(a)
        }


        fun add(value: Int, values: Array<Int>, idx: Int) {
            if (idx > 0 && values[idx - 1] < value) {
                values[idx] = value
            }
            else {
            }
        }


        var idx = 0
        aux[idx] = queue.poll()
        while (queue.isNotEmpty() && idx < aux.size - 1) {
            if (queue.peek() > values[idx]) {
                idx += 1
                aux[idx] = queue.poll()
            }
            else {
                aux[idx] = aux[idx] / 2
            }
        }
    }

}