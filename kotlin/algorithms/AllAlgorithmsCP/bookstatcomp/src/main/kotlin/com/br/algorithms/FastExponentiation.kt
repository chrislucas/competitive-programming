package com.br.algorithms

import java.math.BigDecimal
import java.math.BigInteger

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
            if (expo < BigInt.ZERO) {
                base = BigDec.ONE.divide(base)
                expo = -expo
            }
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

private fun modular(b: BigDec, e: BigInt, m: BigInt): BigDec {
    var base = b
    var expo = e
    val cm = BigDec(m)

    fun multiply(a: BigDec, b: BigDec, m: BigDec): BigDec =
        (a % m * b % m) % m

    return when (expo) {
        BigInt.ZERO -> {
            BigDec.ONE
        }
        BigInt.ONE -> {
            base
        }
        else -> {
            if (expo < BigInt.ZERO) {
                base = BigDec.ONE.divide(base)
                expo = -expo
            }
            var acc = BigDec.ONE
            while (expo > BigInt.ZERO) {
                if (expo and BigInt.ONE == BigInt.ONE) {
                    acc = multiply(acc, base, cm)
                }
                base = multiply(base, base, cm)
                expo = expo shr 1
            }
            acc
        }
    }
}


fun main() {
    println(exp(BigDec("2"), BigInt("-3")))
    println(modular(BigDec("10"), BigInt("125"), BigInt("34")))
    println(modular(BigDec("343513213"), BigInt("542323"), BigInt("34")))
}