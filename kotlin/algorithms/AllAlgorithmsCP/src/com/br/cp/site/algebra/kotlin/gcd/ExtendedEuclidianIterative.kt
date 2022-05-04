package src.com.br.cp.site.algebra.kotlin.gcd

// https://www.dcode.fr/extended-gcd

val VALUES = arrayOf(
    10 to 4,
    120 to 23,
    1914 to 899,
    102 to 38,
    42823 to 6409
)

/**
 * https://pt.wikipedia.org/wiki/Algoritmo_de_Euclides_estendido
 * au * bv = gcd(a, b)
 */
private fun extended(a: Int, b: Int) {
    var ca = a
    var cb = b
    var currentU = 1
    var currentV = 0
    var au = 0
    var bv = 1
    while (cb != 0) {
        val q = ca / cb
        val tempA = ca
        val tempU = currentU
        val tempV = currentV
        ca = cb
        currentU = au
        currentV = bv
        cb = tempA - q * cb
        au = tempU - q * currentU
        bv = tempV - q * bv
    }
    println("$ca, $currentU, $currentV")
}

/**
 * https://cp-algorithms.com/algebra/extended-euclid-algorithm.html
 * ax + by = gcd(a,b)
 *
 */
private fun extended2(a: Int, b: Int) {
    var ca = a
    var cb = b
    var ax = 1
    var by = 0
    var tx = 0
    var ty = 1
    while (cb != 0) {
        val q = ca / cb
        val r = ca % cb
        val cx = ax - q * tx
        ax = tx
        tx = cx
        val cy = by - q * ty
        by = ty
        ty = cy
        ca = cb
        cb = r
    }
    println("$a, $b, $ax, $by, $ca")
}

private fun checkExtended() {
    VALUES.forEach { (a, b) ->
        extended(a, b)
    }
}

private fun checkExtendedItV2() {
    VALUES.forEach {
        (a, b) ->
        extended2(a, b)
    }
}

fun main() {
    checkExtended()
    println("*************************************************")
    checkExtendedItV2()
}