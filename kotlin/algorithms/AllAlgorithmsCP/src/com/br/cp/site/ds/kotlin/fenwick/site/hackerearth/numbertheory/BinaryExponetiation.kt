package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.numbertheory

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
        var cBase = base
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


private fun checkExp() {
    println(exp(11, 13, 19))
    println(exp(11, 13, 1))
    println(exp(25, 14, 1))
    println(exp(2, 31313, 3))
    println("************************************************************************")
    println(exp(BigInt("11"), BigInt("13"), BigInt("19")))
    println(exp(BigInt("11"), BigInt("13"), BigInt("1")))
    println(exp(BigInt("25"), BigInt("14"), BigInt("1")))
    println(exp(BigInt("2"), BigInt("31313"), BigInt("3")))
}


private fun checkExpBigInt() {
    println(exp(BigInt("23"), BigInt("123")))
    //
    val rs = exp(BigInt("23"), BigInt("312"))
    println("$rs\n${rs.toString().length}")
}





fun main() {
    checkExpBigInt()
}