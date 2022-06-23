package src.com.br.oj.uva.dp.maximumsum

/*
    https://www.interviewbit.com/blog/maximum-sum-rectangle/
    https://www.tutorialspoint.com/Maximum-sum-rectangle-in-a-2D-matrix
    https://www.tutorialcup.com/interview/dynamic-programming/maximum-sum-rectangle-in-a-2d-matrix.htm
 */


private val testCases = arrayOf(
    arrayOf(
        arrayOf(1, 2, -1, -4, -20),
        arrayOf(-8, -3, 4, 2, 1),
        arrayOf(3, 8, 10, 1, 3),
        arrayOf(-4, -1, 1, 7, -6)
    ), // saida esperada retangulo (1, 1) (3, 3) max = 29
    arrayOf(
        arrayOf(1, 0, 1, 0, 1),
        arrayOf(0, 1, 0, 1, 0),
        arrayOf(1, 0, 1, 0, 1),
        arrayOf(0, 1, 0, 1, 0)
    ) // saida esperada retangulo (0, 0) (3,4) max = 10
)

/*
    solucao baseada no link
    https://www.interviewbit.com/blog/maximum-sum-rectangle/
 */

private data class Kadane2D(val max: Int, val left: Int, val top: Int, val right: Int, val bottom: Int)

private fun s1(mat: Array<Array<Int>>): Kadane2D {

    fun kadane(array: Array<Int>): Pair<Int, Pair<Int, Int>> {
        var global = array[0]
        var local = 0
        var p = 0
        var q = 0
        var s = 0
        for (i in array.indices) {
            local += array[i]
            if (local > global) {
                global = local
                p = s
                q = i
            } else if (local < 0) {
                local = 0
                s = i + 1
            }
        }
        return Pair(global, p to q)
    }

    val lin = mat.size
    val col = mat[0].size
    var (left, right, top, bottom) = arrayOf(-1, -1, -1, -1)
    var global = Int.MIN_VALUE

    for (i in 0 until col) {
        val subset = Array(lin) { 0 }
        for (j in i until col) {
            for (k in 0 until lin) {
                subset[k] += mat[k][j]
            }
            val (local, pair) = kadane(subset)
            val (p, q) = pair
            if (local > global) {
                global = local
                left = i
                right = j
                top = p
                bottom = q
            }
        }
    }

    return Kadane2D(global, left, top, right, bottom)
}


private fun checkSolution() {
    testCases.forEach { case ->
        val a = s1(case)
        println(a)
    }
}


fun main() {
    checkSolution()
}