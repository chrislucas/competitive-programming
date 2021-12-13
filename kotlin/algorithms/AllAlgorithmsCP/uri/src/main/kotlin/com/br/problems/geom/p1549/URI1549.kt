package com.br.problems.geom.p1549

import kotlin.math.PI
import kotlin.math.pow

/*
    https://www.beecrowd.com.br/judge/es/problems/view/1549
    https://www.omnicalculator.com/math/cone-volume
    Formulas
    https://www.calculatorsoup.com/calculators/geometry-solids/conicalfrustum.php
 */

fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

fun v(rMenor: Double, rMaior: Double, h: Double) =
//PI * (h / 3.0) * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor)
    //(PI * h / 3.0) * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor)
    (PI * h * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor)) / 3.0

/*
    V = (PI * h * s) / 3
    3V = PI * s * h
    // re arranjando
    h = 3V / (PI * s)
 */
private fun h(rMenor: Double, rMaior: Double, v: Double) =
    (v * 3.0) / (PI * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor))

private fun lagerBaseFrustumCone(rMenor: Double, rMaior: Double, h: Double, v: Double) =
    (v * 3.0 * (rMaior - rMenor) / (PI * h) + rMenor * rMenor * rMenor).pow(1.0 / 3.0)


private fun check() {
    val v = v(5.0, 6.0, 8.0)
    println(v)
    println(h(5.0, 6.0, v))
    println("*************************")
    println(h(5.0, 6.0, 200.0))
}

private fun s1(qPeople: Double, qCoke: Double, rMenor: Double, rMaior: Double, h: Double) {
    val newVolume = qCoke / qPeople
    val la = lagerBaseFrustumCone(rMenor, rMaior, h, newVolume)
    println(String.format("%.2f", h(rMenor, la, newVolume)))
}


// pensar como usar Bsearch
private fun s2(qPeople: Double, qCoke: Double, rMenor: Double, rMaior: Double, h: Double) {

    fun Double.almostEquals(that: Double, eps: Double = 10e-9) =
        if (that < this) {
            this - that < eps
        } else {
            that - this < eps
        }


    var currentVolume = v(rMenor, rMaior, h)
    val goalVolume = qCoke / qPeople
    val loB = rMenor
    var hiB = rMaior

    var loH = 1
    var hiH = h

    var nh = h


    while (!goalVolume.almostEquals(currentVolume)) {

        val midH = (hiH - loH) / 2.0 + loH
        val midB = (hiB - loB) / 2.0 + loB

        nh = h(loB, midB, goalVolume)
        val v = v(loB, midB, midH)
        currentVolume = v(loB, midB, nh)


        println()
    }

    println(String.format("%.2f", nh))

}

fun main() {
    //check()
    var q = readValue { it.toInt() }
    while (q > 0) {
        val (qPeople, qCoke) = readValues { it.toDouble() }
        val (baseMenor, baseMaior, h) = readValues { it.toDouble() }
        //s1(qPeople, qCoke, baseMenor, baseMaior, h)
        s2(qPeople, qCoke, baseMenor, baseMaior, h)
        q -= 1
    }
}