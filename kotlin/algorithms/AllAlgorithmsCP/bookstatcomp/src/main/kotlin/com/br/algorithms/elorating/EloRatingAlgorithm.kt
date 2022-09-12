package com.br.algorithms.elorating

import java.math.BigDecimal
import java.math.BigInteger

/*
    https://en.wikipedia.org/wiki/Elo_rating_system
    https://www.hackerearth.com/blog/developers/elo-rating-system-common-link-facemash-chess/

    evento_a = 1 / 1 + 10 ^ ((rb - ra) / 400)
    evento_b = 1 / 1 + 10 ^ ((ra - rb) / 400)

 */


private fun exp(b: Double, e: Long): Double {
    var base = b
    var expo = e
    return when (expo) {
        0L -> {
            1.0
        }
        1L -> {
            base
        }
        else -> {
            var acc = 1.0
            while (expo > 0) {
                if (expo and 1 == 1L) {
                    acc *= base
                }
                base *= base
                expo = expo shr 1
            }
            acc
        }
    }
}

private typealias BigDec = BigDecimal
private typealias BigInt = BigInteger

private fun exp(b: BigDec, e: BigInt): BigDec {
    var base = b
    var expo = e
    return when (expo) {
        BigInt.ZERO -> {
            BigDec.ONE
        }
        BigInt.ONE -> {
            base
        }
        else -> {
            var acc = BigDec.ONE
            while (expo > BigInt.ZERO) {
                if (expo and BigInt.ONE == BigInt.ONE) {
                    acc *= base
                }
                base *= base
                expo = expo shr 1
            }
            acc
        }
    }
}


fun main() {
    println(exp(0.5, 1013))
    println(exp(BigDec("0.5"), BigInt("1013")))
    println(exp(BigDec("0.5"), BigInt("3")))
}