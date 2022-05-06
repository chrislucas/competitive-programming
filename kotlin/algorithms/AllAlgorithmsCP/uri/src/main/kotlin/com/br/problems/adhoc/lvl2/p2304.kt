package com.br.problems.adhoc.lvl2


/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2304
 *
 * DONE
 * */


private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun main(args: Array<String>) {
    val (amount, operations) = readValues(transform = String::toInt)

    var d = amount
    var e = amount
    var f = amount

    testCases(operations) {
        val values = readLine()!!.split(" ")
        if (values.size == 3) {
            val (op, g1, value) = values
            val v = if (op == "C") -value.toInt() else value.toInt()
            when (g1) {
                "D" -> {
                    d += v
                }
                "E" -> {
                    e += v
                }
                else -> {
                    f += v
                }
            }
        }
        else {
            val (op, g1, g2, value) = values
            val v = value.toInt()
            when (g1) {
                "D" -> {
                    d += v
                }
                "E" -> {
                    e += v
                }
                else -> {
                    f += v
                }
            }

            when (g2) {
                "D" -> {
                    d -= v
                }
                "E" -> {
                    e -= v

                }
                else -> {
                    f -= v
                }
            }
        }
    }
    println("$d $e $f")
}