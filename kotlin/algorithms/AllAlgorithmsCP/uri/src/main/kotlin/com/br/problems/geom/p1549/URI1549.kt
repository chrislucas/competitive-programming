package com.br.problems.geom.p1549

import kotlin.math.PI
import kotlin.math.sqrt

/*
    https://www.beecrowd.com.br/judge/es/problems/view/1549
 */

fun <T> readValue(transform: (String) -> T ) = transform(readLine()!!)

private fun <T> readValues(delimiter: String = " ", transform: (String) -> T ) =
    readLine()!!.split(delimiter).map(transform)


data class DataTruncatedCone(val raioMenor: Double, val raioMaior: Double, val  h: Double) {
    val volume: Double
        get() =   (PI * h / 3.0) * (raioMaior * raioMaior + raioMaior * raioMenor + raioMenor * raioMenor)

}


fun main() {

    var q = readValue { it.toInt() }

    while (q > 0) {
        var (qPeople, qCoke) = readValues { it.toInt() }
        var (baseMenor, baseMaior, h) = readValues { it.toInt() }

        q -= 1
    }

}