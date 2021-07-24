package com.br.algo.math.lib.algebra



private fun testRoot() {
    println(root(100.0, index = 2))
    println(root(100, index = 2))
}


private fun testLog() {
    println(log(10, 100))
    println(log(2, 100))
    println(log(3, 27))
}

private fun testLogE() {
    println(logE(Math.E))
}

fun main() {
  testRoot()
}