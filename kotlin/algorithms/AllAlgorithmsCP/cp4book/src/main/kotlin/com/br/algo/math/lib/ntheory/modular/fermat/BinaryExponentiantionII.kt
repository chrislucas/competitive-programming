package com.br.algo.math.lib.ntheory.modular.fermat

/**
 * https://cp-algorithms.com/algebra/binary-exp.html
 */


fun longexp(b: Long, e: Long): Long {
    return when (e) {
        0L -> {
            1L
        }
        1L -> {
            b
        }
        else -> {
            var acc = 1L
            var ce = e
            var cb = b
            while (ce > 0) {
                if (ce and 1L == 1L) {
                    acc *= cb
                }
                cb *= cb
                ce = ce shr 1
            }
            acc
        }
    }
}

fun doubleexp(b: Double, e: Long): Double {
    return when (e) {
        0L -> {
            1.0
        }
        1L -> {
            b
        }
        else -> {
            var acc = 1.0
            var ce = e
            var cb = b
            if (ce < 0) {
                ce = -ce
                cb = 1.0 / cb
            }
            while (ce > 0) {
                if (ce and 1L == 1L) {
                    acc *= cb
                }
                cb *= cb
                ce = ce shr 1
            }
            acc
        }
    }
}


/**
 * https://cp-algorithms.com/algebra/binary-exp.html
 * Explicacao:
 * Vamos lidar com o expoente na base binaria, 3 ^ 13 == 3 ^ 1101b = 3 ^ 8 * 3 ^ 4 * 3 ^ 1
 *
 * como um numero N na base binaria tem somente log2(n) + 1 digitos so precisamos realizar log(n) + 1 operacoes
 * Dessa forma reduzimos a complexidade do algoritmo de exponenciacao de O(n) para O(log2(n))
 * Veja que no exemplo usado nao precisamos computar 3 ^ 2, porque o bit na posicao 2 nao esta definido (1101)
 *
 * binarypow(3, 13) ->
 * r binarypow(3, 6)
 * r binarypow(3, 3)
 * r binarypow(3, 1) -> 3
 * res = 3, e = 3, b = 3
 * e and 1 == 1 entao retorne (res * res * b) 27
 *
 * res = 27, e = 6, b = 3
 * e and 1 != 1 entao retorne (27 * 27) = 729
 *
 * res = 729, e = 13, b = 3
 * e and 1 == 1 entao retorne (729 ^ 2 * 3) = 1594323
 *
 * na forma iterativa seria
 *
 * b = 3
 * e = 13
 * res = 1
 *
 * 13 and 1 == 1
 *  res *= b => res = 1 * 3 = 3
 * b *= b => 3 * 3 = 9
 * e = 13 / 2 => 6
 *
 * b = 9
 * e = 6
 * res = 3
 * 6 and 1 == 0
 * b *= b = 81
 * e = 6 / 2 = 3
 *
 * b = 81
 * e = 3
 * res = 3
 * 3 and 1 == 1
 *  res *= b => 81 * 3 = 243
 * b *= b = 81 ^ 2 = 6561
 * e = 3 / 2 = 1
 *
 * b = 6561
 * e = 1
 * res 243
 * e and 1  == 1
 *  res *= b => (6561 * 243) = 1594323
 * b *= b => 6561 ^ 2 == 3 ^ 16 = 43046721
 * e = 1 / 2 = 0
 *
 */
fun binarypow(b: Long, e: Long): Long {
    return when (e) {
        0L -> {
            1L
        }
        1L -> {
            b
        }
        else -> {
            val res = binarypow(b, e shr 1)
            if (e and 1L == 1L) {
                res * res * b
            } else {
                res * res
            }
        }
    }
}

private fun checkexp() {
    println(String.format("%d, %d", longexp(3, 13), binarypow(3, 13)))

    println(
        String.format(
            "%d, %.15f %d", longexp(23, 5), doubleexp(23.0, 5), binarypow(23, 5)
        )
    )
    println(
        String.format(
            "%d, %.15f %d", longexp(23, 4), doubleexp(23.0, -5), binarypow(23, 4)
        )
    )
    println(
        String.format(
            "%d, %.17f %d",
            longexp(23, 4), doubleexp(123.0, -5), binarypow(23, 4)
        )
    )
}

fun main() {
    checkexp()
}