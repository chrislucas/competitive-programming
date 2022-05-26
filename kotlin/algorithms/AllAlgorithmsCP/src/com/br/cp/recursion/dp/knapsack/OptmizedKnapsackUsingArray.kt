package src.com.br.cp.recursion.dp.knapsack

/**
 *  com vetor: metodo 4
 *  https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=lbp
 */

private fun solver(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    val dp = Array(capacity + 1) { 0 }

    return dp[capacity]
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