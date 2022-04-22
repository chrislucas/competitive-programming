package com.br.algo.math.lib.ntheory.modular.fermat

/**
 * https://codeforces.com/blog/entry/78873
 *
 * Comecar por aqui
 * https://codeforces.com/blog/entry/72527
 * https://cp-algorithms.com/algebra/binary-exp.html
 *
 * https://www.dcode.fr/modular-exponentiation
 */

fun iterativeModularExponential(b: Long, e: Long, m: Long): Long {
    return when (e) {
        0L -> {
            1L
        }
        1L -> {
            b % m
        }
        else -> {
            var acc = 1L
            var cb = b % m
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

fun recursiveModularExponential(b: Long, e: Long, m: Long): Long {
    return when (e) {
        0L -> 1
        1L -> b % m
        else -> {
            var p = recursiveModularExponential(b, e shr 1, m)
            p = (p % m * p % m) % m
            if (e and 1 == 0L) {
                p
            } else {
                (b % m * p % m) % m
            }
        }
    }
}


// https://www.dcode.fr/modular-exponentiation
private fun checkModExponential() {

    fun show(a: Long?, b: Long?) =
        println(String.format("%d, %d", a, b))

    show(
        iterativeModularExponential(3, 24, 26),
        recursiveModularExponential(3, 24, 26)
    )

    show(
        iterativeModularExponential(11, 24, 26),
        recursiveModularExponential(11, 24, 26)
    )

    show(
        iterativeModularExponential(11, 11, 13),
        recursiveModularExponential(11, 11, 13)
    )

    show(
        iterativeModularExponential(3, 9, 11),
        recursiveModularExponential(3, 9, 11)
    )


    show(
        iterativeModularExponential(11, 13, 19),
        recursiveModularExponential(11, 13, 19)
    )

    show(
        iterativeModularExponential(34, 1, 19),
        recursiveModularExponential(34, 1, 19)
    )

    show(
        iterativeModularExponential(1234, 13, 19),
        recursiveModularExponential(1234, 13, 19)
    )

    show(
        iterativeModularExponential(1234, 13, 195),
        recursiveModularExponential(1234, 13, 195)
    )


    show(
        iterativeModularExponential(343513213, 542323, 195),
        recursiveModularExponential(343513213, 542323, 195)
    )

    show(
        iterativeModularExponential(343513213, 542323, 542323),
        recursiveModularExponential(343513213, 542323, 542323)
    )

}

fun main() {
    checkModExponential()
}