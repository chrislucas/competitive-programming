package com.br.algo.math.lib.circle

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/*
    https://math.stackexchange.com/questions/256100/how-can-i-find-the-points-at-which-two-circles-intersect
    https://www.obaricentrodamente.com/2011/06/interseccao-de-circunferencias.html#
    https://pt.stackoverflow.com/questions/260057/como-detectar-quais-s%C3%A3o-os-pontos-em-comum-entre-duas-circunfer%C3%AAncias
 */


/*

 */





private fun checkIfCircleInsideAnotherOne() {

    val pairs = arrayOf(
        /*
        Circle(10.0, 8.0, 30.0) to Circle(1.0, 2.0, 10.0),
        Circle(7.0, 8.0, 30.0) to Circle(3.0, 5.0, 25.0),
        Circle(7.0, 8.0, 30.0) to Circle(7.0, 8.0, 30.0),

         */
        Circle(27.0, 8.0, 30.0) to Circle(7.0, 8.0, 30.0),
        Circle(10.0, 8.0, 30.0) to Circle(7.0, 8.0, 30.0),
        Circle(34.0, 8.0, 3.0) to Circle(7.0, 8.0, 30.0),
        Circle(35.0, 8.0, 3.0) to Circle(7.0, 8.0, 30.0),
        Circle(35.0, 8.0, 2.0) to Circle(7.0, 8.0, 30.0),

    )

    pairs.forEach {
        (p, q) ->
        val isInside = p.checkIfCircleInsideAnotherOne(q)
        println("$p ${if (isInside) "is" else "isn't"} inside $q")

        when(p.touchInternallyOrExternally(q)) {
            0 -> {
                println("$p e $q nao se tocam")
            }

            1 -> {
                println("$p e $q se tocam internamente")
            }
            else -> {
                println("$p e $q se tocam externamente")
            }
        }
        println("")
    }

}


fun main() {
    checkIfCircleInsideAnotherOne()
}