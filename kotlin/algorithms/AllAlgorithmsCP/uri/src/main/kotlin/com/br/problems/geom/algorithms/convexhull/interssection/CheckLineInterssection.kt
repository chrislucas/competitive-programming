package com.br.problems.geom.algorithms.convexhull.interssection

import kotlin.math.max
import kotlin.math.min

/**
 * https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
 *
 * Dos segmentos A(p1, q1) e B(p2, q2) intersectao se e somente se uma das 2 condicoes
 * citadas a seguir ocorrerem
 *
 * 1) caso geral
 *
 * Pontos:
 * (p1, q1, p2) e (p1, q1, q2) tiverem diferentes orientacoes
 * e
 * (p2, q2, p1) e (p2, q2, q1) idem
 *
 * 2) Caso especial
 * (p1, q1, p2); (p1, q1, q2); (p2, q2, p1) e (p2, q2, q2) sao todos colineares
 * e
 * a projecao do segmento em x de (p1, q1) e (p2, q2) se intersecta
 * e
 * a projecao do segmento em y de (p1, q1) e (p2, q2) se intersecta
 *
 * */

data class Point(val x: Int, val y: Int)

// Possiveis interseccoes entre 2 segmentos de reta
enum class Orientation(val orientation: Int) {
    COUNTERCLOCKWISE(-1),
    CLOCKWISE(1),
    COLLINEAR(0)
}

// checa se q esta no segmento pr
private fun onSegment(p: Point, q: Point, r: Point): Boolean {
    // qx entre max(px, rx) e min(px,rx) e qy entre max(py, ry) e min(py, ry)
    return q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) &&
            q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y)
}

private fun orientation(p: Point, q: Point, r: Point): Orientation {
    return when ((q.y - p.y) * (r.x - q.x) - (q.x - r.x) * (r.y - q.y)) {
        0 -> {
            Orientation.COLLINEAR
        }
        1 -> {
            Orientation.CLOCKWISE
        }
        else -> {
            Orientation.COUNTERCLOCKWISE
        }
    }
}

private fun areIntersecting(p1: Point, q1: Point, p2: Point, q2: Point): Boolean {
    val oA = orientation(p1, q1, p2)
    val oB = orientation(p1, q1, q2)
    val oC = orientation(p2, q2, p1)
    val oD = orientation(p2, q2, q1)

    // caso geral
    if (oA != oB && oC != oD)
        return true

    // caso especial
    // p1, q1, p2 sao colineares e p2 esta no segmento p1q1
    if (oA == Orientation.COLLINEAR && onSegment(p1, p2, q1))
        return true

    //  p1, q1, q2 sao colineares e q2 esta no segmento p1q1
    if (oB == Orientation.COLLINEAR && onSegment(p1, q2, q1))
        return true

    // p2, q2, p1
    if (oC == Orientation.COLLINEAR && onSegment(p2, p1, q2))
        return true

    // p2, q2, q1
    if (oD == Orientation.COLLINEAR && onSegment(p2, q1, q2))
        return true

    return false
}

private fun checkIntersect(p: Point, q: Point, r: Point, s: Point) =
    areIntersecting(p, q, r, s)


/**
 * General case
 * https://media.geeksforgeeks.org/wp-content/uploads/linesegments1.png
 * Special case
 * https://media.geeksforgeeks.org/wp-content/uploads/linesegments2.png
 * */

fun main() {
    // segmentos paralelos
    println(
        checkIntersect(
            Point(1, 1),
            Point(10, 1),
            Point(1, 2),
            Point(10, 2)
        )
    )

    // segmento pq e rs se intersectao
    println(
        checkIntersect(
            Point(10, 1),
            Point(0, 10),
            Point(0, 0),
            Point(10, 10)
        )
    )

    //
    /**
     * segmento pq traca uma linha diagonal e o rs tambem sao segmentos colineares
     * https://www.uel.br/projetos/matessencial/basico/fundamental/basico.html
     * */
    println(
        checkIntersect(
            Point(-5, -5),
            Point(0, 0),
            Point(1, 1),
            Point(10, 10)
        )
    )

    /**
     * Aqui tambem pq e rs sao colineares
     * */
    println(
        checkIntersect(
            Point(-5, -5),
            Point(1, 1),
            Point(0, 0),
            Point(10, 10)
        )
    )

}





