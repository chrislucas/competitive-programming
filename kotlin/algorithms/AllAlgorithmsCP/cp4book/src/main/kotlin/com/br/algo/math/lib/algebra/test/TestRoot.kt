package com.br.algo.math.lib.algebra.test


import com.br.algo.math.lib.algebra.ithDouble2Root
import com.br.algo.math.lib.algebra.ithDoubleRoot
import com.br.algo.math.lib.algebra.ithIntRoot
import kotlin.math.pow


private fun testBuiltinRunRoot() {
    println(100.0.pow(1.0 / 2)) // raiz quadrada de 100
    println(27.0.pow(1.0 / 3))  // raiz cubica de 27
}

private fun testRoot() {
    println(
        String.format(
            "ithDoubleRoot: %f\nithDoubleRoot: %f\n\nithIntRoot: %f\n",
            ithDoubleRoot(100.0, index = 2),
            ithDoubleRoot(27.0, index = 3),
            ithIntRoot(100, index = 2)
        ),
    )

}

private fun testIthDouble2Root() {
    println(ithDouble2Root(100.0, index = 2))
    println(ithDouble2Root(100.0, index = 3))
    println(ithDouble2Root(27.0, index = 3))
}


fun main() {
    //testRoot()
    testIthDouble2Root()
}