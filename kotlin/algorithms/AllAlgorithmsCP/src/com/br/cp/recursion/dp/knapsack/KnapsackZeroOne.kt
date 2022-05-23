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
    return if (target == 0 || idx == 0) {
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

private fun bottomUpKnapack(weights: Array<Int>, values: Array<Int>, target: Int): Int {
    val state = Array(weights.size + 1) { Array(values.size) { 0 } }

    for (i in values.indices) {
        state[0][i] = 1
    }

    return state[weights.size][target - 1]
}


private val testCases = arrayOf(
    arrayOf(10, 20, 30) to arrayOf(60, 100, 120) to 50
)

private fun testTopDownKnapsack() {
    testCases.forEach { (p, k) ->
        val (w, v) = p
        val s = topDownKnapsack(w, v, k, v.size - 1)
        val r = bottomUpKnapack(w, v, k)
        println("$s, $r")
    }
}


fun main() {
    testTopDownKnapsack()
}