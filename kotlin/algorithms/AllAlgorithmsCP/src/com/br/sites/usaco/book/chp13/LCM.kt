package src.com.br.sites.usaco.book.chp13


/**
 * Calculadora online
 * https://www.calculatorsoup.com/calculators/math/lcm.php
 *
 */

fun lcm(a: Int, b: Int): Int {
    fun gcd(a: Int, b: Int): Int {
        return if (a % b == 0) {
            b
        } else {
            gcd(b, a % b)
        }
    }
    return a * b / gcd(a, b)
}

private fun checkLCM() {
    println(lcm(12, 15)) // 60
    println(lcm(12, 17)) // 204
}


fun lcm(values: Array<Int>): Int {
    fun gcd(a: Int, b: Int): Int {
        return if (a % b == 0) {
            b
        } else {
            gcd(b, a % b)
        }
    }

    fun lcm(a: Int, b: Int) = a * b / gcd(a, b)

    return if (values.size > 2) {
        var acc = lcm(values[0], values[1])
        for (i in 2 until values.size) {
            acc = lcm(acc, values[i])
        }
        acc
    } else {
        if (values.size == 2) {
            val (p, q) = values
            p * q / gcd(p, q)
        } else {
            0
        }
    }
}


private fun checkArrayLCM() {
    println(lcm(arrayOf(12, 15))) // 60
    println(lcm(arrayOf(12, 17))) // 204
    println(lcm(arrayOf(12, 15, 75))) // 300
    println(lcm(arrayOf(12, 15, 17))) // 1020
}

fun main() {
    //checkLCM()
    checkArrayLCM()
}