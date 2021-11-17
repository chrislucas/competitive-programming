package com.br.problems.geom.p1549

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

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
    (PI * h / 3.0) * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor)

/*
    V = h/3 * (PI * s)
    V / (h/3) = PI * s
    3V / h = PI * s
    h = 3V / (PI * s)
 */
private fun h(rMenor: Double, rMaior: Double, v: Double) =
    (v * 3.0) / (PI * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor))

private fun qa(rMenor: Double, rMaior: Double, h: Double, v: Double) =
    (v * 3.0 * (rMaior - rMenor) / (PI * h) + rMenor * rMenor * rMenor).pow(1.0 / 3.0)



private fun check() {
    val v = v(5.0, 6.0, 8.0)
    println(v)
    println(h(5.0, 6.0, v))
}

private fun s1(qPeople: Double, qCoke: Double, rMenor: Double, rMaior: Double, h: Double) {
    val newVolume = qCoke / qPeople
    val la = qa(rMenor, rMaior, h, newVolume)
    println(String.format("%.2f", h(rMenor, la, newVolume)))
}




// pensar como usar Bsearch
private fun s2(qPeople: Double, qCoke: Double, rMenor: Double, rMaior: Double, h: Double) {

    fun Double.almostEquals(that: Double, eps: Double = 10e-9) = (that - this) < eps

    val newVolume = qCoke / qPeople

    var lo = 10E-9
    var hi = h

    10 xor 1

    while ( ! lo.almostEquals(hi) ) {
        val nH = v(rMenor, rMaior, h)
        if (nH < hi) {}
    }
}

fun main() {
    var q = readValue { it.toInt() }
    while (q > 0) {
        val (qPeople, qCoke) = readValues { it.toDouble() }
        val (baseMenor, baseMaior, h) = readValues { it.toDouble() }
        s1(qPeople, qCoke, baseMenor, baseMaior, h)
        q -= 1
    }
}