package src.com.br.cp.math.combinatorics.bigint

import src.com.br.cp.bitwise.systems.until
import java.lang.StringBuilder
import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO


typealias BigInt = BigInteger

infix fun BigInt.isSet(nth: Int) = this and (ONE shl (nth - 1)) > ZERO

fun allCombinationOfK(k: Int): String {
    val list = mutableListOf<String>()
    var i = ZERO
    while (i < (ONE shl k)) {
        val sb = StringBuilder()
        for (j in k downTo 1) {
            sb.append(if (i isSet j) "1" else "0")
        }
        list.add(sb.toString())
        i += ONE
    }
    return list.joinToString("\n")
}

fun allCombinationFromPtoQ(p: Int, q: Int): String {
    val list = mutableListOf<String>()
    var i = BigInt("$p")
    while (i < (ONE shl q)) {
        val sb = StringBuilder()
        for (j in q downTo 1) {
            sb.append(if (i isSet j) "1" else "0")
        }
        list.add(sb.toString())
        i += ONE
    }
    return list.joinToString("\n")
}

private fun check1() {
    println(allCombinationOfK(33))
}

private fun check2() {
    println(allCombinationFromPtoQ(5, 6))
    println("******************")
    println(allCombinationFromPtoQ(2, 3))
}

fun main() {
    check2()
}