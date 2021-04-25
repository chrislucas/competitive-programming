package com.br.cp.dp.ccp.mincoin

import com.br.cp.dp.ccp.INSTANCE_PROBLEMS
import com.br.cp.exts.log
import com.br.cp.simpleCounterTime

import java.lang.Integer.min

const val INF = Int.MAX_VALUE - 1

fun rec(values: Array<Int>, target: Int): Int {
    if (target < 0)
        return INFINITY
    else if (target == 0)
        return 0
    var min = INFINITY
    for (v in values) {
        val p = rec(values, target - v) + 1
        min = min(min, p)
    }
    return min
}

fun memoization(values: Array<Int>, memo: Array<Int>, target: Int): Int {
    if (target < 0) {
        return INFINITY
    } else if (memo[target] in 0 until INFINITY) {
        return memo[target]
    }
    var min = INFINITY
    for (v in values) {
        val p = memoization(values, memo, target - v) + 1
        min = min(min, p)
    }
    memo[target] = min
    return memo[target]
}

fun it(values: Array<Int>, target: Int): Int {
    // [0 .. target][values[0] .. values[n]]
    val solution = Array(target + 1) { Array(values.size + 1) { 1 } }
    val infinity = (1 shl  30) - 1
    for(i in 0 .. target) {
        solution[i][0] = infinity
    }
    for (subProblem in 1..target) {
        for (j in 1 .. values.size) {
            val subTarget = subProblem - values[j - 1]
            solution[subProblem][j] = if (subTarget >= 0) {
                min(solution[subProblem][j-1], solution[subTarget][j] + 1)
            } else {
                 solution[subProblem][j-1]
            }
        }
    }

    return solution[target][values.size]
}

fun itOptimized(values: Array<Int>, target: Int): Int {
    val infinity = (1 shl 30) - 1
    val memory = Array(target + 1) { infinity }
    memory[0] = 0
    for (instance in 1 .. target) {
        for (value in values) {
            val subTarget = instance - value
            if (subTarget >= 0) {
                memory[instance] = min(memory[instance], memory[subTarget] + 1)
            }
        }
    }
    return memory[target]
}


private fun compareRecAndItSolution() {
    INSTANCE_PROBLEMS.forEachIndexed { i, (coins, target) ->
        val (b, timeB) = simpleCounterTime {
            it(coins, target)
        }
        val (a, timeA) = simpleCounterTime {
            rec(coins, target)
        }
        val (c, timeC) = simpleCounterTime {
            val memory = Array(target + 1) { INFINITY }
            memory[0] = 0
            memoization(coins, memory, target)
        }
        val (d, timeD) = simpleCounterTime {
            itOptimized(coins, target)
        }

        println(
            String.format(
                "P(%d) -> |instance %s | Rec - T(%.3f), R(%d) | BottomUpd - T(%.3f), R(%d) | " +
                        "Rec Memoization - T(%.3f), R(%d) | BottomUpMemoryOptimized T(%.3f), R(%d)| Unico: %s\n",
                (i + 1),
                Pair(coins.log(), target),
                timeA / 1000.0,
                a,
                timeB / 1000.0,
                b,
                timeC / 1000.0,
                c,
                timeD / 1000.0,
                d,
                arrayOf(a,b,c,d).distinct()
            )
        )
    }
}


fun main() {
    compareRecAndItSolution()
}
