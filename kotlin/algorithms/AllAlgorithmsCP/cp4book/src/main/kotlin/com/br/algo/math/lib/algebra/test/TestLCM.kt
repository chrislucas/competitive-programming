package com.br.algo.math.lib.algebra.test

import com.br.algo.math.lib.algebra.lcmInt


val numbers = arrayOf(arrayOf(6, 10),
    arrayOf(2,40,100,345)
)


private fun testLCMProperty() {
    for (array in numbers) {
        println(array.lcmInt)
    }
}


fun main(args: Array<String>) {
    testLCMProperty()
}