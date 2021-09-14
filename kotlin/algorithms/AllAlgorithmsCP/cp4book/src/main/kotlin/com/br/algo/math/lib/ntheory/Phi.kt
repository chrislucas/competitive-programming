package com.br.algo.math.lib.ntheory

import kotlin.math.ln
import kotlin.math.log
import kotlin.math.roundToInt

// https://cp-algorithms.com/algebra/phi-function.html

private fun testApproximation() {

    fun approximationA(x: Int) = x / ln(x * 1.0)

    fun approximationB(x: Int) = x / log(x * 1.0, Math.E)

    for (i in 1..1000) {
        println(String.format("%d -> %f, %f", i, approximationA(i), approximationB(i)))
    }

}

fun main(args: Array<String>) {
    testApproximation()
}