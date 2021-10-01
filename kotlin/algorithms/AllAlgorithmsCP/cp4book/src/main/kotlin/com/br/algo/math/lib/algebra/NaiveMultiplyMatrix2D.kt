package com.br.algo.math.lib.algebra

import java.lang.IllegalArgumentException
import java.lang.StringBuilder


typealias Matrix2D <T> = Array<Array<T>>

typealias IntMatrix2D = Matrix2D<Int>

typealias DoubleMatrix2D = Matrix2D<Double>


infix fun IntMatrix2D.multiply(other: IntMatrix2D): IntMatrix2D? {
    val lA = this.size
    val cA = this[0].size
    val lB = other.size
    val cB = other[0].size

    if (cA != lB)
        return null

    val result = IntMatrix2D(lA) { Array(cB) { 0 } }

    for (i in 0 until lA) {
        for (j in 0 until cB) {
            for (k in 0 until lB) {
                result[i][j] += this[i][k] * other[k][j]
            }
        }
    }

    return result
}


infix fun DoubleMatrix2D.multiply(other: DoubleMatrix2D): DoubleMatrix2D {
    val lA = this.size
    val cA = this[0].size
    val lB = other.size
    val cB = other[0].size

    val result = DoubleMatrix2D(lA) { Array(cB) { 0.0 } }


    return result
}


val <T> Matrix2D<T>.string: String
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

private fun test1() {
    val a = arrayOf(arrayOf(1, 2), arrayOf(1, 2))
    val b = arrayOf(arrayOf(3, 4), arrayOf(3, 4))

    val msg = "A: ${a.string}\nB: ${b.string}\nR: ${(a multiply b)?.string}\n******************\n"
    println(msg)
}

private fun test2() {
    val a = arrayOf(arrayOf(3, 3), arrayOf(4, 5), arrayOf(-12, -23), arrayOf(345, 123))
    val b = arrayOf(arrayOf(4), arrayOf(-5))

    val msg = "A: ${a.string}\nB: ${b.string}\nR: ${(a multiply b)?.string}\n******************\n"
    println(msg)
}

private fun test3() {
    val matrix1 = arrayOf(arrayOf(1, 2), arrayOf(3, 4))
    val matrix2 = arrayOf(arrayOf(-1, 3), arrayOf(4, 2))

    println("R: ${(matrix1 multiply matrix2)?.string}\n******************\n")

    val matrix3 = arrayOf(arrayOf(2, 3), arrayOf(0, 1), arrayOf(-1, 4))
    val matrix4 = arrayOf(arrayOf(1, 2, 3), arrayOf(-2, 0, 4))
    println("R: ${(matrix3 multiply matrix4)?.string}\n******************\n")

    val matrix5 = arrayOf(arrayOf(-1, 3), arrayOf(4, 2))
    val matrix6 = arrayOf(arrayOf(1, 2), arrayOf(3, 4))
    println("R: ${(matrix5 multiply matrix6)?.string}\n******************\n")


}

fun main() {
    //test1()
    //test2()
    test3()
}