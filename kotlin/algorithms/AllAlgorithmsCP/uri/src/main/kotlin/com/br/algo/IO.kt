package com.br.algo

import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

private fun readInt() = readLine()!!.toInt()

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)


private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private fun Char.toInt() = Character.getNumericValue(this)

private fun <T> Array<T>.show(prefix: String = "") = "$prefix${this.joinToString(" ")}"


private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }


typealias PLL = Pair<Long, Long>

typealias PQueue<T> = PriorityQueue<T>

typealias BigInt = BigInteger

typealias BigDec = BigDecimal

fun main() {
    readValues { it.toInt() }
}