package com.br.cp.site.algebra.kotlin

import kotlin.math.log10

/**
 * log a base b = c -> b^c = a
 * */

fun <T:Number> T.log(base: Long): Double = log10(this.toDouble()) / log10(base * 1.0)


fun main() {
    val p = 10
    println(p.log(2))
    println(100.log(10))
}