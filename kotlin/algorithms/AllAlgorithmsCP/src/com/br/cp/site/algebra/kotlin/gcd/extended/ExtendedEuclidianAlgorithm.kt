package src.com.br.cp.site.algebra.kotlin.gcd.extended

/**
 * https://brilliant.org/wiki/extended-euclidean-algorithm/
 * https://wiki.math.ntnu.no/_media/tma4155/2010h/euclid.pdf
 * https://brilliant.org/wiki/bezouts-identity/
 * https://usaco.guide/adv/extend-euclid?lang=java
 * http://zimmer.csufresno.edu/~lburger/Math149_diophantine%20I.pdf
 */

class GCD(val a: Long, val b: Long) {

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

    fun rec(): Long {
        fun fn(a: Long, b: Long): Long {
            return if (b == 0L) {
                a
            } else {
                fn(b, a % b)
            }
        }

        fun rec(a: Long, b: Long): Long {
            return if (a % b == 0L) {
                b
            } else {
                rec(b, a % b)
            }
        }
        return rec(a, b)
    }

    fun extendedIt(): Equation {
        var ca = a
        var cb = b
        var ax = 1L
        var by = 0L
        var tx = 0L
        var ty = 1L
        while (cb != 0L) {
            val quo = ca / cb
            val rem = ca % cb
            val cx = ax - tx * quo
            ax = tx
            tx = cx
            val cy = by - ty * quo
            by = ty
            ty = cy
            ca = cb
            cb = rem
        }
        return Equation(ax, by, a, b, ca)
    }

    fun extendedRe(): Equation {
        /**
         * ax + by = gcd(a, b)
         * no final do algoritmo 1) gcd(a, b) == b dependendo da implementacao pode ser que 2) gcd(a,b) == a
         * ax(1-th) + by(1-th) = b podemos concluir que (x, y) == (0, 1)
         * a * 0 + b * 1 = b
         */
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

private fun check() {
    arrayOf(
        10L to 4L,
        120L to 23L,
        1914L to 899L,
        102L to 38L,
        42823L to 6409L
    ).forEach { (a, b) ->
        println("$a, $b")
        val gcd = GCD(a, b)
        println("GCD($a, $b) = ${gcd.gcd()}")
        println("GCD($a, $b) = ${gcd.rec()}")
        println(gcd.extendedRe())
        println(gcd.extendedIt())
        println("*************************")
    }
}

fun main() {
    check()
}