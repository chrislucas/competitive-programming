package src.com.br.cp.math.combinatorics.patternlock.enumerate

import kotlin.collections.LinkedHashMap

// https://github.com/delight-im/AndroidPatternLock


const val DOTS = 9

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


private fun countWays(visited: Array<Boolean>, possibleJumps: Array<Array<Int>>, source: Int, q: Int): Int {
    if (q <= 0) {
        return if (q == 0) 1 else 0
    }
    var counter = 0
    visited[source] = true
    for (i in 1..DOTS) {
        val p = possibleJumps[i][source]
        if (!visited[i] && (p == 0 || visited[p])) {
            counter += countWays(visited, possibleJumps, i, q - 1)
        }
    }
    visited[source] = false
    return counter
}

private fun calculate(quantity: Int): Int {
    var counter = 0
    val visited = Array(DOTS + 1) { false }
    counter += 4 * countWays(visited, possibleJumps, 1, quantity - 1)
    counter += 4 * countWays(visited, possibleJumps, 2, quantity - 1)
    counter += countWays(visited, possibleJumps, 5, quantity - 1)
    return counter
}

private fun checkCalculate() {
    (3 .. 9).forEach {
        println(calculate(it))
    }
}

private fun get(quantity: Int): LinkedHashMap<Int, List<Set<Int>>> {

    return linkedMapOf()
}


fun main() {
    checkCalculate()
}