package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.problems

import kotlin.system.measureTimeMillis

/*
    https://en.wikipedia.org/wiki/Euler%27s_totient_function
    TODO estudar a funcao phi de euler
    https://www.geeksforgeeks.org/eulers-totient-function/#
 */

/*
    algorimto 1
    Complexidade n log n
    gcd = O(h) onde h eh o numero de digitos do menor numero entre a e b
 */
private fun simpliestCountingCoprimes(n: Int): Pair<Int, Int> {
    fun gcd(a: Int, b: Int): Int = if (a % b == 0) {
        b
    } else {
        gcd(b, a % b)
    }

    var acc = 1
    for (i in 2 until n) {
        if (gcd(i, n) == 1)
            acc += 1
    }

    return n to acc
}

private fun checkSimpliestCountinCoprimes() {
    /*
        phi(1) = 1
        phi(2) = 1
        phi(3) = 2
        phi(4) = 2
        phi(5) = 4
        phi(6) = 2
        phi(7) = 6
        phi(8) = 4
        phi(9) = 6
        phi(10) = 4
     */
    (1..10).forEach {
        println("Phi($it) = ${simpliestCountingCoprimes(it)}")
    }
}

/*
    algoritmo 2
    phi(N) = n * PRODUTORIO de 1 - (1/p-ith)
    p-ith sao os fatores primos de n

    Exemplos
    phi(6) = 6 * (1 - 1/2) * (1- 1/3) = 2

    Complexidade: O(sqrt(n log n)

    A ideia e contar todos os fatores primos P e seus multiplos. Subtrair
    esses fatores de P de N, o que sobra são as quantidades de coprimos (O que a
    funcao totient se propoe)

    1 — inicia a contagem com o valor N
    2 — p = 2 ate n
       a — se p divide n entao
         a.1 subtraia p de n ate que p nao divida mais n,
         isso p como fator primo e todos os multiplos de p
         pois nao sao coprimos de n
         a.2 Atualiza o resultado da contagem
   3 - apos p ultrapassar sqrt(n) (p*p >= n) e n' > 1
   entao remova do resultado todos os multiplos n'
 */

private fun phi(n: Int): Pair<Int, Int> {
    var result = n
    var cn = n
    var p = 2
    while (p * p <= cn) {
        if (cn % p == 0) {
            while (cn % p == 0)
                cn /= p
            result -= result / p
        }
        p += 1
    }

    /**
     * Se n tem um fator primo maior que sqrt(n)
     * remova-o da contagem tbm.
     * Isso ocorre para numeros nao primos que possuem
     * um fator primo maior que sqrt(n) ou para
     * numeros primos que sao divisiveis por si mesmo
     */
    if (cn > 1) {
        result -= result / cn
    }
    return n to result
}

private fun checkPhiFunction() {
    (10..100).forEach {
        println("${phi(it)}, ${simpliestCountingCoprimes(it)}")
    }
}

private fun checkTimeSpent() {
    val result = arrayOf(0, 0, 0)
    (10..10000).forEach {
        val a = measureTimeMillis { simpliestCountingCoprimes(it) } / 1000.0
        val b = measureTimeMillis { phi(it) } / 1000.0
        if (a < b) {
            result[0] += 1
        } else if (b < a) {
            result[1] += 1
        } else {
            result[2] += 1
        }
    }
    val (a, b, c) = result
    println("$a, $b, $c")
}


/**
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
 */

fun main() {
    // checkSimpliestCountinCoprimes()
    //checkPhiFunction()
    checkTimeSpent()
}