package src.com.br.sites.usaco.book.chp13.erathostenes.sieve


/******************************************************************************
 *  Compilation:  javac PrimeSieve.java
 *  Execution:    java -Xmx1100m PrimeSieve n
 *
 *  Computes the number of primes less than or equal to n using
 *  the Sieve of Eratosthenes.
 *
 *  % java PrimeSieve 25
 *  The number of primes <= 25 is 9
 *
 *  % java PrimeSieve 100
 *  The number of primes <= 100 is 25
 *
 *  % java -Xmx100m PrimeSieve 100000000
 *  The number of primes <= 100000000 is 5761455
 *
 *  % java PrimeSieve -Xmx1100m 1000000000
 *  The number of primes <= 1000000000 is 50847534
 *
 *
 *  The 110MB and 1100MB is the amount of memory you want to allocate
 *  to the program. If your computer has less, make this number smaller,
 *  but it may prevent you from solving the problem for very large
 *  values of n.
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
 *
 ******************************************************************************/

/**
 * https://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
 */

fun sieve(n: Int): List<Int> {
    val isPrime = Array(n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    var factor = 2
    val primes = mutableListOf<Int>()
    while (factor * factor <= n) {
        if (isPrime[factor]) {
            var acc = factor
            while (acc * factor <= n) {
                isPrime[acc * factor] = false
                acc += 1
            }
        }
        factor += 1
    }
    if (n == 1)
        return listOf(2)

    for (i in 0..n) {
        if (isPrime[i])
            primes.add(factor)
    }
    return primes.toList()
}

private fun checkSieve() {

    infix fun IntRange.step(next: (Int) -> Int) =
        generateSequence(first, next).takeWhile { if (first < last) it <= last else it >= last }

    for (i in 1..1000000 step { it * 10 }) {
        println("$i, ${sieve(i).size}")
    }

}

fun main() {
    checkSieve()
}