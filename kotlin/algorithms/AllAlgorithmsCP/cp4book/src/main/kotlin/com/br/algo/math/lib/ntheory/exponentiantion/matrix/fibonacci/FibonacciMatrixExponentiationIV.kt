package com.br.algo.math.lib.ntheory.exponentiantion.matrix.fibonacci

/**
 * https://itnext.io/blazing-fast-fibonacci-with-kotlin-and-arrow-library-33c1d7eca0bb
 * Tinha visto que existe uma outra forma matricial de representar a recorrencia
 */

import java.math.BigInteger

typealias MatrixBigInt = Array<Array<BigInteger>>

fun exp(nth: BigInteger) {

    operator fun MatrixBigInt.get(i: Int, j: Int) = this[i][j]

    operator fun MatrixBigInt.set(i: Int, j: Int, value: BigInteger) {
        this[i][j] = value
    }

    infix operator fun MatrixBigInt.times(that: MatrixBigInt): MatrixBigInt {

        if (this[0].size != that.size)
            throw Exception("Impossible compute")

        val res = Array(this.size) { Array(that[0].size) { BigInteger.ZERO } }

        for (i in 0 until this.size) { // linha de a
            for (j in 0 until that[0].size) { // coluna de b
                for (k in 0 until this[0].size) { // linha de b ou coluna de a, ambos sao liga
                    res[i, j] += this[i, k] * that[k, j]
                }
            }
        }
        return res
    }

    fun exp(mat: MatrixBigInt, e: BigInt): MatrixBigInt {
        fun multiply(p: MatrixBigInt, q: MatrixBigInt): MatrixBigInt {
            val r = arrayOf(
                p[0, 0] * q[0, 0] + p[0, 1] * q[1, 0],
                p[0, 0] * q[0, 1] + p[0, 1] * q[1, 1]
            )
            val s = arrayOf(
                p[1, 0] * q[0, 0] + p[1, 1] * q[1, 0],
                p[1, 0] * q[0, 1] + p[1, 1] * q[1, 1]
            )
            return arrayOf(r, s)
        }

        var cpy = mat
        var res = mat
        var ce = e
        while (ce > BigInt.ZERO) {
            if (ce and BigInt.ONE == BigInt.ONE) {
                res = multiply(res, cpy)
            }
            ce = ce shr 1
            cpy = multiply(cpy, cpy)
        }
        return res
    }

    val mat = arrayOf(
        arrayOf(BigInteger.ZERO, BigInteger.ONE),
        arrayOf(BigInteger.ONE, BigInteger.ONE)
    )

    val vet = arrayOf(arrayOf(BigInteger.ZERO), arrayOf(BigInteger.ONE))

    val res = exp(mat, nth - BigInteger.ONE) * vet // res = [ [f(n)], [f(n+1)] ]

    res.forEach { vetor ->
        println(vetor.joinToString(", "))
    }
}

fun main() {
    exp(BigInteger("3"))
    exp(BigInteger("10"))

}