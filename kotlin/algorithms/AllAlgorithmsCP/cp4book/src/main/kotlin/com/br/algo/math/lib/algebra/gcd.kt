package com.br.algo.math.lib.algebra

fun gcd(a: Long, b: Long): Long {
    var aa = a
    var bb = b
    while (aa % bb != 0L) {
        val aux = bb
        bb = aa % aux
        aa = aux
    }
    return bb
}

fun rgcd(a: Long, b: Long): Long {
    return if (a % b == 0L) b else rgcd(b, a % b)
}