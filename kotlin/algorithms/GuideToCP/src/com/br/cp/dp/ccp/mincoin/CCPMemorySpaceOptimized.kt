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
        // usar i valores para atigin o valor objetivo (instance)
        //for (i in values.indices) {
        for (value in values) {
            //val subTarget = instance - values[i]
            val subTarget = instance - value
            if (subTarget >= 0) {
                memory[instance] = min(memory[instance], memory[subTarget] + 1)
            }
        }
    }
    return memory[target]
}

private fun bottomUpOptimizedWithTracking(values: Array<Int>, target: Int): Array<Int>{
    val infinity = (1 shl 30) - 1
    val memory = Array(target + 1) { infinity }
    val tracking = Array(target + 1) { 0 }
    memory[0] = 0
    for (i in 1 .. target) {
        for (value in values) {
            val subTarget = i - value
            if (subTarget >= 0 && memory[subTarget] + 1 < memory[i]) {
                memory[i] = memory[subTarget] + 1
                tracking[i] = value
            }
        }
    }
    return tracking
}

fun bottomUp(values: Array<Int>, target: Int): Int {
    // [0, 1, 2 .. target] [value{0}, values{1}, values{1,2}, values{1,2 .. n-1} ... values{n}]
    val memory = Array(target + 1) { Array(values.size + 1) { 0 } }
    val infinity = (1 shl 30) - 1
    for (i in 0..target) {
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

private fun bottomUpWithTracking(values: Array<Int>, target: Int): Array<Int> {
    val tracking = Array(values.size) { 0 }
    val infinity = (1 shl 30) - 1
    val memory = Array(target + 1) { Array(values.size + 1) { 0 } }

    for (i in 0..target) {
        memory[i][0] = infinity
    }

    return tracking
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
                "P(%d) -> |instance %s | BottomUpOptimized(%.3f, %d) | BottomUp(%.3f, %d) |  Unico: %s",
                (i + 1),
                Pair(values.log(), target),
                timeA / 1000.0, a,
                timeB / 1000.0, b,
                arrayOf(a, b).distinct()
            )
        )
    }
}


private fun testTrackingSolutions() {
    INSTANCE_PROBLEMS.forEachIndexed { idx, (values, target) ->
        val (rA, tA) = simpleCounterTime {
            bottomUpOptimizedWithTracking(values, target)
        }

        var n = target
        while (n > 0) {
            println(rA[n])
            n -= rA[n]
        }

        val (rB, tB) = simpleCounterTime {
            bottomUpWithTracking(values, target)
        }
/*
        val msg = String.format(
            "P(%d) -> |instance %s | BottomUp (%.3f, %d) | BottomUpOptimized(%.3f, %d) |  Unico: %s",
            (idx + 1),
            Pair(values.log(), target),
            tA / 1000.0,
            rA,
            tB / 1000.0,
            rB,
            arrayOf(rA, rB).distinct()
        )

        println(msg)
 */
    }
}

fun main() {
    testAlgorithms()
    //testTrackingSolutions()
}