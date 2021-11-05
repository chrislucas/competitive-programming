package com.br.algo

import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

typealias PLL = Pair<Long, Long>

typealias PQueue<T> = PriorityQueue<T>

typealias BigInt = BigInteger

typealias BigDec = BigDecimal

fun main() {
    println(0xff)
}