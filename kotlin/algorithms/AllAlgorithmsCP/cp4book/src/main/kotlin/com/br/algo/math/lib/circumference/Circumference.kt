package com.br.algo.math.lib.circumference

import kotlin.math.sqrt



data class Circumference(val center: Point2D, val radius: Double) {

    data class Point2D(val x: Double, val y: Double)

    constructor(x: Double, y: Double, radius: Double) : this(Point2D(x, y), radius)

    /**
     * Equacao geral
     * x^2 + y^2 - 2ax - 2by + a^2 + b^2 - r = 0
     *
     * m = -2ax
     * n = -2by
     * p = a^2 + b^2 - r
     *
     * x^2 + y^2 + m + n + p = 0
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

private fun findThePointsOfIntersection(ca: Circumference, cb: Circumference) {
    val (a, b) = ca.center
    val (c, d) = cb.center

    val r = ca.radius
    val s = cb.radius
    val f = -r + s + a * a + b * b - c * c - d * d
    val g = c - a
    val h = d - b
    val j = g * 2
    val k = h / 2
    /*
        (x - a)^2 + (y - b)^2 = R
        (x - c)^2 + (y - d)^2 = S
        m) xx - 2ax + aa + yy - 2by + bb = R
        n) xx - 2cx + cc + yy - 2dy + dd = S
        m - n
        xx - 2ax + aa + yy - 2by + bb = R
        -xx + 2cx - cc - yy + 2dy - dd = -S

        -2ax + 2cx -2by + 2dy + aa + bb - cc - dd = R - S
        -2ax + 2cx -2by + 2dy = R - S - aa - bb + cc + dd

        f = R - S - aa - bb + cc + dd
        g = c-a
        h = d-b
        j = g/2
        k = h/2

        -2ax + 2cx -2by + 2dy = f
        2(g)x + 2(h)y = f
        2(g)x = f - 2(h)y

        dividir os 2 lados por 2
        x = (f - (h/2)y) / (2g)
        x = (f - hy) / j
     */
    val cy = (f - 2 * h) / 2 * g

    /*
        substituir x na equacao m
        m) xx - 2ax + aa + yy - 2by + bb = R

        ((f - hy) / j) ^ 2 = (f - hy) ^ 2 / jj
        (f - hy) ^ 2 / jj
        ff - 2hy + (hy) ^ 2
        ff / jj
        -2h / jj
        h^2 / jj


        ((f - hy) / j) ^ 2 - 2a((w - hy) / j) + yy - 2by + bb - R = 0
     */

    return
}


private fun check() {

    /**
        p) (x - a)^2 + (y - b)^2 = R
        q) (x - c)^2 + (y - d)^2 = S
        ou
        p) xx + yy - 2ax - 2by + aa + bb = R
        q) xx + yy - 2cx - 2dy + cc + dd = S
     */
    val pairs = arrayOf(

        Circumference(Circumference.Point2D(-2.0, -3.0), 9.0) to
                Circumference(Circumference.Point2D(-1.0, 1.0), 16.0)

/*
        Circumference(Circumference.Variables(2 * -2.0, 2 * -3.0, 18.0))
                to Circumference(Circumference.Variables(2 * -1.0, 2 * 1.0, 17.0))

 */
    )

    pairs.forEach { (p, q) ->
        findThePointsOfIntersection(p, q)
    }

}


fun main() {
    check()
}