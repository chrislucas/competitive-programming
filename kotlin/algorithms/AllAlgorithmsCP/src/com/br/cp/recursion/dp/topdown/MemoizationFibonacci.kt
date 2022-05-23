package src.com.br.cp.recursion.dp.topdown

/**
 * https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
 * https://r-knott.surrey.ac.uk/Fibonacci/fibtable.html
 */

private fun solver(n: Int): Long {
    fun solver(n: Int, memo: Array<Long>): Long {
        if (memo[n] == 0L) {
            if (n < 2) {
                memo[n] = n * 1L
            } else {
                memo[n - 1] = solver(n - 1, memo)
                memo[n - 2] = solver(n - 2, memo)
                memo[n] = memo[n - 1] + memo[n - 2]
            }
        }
        return memo[n]
    }

    val memo = Array(n + 1) { 0L }
    solver(n, memo)
    return memo[n]
}


fun main() {
    (1..92).forEach {
        println("$it: ${solver(it)}")
    }
}