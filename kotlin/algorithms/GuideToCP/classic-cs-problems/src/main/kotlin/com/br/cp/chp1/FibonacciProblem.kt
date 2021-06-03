package com.br.cp.chp1

import com.br.extkt.simpleCounterTime


private fun rec(ith: Int): Int = if (ith < 2) 1 else rec(ith - 1) + rec(ith - 2)

private fun memoization(ith: Int, buffer: Array<Int>): Int {
    return when {
        ith < 0 -> {
            0
        }
        buffer[ith] > 0 -> {
            buffer[ith]
        }
        else -> {
            buffer[ith] = memoization(ith - 1, buffer) + memoization(ith - 2, buffer)
            buffer[ith]
        }
    }
}


private val RANGE = 1..50

private fun runFibonacciRec() {

    val builder = StringBuilder()
    val (_, time) = simpleCounterTime {
        RANGE.forEach {
            builder.append("${rec(it)}\n")
        }
    }
    println(String.format("Fibonacci Rec: %s. %.3f", RANGE, time / 1000.0))
    // println(builder.toString())
}

private fun runFibonacciMemoization() {
    val builder = StringBuilder()
    val (_, time) = simpleCounterTime {
        RANGE.forEach {
            val memo = Array(it + 1) { 0 }
            memo[0] = 0
            memo[1] = 1
            if (it > 1) {
                memo[2] = 1
            }
            builder.append("${memoization(it, memo)}\n")
        }
    }
    println(String.format("Fibonacci Memo: %s. %.3f", RANGE, time / 1000.0))
    // println(builder.toString())
}

fun main() {
    runFibonacciRec()
    runFibonacciMemoization()
}