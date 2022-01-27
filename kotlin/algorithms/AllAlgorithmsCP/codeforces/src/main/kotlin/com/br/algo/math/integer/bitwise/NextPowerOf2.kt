package com.br.algo.math.integer.bitwise

import kotlin.math.ceil
import kotlin.math.log

/**
 * https://stackoverflow.com/questions/466204/rounding-up-to-next-power-of-2
 * https://en.wikipedia.org/wiki/Logarithm#Change_of_base
 * https://www.hackerearth.com/practice/notes/round-a-number-to-the-next-power-of-2/
 * https://en.wikipedia.org/wiki/Logarithm#Change_of_base
 * */


val Int.nextPowerOf2V1: Int
    get() {
        var value = this
        value -= 1
        value = value or (value shr 1)
        value = value or (value shr 2)
        value = value or (value shr 4)
        value = value or (value shr 8)
        value = value or (value shr 16)
        return value + 1
    }

// log A base B = log A base C / log B base C
// pow(2, ceil(log(x)/log(2)));
// pow: 2 exp: ceil(log x base 2)
private val Int.nextPowerOf2: Int
        get() {
            fun exp(base: Int, e: Int): Int {
                return when (e) {
                    0 -> {
                        1
                    }
                    1 -> {
                        base
                    } else -> {
                        var acc = 1
                        var mE = e
                        var mB = base

                        while(mE > 0) {
                            if (mE  and 1 == 1) {
                                acc *= mB
                            }
                            mB *= mB
                            mE = mE shr 1
                        }
                        acc
                    }
                }
            }

            return exp(2, ceil(log(this*1.0, 2.0)).toInt())
        }


private fun test() {
    (0 .. 1023).forEach {
        println("Int: $it - nextPowerOf2: ${it.nextPowerOf2}")
    }
}

fun main() {
    test()
}