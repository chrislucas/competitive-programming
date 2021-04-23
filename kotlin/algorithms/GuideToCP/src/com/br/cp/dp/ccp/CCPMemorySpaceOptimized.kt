package com.br.cp.dp.ccp

import com.br.cp.simpleCounterTime
import kotlin.math.min


/**
 *
 *
 */
fun bottomUpOptimized(values: Array<Int>, target: Int) : Int {
    val memory = Array(target+1) { INF }
    memory[0] = 0
    for (instance in 1 .. target) {
        for(value in values) {
            val subTarget = instance - value
            if (subTarget >= 0) {
                memory[instance] = min(memory[instance], memory[subTarget] + 1)
            }
        }
    }
    return memory[target]
}

/**
 * https://riptutorial.com/dynamic-programming/example/25891/minimum-number-of-coins-to-get-total
 * a solucao proposta no link acima monta uma matriz [target][values.size+1]
 * */
fun bottomUp(values: Array<Int>, target: Int) : Int {
    val memory = Array(values.size) { Array(target + 1) { 0 } }
    for (instance in values.indices) {
        for(j in 0 .. target) {

        }
    }

    return memory[values.size][target]
}



private fun run() {
    INSTANCE_PROBLEMS.forEach {
        (values, target) ->
        val (a, timeA)  = simpleCounterTime {
            bottomUpOptimized(values, target)
        }
        val (b, timeB) = simpleCounterTime {
            bottomUp(values, target)
        }
        println( String.format("BottomUp (%f, %d), BottomUpOptimized(%f, %d)"
            , timeA / 1000.0, a, timeB / 1000.0, b ))
    }
}

fun main() {

}