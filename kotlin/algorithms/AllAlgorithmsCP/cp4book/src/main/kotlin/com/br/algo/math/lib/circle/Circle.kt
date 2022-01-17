package com.br.algo.math.lib.circle

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt


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
     */
    data class Variables(val m: Double, val n: Double, val p: Double) {
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
 * https://www.quora.com/What-is-the-shortest-way-possible-to-determine-whether-2-circles-touch-each-other-internally-or-externally-when-the-ctr-and-radius-of-each-is-given
 */
fun Circle.touchInternallyOrExternally(that: Circle): Int {
    return when (distanceOfCenter(that)) {
        radius - that.radius -> {
            1
        }
        radius + that.radius -> {
            2
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

private fun createCircleFromEquantion() {
    /**
     * Equcao
     * x^2 + y^2 - 10x + 14y + 10 = 0
     */
    val circle = Circle(Circle.Variables(-10.0, 14.0, 10.0))
    println(circle)
}


fun main() {
    createCircleFromEquantion()
}