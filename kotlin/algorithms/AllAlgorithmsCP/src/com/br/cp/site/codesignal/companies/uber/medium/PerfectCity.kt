package src.com.br.cp.site.codesignal.companies.uber.medium

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.sqrt

/*
    https://app.codesignal.com/company-challenges/uber/gsjPcfsuNavxhsQQ7
 */

fun solution(departure: MutableList<Double>, destination: MutableList<Double>): Double {

    val a = Point2f(departure[0], departure[1])
    val ra = Point2f(abs(1.0 - a.x) + a.x, a.y)
    val b = Point2f(destination[0], destination[1])
    val lb = Point2f(abs(1.0 - b.x) + b.x, b. y)

    val la = Point2f(0.0, a.y)
    val rb = Point2f(0.0, b.y)

    val p = (a distance ra) + (ra distance lb) + (lb distance  b)
    val q = (a distance la) + (la distance rb) + (rb distance b)


    return min(p, q)
}


private fun check() {
    println(solution(mutableListOf(0.4, 1.0), mutableListOf(0.9, 3.0)))
}

data class Point2f(val x: Double, val y: Double)

infix fun Point2f.distance(q: Point2f): Double = sqrt((q.x - x) * (q.x - x) + (q.y - y) * (q.y - y))

operator fun Point2f.minus(q: Point2f) = Point2f(q.x - x, q.y - y)

private fun checkDistance() {

    val p = Point2f(.4, 1.0)
    val q = Point2f(.9, 3.0)

    // pelo lado direito
    //println(Point2f(1.0, 1.0) distance Point2f(3.0, 1.0))
    println(
        (Point2f(.4, 1.0) distance Point2f(1.0, 1.0)) +
                (Point2f(1.0, 1.0) distance Point2f(1.0, 3.0)) +
                (Point2f(1.0, 3.0) distance Point2f(0.9, 3.0))
    )


    // pelo lado esuerdo
    println(
        (Point2f(0.4, 1.0) distance Point2f(0.0, 1.0)) +
                (Point2f(0.0, 1.0) distance Point2f(0.0, 3.0)) +
                (Point2f(0.0, 3.0) distance Point2f(0.9, 3.0))
    )


}

fun main() {
    check()
}