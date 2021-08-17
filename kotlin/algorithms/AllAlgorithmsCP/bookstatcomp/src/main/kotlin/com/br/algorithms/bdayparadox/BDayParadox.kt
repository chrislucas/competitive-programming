package com.br.algorithms.bdayparadox

import kotlin.math.exp


/**
 * https://en.wikipedia.org/wiki/Birthday_problem
 * https://pt.wikipedia.org/wiki/Paradoxo_do_anivers%C3%A1rio
 * */


fun squaringExponentiation(base: Long, exp: Long): Long {
    return when (exp){
        0L  -> { 1L }
        1L -> { base }
        else -> {
            var acc = 1L
            var mExp = exp
            var mBase = base
            while (mExp > 0) {
                if (mExp and 1L == 1L) {
                    acc *= mBase
                }
                mBase *= mBase
                mExp = mExp shr 1
            }
            acc
        }
    }
}

private fun testExp() {
    println(squaringExponentiation(12L, 3L))
    println(squaringExponentiation(125L, 3L))
}

fun main(args: Array<String>) {
    testExp()
}