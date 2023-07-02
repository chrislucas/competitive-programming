package src.com.br.cp.site.ds.kotlin.site.hackerearth.problems

/*
    TODO estudar essa teoria
    https://en.wikipedia.org/wiki/Pillai's_arithmetical_function

    A GCD sum function tambem chamada Pilla'' arithmetic function e definida pot cada m en

    F(n) = somadorio de k = 1 a n de gcd(k,n) e o equivalente

    F(n) = somatoria de d * phi(n/d)
    d|n  = 'd' sao os divisores de n

    exemplo: n = 10 d {1, 2, 5, 10}
    f(10) = 1 * phi(10/1) + 2 * phi(10/2) + 5 * phi(10/5) + 10 * phi(10/10)
        = 1 * phi(10) + 2 * phi(5) + 5 * phi(2) + 10 * phi(1)
        = 4 + 8 + 5 + 10
        = 27

    S = gcd(1, 10) + ... + gcd(10, 10)
      =
    n = 9; d {1, 3, 9}
    f(9) = 1 * phi(9) + 3 * phi(3) + 9 * phi(1)
         = 6 + 6 + 9
         = 21
    S = gcd(1, 9) + ... + gcd(9, 9)
      = 1 + 1 + 3 + 1 + 1 + 3 + 1 + 1 + 9
      = 21

    n = 4; d {1, 2, 4}
    f(4) = 1 * phi(4) + 2 * phi(2) + 4 * phi(i)
         = 2 + 2 + 4
         = 8
     S = gcd(1, 4) + gcd(2, 4) + gcd(3, 4) + gcd(4, 4)
       = 1 + 2 + 1 + 4
       = 8

    n = 3; d {1, 3}
    f(3) = 1 * phi(3) + 3 * phi(1)
         = 2 + 3
         = 5

    n = 2; d {1, 2}
    f(2) = 1 * phi(2) + 2 * phi(1)
         = 1 + 2
         = 3
    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/akash-and-gcd-1-15/editorial/
    https://www.codingninjas.com/codestudio/problem-details/gcd-sum_1472653
 */


private fun computeEulerFunctionRange(n: Int): List<Int> {

    fun eulerTotientRange(n: Int): Array<Int> {
        val phi = Array(n + 1) { it }
        for (i in 2..n) {
            if (phi[i] == i) {
                phi[i] = i - 1  // quantidadades de coprimos de um numero i é no máximo i-1
                var j = 2 * i
                while (j <= n) {
                    phi[j] -= phi[j] / i
                    j += i
                }
            }
        }
        return phi
    }

    fun eulerFunctionRange(n: Int): Array<Int> {
        val table = Array(n + 1) { 0 }
        table[1] = 1
        for (i in 2..n) {
            table[i] = i - 1
        }
        for (i in 2..n) {
            var j = 2 * i
            while (j <= n) {
                table[j] -= table[i]
                j += i
            }
        }
        return table
    }

    val phi = eulerTotientRange(n)

    /*
        F(n) = somatoria de d * phi(n/d)
        d|n  = 'd' sao os divisores de n
     */
    val summation = Array(n + 1) { 0 }
    for (divisor in 1..n) {
        var i = 1
        var j = divisor     // j-esimo divisor
        while (j <= n) {
            /*
                como j cresce com a soma de div entao esse loop
                vai executar n/div vezes e assim i só pode ir ate n/div
                Assim conseguimos calcular:
                S = d * phi(i) + ... d * phi(i+1)
             */
            summation[j] += divisor * phi[i]
            j += divisor
            i += 1
        }
    }

    return summation.toList()
}

private fun checkWithRange() {
    (10..100).forEach {
        computeEulerFunctionRange(it)
    }
}

private fun checkWithLargeEntry() {
    val computed = computeTimeInMillis {
        computeEulerFunctionRange(10)
    }
    val (r, s) = computed
    println("$r, ${s / 1000.0}")
}


private fun <T> computeTimeInMillis(block: () -> T): Pair<T, Long> {
    val start = System.currentTimeMillis()
    val result = block()
    return Pair(result, System.currentTimeMillis() - start)
}


/*
     https://www.dcode.fr/euler-totient
     https://oeis.org/A000010
 */
fun main() {
    checkWithLargeEntry()
}