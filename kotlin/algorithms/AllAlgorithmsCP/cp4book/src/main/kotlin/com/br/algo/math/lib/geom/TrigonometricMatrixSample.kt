package com.br.algo.math.lib.geom

import java.lang.StringBuilder
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


private val degree = (PI / 6)

private val MATRIX_TRIG = arrayOf(
    arrayOf(cos(degree), -sin(degree)),
    arrayOf(sin(degree), -cos(degree)),
)

/*
      [
        [cos(PI / 6), -sin(PI / 6)],
        [sin(PI / 6), -cos(PI / 6)]
      ]
       *
      [[X],
      [Y]]
      =
      [[X],
      [Y]]
 */

typealias Matrix2D <T> = Array<Array<T>>


typealias DoubleMatrix = Matrix2D<Double>

val <T>  Matrix2D<T>.string: String
    get() {
        val sb = StringBuilder()
        sb.append("[")
        for (i in 0 until this.size) {
            sb.append(if (i > 0) "\n[" else "[")
            for (j in 0 until this[i].size) {
                sb.append(if (j == 0) "${this[i][j]}" else ", ${this[i][j]}")
            }
            sb.append(if (i < this.size - 1) "]," else "]")
        }
        sb.append("]")
        return sb.toString()
    }

/*
        https://www.somatematica.com.br/emedio/matrizes/matrizes4.php
        https://brasilescola.uol.com.br/matematica/multiplicacao-matrizes.htm
        A = [M, N]
        B = [N, O]

        C = A * B so eh possivel se o numero de colunas de A for igual ao numero de linhas de B

        C = [M, O]
        [
            l(0 a M)
            c(0 a O)
           [A00 * B00 + A01 * B10 ... + A0N * BN0], [A00 * B01 + A01 * B11 ...  + A0N * BN1], [...], [A00 * B0O + ... A0N * BNO]
            ...
           [AM0 * B00 + AM1 * B10 ... + AMN * BN0], [AM0 * B01 + AM1 * B11 ...  + AMN * BN1],  [..], [AM0 * BN0 + ... AMN * BNO]
        ]

*/
private infix fun DoubleMatrix.multiply(other: DoubleMatrix): DoubleMatrix? {

    val cA = this[0].size
    val lA = this.size
    val cB = other[0].size
    val lB = other.size

    if(cA != lB)
        return null

    val result = DoubleMatrix(lA) { Array(cB) { 0.0 } }

    for (i in 0 until lA) {
        for (j in 0 until cB) {
            for (k in 0 until cA) {
                result[i][j] += this[i][k] * other[k][j]
            }
        }
    }

    return result
}


fun main() {
    println(MATRIX_TRIG.string)
    val matrix = MATRIX_TRIG multiply arrayOf(arrayOf(2.0), arrayOf(3.0)) // [2, 2] * [2, 1]
    println(matrix?.string)
}