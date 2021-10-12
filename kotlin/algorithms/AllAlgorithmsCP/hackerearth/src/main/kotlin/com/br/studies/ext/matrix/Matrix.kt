package com.br.studies.ext.matrix

typealias  Matrix<T> = Array<Array<T?>>

operator fun <T> Matrix<T>.set(i: Int, j: Int, value: T) { this[i][j] = value }

operator fun <T> Matrix<T>.get(i: Int, j: Int) = this[i][j]

private inline fun <reified T> create(x: Int, y: Int): Matrix<T?> = create(x, y) { null }

private inline fun <reified T> create(x: Int, y: Int, init: () -> T?): Matrix<T?> = Array(x) { Array(y) { init() } }

typealias  Matrix3D<T> = Array<Array<Array<T?>>>

operator fun <T> Matrix3D<T>.set(i: Int, j: Int, k: Int, value: T) {
    this[i][j][k] = value
}

operator fun <T> Matrix3D<T>.get(i: Int, j: Int, k: Int) = this[i][j][k]

private inline fun <reified T> create(x: Int, y: Int, z: Int, init: () -> T?): Matrix3D<T?> =
    Array(x) { Array(y) { Array(z) { init() } } }