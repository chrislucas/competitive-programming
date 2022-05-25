package src.com.br.cp.recursion.dp.knapsack

import java.lang.Integer.max

// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=lbp

/**
 * Artigo com uma disussao sobre uma variacao do problema coin-change
 * https://codeforces.com/blog/entry/85257
 *
 * Variacoes do problema knapsack
 * http://www.algonotes.com/en/knapsacks/
 *
 * https://www.geeksforgeeks.org/0-1-knap`sack-problem-dp-10/?ref=lbp
 */


private fun topDownKnapsack(weights: Array<Int>, values: Array<Int>, target: Int, idx: Int): Int {
    return if (target == 0 || idx < 0) {
        0
    } else if (weights[idx] > target) {
        topDownKnapsack(weights, values, target, idx - 1)
    } else {
        // usando o i-esimo item
        val p = topDownKnapsack(weights, values, target - weights[idx], idx - 1) + values[idx]
        val q = topDownKnapsack(weights, values, target, idx - 1)
        max(p, q)
    }
}

private fun test(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    /**
     * Nao é a resposta certa, mas o comportamento desse algoritmo é interessante
     * de ser estudado
     */
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

private fun fn(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    val state = Array(capacity + 1) { Array(weights.size + 1) { 0 } }
    for (c in 1..capacity) {
        for (w in 1..weights.size) {
            state[c][w] = if (weights[w - 1] <= c) {
                val include = state[c][w - weights[w - 1]] + values[w - 1]
                val exclude = state[c][w - 1]
                max(include, exclude)
            } else {
                state[c][w - 1]
            }
        }
    }
    return state[capacity][weights.size]
}

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=lbp
 */
private fun bottomUp(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    // [weights][capacities]
    val state = Array(weights.size + 1) { Array(capacity + 1) { 0 } }
    for (i in 1..weights.size) {
        for (w in 1..capacity) {
            state[i][w] = if (weights[i - 1] <= w) {
                val include = values[i - 1] + state[i - 1][w - weights[i - 1]]
                val exclude = state[i - 1][w]
                max(include, exclude)
            } else {
                state[i - 1][w]
            }
        }
    }
    return state[weights.size][capacity]
}


private val testCases = arrayOf(
    arrayOf(1, 2, 3) to arrayOf(10, 15, 40) to 6, // 55
    /*
    arrayOf(1, 1, 1) to arrayOf(10, 20, 30) to 2, //
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 50, // 220
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 20, // 100
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 30, // 120
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 40 // 120

     */
)

private fun testSolverKnapsack() {
    testCases.forEach { (p, k) ->
        val (w, v) = p
        val r = topDownKnapsack(w, v, k, v.size - 1)
        val u = bottomUp(w, v, k)
        val s = test(w, v, k)
        val t = fn(w, v, k)
        println("$r, $u, $s, $t")
    }
}


fun main() {
    testSolverKnapsack()
}