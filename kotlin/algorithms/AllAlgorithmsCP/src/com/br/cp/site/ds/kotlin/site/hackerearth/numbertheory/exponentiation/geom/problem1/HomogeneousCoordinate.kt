package src.com.br.cp.site.ds.kotlin.site.hackerearth.numbertheory.exponentiation.geom.problem1

import java.lang.StringBuilder
import java.math.BigInteger

/*
    https://cp-algorithms.com/algebra/binary-exp.html#fast-application-of-a-set-of-geometric-operations-to-a-set-of-points
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


fun main() {

}