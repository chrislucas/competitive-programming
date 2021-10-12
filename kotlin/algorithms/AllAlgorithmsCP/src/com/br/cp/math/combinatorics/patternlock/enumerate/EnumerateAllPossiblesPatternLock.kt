package src.com.br.cp.math.combinatorics.patternlock.enumerate

import kotlin.collections.LinkedHashMap

// baseado em: https://github.com/delight-im/AndroidPatternLock


const val DOTS = 9

typealias EnumerateSet<T> = LinkedHashMap<T, MutableList<MutableList<T>>>


val <T> EnumerateSet<T>.accumulate: LinkedHashMap<T, Int>
get() {
    val map = linkedMapOf<T, Int>()
    this.forEach { (k, v) ->
        map[k] = v.count()
    }
    return map
}

val possibleJumps: Array<Array<Int>>
    get() {
        val matrix = Array(DOTS + 1) { Array(DOTS + 1) { 0 } }

        // entrea celula 1 e 3 e vice e versa
        matrix[1][3] = 2
        matrix[3][1] = 2
        matrix[1][7] = 4
        matrix[7][1] = 4

// entre 7 e 9 tem o 8
        matrix[7][9] = 8
        matrix[9][7] = 8
        matrix[3][9] = 6
        matrix[9][3] = 6

// 5 no meio do teclado
        matrix[1][9] = 5
        matrix[9][1] = 5
        matrix[2][8] = 5
        matrix[8][2] = 5
        matrix[3][7] = 5
        matrix[7][3] = 5
        matrix[4][6] = 5
        matrix[6][4] = 5
        return matrix
    }


private fun countWays(
    visited: Array<Boolean>,
    possibleJumps: Array<Array<Int>>,
    source: Int,
    q: Int
): Int {
    if (q <= 0) {
        return if (q == 0) 1 else 0
    }
    var counter = 0
    visited[source] = true
    for (i in 1..DOTS) {
        val connection = possibleJumps[i][source]
        // connection == 0 -> existe um caminho direto de k a source
        // porem se connection != 0 mas visited[connect] = true quer dizer que atraves da DFS que esse
        // algoritmo faz, foi possivel chegar de i ate source
        if (!visited[i] && (connection == 0 || visited[connection])) {
            counter += countWays(visited, possibleJumps, i, q - 1)
        }
    }
    visited[source] = false
    return counter
}


fun <T> MutableList<T>.copy(): MutableList<T> {
    val copy = mutableListOf<T>()
    this.forEach {
        copy.add(it)
    }
    return copy
}

private fun enumerate(
    visited: Array<Boolean>,
    possibleJumps: Array<Array<Int>>,
    set: EnumerateSet<Int>,
    subset: MutableList<Int>,
    source: Int,
    q: Int
) {
    if (q == 0) {
        subset.add(source)
        set[subset[0]]?.add(subset.copy())
        return
    }
    visited[source] = true
    subset.add(source)
    for (k in 1..DOTS) {
        val connection = possibleJumps[k][source]
        // connection == 0 -> existe um caminho direto de k a source
        // connection != 0 porem visited[coonection] = true significa que com a DFS foi possivel
        // chegar de k a source
        if (!visited[k] && (connection == 0 || visited[connection])) {
            enumerate(visited, possibleJumps, set, subset, k, q - 1)
            subset.remove(k)
        }
    }
    visited[source] = false
}

private fun enumerate(q: Int): EnumerateSet<Int> {
    val set: EnumerateSet<Int> = linkedMapOf()
    val visited = Array(DOTS + 1) { false }
    for (source in 1..DOTS) {
        set[source] = mutableListOf()
        enumerate(visited, possibleJumps, set, mutableListOf(), source, q - 1)
    }
    println("$q\n${set.accumulate}\n${set.accumulate.values.sum()}\n")
    return set
}

private fun enumerate(range: IntRange) {
    // leia range esta em 4 .. 9, da direita para esquerda
    if (3 .. 9 in range) {
        range.forEach {
            enumerate(it)
        }
    }
}

private fun calculate(quantity: Int): Int {
    var counter = 0
    val visited = Array(DOTS + 1) { false }
    counter += 4 * countWays(visited, possibleJumps, 1, quantity - 1)
    counter += 4 * countWays(visited, possibleJumps, 2, quantity - 1)
    counter += countWays(visited, possibleJumps, 5, quantity - 1)
    return counter
}

/*
3: 320
4: 1624
5: 7152
6: 26016
7: 72912
8: 140704
9: 140704
 */

private fun checkCalculate() {
    (3..9).forEach {
        println("$it: ${calculate(it)}")
    }
}

private fun checkEnumerate() {
    (3..9).forEach {
        println("$it: ${enumerate(it)}")
    }
}


operator fun IntRange.contains(other: IntRange): Boolean =
    first >= other.first && last <= other.last


private fun sum(range: IntRange) {
    var acc = 0
    // leia range esta em 4 .. 9, da direita para esquerda
    if (3 .. 9 in range ) {
        range.forEach {
            acc += calculate(it)
        }
        println(acc)
    } else {
        println("Error")
    }
}

fun main() {
    sum(4 .. 9)
    //enumerate(4)
    enumerate(3 .. 9)
    //println(calculate(4))
}