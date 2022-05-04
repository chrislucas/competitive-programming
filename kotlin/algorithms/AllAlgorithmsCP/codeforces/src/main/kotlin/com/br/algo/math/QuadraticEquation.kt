package com.br.algo.math

import kotlin.math.sqrt




class QuadraticEquation(private val a: Double, private val b: Double, private val c: Double) {

    constructor(a: Int, b: Int, c: Int) : this(a * 1.0, b * 1.0, c * 1.0)

    constructor(a: Long, b: Long, c: Long) : this(a * 1.0, b * 1.0, c * 1.0)

    interface RootsQuadraticEquation {
        val isComplex: Boolean
    }

    data class ComplexNumber(val real: Double, val img: Double)

    data class ComplexQuadraticRoot(val root: Pair<ComplexNumber, ComplexNumber>) : RootsQuadraticEquation {
        override val isComplex: Boolean = true
    }

    data class QuadraticRoot(val root: Pair<Double, Double>) : RootsQuadraticEquation {
        override val isComplex: Boolean = false
    }

    val solution: RootsQuadraticEquation
        get() {
            val delta = b * b - 4 * a * c
            return if (delta < 0) {
                val root = sqrt(-delta)
                val p = ComplexNumber(-b / (2.0 * a), root / (2.0 * a))
                val q = ComplexNumber(-b / (2.0 * a), -root / (2.0 * a))
                ComplexQuadraticRoot(p to q)
            } else {
                val root = sqrt(delta)
                QuadraticRoot((-b + root) / (2.0 * a) to (-b - root) / (2.0 * a))
            }
        }
}


fun main() {
    arrayOf(
        QuadraticEquation(3, 4 ,5),
        QuadraticEquation(9, 16 ,25),
    ).forEach {
        println(it.solution)
    }
}