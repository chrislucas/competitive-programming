package com.br.algo.math.lib.algebra

import java.math.BigInteger

/**
 * Application
 * https://cp-algorithms.com/algebra/binary-exp.html
 * */

fun squaringInt2Exp(base: Int, expo: Int): Int {
    var mBase = base
    var mExpo = expo
    return when {
        expo <= 0 -> {
            1
        }
        expo == 1 -> {
            base
        }
        else -> {
            var acc = 1
            while (mExpo > 0) {
                if (mExpo and 1 == 1) {
                    acc *= mBase
                }
                mBase *= mBase
                mExpo = mExpo shr 1
            }
            acc
        }
    }
}


fun squaringLongExp(base: Long, expo: Long, mod: Long): Long {

    fun multiply(a: Long, b: Long, m: Long) = (a % m * b % m) % m

    var mBase = base
    var mExpo = expo
    return when {
        expo <= 0L -> {
            1
        }
        expo == 1L -> {
            base
        }
        else -> {
            var acc = 1L
            while (mExpo > 0) {
                if (mExpo and 1L == 1L) {
                    acc = multiply(acc, mBase, mod)
                }
                mBase = multiply(mBase, mBase, mod)
                mExpo = mExpo shr 1
            }
            acc
        }
    }
}


fun squaringDoubleExp(base: Double, expo: Long): Double {
    return when (expo) {
        0L -> {
            1.0
        }
        1L -> {
            base
        }
        else -> {
            var (mExpo, mBase) = if (expo < 0) {
                -expo to (1.0 / base)
            } else {
                expo to base
            }
            var acc = 1.0
            while (mExpo > 0) {
                if (mExpo and 1L == 1L) {
                    acc *= mBase
                }
                mBase *= mBase
                mExpo = mExpo shr 1
            }
            acc
        }
    }
}

fun squaringDouble2Exp(base: Double, expo: Double): Double {
    return when (expo) {
        0.0 -> {
            1.0
        }
        1.0 -> {
            base
        }
        else -> {
            var (mExpo, mBase) = when {
                expo < 0 -> {
                    -expo to (1.0 / base)
                }
                expo < 1 -> {
                    expo to (1.0 / base)
                }
                else -> {
                    expo to base
                }
            }
            var acc = 1.0
            while (mExpo > 0) {
                if (mExpo % 2.0 == 1.0) {
                    acc *= mBase
                }
                mBase *= mBase
                mExpo /= 2
            }
            acc
        }
    }
}

typealias BigInt = BigInteger

fun bigIntExp(b: BigInt, e: BigInt): BigInt {
    return when (e) {
        BigInt.ZERO -> {
            BigInt.ONE
        }
        BigInt.ONE -> {
            b
        }
        else -> {
            var ce = e
            var cb = b
            var acc = BigInt.ONE
            while (ce > BigInt.ZERO) {
                if (ce and BigInt.ONE == BigInt.ONE) {
                    acc *= cb
                }
                cb *= cb
                ce = ce shr 1
            }
            acc
        }
    }
}

fun modularBigIntExp(b: BigInt, e: BigInt, m: BigInt): BigInt {
    return when (e) {
        BigInt.ZERO -> {
            BigInt.ONE
        }
        BigInt.ONE -> {
            b
        }
        else -> {
            var ce = e
            var cb = b
            var acc = BigInt.ONE
            while (ce > BigInt.ZERO) {
                if (ce and BigInt.ONE == BigInt.ONE) {
                    acc = (acc % m * cb % m) % m
                }
                cb = (cb % m * cb % m) % m
                ce = ce shr 1
            }
            acc
        }
    }
}

private fun checkBigIntExp() {
    println(bigIntExp(BigInt("3"), BigInt("3")))
    println(bigIntExp(BigInt("3"), BigInt("4")))
}


fun main() {

}