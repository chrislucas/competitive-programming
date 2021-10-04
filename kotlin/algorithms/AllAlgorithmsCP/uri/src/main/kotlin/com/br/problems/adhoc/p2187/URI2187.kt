package com.br.problems.adhoc.p2187

// https://www.urionlinejudge.com.br/judge/en/problems/view/2187



private fun readInt() = readLine()!!.toInt()

private fun <T> Array<T>.show(prefix: String = "") = "$prefix${this.joinToString(" ")}"


fun main(args: Array<String>) {
    val bits = arrayOf(50, 10, 5 , 1)
    var cases = 1
    do {
        var value = readInt()
        if (value == 0)
            break
        var idx = 0
        val quantities = Array(4) { 0 }
/*
        while (value > 0) {
            if (value >= bits[idx]) {
                value -= bits[idx]
                quantities[idx] += 1
            } else {
                idx+=1
            }
        }

 */
        quantities[0] += value / bits[0]
        value %= bits[0]

        quantities[1] += value / bits[1]
        value %= bits[1]

        quantities[2] += value / bits[2]
        value %= bits[2]

        quantities[3] += value / bits[3]
        value %= bits[3]

        println(quantities.show("Teste $cases\n"))
        println()
        cases += 1
    } while (true)
}

