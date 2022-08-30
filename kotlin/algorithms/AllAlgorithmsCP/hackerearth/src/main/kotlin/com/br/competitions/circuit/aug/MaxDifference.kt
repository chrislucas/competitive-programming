package com.br.competitions.circuit.aug

/*
    https://www.hackerearth.com/challenges/competitive/august-circuits-22/problems/
    https://www.hackerearth.com/challenges/competitive/august-circuits-22/algorithm/max-difference-3-a5f48242/
    DONE
 */


private inline fun testCases(times: Int, exec: (Int) -> Unit) = repeat(times, exec)

inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

/*
    1,2,3,4,5
    [5, 1] e [4, 2]
 */

fun main() {
    testCases(readValue(String::toInt)) {
        val size = readValue(String::toInt)
        val values = readValues(transform = String::toInt).sorted()
        val i = 0
        val j = size - 1
        if (size < 3) {
            println(values[1] - values[0])
        } else {
            if (size == 3) {
                println(values[j] - values[i])
            } else {
                println((values[j] - values[i]) + (values[j - 1] - values[i + 1]))
            }
        }
    }
}