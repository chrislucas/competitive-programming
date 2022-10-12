package com.br.algo.math.lib.ntheory.phi

/**
 *
 * Pillai's arithmetical function
 * https://en.wikipedia.org/wiki/Pillai%27s_arithmetical_function
 *
 *
 * https://cp-algorithms.com/algebra/phi-function.html
 *
 * Propriedades da funcao phi de euler
 * 1) para um p primo phi(p) = p - 1
 *
 * 2) para 2 primos a e b
 *  phi(a) * phi(b) = (a - 1) * (b - 1)
 *  isso eh usado no algorimto de RSA
 *  https://www.geeksforgeeks.org/rsa-algorithm-cryptography/
 *
 * 3) seja p um numero primo -> phi(p ^ k) = p ^ k - p ^ (k - 1)
 *     phi(2^5) = 2^5 - 2^4
 *     phi(5^3) = 5^3 - 5^2
 *
 * 4) Para 2 numeros a e b
 *      phi(a * b) =
 *      phi(a) * phi(b) *  gcd(a,b) / phi(gcd(a,b))
 *      Caso especial gcd(a,b) = 1
 *      phi(a * b) = phi(a) * phi(b) * 1 / phi(1) = phi(a) * phi(b)
 *
 * 5) a soma dos valores de funcao phi de todos os divisores de n é igual n
 *      Exemplo: n = 6 - fatores {1, 2, 3, 6}
 *      phi(1) + phi(2) + phi(3) + phi(6) = 6
 *
 *
 */


private fun eulerFunctionFrom1ToN(n: Int): List<Int> {
    /*
        Usando idea do Crivo de eratosteles
        Complexidade O(n log log n)
     */
    val phi = Array(n + 1) { it }
    for (i in 2..n) {
        if (phi[i] == i) {
            var j = i
            while (j <= n) {
                phi[j] -= phi[j] / i
                j += i
            }
        }
    }
    return phi.toList()
}


private fun eulerFunctionRange1ToN(n: Int): List<Int> {
    /*
        Usando Propriedades da soma
        Complexidade = O(nlogn)
        Usando a somatorio de phi(d[i]) onde d[i] e o i-esimo divisor de n
        por exemplo N = 10 e divisores {1,2,5,10}
        phi(1) + phi(2) + phi(5) + phi(10) = 10
     */
    val phi = Array(n + 1) { 0 }
    phi[1] = 1
    for (i in 2..n) {
        phi[i] = i - 1
    }
    for (i in 2..n) {
        var j = 2 * i
        while (j <= n) {
            phi[j] -= phi[i]
            j += i
        }
    }
    return phi.toList()
}

/*
    Application in Euler's theorem
    https://cp-algorithms.com/algebra/phi-function.html#finding-the-totient-from-1-to-n-using-the-divisor-sum-property

    A mais importante propriedade do funcao totiente de euler
 */


private fun checkEulerFUnctionFrom1ToN() {
    (2..12).forEach {
        println(eulerFunctionFrom1ToN(it))
        println(eulerFunctionRange1ToN(it))
    }
}

fun main() {
    checkEulerFUnctionFrom1ToN()
}