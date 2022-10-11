package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.problems

/*
    TODO estudar essa teoria
    https://en.wikipedia.org/wiki/Pillai's_arithmetical_function

    A GCD sum function tambem chamada Pilla'' arithmetic function e definida pot cada m en

    F(n) = somadorio de k = 1 a n de gcd(k,n) e o equivalente

    F(n) = somatoria de d * phi(n/d)
    d|n  = 'd' sao os divisores de n

    exemplo: n = 10 d {1,2,5, 10}
    f(10) = 1 * phi(10/1) + 2 * phi(10/2) + 5 * phi(10/5) + 10 * phi(10/10)

    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/akash-and-gcd-1-15/editorial/
    https://www.codingninjas.com/codestudio/problem-details/gcd-sum_1472653
 */


private fun computeEulerFunctionRange(n: Int) {

    val eulerTotientFunction = Array(n + 1) { it }

    for (i in 2..n) {
        if (eulerTotientFunction[i] == i) {
            eulerTotientFunction[i] = i - 1
            var j = 2 * i
            while (j <= n) {
                eulerTotientFunction[j] -= eulerTotientFunction[j] / i
                j += i
            }
        }
    }

    val pre = Array(n + 1) { 0 }
    for (i in 1..n) {
        var j = i
        var k = 1
        while (j <= n) {
            pre[j] += i * eulerTotientFunction[k]
            j += i
            k += 1
        }
    }

    println(eulerTotientFunction)
}


/*
     https://www.dcode.fr/euler-totient
     https://oeis.org/A000010
     1, 1, 2, 2, 4, 2, 6, 4, 6, 4, 10,
     4, 12, 6, 8, 8, 16, 6, 18, 8, 12,
     10, 22, 8, 20, 12, 18, 12, 28, 8,
     30, 16, 20, 16, 24, 12, 36, 18, 24,
     16, 40, 12, 42, 20, 24, 22, 46, 16,
     42, 20, 32, 24, 52, 18, 40, 24, 36,
     28, 58, 16, 60, 30, 36, 32, 48, 20, 66, 32, 44
 */
fun main() {
    computeEulerFunctionRange(100)
}