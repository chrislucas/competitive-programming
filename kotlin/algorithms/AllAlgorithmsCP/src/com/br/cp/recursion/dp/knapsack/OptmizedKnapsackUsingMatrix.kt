package src.com.br.cp.recursion.dp.knapsack

import java.lang.Integer.max

/**
 *  Usando uma matriz de 2 linhas
 *  https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=lbp
 *  Como so precisamos da linha anterior para calcular a linha atual
 *  mantemos somente 2 linhas
 */

private fun solver(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    val dp = Array(2) { Array(capacity + 1) { 0 } }
    for (wi in 1..weights.size) {
        val w = (wi - 1) % 2
        for (ci in 1..capacity) {
            dp[wi % 2][ci] = if (weights[wi - 1] > ci) {
                dp[w][ci]
            } else {
                val i = dp[w][ci - weights[wi - 1]] + values[wi - 1]
                val e = dp[w][ci]
                max(i, e)
            }
        }
    }
    return dp[weights.size % 2][capacity]
}

private val testCases = arrayOf(
    // weights, values, capacity
    arrayOf(1, 2, 3) to arrayOf(10, 15, 40) to 6, // 65
    arrayOf(2, 1, 3) to arrayOf(10, 15, 40) to 6, // 65
    arrayOf(3, 1, 2) to arrayOf(10, 15, 40) to 6, // 65
    arrayOf(1, 1, 1) to arrayOf(10, 20, 30) to 2, // 50
    arrayOf(1, 2, 3) to arrayOf(10, 15, 40) to 7, // 65
    arrayOf(10, 20, 30) to arrayOf(10, 15, 40) to 30, // 40
    arrayOf(10, 20, 30) to arrayOf(10, 15, 40) to 60, // 65
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 50, // 220
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 20, // 100
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 30, // 160
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 40 // 180
)

private fun checkSolver() {
    testCases.forEach { (p, capacity) ->
        val (w, v) = p
        println("${solver(w, v, capacity)}")
    }
}

fun main() {
    checkSolver()
}