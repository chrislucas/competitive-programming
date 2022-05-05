package com.br.algo.math.ntheory

/**
 * Get all primes smaller than N
 *
 * O algoritmo de sundaram gera 2*n+2 primos, para conseguirmos os primos
 * menores que n podemos reduzir o espaço de busca para (n-1)/2
 *
 * TODO estudar esse algoritmo
 * */


fun sieveOfSundaram(n: Int): List<Int> {
    val lim = (n - 1) / 2
    val isPrime = Array(lim + 1) { false }


    for (i in 1..lim) {
        var j = i
        var s = i + j + 2 * i * j
        while (s <= lim) {
            isPrime[s] = true
            j += 1
            s = i + j + 2 * i * j
        }
    }

    val primes = mutableListOf<Int>()
    primes += 2
    for (i in 1..lim) {
        if (!isPrime[i]) {
            primes += i * 2 + 1
        }
    }
    return primes
}


fun main() {
    sieveOfSundaram(20)
}