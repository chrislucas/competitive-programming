package com.br.cp.chp1

import com.br.extkt.simpleCounterTime


private fun rec(ith: Int): Int = if (ith < 2) ith else rec(ith - 1) + rec(ith - 2)

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

private val RANGE = 1..60

private fun runFibonacciRec(): MutableMap<Int, Int> {
    val result = mutableMapOf<Int, Int>()
    val (_, time) = simpleCounterTime {
        RANGE.forEach {
            result[it] = rec(it)
        }
        Unit
    }
    println(String.format("Fibonacci Rec: %s. %.3f", RANGE, time / 1000.0))
    return result
}

private fun runFibonacciMemoization(): MutableMap<Int, Int> {
    val result = mutableMapOf<Int, Int>()
    val (_, time) = simpleCounterTime {
        RANGE.forEach {
            val memo = Array(it + 1) { 0 }
            memo[0] = 0
            memo[1] = 1
            if (it > 1) {
                memo[2] = 1
            }
            result[it] = memoization(it, memo)
        }
        Unit
    }
    println(String.format("Fibonacci Memo: %s. %.3f", RANGE, time / 1000.0))
    return result
}

fun main() {
    val resultA = runFibonacciRec()
    val resultB = runFibonacciMemoization()
    println(resultA == resultB)
    println("$resultA\n$resultB")
}