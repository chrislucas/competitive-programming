package com.br.studies.dynamicprogramming.bitmask.problems.pb

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

private fun checkNaive() {

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


// https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
/*
    set bit
    b = 4 = 100
    b = b or (1 << i) - set i-esimo bit 0

    is i-esimo bit set ?
    i = 0, 1, 2 ...
    if b and (1 << i) > 0 - checa se o i-esimo bit de 'b' esta definido ou nao

    unset bit
    b and not(1 << i) - unset o i-esimo bit

    Conhecendo as operacoes acima, vamos ao algoritmo abaixo

    Podemos resolver o problema definir uma tarefa para cada pessoa com um custo minimo usando uma DP
    cujo estado eh (K, MASK)
    k = numero de pessoas no problema
    MASK = uma representacao binarias qie vai varias de 0 a 2 ^ K, vamos usar os bits desse numero
    ter as combinacoes de task definidas para cada pessoa. QUando k-esimo bit for 1 quer dizer
    que a k-esima pessoa foi designada para k-esima tarefa

    Podemos designar a tarefa i para a pessoa k se

    if mask & (1 << i) == 0 // o i-esimo bit está 'desligado'
    then
        // k variando de 1 a N aqui

        // calcula-se qual e o custo minimo para i-esima tarefa (atual)
        // a: designar a tarefa para k+1 pessoa
        // b: designar a tarefa para k pessoa com o custo sendo cost[k][i]
        value = min(f(k+1, mask | (1 << i)), f(k, mask) + cost[k][i])

        // responde qual menor custo para o
        f(k + 1, mask | (1 << i)) = value

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

    for (mask in 0 until limit) {
        val k = countSetBits(mask)
        for (i in 0 until tasks) {
            if (!(mask isSet i)) {
                memory[mask set i] = min(memory[mask set i], memory[mask] + cost[k][i]!!)
            }
        }
    }
    return memory[limit - 1]
}

private fun checkAssign() {
    val cost = create(3, 3) { 0 }
    fun Pair<Int, Pair<Int, Int>>.fill(mat: Matrix<Int>) {
        mat[this.first, this.second.first] = this.second.second
    }
    arrayOf(
        Pair(0, Pair(0, 1)),
        Pair(0, Pair(1, 5)),
        Pair(0, Pair(2, 5)),

        Pair(1, Pair(0, 2)),
        Pair(1, Pair(1, 5)),
        Pair(1, Pair(2, 3)),

        Pair(2, Pair(0, 5)),
        Pair(2, Pair(1, 3)),
        Pair(2, Pair(2, 5)),
    ).forEach {
        it.fill(cost)
    }

    println(assign(3, cost))
}

fun main() {
    checkAssign()
}