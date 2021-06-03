package com.br.cp.dp.ccp.combinatory

import com.br.cp.dp.ccp.INSTANCES_PROBLEM_COUNT_SOLUTION
import com.br.cp.dp.ccp.INSTANCE_PROBLEMS
import com.br.cp.exts.simpleCounterTime

private fun countSolutionsBottomUp(values: Array<Int>, target: Int): Int {
    return 0
}

private fun compareSolutions(): String {
    val buffer = StringBuilder()
    (INSTANCES_PROBLEM_COUNT_SOLUTION + INSTANCE_PROBLEMS).forEachIndexed { idx, (values, target) ->

        val (rA, tA) = simpleCounterTime {
            countSolutionsBottomUp(values, target)
        }

    }

    return buffer.toString()
}


fun main() {
    val (r, t) = simpleCounterTime {
        compareSolutions()
    }
    println(String.format("Tempo de execucao T(%.3f)\nResultado\n%s", t / 1000.0, r))
}