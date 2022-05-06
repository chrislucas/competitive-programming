package com.br.problems.ds.lvl2


/**
 * https://www.beecrowd.com.br/judge/en/problems/view/2482
 * DONE
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun main(args: Array<String>) {

    val translate = mutableMapOf<String, String>()
    repeat(readValue(String::toInt)) {
        val country = readLine()!!
        val greeting = readLine()!!
        translate[country] = greeting
    }

    repeat(readValue { it.toInt() }) {
        val name = readLine()!!
        val origin = readLine()!!
        println(name)
        println("${translate[origin]}\n")
    }
}