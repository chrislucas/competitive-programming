package src.com.br.cp.site.algebra.kotlin

/**
 *  https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/?ref=lbp
 *
 *  Algoritmo de euclides extendido
 *  https://portaldaobmep.impa.br/index.php/modulo/ver?modulo=55
 */


fun gcd(a: Long, b: Long): Long {
    return if (a % b == 0L) {
        b
    } else {
        gcd(b, a % b)
    }
}


private fun checkGcd() {
    println(gcd(15, 5))
    println(gcd(35, 10))
    println(gcd(31, 2))
}

/**
 * ax + by = gcd(a, b)
 *
 * o algoritmo extendido de euclide encontra os coeficiences x e y
 * da equacao acima
 *
 * Exemplo: https://www.classicistranieri.com/pt/articles/a/l/g/Algoritmo_de_Euclides_estendido_d345.html
 * GCD(120, 23)
 *
 * 1) 120 % 23 = R=5 Q=5
 * 2) 23 % 5 = R=3 Q=4
 * 3) 5 % 3 = R=2 Q=1
 * 4) 3 % 2 = R=1 Q=1
 * 5) 2 % 1 = R=0 Q=2
 *
 * Usando os restos da equacao
 *
 * N) R = D - d * q
 * 1) 5 = 120 - 23 * 5
 * 2) 3 = 23 - 5 * 4 => substituindo o 5 por (120 - 23 * 5)
 *    3 = 23 - 4 * (120 - 23 * 5)
 *    3 = 23 - (4*120 - 4*5*23)
 *    3 = 23 - (4*120 - 20*23)
 *    3 =  -4*120 + 21*23
 *
 * 3) 2 = 5 - 3 * 1 => substituindo 5 e 3 por (120 - 23 * 5) e  -4*120 + 21*23 respectivamente
 *    2 = (120 - 23 * 5) - (-4*120 + 21*23)
 *    2 = (120 - 23 * 5) + (4*120 - 21*23)
 *    2 = (120 - 23 * 5) + (4*120 - 21*23)
 *    2 = 5 * 120 - 26 * 23
 *
 *
 * 4) 1 = 3 - 2 * 1 => substituindo 3 e 2  (-4*120 + 21*23) e (5 * 120 - 26 * 23
 *    1 = (-4*120 + 21*23) - (5 * 120 - 26 * 23)
 *    1 = -4*120 -5*120 + 21*23 + 26*23
 *    1 = -9*120 + 47*23
 *
 * ax + by = gcd(a, b)
 * x = -9 e y = 47
 */

/*
data class Triple<P, Q, R>(val p: P, val q: Q, val r: R)

fun extended(a: Long, b: Long, x: Long, y: Long): Triple<Long, Long, Long> {
    val x: Long
    val y: Long
    if (b % a == 0L) {
        return Triple(0, 1, b)
    }
    val x1 = 1L
    val y1 = 1L
    val g = extended(b, a%b, x1, y1)
    x = y1 - (b/a) * x1
    y = x1
    return Triple(x, y, g.r)
}

 */



fun main() {
    checkGcd()
}