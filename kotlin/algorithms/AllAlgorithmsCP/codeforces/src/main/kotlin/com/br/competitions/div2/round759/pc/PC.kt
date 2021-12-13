package com.br.competitions.div2.round759.pc



// https://codeforces.com/contest/1591/problem/C

private fun readInt() = readLine()!!.toInt()

private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

fun main() {
    testCases(readInt()) {
        val (totalBags, kBagsCanDelivery) = readValues { it.toInt() }
        // armazens
        val depots = readValues { it.toInt() }
    }
}