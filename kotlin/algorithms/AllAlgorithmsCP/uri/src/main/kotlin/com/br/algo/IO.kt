package com.br.algo

import java.math.BigDecimal
import java.math.BigInteger
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

private fun readInt() = readLine()!!.toInt()

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private fun readInts() = readValues(transform = String::toInt)

private fun readStrings(delimiter: String = " ") = readLine()!!.split(delimiter)

private fun Char.getInt() = Character.getNumericValue(this)

private fun <T> Array<T>.show(prefix: String = "") = "$prefix${this.joinToString(" ")}"


private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


private inline fun testCases(times: Int, exec: () -> Unit) = (0 until times).forEach { _ -> exec() }


// para casos de teste ate EOF
private inline fun runWhiteTruth(fn: () -> Boolean) {
    while (true) {
        if (!fn()) {
            break
        }
    }
}


typealias PLL = Pair<Long, Long>

typealias PQueue<T> = PriorityQueue<T>

typealias BigInt = BigInteger

typealias BigDec = BigDecimal

val decimalFormat = DecimalFormat("#########.##").apply {
    decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ENGLISH)
}

val Char.intValue: Int
    get() = Character.getNumericValue(this)


private fun checkCharIntValue() {
    val romanNumeral = '\u216b'
    println("$romanNumeral, ${romanNumeral.intValue}")
    println(romanNumeral.digitToIntOrNull())
    //println(romanNumeral.digitToInt()) // Exception Char Ⅻ is not a decimal digit
    println(romanNumeral.toInt())
    println("***************")
    val c = '3'
    println(c.intValue)
    println(c.digitToInt())
    //println(c.digitToInt(28))
    println(c.toInt())

}

fun main() {
    checkCharIntValue()
}