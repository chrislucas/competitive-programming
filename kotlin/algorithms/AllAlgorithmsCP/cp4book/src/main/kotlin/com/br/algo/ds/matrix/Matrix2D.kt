package com.br.algo.ds.matrix

import java.text.FieldPosition


typealias  Matrix<T> = Array<Array<T?>>

operator fun <T> Matrix<T>.set(i: Int, j: Int, value: T) {
    this[i][j] = value
}

operator fun <T> Matrix<T>.get(i: Int, j: Int) = this[i][j]

// calculo feito para o intervalor 1 .. size
fun <T> Matrix<T>.index(position: Int): Pair<Int, Int> {
    return Pair(position / size, position % size)
}

private fun <T> Matrix<T>.position(i: Int, j: Int): Int? {
    return if (i in 0 until size && j in 0 until size) {
        size * i + j
    } else {
        null
    }
}

private inline fun <reified T> create(x: Int, y: Int): Matrix<T?> = create(x, y) { null }

private inline fun <reified T> create(x: Int, y: Int, init: () -> T?): Matrix<T?> =
    Array(x) { Array(y) { init() } }

private fun checkPosition() {
    val matrix = create(3, 3) { 0.0 }
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            println(matrix.position(i, j))
        }
    }
}

private fun checkIndexByPosition() {
    arrayOf(
        create(3, 3) { 0.0 },
        create(2, 10) { 0.0 },
        create(10, 2) { 0.0 },
        create(10, 20) { 0.0 },
    ).forEach { matrix ->
        val i = matrix.size
        val j = matrix[0].size
        val size = i * j
        println("Matrix ($i, $j)")
        for (position in 1..size) {
            val p = matrix.index(position)
            val q = matrix.index(position - 1)
            val (mi, mj) = q
            println(
                String.format(
                    "%d: %s - %s - pos: %d",
                    position,
                    p,
                    q,
                    matrix.position(mi, mj)
                )
            )
        }
        println("**************************************************")
    }
}


private fun checkCreation() {
    val matrix = create(3, 3) { 0.0 }
    matrix[1, 2] = 12.0
    println(matrix[0, 0])
    println(matrix[1, 2])
}

fun main() {
    checkIndexByPosition()
}