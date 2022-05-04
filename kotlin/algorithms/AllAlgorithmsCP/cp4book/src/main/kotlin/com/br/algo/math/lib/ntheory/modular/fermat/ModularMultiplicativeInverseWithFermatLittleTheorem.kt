package com.br.algo.math.lib.ntheory.modular.fermat


/**
 * https://www.geeksforgeeks.org/fermats-little-theorem/
 * https://en.wikipedia.org/wiki/Fermat's_little_theorem
 *
 * O "pequeno teorema de fermat" declara que
 *
 * Se p é um numero primo, entao para qualquer inteiro a, o numero  (a ^ p) - a é um inteiro multiplo de p
 *
 * Existe um caso especial para esse problema:
 *
 * Se a nao for divisivel por p, o teorema é equivalente a essa declaracao
 *
 * a ^ (p - 1) - 1 é um inteiro multiplo de p
 *
 * Algebricamente
 *
 * a ^ (p - 1) % p = 1 ou
 * a ^ (p - 1) é congruente a 1 mod p
 *
 */


/**
 * calculadoras online
 * https://planetcalc.com/3311/
 */
fun iterativeModularInverse(a: Long, m: Long): Long? {

    fun gcd(a: Long, b: Long): Long = if (a % b == 0L) {
        b
    } else {
        gcd(b, a % b)
    }

    fun modularExp(b: Long, e: Long, m: Long): Long {
        return when (e) {
            0L -> {
                1L
            }
            1L -> {
                b % m
            }
            else -> {
                var acc = 1L
                var cb = b
                var ce = e
                while (ce > 0L) {
                    if (ce and 1 == 1L) {
                        acc = (acc % m * cb % m) % m
                    }
                    cb = (cb % m * cb % m) % m
                    ce = ce shr 1
                }
                acc
            }
        }
    }

    return if (gcd(a, m) != 1L) {
        null
    } else {
        modularExp(a, m - 2, m)
    }
}

fun recursiveModularInverse(a: Long, m: Long): Long? {
    fun gcd(a: Long, b: Long): Long = if (a % b == 0L) {
        b
    } else {
        gcd(b, a % b)
    }

    fun modularExponential(b: Long, e: Long, m: Long): Long {
        return when (e) {
            0L -> 1
            1L -> b % m
            else -> {
                var p = modularExponential(b, e shr 1, m)
                p = (p % m * p % m) % m
                if (e and 1 == 0L) {
                    p
                } else {
                    (b % m  * p % m) % m
                }
            }
        }
    }

    return if (gcd(a, m) != 1L) {
        null
    } else {
        modularExponential(a, m - 2, m)
    }
}

fun anotherIterativeModularInverse(a: Long, m: Long): Long {
    fun modular(b: Long, e: Long, m: Long): Long {
        return when (e) {
            0L -> {
                1L
            }
            1L -> {
                b % m
            }
            else -> {
                var acc = 1L
                var cb = b
                var ce = e
                while (ce > 0L) {
                    if (ce % 2 == 1L) {
                        acc = (acc % m * cb % m) % m
                    }
                    cb = (cb % m * cb % m) % m
                    ce /= 2
                }
                acc
            }
        }
    }
    return modular(a, m - 2, m)
}

/**
 * https://www.dcode.fr/modular-inverse
 */
private fun checkModularInverse() {

    fun show(a: Long?, b: Long?) = println(String.format("%d, %d", a, b))

    show(iterativeModularInverse(11, 13), recursiveModularInverse(11, 13))
    println(
        String.format(
            "%d\n",
            anotherIterativeModularInverse(11, 13)
        )
    )

    // Resultados diferente da calculadora https://www.dcode.fr/modular-inverse
    show(iterativeModularInverse(11, 26), recursiveModularInverse(11, 26))
    println(
        String.format(
            "%d\n",
            anotherIterativeModularInverse(11, 26)
        )
    )

    show(iterativeModularInverse(3, 11), recursiveModularInverse(3, 11))
    println(
        String.format(
            "%d\n",
            anotherIterativeModularInverse(3, 11)
        )
    )

    // Resultados diferente da calculadora https://www.dcode.fr/modular-inverse
    show(iterativeModularInverse(3, 26), recursiveModularInverse(3, 26))
    println(
        String.format(
            "%d\n",
            anotherIterativeModularInverse(3, 26)
        )
    )


    show(iterativeModularInverse(123, 4567), recursiveModularInverse(123, 4567))
    println(
        String.format(
            "%d\n",
            anotherIterativeModularInverse(123, 4567)
        )
    )
}


fun main() {
    checkModularInverse()
}