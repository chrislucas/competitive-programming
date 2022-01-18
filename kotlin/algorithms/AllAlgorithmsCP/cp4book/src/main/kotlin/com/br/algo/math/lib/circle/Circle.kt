package com.br.algo.math.lib.circle

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * https://www.varsitytutors.com/hotmath/hotmath_help/topics/equation-of-a-circle#
 * Equacao reduzida
 * https://educacao.uol.com.br/disciplinas/matematica/equacao-da-circunferencia-geral-e-reduzida-determinacao-de-centro-e-raio.htm
 * Equacao geral
 * https://educacao.uol.com.br/disciplinas/matematica/equacao-da-circunferencia-geral-e-reduzida-determinacao-de-centro-e-raio.htm
 * https://brasilescola.uol.com.br/matematica/equacao-normal-circunferencia.htm
 */
data class Circle(val center: Point2D, val radius: Double) {

    constructor(x: Double, y: Double, radius: Double) : this(Point2D(x, y), radius)

    /**
     * Equacao geral
     * cx2 + cy2 - 2xcx - 2ycy + x2 + y2 - r2 = 0
     *
     * m = -2xcx
     * n = -2ycy
     * p = x2 + y2 - r2
     *
     * cx2 + cy2 + m + n + p = 0
     *
     * Equacal reduzida
     * (x - cx)^2 + (y - cy)^2 = R^2
     */
    data class Variables(val m: Double = 0.0, val n: Double = 0.0, val p: Double) {
        val cx = -m / 2.0
        val cy = -n / 2.0
        val radius = sqrt((cx * cx) + (cy * cy) - p)
    }

    /**
     * Construir um circulo a partir da equacao geral
     * https://educacao.uol.com.br/disciplinas/matematica/equacao-da-circunferencia-geral-e-reduzida-determinacao-de-centro-e-raio.htm
     */
    constructor(variables: Variables) : this(Point2D(variables.cx, variables.cy), variables.radius)
}


fun Circle.distanceOfCenter(c: Circle): Double {
    return this.center.diff(c.center).let { (dx, dy) ->
        sqrt(dx * dx + dy * dy)
    }
}

/**
 * 0 - se os circulos nao se tocam
 * 1 - se os circulos se tocam internamente
 * 2 - se os circulos se tocam externamente
 * 3 - se os circulos se tocam em 2 pontos
 * https://www.quora.com/What-is-the-shortest-way-possible-to-determine-whether-2-circles-touch-each-other-internally-or-externally-when-the-ctr-and-radius-of-each-is-given
 */
fun Circle.isTouching(that: Circle): Int {
    val distance = distanceOfCenter(that)
    return when {
        distance == that.radius - radius -> {
            1
        }
        distance == radius + that.radius -> {
            2
        }
        distance > that.radius - radius && distance < radius + that.radius -> {
            3
        }
        else -> {
            0
        }
    }
}

/*
    https://www.geeksforgeeks.org/check-if-a-circle-lies-inside-another-circle-or-not/?ref=lbp
    Possiveis casos
 */
fun Circle.checkIfCircleInsideAnotherOne(that: Circle): Boolean {
    /**
     * caso 1 - um circulo esta dentro de outro
     * se a soma do menor raid e a distancia entre os centros e menor que o raio maior,
     * entao o circulo menor esta completamente dentro do maior
     *
     * caso 2 - o menor circulo está dentro do maior porém eles se tocam em um ponto
     * se a soma do menor raio e a distancia entre os centros for igual ao
     * raio do circulo maior, os circulos se tocam em um unico ponto com o menor
     * ainda dentro do maior (obviamente)
     * */
    val minRadius = min(radius, that.radius)
    val maxRadius = max(radius, that.radius)
    val distance = distanceOfCenter(that)

    return minRadius + distance <= maxRadius
}

private fun createCircleFromGeneralEquation() {
    /**
     * Equcao
     * x^2 + y^2 - 10x + 14y + 10 = 0
     */
    val circle = Circle(Circle.Variables(-10.0, 14.0, 10.0))
    println(circle)
}


private fun createCircleFromReducedEquation() {
    val circle = Circle(Circle.Variables(p = 25.0))
    println(circle)
}


/*
    https://undergroundmathematics.org/circles/r6100/solution
    equacao geral = cx2 + cy2 - 24x - 18y + 125 = 0
    x2 + y2 + m + n + p
    cx = m/2
    cy = n/2
    p = x2 + y2 - r

    r = 125
    cx = -24/2 = -12
    cy = -18/2 = -9
    p = (-12)^2 + (-9)^2 - 125 = 144 + 81 - 125 = 100
    (x - 12)^2 + (y - 9)^2 = 100

 */
private fun twoCirclesFromEquation() {
    // equacao reduzida x2 + y2 = 25
    val reduced = Circle(Circle.Variables(p = 25.0))
    // equacao geral = x2 + y2 - 24x - 18y + 125 = 0
    val general = Circle(Circle.Variables(-24.0, -18.0, 125.0))

    println("$reduced")
    println("$general")

    val distance = general.distanceOfCenter(reduced)

    println(distance)
}

fun main() {
    // createCircleFromGeneralEquation()
    // createCircleFromReducedEquation()
    twoCirclesFromEquation()
}