package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.problems

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
    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/akash-and-gcd-1-15/editorial/
    https://www.codingninjas.com/codestudio/problem-details/gcd-sum_1472653
 */


private fun computeEulerFunctionRange(n: Int): List<Int> {

    fun eulerTotientRange(n: Int): Array<Int> {
        val table = Array(n + 1) { it }
        for (i in 2..n) {
            if (table[i] == i) {
                table[i] = i - 1
                var j = 2 * i
                while (j <= n) {
                    table[j] -= table[j] / i
                    j += i
                }
            }
        }
        return table
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
    for (i in 1..n) {
        var j = i
        var k = 1
        while (j <= n) {
            summation[j] += i * phi[k]
            j += i
            k += 1
        }
    }

    return summation.toList()
}


/*
     https://www.dcode.fr/euler-totient
     https://oeis.org/A000010
 */
fun main() {
    (10..100).forEach {
        computeEulerFunctionRange(it)
    }
}