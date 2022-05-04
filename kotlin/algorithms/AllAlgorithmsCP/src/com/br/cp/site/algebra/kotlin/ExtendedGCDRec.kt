package src.com.br.cp.site.algebra.kotlin

/** Calculadora
 *  https://www.dcode.fr/extended-gcd
 *  https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/?ref=lbp
 *  Algoritmo de euclides extendido
 *  https://portaldaobmep.impa.br/index.php/modulo/ver?modulo=55
 */

fun recGCD(a: Long, b: Long): Long {
    return if (a % b == 0L) {
        b
    } else {
        recGCD(b, a % b)
    }
}

fun itGCD(a: Long, b: Long): Long {
    var ca = a
    var cb = b
    while (ca % cb != 0L) {
        val rem = ca % cb
        ca = cb
        cb = rem
    }
    return cb
}

private fun checkGcd() {
    println(recGCD(15, 5))
    println(itGCD(15, 5))
    println(recGCD(35, 10))
    println(itGCD(35, 10))
    println(recGCD(31, 2))
    println(itGCD(31, 2))
}

class ExtendedGCDRec {
    data class Coefficient(
        val a: Long, val b: Long,
        val x: Long, val y: Long, val g: Long
    ) {
        val equation: String = "($a * $x) + ($b * $y) == $g\n${a * x + b * y} == $g"
    }

    // calculadora https://www.dcode.fr/extended-gcd
    // https://cp-algorithms.com/algebra/extended-euclid-algorithm.html
    fun solverRe(a: Long, b: Long): Coefficient {
        if (a % b == 0L) {
            /**
             * Interessante constatacao
             * na equacao ax + by = gcd(a, b)
             * gcd(a, b) = g e no final do algoritmo b == g
             * entao podemos escrever da seguinte forma
             *
             * 1) (x, y) = (0, 1)
             * 2) se b == g entao
             *   => a * 0 + b * 1 = g
             */
            return Coefficient(a, b, 0, 1, b)
        }
        val (_, _, cx, cy, g) = solverRe(b, a % b)
        val y = cx - cy * (a / b)
        val x = cy
        return Coefficient(a, b, x, y, g)
    }

    /**
     * ax + by = gcd(a, b)
     * gcd(a, b) = c -> no final do algoritmo o valor de b para em c
     * Explicacao interessante do caso base desse problema: https://codeforces.com/blog/entry/60458
     * Se ax + by = a entao x = 1 e y = 0
     * Se ax + by = b entao x = 0 e y = 1
     */
    fun solverIt(a: Long, b: Long): Coefficient {
        var ax = 1L
        var by = 0L
        var tx = 0L
        var ty = 1L
        var ca = a
        var cb = b
        while (cb != 0L) {
            val quo = ca / cb
            val rem = ca - cb * quo
            val cx = ax - quo * tx
            ax = tx
            tx = cx
            val cy = by - quo * ty
            by = ty
            ty = cy
            ca = cb
            cb = rem
        }
        return Coefficient(a, b, ax, by, ca)
    }
}

private fun checkExtendedGCDRec() {
    val ext = ExtendedGCDRec()
    arrayOf(
        10L to 4L,
        120L to 23L,
        1914L to 899L,
        102L to 38L,
        42823L to 6409L
    ).forEach { (a, b) ->
        val s = ext.solverRe(a, b)
        val r = ext.solverIt(a, b)
        println(s)
        //println(s.equation)
        println(r)
        //println(r.equation)
        println("**********************************")
    }
}

fun main() {
    //checkExtendedGCDRec()
    checkGcd()
}