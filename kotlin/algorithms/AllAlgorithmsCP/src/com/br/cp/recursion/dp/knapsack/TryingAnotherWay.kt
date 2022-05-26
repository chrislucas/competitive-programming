package src.com.br.cp.recursion.dp.knapsack

import java.lang.Integer.max

/**
 * Nao é a resposta certa, mas o comportamento desse algoritmo é interessante
 * de ser estudado
 */
private fun test(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    val state = Array(capacity + 1) { Array(values.size) { 0 } }
    for (c in 1..capacity) {
        for (k in weights.indices) {
            val p = if (weights[k] > c) {
                0
            } else {
                state[c - weights[k]][k] + values[k]
            }
            val q = if (k > 0) {
                state[c][k - 1]
            } else {
                0
            }
            state[c][k] = max(p, q)
        }
    }
    return state[capacity][weights.size - 1]
}

private fun solver(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    // [capacity][weight]
    val state = Array(capacity + 1) { Array(weights.size + 1) { 0 } }
    for (ci in 1..capacity) {
        for (wi in 1..weights.size) {
            state[ci][wi] = if (weights[wi - 1] <= ci) {
                val include = state[ci][wi - weights[wi - 1]] + values[wi - 1]
                val exclude = state[ci][wi - 1]
                max(include, exclude)
            } else {
                state[ci][wi - 1]
            }
        }
    }
    return state[capacity][weights.size]
}

private val testCases = arrayOf(
    arrayOf(1, 2, 3) to arrayOf(10, 15, 40) to 6, // 65
    arrayOf(2, 1, 3) to arrayOf(10, 15, 40) to 6, // 65
    arrayOf(3, 1, 2) to arrayOf(10, 15, 40) to 6, // 65
    arrayOf(1, 1, 1) to arrayOf(10, 20, 30) to 2, // 50
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 50, // 220
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 20, // 100
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 30, // 160
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 40 // 180
)

private fun check() {
    testCases.forEach { (p, capacity) ->
        val (w, v) = p
        val s = test(w, v, capacity)
        val t = solver(w, v, capacity)
        println("$s, $t")
    }
}


fun main() {
    check()
}