package src.com.br.cp.math.algebra.coprimes

import src.com.br.sites.usaco.book.chp13.erathostenes.sieve.sieve

/*
    https://www.geeksforgeeks.org/generate-array-of-distinct-elements-with-gcd-as-1-and-no-coprime-pair/

    Dado um inteiro M, gere um array de M distintos inteiros tal q o gdc de todos os elementos do
    array é 1, mas nenhum par de elementos é coprimeo - gcd(a[i] , a[i+1]) != 1

    Exemplo
    n = 4, {30, 70, 42, 105}
    gcd(30, 70) = 10 ...
    N = 6, {10,15,6,12,24,48}
    gcd (10, 15) = 5

    Para N = 2 nao ha solucao pois nao eh possivel pois o que queremos eh uma colecao
    de numeros cujo gcd seja igual a 1 mais nenhum par seja gcd == 1
 */


private fun List<Int>.gcd(): Int {
    fun gcd(a: Int, b: Int): Int {
        return if (a % b == 0) {
            b
        } else {
            gcd(b, a % b)
        }
    }
    return if (isEmpty()) {
        0
    } else if(size == 1){
        this[0]
    } else {
        var p = gcd(this[0], this[1])
        for (i in 2 until size) {
            p = gcd(p, this[i])
        }
        p
    }
}

private fun solver(n: Int): List<Int> {

    /*
        https://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
         *
         *
         *                  n     Primes <= n
         *  ---------------------------------
         *                 10               4
         *                100              25
         *              1,000             168
         *             10,000           1,229
         *            100,000           9,592
         *          1,000,000          78,498
         *         10,000,000         664,579
         *        100,000,000       5,761,455
         *      1,000,000,000      50,847,534
     */
    fun sieveOfEratosthenes(n: Int): List<Int> {
        val primes = mutableListOf<Int>()
        val isPrime = Array(n + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        var factor = 2
        while (factor * factor <= n) {
            if (isPrime[factor]) {
                var k = factor
                while (k * factor <= n) {
                    isPrime[k * factor] = false
                    k += 1
                }
            }
            factor += 1
        }

        for (i in 2..n) {
            if (isPrime[i])
                primes += i
        }

        return primes
    }

    return if (n < 3) {
        emptyList()
    } else {
        val primes = sieveOfEratosthenes(n)
        val product = primes.fold(1) { acc, i -> acc * i }
        val answer = primes.map { product / it }
        answer
    }
}

fun main() {
    for (i in 0 .. 20) {
        with(solver(i)) {
            println(i)
            println(this)
            println("size: ${this.size}")
            println("gcd: ${this.gcd()}")
            println("************************************************")
        }
    }
}