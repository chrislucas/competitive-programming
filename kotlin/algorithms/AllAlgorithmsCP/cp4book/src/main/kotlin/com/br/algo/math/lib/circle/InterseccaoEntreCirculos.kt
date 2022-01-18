package com.br.algo.math.lib.circle

/*
    https://math.stackexchange.com/questions/256100/how-can-i-find-the-points-at-which-two-circles-intersect
    https://www.obaricentrodamente.com/2011/06/interseccao-de-circunferencias.html#
    https://pt.stackoverflow.com/questions/260057/como-detectar-quais-s%C3%A3o-os-pontos-em-comum-entre-duas-circunfer%C3%AAncias
 */


private fun checkIfCircleInsideAnotherOne() {

    val pairs = arrayOf(
        Circle(10.0, 8.0, 30.0) to Circle(1.0, 2.0, 10.0),
        Circle(7.0, 8.0, 30.0) to Circle(3.0, 5.0, 25.0),
        Circle(7.0, 8.0, 30.0) to Circle(7.0, 8.0, 30.0),
        Circle(27.0, 8.0, 30.0) to Circle(7.0, 8.0, 30.0),
        Circle(10.0, 8.0, 30.0) to Circle(7.0, 8.0, 30.0),
        Circle(34.0, 8.0, 3.0) to Circle(7.0, 8.0, 30.0),
        Circle(35.0, 8.0, 3.0) to Circle(7.0, 8.0, 30.0),
        Circle(35.0, 8.0, 2.0) to Circle(7.0, 8.0, 30.0),
        Circle(38.0, 8.0, 2.0) to Circle(7.0, 8.0, 30.0),
        Circle(37.0, 8.0, 2.0) to Circle(7.0, 8.0, 30.0),
        Circle(39.0, 8.0, 2.0) to Circle(7.0, 8.0, 30.0),
        Circle(40.0, 8.0, 2.0) to Circle(7.0, 8.0, 30.0),
    )

    pairs.forEach { (p, q) ->
        val isInside = p.checkIfCircleInsideAnotherOne(q)
        println("$p ${if (isInside) "is" else "isn't"} inside $q")
        when (p.isTouching(q)) {
            0 -> {
                println("$p e $q nao se tocam")
            }
            1 -> {
                println("$p e $q se tocam internamente")
            }
            2 -> {
                println("$p e $q se tocam externamente")
            }
            else -> {
                println("$p e $q se tocam em 2 pontos")
            }
        }
        println("")
    }
}

private fun findThePointsOfIntersection(v1: Circle.Variables, v2: Circle.Variables) {
    val c1 = Circle(v1)
    val c2 = Circle(v2)
    println("$c1\n$c2")
}

private fun testFindThePointsOfIntersection() {
    /**
     * equacao 1
     * https://www.youtube.com/watch?v=U-APk19nA7A
     * (x^2+y^2) -  3y + 4 = 0
     * (x^2+y^2) + 2x - 5y - 2 = 0
     */
/*
    findThePointsOfIntersection(
        Circle.Variables(0.0, -3.0, 4.0),
        Circle.Variables(2.0, -5.0, -2.0)
    )

 */

    /**
     * equacao 2
     * https://www.analyzemath.com/CircleEq/circle_intersection.html
     * (x - cx)^2 + (y - cy)^2 = R^2
     *
     * (x - 2)^2 + (y - 3)^2 = 9 -> centro(-2, -3) raio 9
     * (x - 1)^2 + (y + 1)^2 = 16 -> centro(-1, 1) raio 16
     */

    findThePointsOfIntersection(
        Circle.Variables(-2.0, -3.0, 9.0),
        Circle.Variables(-1.0, 1.0, 16.0)
    )
}


fun main() {
    testFindThePointsOfIntersection()
}