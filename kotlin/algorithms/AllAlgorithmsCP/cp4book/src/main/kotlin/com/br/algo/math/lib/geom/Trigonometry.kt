package com.br.algo.math.lib.geom

import kotlin.math.PI
import kotlin.math.tan


val Double.fromDegreeToRadian: Double
    get() =  this * PI / 180.0

val Double.fromRadianRoDegree: Double
    get() = this * 180.0 / PI

// https://www.todamateria.com.br/funcoes-trigonometricas/
// https://pt.wikipedia.org/wiki/Fun%C3%A7%C3%B5es_trigonom%C3%A9tricas_inversas#

fun main() {
    println(tan(45.0.fromDegreeToRadian))

    println(2 * PI.fromRadianRoDegree)

}