package com.br.algo.math.lib.circle

/*
    https://math.stackexchange.com/questions/256100/how-can-i-find-the-points-at-which-two-circles-intersect
    https://www.obaricentrodamente.com/2011/06/interseccao-de-circunferencias.html#
    https://pt.stackoverflow.com/questions/260057/como-detectar-quais-s%C3%A3o-os-pontos-em-comum-entre-duas-circunfer%C3%AAncias

    Outra fonte sobre a equacao de interseccao de duas circunferencias
    https://www.quora.com/How-do-I-find-the-equation-of-a-line-passing-through-the-points-of-intersections-of-two-circles
    Calculadora
    http://www.ambrsoft.com/TrigoCalc/Circles2/circle2intersection/CircleCircleIntersection.htm
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

    /*
        1) (x - a)^2 + (y - b)^2 = R^2
        2) (x - c)^2 + (y - d)^2 = S^2

        expandindo
        (x^2 -2ax + a^2) + (y^2 - 2by + b^2)
        x^2 + y^2 -2ax -2by + a^2 + b^2

        (x^2 -2cx + c^2) + (y^2 - 2dy + d^2)
        x^2 + y^2 -2cx -2dy + c^2 + d^2

        apos expandir 1 e 2 e Subtraindo 2 de 1 temos

        2x (c - a) + 2y (d - b) - a^2 - b^2 + c^2 + d^2 = - R + S

         2x(c-a)+2y(d-b)= -R+s+(a)^2+(b)^2-(c)^2-(d)^2
         w = -r+s+(a)^2+(b)^2-(c)^2-(d)^2

         p = c-a
         q = d-b
         x = (w - yq) * / (2 * p) -> (w - yq) * (1 / (2 * p))

         t => (w - yq) / 2 * p = w/(2*p) - yq/2*p
         u => a^2 + b^2
         v => c^2 + d^2
         substituir x na equacao 1


         (t^2 + y^2 -2at -2by + z)

         ((w - yp) / 2 * p)^2 + y^2 - 2a((w - yp) / 2 * p) - 2by + u

         w^2 - 2wpy + (yp)^2 / (2p * 2p) + y^2 - (2aw - py) / (2 * p) - 2by
         e = (2p * 2p)
         f = 2wp
         chegamos numa equacao quadradica
         ((py)^2 / e) + y^2 - fy - (p/2*p)y -2by + 2aw / (2*p) + w^2 - 2wpy
    */

    val (a, b) = c1.center
    val (c, d) = c2.center
    val r = c1.radius
    val s = c1.radius
    val w = (-r + s) + (a * a) + (b * b) - (c * c) - (d * d)
    val p = (c-a)
    val q = (d-b)
    val u = (a*a+b*b)
    val v = (c*c+d*d)
    val e = (2*p*2*p)







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
     * Exemplo de equacao tirado de
     * https://math.stackexchange.com/questions/256100/how-can-i-find-the-points-at-which-two-circles-intersect
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