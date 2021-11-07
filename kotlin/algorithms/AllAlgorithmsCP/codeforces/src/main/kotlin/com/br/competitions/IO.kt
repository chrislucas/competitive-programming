package com.br.competitions

import java.math.BigDecimal
import java.math.BigInteger
import java.util.*


fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)


typealias PLL = Pair<Long, Long>

typealias PQueue<T> = PriorityQueue<T>

typealias BigInt = BigInteger

typealias BigDec = BigDecimal