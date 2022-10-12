package com.br.algo.math.lib.ntheory.phi

// COMPETITIVE
// https://cp-algorithms.com/algebra/phi-function.html#properties

private fun totient(n: Long): Long {
    var acc = n
    var i = 2
    var cn = n
    while (i * i <= cn) {
        if (cn % i == 0L) {
            while (cn % i == 0L) {
                cn /= i
            }
            acc -= acc / i
        }
        i += 1
    }
    if (cn > 1) {
        acc -= acc / cn
    }
    return acc
}


fun main() {
    println(totient(10))
}