package src.com.br.cp.math.algebra.lcm

import java.math.BigInteger


private fun lcm(p: Long, q: Long): Long {
    fun gcd(p: Long, q: Long): Long {
        return if (p % q == 0L) {
            q
        } else {
            gcd(q, p % q)
        }
    }
    return (p * q) / gcd(p, q)
}

private fun lcm(p: Int, q: Int): Int {
    fun gcd(p: Int, q: Int): Int {
        return if (p % q == 0) {
            q
        } else {
            gcd(q, p % q)
        }
    }
    return (p * q) / gcd(p, q)
}

private fun lcm(p: BigInteger, q: BigInteger): BigInteger = (p * q) / p.gcd(q)


data class Rational(val n: BigInteger, val d: BigInteger)

private infix fun Rational.lcm(that: Rational) : BigInteger = lcm(this.d, that.d)

operator fun Rational.plus(that: Rational) : Rational {
    val denominator = this lcm that
    return Rational(this.n * (denominator / this.d) + that.n * (denominator / that.d), denominator )
}

operator fun Rational.minus(that: Rational) : Rational {
    val denominator = this lcm that
    return Rational(this.n * (denominator / this.d) - that.n * (denominator / that.d), denominator)
}


fun Rational.normalize() : Rational {
    val gdc = n.gcd(d)
    return Rational(n / gdc, d / gdc)
}
