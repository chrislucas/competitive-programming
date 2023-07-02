package src.com.br.cp.site.ds.kotlin.site.hackerearth

import kotlin.system.measureTimeMillis

/**
 * TODO
 * https://www.geeksforgeeks.org/eulers-totient-function-for-all-numbers-smaller-than-or-equal-to-n/
 *
 * Computar phi(n) de 1 a n
 *
 * Exemplo
 * fn(5) =
 *      phi(1) = 1
 *      phi(2) = 1
 *      phi(3) = 2
 *      phi(4) = 2
 *      phi(5) = 4
 *      1 + 1 + 2 + 2 + 4 = 10
 */


private fun computeEulerFunctionRange(n: Int): Array<Int> {
    /*
        Complexidade O(n^2)
     */
    val eulerTotientComputed = Array(n + 1) { it }
    for (p in 2..n) {
        if (eulerTotientComputed[p] == p) {
            eulerTotientComputed[p] = p - 1 // 1 <= phi(n) <= n-1
            var i = 2 * p
            while (i <= n) {
                eulerTotientComputed[i] = eulerTotientComputed[i] / p * (p - 1)
                i += p
            }
        }
    }
    return eulerTotientComputed
}

private fun checkComputeEulerFunctionRange() {
    (1..12).forEach {
        computeEulerFunctionRange(it)
    }
}

private fun computeEulerFunction(n: Int): Array<Int> {
    /*
        https://www.geeksforgeeks.org/eulers-totient-function-for-all-numbers-smaller-than-or-equal-to-n/
        Complexidade: O(sqrt(n) * log(n))
     */
    fun exp(b: Int, e: Int): Int {
        return when (e) {
            0 -> {
                1
            }
            1 -> {
                b
            }
            else -> {
                var acc = 1
                var ce = e
                var base = b
                while (ce > 0) {
                    if ((ce and 1) == 1) {
                        acc *= base
                    }
                    base *= base
                    ce = ce shr 1
                }
                acc
            }
        }
    }

    fun compute(n: Int): Int {
        var result = 1
        var ci = 2
        var cn = n
        while (ci * ci <= cn) {
            var counter = 0
            if (cn % ci == 0) {
                while (cn % ci == 0) {
                    counter += 1
                    cn /= ci
                }
            }
            if (counter > 0) {
                val s = exp(ci, counter - 1) * (ci - 1)
                result *= s
            }
            ci += 1
        }
        if (cn > 1) {
            result *= (cn - 1)
        }
        return result
    }
    return Array(n + 1) { compute(it) }
}

private fun checkComputeEulerFunction() {
    val s = computeEulerFunction(12)
    println(s)
}

private fun compareSolutions() {
    val rs = arrayOf(0, 0, 0)
    (2..10000).forEach {
        val p = measureTimeMillis {
            val s = computeEulerFunctionRange(it).toList()
            //println(s)
        } / 1000.0

        val q = measureTimeMillis {
            val s = computeEulerFunction(it).toList()
            //println(s)
        } / 1000.0

        if (p < q) {
            rs[0] += 1
        } else if (q < p) {
            rs[1] += 1
        } else {
            rs[2] += 1
        }
        //println("**************")
    }
    //println("**************************************************************")
    println(rs.toList())
}


fun main() {
    compareSolutions()
}