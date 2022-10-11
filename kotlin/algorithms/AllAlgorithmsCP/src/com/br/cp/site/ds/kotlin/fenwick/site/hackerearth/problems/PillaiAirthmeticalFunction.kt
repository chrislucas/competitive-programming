package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.problems

/*
    TODO estudar essa teoria
    https://en.wikipedia.org/wiki/Pillai's_arithmetical_function

    A GCD sum function tambem chamada Pilla'' arithmetic function e definida pot cada m en

    F(n) = somadorio de k = 1 a n de gcd(k,n) e o equivalente

    F(n) = somatoria de d|n  de d * phi(m/d)

    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/akash-and-gcd-1-15/editorial/
    https://www.codingninjas.com/codestudio/problem-details/gcd-sum_1472653
 */


private fun pillaiFunction(n: Int) {

}
private fun phi(n: Int): Int {
    var result = n
    var cn = n
    var p = 2
    while (p * p <= cn) {
        if (cn % p == 0) {
            while (cn % p == 0) {
                cn /= p
            }
            result -= result / p
        }
        p += 1
    }

    if (cn > 1) {
        result -= result / cn
    }

    return result
}


fun main() {

}