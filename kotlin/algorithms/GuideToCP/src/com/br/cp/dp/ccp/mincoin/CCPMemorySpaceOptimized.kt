package com.br.cp.dp.ccp.mincoin

import com.br.cp.dp.ccp.INSTANCE_PROBLEMS
import com.br.cp.simpleCounterTime
import kotlin.math.min


/**
 *
 *
 */
fun bottomUpOptimized(values: Array<Int>, target: Int): Int {
    val infinity = (1 shl  30) - 1
    val memory = Array(target + 1) { infinity }
    memory[0] = 0
    for (instance in 1..target) {
        for (value in values) {
            val subTarget = instance - value
            if (subTarget >= 0) {
                memory[instance] = min(memory[instance], memory[subTarget] + 1)
            }
        }
    }
    return memory[target]
}

fun bottomUp(values: Array<Int>, target: Int): Int {
    val memory = Array(target + 1) { Array(values.size  + 1) { 0 } }
    val infinity = (1 shl  30) - 1
    for (i in 0 .. values.size) {
        memory[i][0] = infinity
    }
    for (instance in 1 .. target) {
        for (i in 1..values.size) {
            val subTarget = instance - values[i]
            memory[instance][i] = if (subTarget >= 0) {
              min(memory[instance][i-1], memory[instance][subTarget])
            } else {
                memory[instance][i-1]
            }
        }
    }
    return memory[values.size][target]
}


private fun testAlgorithms() {
    INSTANCE_PROBLEMS.forEach { (values, target) ->
        val (a, timeA) = simpleCounterTime {
            bottomUpOptimized(values, target)
        }
        val (b, timeB) = simpleCounterTime {
            bottomUp(values, target)
        }
        println(
            String.format(
                "BottomUp (%f, %d), BottomUpOptimized(%f, %d)", timeA / 1000.0, a, timeB / 1000.0, b
            )
        )
    }
}

fun main() {
    testAlgorithms()
}