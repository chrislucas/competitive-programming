package com.br.problems.geom.algorithms

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

/*
    https://www.geeksforgeeks.org/frustum-of-a-cone/
     Formulas
    https://www.calculatorsoup.com/calculators/geometry-solids/conicalfrustum.php
    https://en.wikipedia.org/wiki/Frustum
 */

/*
    v = (PI * h * (b*b + bB + BB)) / 3

    Se eu tiver o volume sera que consigo calcular as bases
    v*3 = PI * h * (bb + bB + BB)
    v*3 = PI * h * (b * (1 + B) + BB)


 */

private fun baseMaior(volume: Double, h: Double, baseMenor: Double) =
    (volume * 3.0 / (PI * h + baseMenor * baseMenor * baseMenor)).pow(1.0 / 3.0)


private fun h(rMenor: Double, rMaior: Double, v: Double) =
    (v * 3.0) / (PI * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor))

private fun v(rMenor: Double, rMaior: Double, h: Double) =
    (PI * h * (rMaior * rMaior + rMaior * rMenor + rMenor * rMenor)) / 3.0

private fun slantHeight(rMenor: Double, rMaior: Double, h: Double) =
    sqrt((rMenor - rMaior) * (rMenor - rMaior) + h * h)

private fun test1() {
    val h = h(5.0, 6.0, 200.0)
    val baseMaior = baseMaior(200.0, h, 5.0)
    println("Base Maior: $baseMaior, Altura: $h")
    println("Altura: ${h(5.0, baseMaior, 200.0)}")
    println("Slant Height: ${slantHeight(5.0, baseMaior, h)}")
}

fun main() {
    test1()
}