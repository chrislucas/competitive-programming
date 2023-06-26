package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.numbertheory.exponentiation.geom

import src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.numbertheory.exponentiation.get
import src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.numbertheory.exponentiation.set
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

fun MatBigInt.string(): String =
    with(StringBuilder()) {
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

private fun checkMulitply() {
    val matA = arrayOf(arrayOf(ONE, ONE, ONE, ONE))
    val matB = Array(4) { Array(4) { ONE } }
    println((matA * matB).string())
    println((matA[0] * matB).string())
}

private fun exp(mat: MatBigInt, n: BigInt): MatBigInt {
    var base = mat
    var answer = Array(2) { Array(2) { ONE } }
    var e = n
    while (e > ZERO) {
        if (e and ONE == ONE) {
            answer *= base
        }
        base *= base
        e = e shr 1
    }
    return answer
}


fun Long.toBig() = BigInteger.valueOf(this)

private fun checkHomogeneuorsCoordinates() {
    val op1 = Array(4) { Array(4) { ZERO } }
    op1[0, 0] = ONE
    op1[1, 1] = ONE
    op1[2, 2] = ONE
    op1[3, 3] = ONE

    // coordenadas 3D x=5, y=7, z=9
    op1[3, 0] = 5L.toBig()
    op1[3, 1] = 7L.toBig()
    op1[3, 2] = 9L.toBig()
}

fun main() {
    checkMulitply()
}