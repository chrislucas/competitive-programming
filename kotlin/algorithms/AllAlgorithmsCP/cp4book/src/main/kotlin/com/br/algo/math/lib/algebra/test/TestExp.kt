package com.br.algo.math.lib.algebra.test

import com.br.algo.math.lib.algebra.squaringDouble2Exp
import kotlin.math.ln
import kotlin.math.exp


fun testDouble2Exp() {
    println(squaringDouble2Exp(3.0, 4.0))
    println(squaringDouble2Exp(3.0, -4.0))
    println(squaringDouble2Exp(100.0, .5))
    println(squaringDouble2Exp(100.0, -2.0))
}


fun testEulerNumberRaisedTo() {
    println(exp(100 * ln(2.0)))

}

fun main() {
    testEulerNumberRaisedTo()
}