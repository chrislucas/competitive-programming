package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.numbertheory.exponentiation

import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

/*
    Binary Exponentiation
    https://cp-algorithms.com/algebra/binary-exp.html#applications#fromHistory

    Euler's totient function
    https://cp-algorithms.com/algebra/phi-function.html
 */

typealias BigInt = BigInteger

/*
    https://www.dcode.fr/modular-exponentiation
 */
private fun exp(base: BigInt, e: BigInt, m: BigInt): BigInt {

    fun mulitply(a: BigInt, b: BigInt, m: BigInt) = ((a % m) * (b % m)) % m

    return if (e == ZERO) {
        ONE
    } else if (e == ONE) {
        base
    } else {
        var acc = ONE
        var ce = e
        var cBase = base % m
        while (ce > ZERO) {
            if ((ce and ONE) == ONE) {
                acc = mulitply(acc, cBase, m)
            }
            cBase = mulitply(cBase, cBase, m)
            ce = ce shr 1
        }
        acc
    }
}

/*
    https://www.dcode.fr/exponentiation-calculation
 */
private fun exp(base: BigInt, e: BigInt): BigInt {
    return if (e == ZERO) {
        ONE
    } else if (e == ONE) {
        base
    } else {
        var acc = ONE
        var ce = e
        var cBase = base
        while (ce > ZERO) {
            if ((ce and ONE) == ONE) {
                acc *= cBase
            }
            cBase *= cBase
            ce = ce shr 1
        }
        acc
    }
}

private fun exp(base: Long, e: Long, m: Long): Long {

    /*
        https://cp-algorithms.com/algebra/binary-exp.html

        3 ^ 13 = 3 ^ (1101 base 2) = 3 ^ 8 * 3 ^ 4 * 3 ^1
        Uma vez que um numero n tem log2 (n) + 1 digitos, o algorimto
        de exponenciacao by squaring executa O(log2 n) operacoes

        3 ^ 1 = 3
        3 ^ 2 = (3 ^ 1) ^ 2
        3 ^ 3 = (3 ^ 2) * (3 ^ 1)
        3 ^ 4 = (3 ^ 2) ^ 2
        3 ^ 5 = (3 ^ 4) * (3 ^ 1)
        3 ^ 8 = (3 ^ 4) ^ 2
        ou seja
        se o exponente 'e' for par a operacao é (3 ^ e) ^ 2
        senao a operacao é (3 ^ e) * x onde x é um 3 ^ a uma potencia de 2
     */

    fun mulitply(a: Long, b: Long, m: Long) = ((a % m) * (b % m)) % m

    return if (e == 0L) {
        1L
    } else if (e == 1L) {
        base
    } else {
        var acc = 1L
        var ce = e
        var cBase = base % m
        while (ce > 0) {
            if ((ce and 1L) == 1L) {
                acc = mulitply(acc, cBase, m)
            }
            cBase = mulitply(cBase, cBase, m)
            ce = ce shr 1
        }
        acc
    }
}


private fun computeEulerTotientFunction(n: Int) {
    /*
        https://www.geeksforgeeks.org/eulers-totient-function-for-all-numbers-smaller-than-or-equal-to-n/
     */
}


private fun anotherComputeEulerTotientFunction(n: Int) {
    /*
        https://cp-algorithms.com/algebra/phi-function.html#properties
        O(sqrt(n))
     */
}


private fun computeRangeEulerTotient(n: Int): Array<Int> {
    /*
        // computar phi de euler de 1 a n
        https://www.geeksforgeeks.org/eulers-totient-function-for-all-numbers-smaller-than-or-equal-to-n/
     */
    return arrayOf()
}


private fun anotherComputeRangeEulerTotient(n: Int): Array<Int> {
    /*
        https://cp-algorithms.com/algebra/phi-function.html#implementation
        O(n log log n)
     */
    return arrayOf()
}

private fun modularMultiplicativeInverse() {
    /*
        https://cp-algorithms.com/algebra/binary-exp.html#implementation

        https://cp-algorithms.com/algebra/module-inverse.html
     */

    fun exp(base: BigInt, e: BigInt, m: BigInt): BigInt {

        fun mulitply(a: BigInt, b: BigInt, m: BigInt) = ((a % m) * (b % m)) % m

        return if (e == ZERO) {
            ONE
        } else if (e == ONE) {
            base
        } else {
            var acc = ONE
            var ce = e
            var cBase = base
            while (ce > ZERO) {
                if ((ce and ONE) == ONE) {
                    acc = mulitply(acc, cBase, m)
                }
                cBase = mulitply(cBase, cBase, m)
                ce = ce shr 1
            }
            acc
        }
    }
}


typealias MatBigInt = Array<Array<BigInt>>

private fun fibonacci(n: BigInt): MatBigInt {

    /*
        https://cp-algorithms.com/algebra/binary-exp.html#applications
        https://cp-algorithms.com/algebra/fibonacci-numbers.html#matrix-form

     */

    operator fun MatBigInt.get(x: Int, y: Int) = this[x][y]

    operator fun MatBigInt.set(x: Int, y: Int, v: BigInt) {
        this[x][y] = v
    }

    infix operator fun MatBigInt.timesAssign(other: MatBigInt) {

    }

    val base = Array(2) { Array(2) { ONE } }
    base[1, 1] = ZERO

    val answer = Array(2) { Array(2) { ONE } }
    answer[0, 1] = ZERO
    answer[1, 0] = ZERO

    var e = n
    while (e > ZERO) {
        if (e and ONE == ONE) {
            answer *= base
        }
        base *= base
        e = e shr 1
    }

    return answer
}

private fun fibonacciFastDoubling(n: BigInt) {
    /*
        https://cp-algorithms.com/algebra/fibonacci-numbers.html#matrix-form
     */

    val two = BigInt("2")

    // fast doubling method
    fun fdm(n: BigInt): Pair<BigInt, BigInt> {
        if (n == ZERO) {
            return ZERO to ONE
        }
        val (p, q) = fdm(n shr 1)
        val c = p * (two * q - p)
        val d = p * p + q * q

        return if (n and ONE == ONE) {
            d to c + d
        } else {
            c to d
        }
    }

    println(fdm(n))
}

private fun checkFibonacciFastDoubling() {
    fibonacciFastDoubling(BigInt("500"))
}


private fun checkExp() {
    println(exp(11, 13, 19))
    println(exp(11, 13, 1))
    println(exp(25, 14, 1))
    println(exp(2, 31313, 3))
    println(exp(5, 31313, 3))
    println("************************************************************************")
    println(exp(BigInt("11"), BigInt("13"), BigInt("19")))
    println(exp(BigInt("11"), BigInt("13"), BigInt("1")))
    println(exp(BigInt("25"), BigInt("14"), BigInt("1")))
    println(exp(BigInt("2"), BigInt("31313"), BigInt("3")))
    println(exp(BigInt("5"), BigInt("31313"), BigInt("3")))
}


private fun checkExpBigInt() {
    println(exp(BigInt("23"), BigInt("123")))
    //
    val rs = exp(BigInt("23"), BigInt("312"))
    println("$rs\n${rs.toString().length}")
}


fun main() {
    /*
    checkExpBigInt()
    println("************************************************************************")
    checkExp()

     */
    checkFibonacciFastDoubling()
}