package src.com.br.cp.site.algebra.kotlin.gcd.problems.codeforces

class GCDSolver(val a: Long, val b: Long) {

    data class Equation(val x: Long, val y: Long, val a: Long, val b: Long, val gcd: Long)

    fun gcd(): Long {
        var aa = a
        var bb = b
        while (aa % bb != 0L) {
            val remain = aa % bb
            aa = bb
            bb = remain
        }
        return bb
    }

    fun extended(): Equation {
        fun calc(a: Long, b: Long): Equation {
            if (a % b == 0L) {
                return Equation(0, 1, a, b, b)
            }
            val result = calc(b, a % b)
            val (ax, by, _, _, g) = result
            val nx = by
            val ny = ax - (a / b) * by
            return Equation(nx, ny, a, b, g)
        }
        return calc(a, b)
    }
}