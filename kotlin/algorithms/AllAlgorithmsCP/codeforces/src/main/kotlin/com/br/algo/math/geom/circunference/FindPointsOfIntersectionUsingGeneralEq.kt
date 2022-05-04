package com.br.algo.math.geom.circunference

import kotlin.math.sqrt



/**
 * Calculator
 * https://www.calculatorsoup.com/calculators/algebra/quadratic-formula-calculator.php
 * Solucao equacao quadratica
 * https://mundoeducacao.uol.com.br/matematica/aplicacao-dos-numeros-complexos.htm
 */
class QuadraticEquation(private val a: Double, private val b: Double, private val c: Double) {

    constructor(a: Int, b: Int, c: Int) : this(a * 1.0, b * 1.0, c * 1.0)

    constructor(a: Long, b: Long, c: Long) : this(a * 1.0, b * 1.0, c * 1.0)

    interface RootsQuadraticEquation {
        val isComplex: Boolean
    }

    data class ComplexNumber(val real: Double, val img: Double)

    data class ComplexQuadraticRoot(val root: Pair<ComplexNumber, ComplexNumber>) : RootsQuadraticEquation {
        override val isComplex: Boolean = true
    }

    data class QuadraticRoot(val root: Pair<Double, Double>) : RootsQuadraticEquation {
        override val isComplex: Boolean = false
    }

    val solution: RootsQuadraticEquation
        get() {
            val delta = b * b - 4 * a * c
            return if (delta < 0) {
                val root = sqrt(-delta)
                val p = ComplexNumber(-b / (2.0 * a), root / (2.0 * a))
                val q = ComplexNumber(-b / (2.0 * a), -root / (2.0 * a))
                ComplexQuadraticRoot(p to q)
            } else {
                val root = sqrt(delta)
                QuadraticRoot((-b + root) / (2.0 * a) to (-b - root) / (2.0 * a))
            }
        }
}

data class P2Df(val x: Double, val y: Double)

data class Circle(val center: P2Df, val radius: Double)


/**
 * https://www.analyzemath.com/CircleEq/circle_intersection.html
 * https://www.quora.com/How-can-I-find-the-points-at-which-two-circles-intersect
 * https://www.quora.com/How-do-I-find-the-intersecting-points-of-two-given-circles
 * equacao geral do circulo
 *
 * (x - a) ^ 2 + (y - b) ^ 2 = R ^ 2
 *
 * A forma expandida
 *
 * x^2 - 2ax + a^2 + y^2 - 2by + b^2 = R^2
 * x^2+y^2-2ax-2by+a^2+b^2
 *
 * https://undergroundmathematics.org/circles/r6100/solution
 *
 * */


private fun solverCircleEquation(c1: Circle, c2: Circle) {
    /*
        e1 = x^2+y^2-2ax-2by+a^2+b^2 = R^2
        e2 = x^2+y^2-2cx-2dy+c^2+d^2 = S^2
        e3 = e1 * -1
        e3 = -x^2-y^2+2ax+2by-a^2-b^2 = -R^2

        subtraindo as equacoes 1 e 3
        2x(a-c)+2y(d-b) = -R^2+S^2
        2x(a-c)+2y(d-b)+R^2-S^2 = 0

        y = 2x(a-b)+R^2-S^2 / 2(d-b)
     */


}

private fun solverQuadraticEquation() {
    arrayOf(
        QuadraticEquation(1, -8, 5),
        QuadraticEquation(1, -7, 5),
    ).forEach {
        println(it.solution)
    }

    println("Solucoes complexas")
    // Solucoes complexas
    arrayOf(
        QuadraticEquation(4, -4, 2),
        QuadraticEquation(1, -14, 50),
        QuadraticEquation(19, 12, 3),
        QuadraticEquation(5, 20, 32),
    ).forEach {
        println(it.solution)
    }
}


fun main() {
    solverQuadraticEquation()
}