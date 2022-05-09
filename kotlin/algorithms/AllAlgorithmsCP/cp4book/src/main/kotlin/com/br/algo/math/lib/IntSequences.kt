package com.br.algo.math.lib


fun exp(base: Int, expo: Int): Int = 0 // TODO

// soma de progressao aritmetica
fun sumOfAP(a1: Int, terms: Int, constant: Int) =
    terms / 2 * (2 * a1 + (terms - 1) * constant)


// nth termo numa progressao aritmetica
fun nthAP(a1: Int, nth: Int, constant: Int) = a1 * (nth - 1) * constant


// soma de uma progressao geometrica
fun sumOfGP(a1: Int, terms: Int,  r: Int) = a1 * (1 - exp(r, terms)) / (1 - r)