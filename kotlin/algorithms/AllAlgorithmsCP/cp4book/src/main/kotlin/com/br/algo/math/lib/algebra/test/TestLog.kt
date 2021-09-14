package com.br.algo.math.lib.algebra.test

import com.br.algo.math.lib.algebra.log
import com.br.algo.math.lib.algebra.logE


private fun testLog() {
    println(log(10, 100))
    println(log(2, 100))
    println(log(3, 27))
}

private fun testLogE() {
    println(logE(Math.E))
}

fun main() {
    testLog()
    testLogE()
}