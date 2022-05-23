package com.br.competitions.div3.round787

/**
 * DONE
 */
private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)


fun main() {
    testCases(readValue { it.toInt() }) {
        val (a, b, c, x, y) = readValues { it.toLong() }
        val cx = x - a
        val cy = y - b
        if (cx >= 0 && cy >= 0) {
            if (c >= cx + cy) {
                println("YES")
            } else {
                println("NO")
            }
        } else if (cx < 0 && cy > 0) {
            if (c >= cy) {
                println("YES")
            } else {
                println("NO")
            }
        } else if (cy < 0 && cx > 0) {
            if (c >= cx) {
                println("YES")
            } else {
                println("NO")
            }
        } else {
            println("YES")
        }
    }
}
