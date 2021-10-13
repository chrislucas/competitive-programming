package com.br.algo.rounds.div3.r748.pa

import java.lang.StringBuilder


// Problem A
// https://codeforces.com/contest/1593/problem/0
// DONE depois do contest

private fun readInt(): Int = readLine()!!.toInt()

private fun readInts(delimiter: String = " "): Array<Int> =
    readLine()!!.split(delimiter).map { it.toInt() }.toTypedArray()

private fun readLong(delimiter: String = " "): Array<Long> =
    readLine()!!.split(delimiter).map { it.toLong() }.toTypedArray()

fun max(a: Int, b: Int) = if (a > b) a else b

fun min(a: Int, b: Int) = if (a < b) a else b

fun max(a: Long, b: Long) = if (a > b) a else b

fun min(a: Long, b: Long) = if (a < b) a else b


fun main() {
    var cases = readInt()
    fun transform(p: Long, q: Long) =
        if (p == q) {
            0
        } else {
            (q - p) + 1
        }

    while (cases > 0) {
        val (a, b, c) = readLong()
        val m = max(a, max(b, c))
        if (a == b && b == c) {
            println("1 1 1")
        } else {
            if (a == m && b == m || a == m && c == m || b == m && c == m) {
                val message = StringBuilder()
                message.append(if (a == m) "1" else transform(a, m))
                message.append(if (b == m) " 1" else " ${transform(b, m)}")
                message.append(if (c == m) " 1" else " ${transform(c, m)}")
                println(message)
            } else {
                println("${transform(a, m)} ${transform(b, m)} ${transform(c, m)}")
            }
        }
        cases -= 1
    }
}