package com.br.algo.math.lib.ntheory.modular.fermat

/**
 *  https://cp-algorithms.com/algebra/binary-exp.html
 */


fun modularBinaryExp(b: Long, e: Long, m: Long): Long {
    return when (e) {
        0L -> {
            1L
        }
        1L -> {
            b % m
        }
        else -> {
            var acc = 1L
            var ce = e
            var cb = b % m
            while (ce > 0) {
                if (ce and 1L == 1L) {
                    acc = (acc % m * cb % m) % m
                }
                cb = (cb % m * cb % m) % m
                ce = ce shr 1
            }
            acc
        }
    }
}


fun main() {
    println(modularBinaryExp(11, 24, 26)) // = 1
    println(modularBinaryExp(343513213, 542323, 542323)) // = 222754
}