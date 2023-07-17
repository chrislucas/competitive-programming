package src.com.br.cp.site.ds.kotlin.site.hackerearth.numbertheory.exponentiation.matrix.hackerearth

import java.lang.StringBuilder
import java.math.BigInteger

/*
    https://www.hackerearth.com/practice/notes/matrix-exponentiation-1/
    TODO
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
fun main() {

}