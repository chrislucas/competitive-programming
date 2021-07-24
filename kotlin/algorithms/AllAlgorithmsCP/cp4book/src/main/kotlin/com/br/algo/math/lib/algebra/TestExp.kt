package com.br.algo.math.lib.algebra

import kotlin.math.ln
import kotlin.math.exp


fun testDoubleExp() {
    //println(dexp(3.0, 4.0))
    //println(dexp(3.0, -4.0))
    println(dexp(100.0, .5))
    println(dexp(100.0, -2.0))
}


fun test() {
    println(exp(100 * ln(2.0)))

}

fun main() {
    testDoubleExp()
}