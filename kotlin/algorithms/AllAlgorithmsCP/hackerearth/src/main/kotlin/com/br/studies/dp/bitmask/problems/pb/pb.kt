package com.br.studies.dp.bitmask.problems.pb

import com.br.studies.dp.bitmask.countbits.countSetBits
import kotlin.math.min

// https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/

typealias  Matrix<T> = Array<Array<T?>>

operator fun <T> Matrix<T>.set(i: Int, j: Int, value: T) {
    this[i][j] = value
}

private inline fun <reified T> create(x: Int, y: Int, init: () -> T?): Matrix<T?> = Array(x) { Array(y) { init() } }

infix fun Int.set(nth: Int) = this or (1 shl nth)

private infix fun Int.isSet(nth: Int) = this and (1 shl nth) > 0

/*
  https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
* Como alocar N tarefas para N pessoas onde cada pessoa cobra um valor P para cada atividade de 1 a N.
* Cada atividade deve ser destinada para 1 pessoa com o o menor custo possivel
*
* */

// TODO
private fun nextGreaterPermutation(array: Array<Int>) {}

private fun naive(tasks: Int, cost: Matrix<Int>): Int {
    fun factorial(n: Int): Int {
        var acc = n
        for (i in n - 1 downTo 1) {
            acc *= i
        }
        return acc
    }

    val assignment = Array(tasks) { 0 }
    for (i in assignment.indices) {
        assignment[i] = i
    }

    val k = factorial(tasks)
    var res = Int.MAX_VALUE

    for (i in 0..k) {
        var acc = 0
        for (j in 0 until tasks) {
            acc += cost[j][assignment[j]]!!
        }
        res = if (res < acc) res else acc
        nextGreaterPermutation(assignment)
    }
    return res
}


// https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
/*
    set bit
    b = 4 = 100
    b = b or (1 << 0) - set bit 0

    is bit set ?
    i = 0, 1, 2 ...
    if b and (1 << i) > 0 - checa se o i-esimo bit esta definido ou nao

    unset bit
    b and not(1 << i) - unset o i-esimo bit
*/
private fun assign(tasks: Int, cost: Matrix<Int>): Int {
    val limit = 1 shl tasks
    val memory = Array(limit) { Int.MAX_VALUE }
    memory[0] = 0

    fun countSetBits(value: Int): Int {
        var counter = 0
        var copy = value
        while (copy > 0) {
            copy = copy and (copy - 1)
            counter += 1
        }
        return counter
    }

    for (i in 0 until limit) {
        val j = countSetBits(i)
        for (k in 0 until tasks) {
            if (!(i isSet k)) {
                val bit = i or (1 shl k)
                memory[bit] = min(memory[bit], memory[i] + cost[j][k]!!)
            }
        }
    }

    return memory[limit - 1]
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

    val cost1 = create(4, 4) { 0 }

    cost[0, 0] = 1
    cost[0, 1] = 5
    cost[0, 2] = 5

    cost[1, 0] = 5
    cost[1, 1] = 3
    cost[1, 2] = 5

    cost[2, 0] = 2
    cost[2, 1] = 5
    cost[2, 2] = 3

    naive(4, cost1)
}


fun main() {
    check()
}