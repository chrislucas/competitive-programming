package src.com.br.oj.uva.dp.maximumsum

/*
    https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
 */

private val testCases = arrayOf(
    arrayOf(
        arrayOf(1, 2, -1, -4, -20),
        arrayOf(-8, -3 - 4, 2, 1),
        arrayOf(3, 8, 10, 1, 3),
        arrayOf(-4, -1, 1, 7, -6),
    )
)

private typealias Matrix<T> = Array<Array<T>>

private fun kadane2D(mat: Matrix<Int>) {
    val m = mat.size
    val n = mat[0].size
    val dp = Array(m + 1) { Array(n) { 0 } }

    for (i in 0 until m) {
        for (j in 0 until n) {
            dp[i + 1][j] = dp[i][j] + mat[i][j]
        }
    }


}

fun main() {

}