package com.br.problems.adhoc.p1986

import java.lang.StringBuilder

// https://www.urionlinejudge.com.br/judge/en/problems/view/1986

private fun readInt() = readLine()!!.toInt()

private fun fromStringHexToInt(hex: String): Char {

    val map = mapOf(
        'A' to 10,
        'B' to 11,
        'C' to 12,
        'D' to 13,
        'E' to 14,
        'F' to 15
    )
    var acc = 0
    var prod = 1
    for (i in hex.length - 1 downTo  0 step 1) {
        acc += (map[hex[i]] ?: Character.getNumericValue(hex[i])) * prod
        prod *= 16
    }


    return acc.toChar()
}

fun main(args: Array<String>) {

    val chars = readInt()
    val word = readLine()!!.split(" ")

    val answer = word.run {
        val builder = StringBuilder()
       this.forEach {
            builder.append(fromStringHexToInt(it))
        }
       builder.toString()
    }

    println(answer)
}