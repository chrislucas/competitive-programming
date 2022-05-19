package com.br.algo.math.lib.ntheory.exponentiantion.matrix

import java.math.BigInteger

/**
 * https://www.geeksforgeeks.org/matrix-exponentiation/
 *
 */


typealias MatrixInt = Array<Array<Int>>


private fun exp(matrix: MatrixInt, nth: Int) {

    operator fun MatrixInt.get(i: Int, j: Int) = this[i][j]

    operator fun MatrixInt.set(i: Int, j: Int, value: Int) {
        this[i][j] = value
    }

    infix operator fun MatrixInt.times(that: MatrixInt): MatrixInt {

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
}




fun main() {

}