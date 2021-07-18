package com.br.problems.adhoc.p1982

// https://www.urionlinejudge.com.br/judge/en/problems/view/1982
private fun readInt() = readLine()!!.toInt()

private fun <T> readValues(delimiter: String = " ", transform: (String) -> T ) =
    readLine()!!.split(delimiter).map(transform)

data class Point(val p: Int, val q: Int)

fun main(args: Array<String>) {

    do {
        var c = readInt()
        if (c == 0)
            break
        val set = mutableListOf<Point>()
        while (c > 0) {
            val (p, q) = readValues { it.toInt() }
            set.add(Point(p, q))
           c-=1
        }
    } while (true)

}