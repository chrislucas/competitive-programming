package com.br.problems.adhoc.lvl3

import kotlin.math.sqrt

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/1836
 * DONE
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

fun main(args: Array<String>) {
    var acc = 1
    testCases(readValue { it.toInt() }) {
        val (pokemon, level) = readLine()!!.split(" ")
        println("Caso #$acc: $pokemon nivel $level")
        repeat(4) {
            val (baseValue, individualValue, effortValue) = readValues { it.toInt() }
            val rs = if (it == 0) {
                (individualValue + baseValue + sqrt(effortValue * 1.0) / 8 + 50) * (level.toInt() / 50.0) + 10.0
            } else {
                (individualValue + baseValue + sqrt(effortValue * 1.0) / 8) * (level.toInt() / 50.0) + 5.0
            }
            when (it) {
                0 -> {
                    println("HP: ${rs.toInt()}")
                }
                1 -> {
                    println("AT: ${rs.toInt()}")
                }
                2 -> {
                    println("DF: ${rs.toInt()}")
                }
                else -> {
                    println("SP: ${rs.toInt()}")
                }
            }
        }
        acc += 1
    }
}