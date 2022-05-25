package src.com.br.cp.recursion.dp.knapsack

/**
 *  Usando uma matriz de 2 linhas
 *  https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=lbp
 */

private fun solver(weights: Array<Int>, values: Array<Int>, capacity: Int): Int {
    val dp = Array(2) { Array(capacity + 1) { 0 } }

    return dp[values.size % 2][capacity]
}