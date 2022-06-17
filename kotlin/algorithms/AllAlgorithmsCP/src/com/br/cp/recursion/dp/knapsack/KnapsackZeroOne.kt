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

private typealias Matrix<T> = Array<Array<T>>

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

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=lbp
 */
private fun bottomUp(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    // [weights][capacities]
    val state = Array(weights.size + 1) { Array(capacity + 1) { 0 } }
    for (wi in 1..weights.size) {
        for (ci in 1..capacity) {
            state[wi][ci] = if (weights[wi - 1] <= ci) {
                val include = state[wi - 1][ci - weights[wi - 1]] + values[wi - 1]
                val exclude = state[wi - 1][ci]
                max(include, exclude)
            } else {
                state[wi - 1][ci]
            }
        }
    }
    return state[weights.size][capacity]
}

private fun markParent(
    weights: Array<Int>,
    values: Array<Int>,
    capacity: Int
): Matrix<Pair<Pair<Int, Int>, Int>> {
    val state = Array(weights.size + 1) { Array(capacity + 1) { Pair(0 to 0, 0) } }
    for (wi in 1..weights.size) {
        for (ci in 1..capacity) {
            state[wi][ci] = if (ci < weights[wi - 1]) {
                state[wi - 1][ci]
            } else {
                val (p, q) = wi - 1 to ci - weights[wi - 1]
                val (r, s) = wi - 1 to ci
                val i = state[p][q].second + values[wi]
                val e = state[r][s].second
                if (i > e) {
                    Pair(p to q, i)
                } else {
                    Pair(r to s, e)
                }
            }
        }
    }
    return state
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

private fun testSolverKnapsack() {
    testCases.forEach { (p, capacity) ->
        val (w, v) = p
        val r = topDownKnapsack(w, v, capacity, v.size - 1)
        val u = bottomUp(w, v, capacity)
        println("$r, $u")
    }
}

private fun checkMarkParent() {
    testCases.forEach { (p, capacity) ->
        val (w, v) = p
        val m = markParent(w,v, capacity)
        println(m)
    }
}

fun main() {
    testSolverKnapsack()
}