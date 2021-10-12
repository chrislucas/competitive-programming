package com.br.studies.dp.bitmask.problems.pb

import java.lang.Math.min

// https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/

typealias  Matrix<T> = Array<Array<T?>>

operator fun <T> Matrix<T>.set(i: Int, j: Int, value: T) { this[i][j] = value }

private inline fun <reified T> create(x: Int, y: Int, init: () -> T?): Matrix<T?> = Array(x) { Array(y) { init() } }

infix fun Int.set(nth: Int) = this or (1 shl nth)

private infix fun Int.isSet(nth: Int) = this and (1 shl nth) > 0

/*
  https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
* Como alocar N tarefas para N pessoas onde cada pessoa cobra um valor P para cada atividade de 1 a N.
* Cada atividade deve ser destinada para 1 pessoa com o o menor custo possivel
*
* */


private fun naive(tasks: Int, cost: Matrix<Int>): Int {
    fun factorial(n: Int): Int {
        var acc = n
        for (i in n-1 downTo 1) {
            acc *= i
        }
        return acc
    }

    val assignment = Array(tasks) { 0 }
    for (i in assignment.indices) {
        assignment[i] = i
    }
    val k = factorial(tasks)
    var res = Integer.MAX_VALUE

    for (i in 0 .. k) {
        var acc = 0
        for (j in 0 until tasks) {
            acc += cost[j][assignment[j]]!!
        }
        res = if (res < acc) res else acc
    }

    return res
}


private fun check() {

    val cost = create(3, 3) { 0 }

    cost[0, 0] = 1
    cost[0, 1] = 5
    cost[0, 2] = 5

    cost[1, 0] = 5
    cost[1, 1] = 3
    cost[1, 2] = 5

    cost[2, 0] = 2
    cost[2, 1] = 5
    cost[2, 2] = 3

    naive(3, cost)
}

private fun check1() {

    val cost = create(4, 4) { 0 }

    cost[0, 0] = 1
    cost[0, 1] = 5
    cost[0, 2] = 5

    cost[1, 0] = 5
    cost[1, 1] = 3
    cost[1, 2] = 5

    cost[2, 0] = 2
    cost[2, 1] = 5
    cost[2, 2] = 3

    naive(4, cost)
}


fun main() {
    check()
}