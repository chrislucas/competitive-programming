package com.br.algo.math.lib.algebra.matrix


typealias Matrix<T> = Array<Array<T>>


operator fun <T> Matrix<T>.get(i: Int, j: Int) = this[i][j]

operator fun <T> Matrix<T>.set(i: Int, j: Int, value: T) {
    this[i][j] = value
}

infix operator fun Matrix<Int>.times(that: Matrix<Int>): Matrix<Int> {
    if (this[0].size != that.size)
        throw Exception("Impossible compute")

    val res = Array(this.size) { Array(that[0].size) { 0 } }

    for (i in 0 until this.size) { // linha de a
        for (j in 0 until that[0].size) { // coluna de b
            for (k in 0 until this[0].size) { // linha de b ou coluna de a, ambos sao liga
                res[i, j] += this[i, k] * that[k, j]
            }
        }
    }

    return res
}


/**
 * https://matrixcalc.org/en/
 */
private fun checkMatrixMultiplication() {
    fun multiply(p: Pair<Array<Array<Int>>, Array<Array<Int>>>) {
        val (a, b) = p
        (a * b).forEach { array ->
            println(
                array.joinToString(", ")
            )
        }
    }

    val a1 = Pair(
        arrayOf(
            arrayOf(5, 8, -4),
            arrayOf(6, 9, -5),
            arrayOf(4, 7, -2)
        ),
        arrayOf(
            arrayOf(2), arrayOf(-3), arrayOf(1),
        )
    ) // [-18 -20 -15]

    // another test
    val a2 = Pair(
        arrayOf(
            arrayOf(2, 1, 4, 5),
            arrayOf(5, 2, 3, 1),
            arrayOf(1, 3, 4, 5)
        ),

        arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(10, 1, 2),
            arrayOf(3, 4, 3),
            arrayOf(1, 1, 0)
        )
    ) // [29, 26,20], [35,25,28], [28,26,21]

    multiply(a1)

}

fun main() {
    checkMatrixMultiplication()
}