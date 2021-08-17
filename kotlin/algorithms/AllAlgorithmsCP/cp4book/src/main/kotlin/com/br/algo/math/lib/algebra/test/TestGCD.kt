package com.br.algo.math.lib.algebra.test

import com.br.algo.math.lib.algebra.gdc
import com.br.algo.math.lib.algebra.gdcInt

/**
 * https://www.dcode.fr/gcd
 * */


val data = arrayOf(arrayOf(8, 40, 100),
    arrayOf(20, 30, 50, 150, 300, 350, 2000, 2300, 2500, 10023),
    arrayOf(20, 30, 50, 150, 300, 350, 2000, 2300, 2500, 10023),
    arrayOf(30, 35, 50, 180, 300, 345, 2000, 2300, 2500, 3000)
)

private fun testArrayGcdProperty() {
    for (array in data) {
        println(array)
        val result = array.gdc
        println(array)
        println(result)
    }
}

private fun testArrayGcdFunction() {
    for (array in data) {
        println(array)
        val result = array.gdcInt()
        println(array)
        println(result)
    }
}

fun main() {
    testArrayGcdProperty()
    println("*********************************")
    testArrayGcdFunction()
}