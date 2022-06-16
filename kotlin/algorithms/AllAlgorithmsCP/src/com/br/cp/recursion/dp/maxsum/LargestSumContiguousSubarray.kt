package src.com.br.cp.recursion.dp.maxsum

import java.lang.Integer.max

/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 *
 * Kadabe
 */

private val testCases = arrayOf(
    arrayOf(-2, -3, 4, -1, -2, 1, 5, -3),
    arrayOf(-2, -3, -4, -1),
    arrayOf(-1, -3, -4, -2)
)


private fun kadaneAlgorithm(values: Array<Int>): Pair<Int, Pair<Int, Int>> {
    var global = values[0]
    var local = 0
    var p = 0
    var q = 0
    var s = 0
    for (i in values.indices) {
        local += values[i]
        if (local > global) {
            global = local
            p = s
            q = i
        }
        if (local < 0) {
            local = 0
            s = i + 1
        }
    }

    return Pair(global, p to q)
}

private fun kadaneForAllNegative(values: Array<Int>): Pair<Int, Pair<Int, Int>> {
    var global = values[0]
    var local = global
    var p = 0
    var q = 0
    var s = 0

    for (i in 1 until values.size) {
        local = max(values[i], local + values[i])
        global = if (local > global) {
            p = s
            q = i
            local
        } else {
            global
        }
        if (local < 0) {
            s = i + 1
        }
    }
    return Pair(global, p to q)
}


private fun checkKadaneAlgorithm() {
    testCases.forEach {
        val s = kadaneAlgorithm(it)
        val t = kadaneForAllNegative(it)
        println("$s, $t")
    }
}

fun main() {
    checkKadaneAlgorithm()
}