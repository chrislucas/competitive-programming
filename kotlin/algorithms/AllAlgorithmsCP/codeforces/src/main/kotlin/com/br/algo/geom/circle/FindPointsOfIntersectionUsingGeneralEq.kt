package com.br.algo.geom.circle

/**
 * https://www.analyzemath.com/CircleEq/circle_intersection.html
 * https://www.quora.com/How-can-I-find-the-points-at-which-two-circles-intersect
 *
 * equacao geral do circulo
 *
 * (x - cx) ^ 2 + (y - cy) ^ 2 = R ^ 2
 *
 * */


data class P2Df(val x: Double, val y: Double)


data class Circle(val center: P2Df, val radius: Double)


fun main() {

}