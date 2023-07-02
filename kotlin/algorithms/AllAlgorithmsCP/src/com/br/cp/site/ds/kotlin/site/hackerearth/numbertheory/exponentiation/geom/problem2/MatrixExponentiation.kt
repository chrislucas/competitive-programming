package src.com.br.cp.site.ds.kotlin.site.hackerearth.numbertheory.exponentiation.geom.problem2

import java.lang.StringBuilder
import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO


/*
    Fast application of a set of geometric operations to a set of points
    https://cp-algorithms.com/algebra/binary-exp.html#applying-a-permutation-k-times
 */

typealias BigInt = BigInteger

typealias MatBigInt = Array<Array<BigInt>>

operator fun MatBigInt.get(x: Int, y: Int) = this[x][y]

operator fun MatBigInt.set(x: Int, y: Int, v: BigInt) {
    this[x][y] = v
}

val MatBigInt.string: String
    get() {
        return with(StringBuilder()) {
            for (i in this@string.indices) {
                for (j in this@string[i].indices) {
                    if (this.isEmpty()) {
                        this.append(
                            "${this@string[i, j]}"
                        )
                    } else {
                        this.append(
                            ", ${this@string[i, j]}"
                        )
                    }
                }
                this.append("\n")
            }
            this.toString()
        }
    }


infix operator fun MatBigInt.times(that: MatBigInt): MatBigInt {
    val answer = Array(this.size) { Array(that[0].size) { BigInteger.ZERO } }
    for (i in this.indices) {
        for (j in that[0].indices) {
            for (k in this[0].indices) {
                answer[i, j] += this[i, k] * that[k, j]
            }
        }
    }
    return answer
}

infix operator fun Array<BigInt>.times(that: MatBigInt): MatBigInt {
    val answer = Array(this.size) { Array(that[0].size) { BigInteger.ZERO } }
    for (i in this.indices) {
        for (j in that[0].indices) {
            for (k in this.indices) {
                answer[i, j] += this[i] * that[k, j]
            }
        }
    }
    return answer
}

val Long.toBig: BigInteger
    get() = BigInteger.valueOf(this)

val Int.toBig: BigInteger
    get() = BigInteger.valueOf(this.toLong())

private fun checkMulitply() {
    val matA = arrayOf(arrayOf(ONE, ONE, ONE, ONE))
    val matB = Array(4) { Array(4) { ONE } }
    println((matA * matB).string)
    println((matA[0] * matB).string)
}

private fun matrixBinaryExponential(mat: MatBigInt, n: BigInt): MatBigInt {

    infix operator fun MatBigInt.times(that: MatBigInt): MatBigInt {
        val answer = Array(this.size) { Array(that[0].size) { BigInteger.ZERO } }
        for (i in this.indices) {
            for (j in that[0].indices) {
                for (k in this[0].indices) {
                    answer[i, j] += this[i, k] * that[k, j]
                }
            }
        }
        return answer
    }

    /*
        https://www.blogcyberini.com/2017/10/potenciacao-de-matrizes.html
        https://www.symbolab.com/solver/linear-algebra-calculator/
     */
    return if (n == ZERO) {
        // matriz identidade = o elemento neutro da multiplicacao entre matrizes
        Array(mat.size) { Array(mat[0].size) { ZERO } }.apply {
            for (i in mat.indices) {
                this[i][i] = ONE
            }
        }
    } else if (n == ONE) {
        mat
    } else {
        var base = mat
        var answer = mat
        var e = n - ONE
        while (e > ZERO) {
            if (e and ONE == ONE) {
                answer *= base
            }
            base *= base
            e = e shr 1
        }
        answer
    }
}

private fun checkMatrixBinaryExponential() {
    val mat = arrayOf(
        arrayOf(ONE, ONE, ONE),
        arrayOf(BigInt("2"), BigInt("2"), BigInt("2")),
        arrayOf(BigInt("2"), BigInt("2"), BigInt("2")),
    )

    val rs1 = matrixBinaryExponential(mat, BigInt("2"))
    println(rs1.string)

    println("************************** // *************************************")

    val mat2 = arrayOf(
        arrayOf(ONE, ONE),
        arrayOf(BigInt("2"), BigInt("2"))
    )
    val rs2 = matrixBinaryExponential(mat2, BigInt("3"))
    println(rs2.string)

    println("************************** // *************************************")

    val mat3 = arrayOf(
        arrayOf(1.toBig, 2.toBig, 3.toBig),
        arrayOf(0.toBig, (-1).toBig, (-2).toBig),
        arrayOf(1.toBig, 4.toBig, 1.toBig)
    )
    val rs3 = matrixBinaryExponential(mat3, BigInt("3"))
    println(rs3.string)

    println("************************** // *************************************")

    val mat4 = arrayOf(
        arrayOf(1.toBig, 2.toBig, 3.toBig),
        arrayOf(0.toBig, (-1).toBig, (-2).toBig),
        arrayOf(1.toBig, 4.toBig, 1.toBig)
    )
    val rs4 = matrixBinaryExponential(mat4, ZERO)
    println(rs4.string)
}


private fun matrixModularBinaryExponential(mat: MatBigInt, n: BigInt, m: BigInt): MatBigInt {

    fun modular(matrixA: MatBigInt, matrixB: MatBigInt, m: BigInt): MatBigInt {
        val answer = Array(matrixA.size) { Array(matrixB[0].size) { ZERO } }
        for (i in matrixA.indices) {
            for (j in matrixB[0].indices) {
                for (k in matrixA[0].indices) {
                    answer[i, j] += (matrixA[i, k] % m * matrixB[k, j] % m) % m
                }
            }
        }
        return answer
    }

    return if (n == ZERO) {
        // matriz identidade = o elemento neutro da multiplicacao entre matrizes
        Array(mat.size) { Array(mat[0].size) { ZERO } }.apply {
            for (i in mat.indices) {
                this[i][i] = ONE
            }
        }
    } else if (n == ONE) {
        mat.apply {
            for (i in mat.indices) {
                for (j in mat[i].indices) {
                    this[i, j] %= m
                }
            }
        }
    } else {
        var base = mat
        var answer = mat
        var e = n - ONE
        while (e > ZERO) {
            if (e and ONE == ONE) {
                answer = modular(base, answer, m)
            }
            base = modular(base, base, m)
            e = e shr 1
        }
        answer
    }
}

private fun checkMatrixModularBinaryExponential() {
    arrayOf(
        /*
            9,9
            18,18
         */
        arrayOf(
            arrayOf(ONE, ONE),
            arrayOf(2.toBig, 2.toBig)
        )
    ).forEach { mat ->
        println(matrixModularBinaryExponential(mat, 3.toBig, 2.toBig).string)
    }

}

private fun checkHomogeneuorsCoordinates() {
    val op1 = Array(4) { Array(4) { ZERO } }
    op1[0, 0] = ONE
    op1[1, 1] = ONE
    op1[2, 2] = ONE
    op1[3, 3] = ONE

    // coordenadas 3D x=5, y=7, z=9
    op1[3, 0] = 5.toBig
    op1[3, 1] = 7.toBig
    op1[3, 2] = 9.toBig
}

fun main() {
    //checkMulitply()
    //println("***************************************************************")
    //checkMatrixBinaryExponential()
    //println("***************************************************************")
    checkMatrixModularBinaryExponential()
}