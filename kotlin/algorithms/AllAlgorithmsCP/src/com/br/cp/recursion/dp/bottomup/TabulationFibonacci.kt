package src.com.br.cp.recursion.dp.bottomup

import java.lang.Integer.min

/**
 * https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
 */

private fun solver(n: Int): Long {

    fun solver(n: Int, buffer: Array<Long>) {
        for (i in 1 .. min(n, 2)) {
            buffer[i] = 1
        }

        for (i in 3..n) {
            buffer[i] = buffer[i - 1] + buffer[i - 2]
        }
    }
    val buffer = Array(n + 1) { 0L }
    solver(n, buffer)
    return buffer[n]
}


fun main() {
    (1..100).forEach {
        println("$it: ${solver(it)}")
    }
}