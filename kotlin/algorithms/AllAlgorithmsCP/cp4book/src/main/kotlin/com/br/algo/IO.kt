package com.br.algo


import java.math.BigDecimal
import java.math.BigInteger
import java.util.*


inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }

private fun abs(value: Int) = if (value < 0) -value else value


typealias PLL = Pair<Long, Long>

typealias PQueue<T> = PriorityQueue<T>

typealias BigInt = BigInteger

typealias BigDec = BigDecimal

typealias  Matrix<T> = Array<Array<T?>>

operator fun <T> Matrix<T>.set(i: Int, j: Int, value: T) {
    this[i][j] = value
}

operator fun <T> Matrix<T>.get(i: Int, j: Int) = this[i][j]

private inline fun <reified T> create2DMatrix(x: Int, y: Int, init: () -> T?):
        Matrix<T?> = Array(x) { Array(y) { init() } }


typealias  Cube<T> = Array<Array<Array<T?>>>

operator fun <T> Cube<T>.set(i: Int, j: Int, k: Int, value: T) {
    this[i][j][k] = value
}

operator fun <T> Cube<T>.get(i: Int, j: Int, k: Int) = this[i][j][k]

private inline fun <reified T> createCube(i: Int, j: Int, k: Int, init: () -> T?):
        Cube<T?> = Array(i) { Array(j) { Array(k) { init() } } }


private fun <T> computeTimeInMillis(block: () -> T): Pair<T, Long> {
    val start = System.currentTimeMillis()
    val result = block()
    return Pair(result, System.currentTimeMillis() - start)
}


private fun <V> String.counting(
    map: MutableMap<Char, V>,
    aggregate: (MutableMap<Char, V>, Char) -> Unit
): Map<Char, V> {
    this.forEach {
        aggregate(map, it)
    }
    return map
}

fun main() {

}