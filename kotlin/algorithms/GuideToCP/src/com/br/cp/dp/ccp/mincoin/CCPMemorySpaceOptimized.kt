package com.br.cp.dp.ccp.mincoin

import com.br.cp.dp.ccp.INSTANCE_PROBLEMS
import com.br.cp.exts.log
import com.br.cp.simpleCounterTime
import kotlin.math.min


/**
 *
 *
 */
fun bottomUpOptimized(values: Array<Int>, target: Int): Int {
    val infinity = (1 shl 30) - 1
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
    // [0, 1, 2 .. target] [value{0}, values{1}, values{1,2}, values{1,2 .. n-1} ... values{n}]
    val memory = Array(target + 1) { Array(values.size + 1) { 0 } }
    val infinity = (1 shl 30) - 1
    for (i in 0..values.size) {
        memory[i][0] = infinity
    }
    for (instance in 1..target) {
        for (i in 1..values.size) {
            val subTarget = instance - values[i - 1]
            memory[instance][i] = if (subTarget >= 0) {
                min(memory[instance][i - 1], memory[subTarget][i] + 1)
            } else {
                 memory[instance][i - 1]
            }
        }
    }
    return memory[target][values.size]
}


private fun testAlgorithms() {
    INSTANCE_PROBLEMS.forEachIndexed { i, (values, target) ->
        val (a, timeA) = simpleCounterTime {
            bottomUpOptimized(values, target)
        }
        val (b, timeB) = simpleCounterTime {
            bottomUp(values, target)
        }
        println(
            String.format(
                "P(%d) -> |instance %s | BottomUp (%.3f, %d) | BottomUpOptimized(%.3f, %d) |  Unico: %s",
                (i + 1),
                Pair(values.log(), target),
                timeA / 1000.0, a,
                timeB / 1000.0, b,
                arrayOf(a, b).distinct()
            )
        )
    }
}

fun main() {
    testAlgorithms()
}