package com.br.algo.math.lib.circle

import kotlin.math.sqrt

data class Point2D(val x: Double, val y: Double)

fun Point2D.euclidean(p: Point2D): Double {
    val (x1, y1) = this
    val (x2, y2) = p
    val (dx, dy) = this.diff(p)
    return sqrt(dx * dx + dy * dy)
}

fun Point2D.diff(p: Point2D) = Pair(x - p.x, y - p.y)