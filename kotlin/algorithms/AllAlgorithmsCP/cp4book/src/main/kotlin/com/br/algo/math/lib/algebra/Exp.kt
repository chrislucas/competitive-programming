package com.br.algo.math.lib.algebra

/**
 * Application
 * https://cp-algorithms.com/algebra/binary-exp.html
 * */

fun iexp(base: Int, expo: Int): Int {
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


fun miexp(base: Long, expo: Long, mod: Long): Long {

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


fun dexp(base: Double, expo: Long): Double {
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

fun dexp(base: Double, expo: Double): Double {
    return when (expo) {
        0.0 -> {
            1.0
        }
        1.0 -> {
            base
        }
        else -> {
            var (mExpo, mBase) = if (expo < 0) {
                -expo to (1.0 / base)
            } else if (expo < 1) {
                expo to (1.0 / base)
            } else {
                expo to base
            }
            var acc = 1.0
            while (mExpo > 0) {
                if (mExpo % 2 == 1.0) {
                    acc *= mBase
                }
                mBase *= mBase
                mExpo /= 2
            }
            acc
        }
    }
}