package com.br.cp.dp.tutorials.geeksforgeeks.dp

import com.br.cp.exts.show
import com.br.cp.exts.timeSpentInSeconds


val range = (1..50)

private fun classicalRecursiveSolution(ith: Int): Long {
    return if (ith < 3) 1L else {
        classicalRecursiveSolution(ith - 1) + classicalRecursiveSolution(ith - 2)
    }
}

private fun recursivelyWithMemoization(ith: Int, memory: Array<Long>): Long {
    return if (memory[ith] > 0) {
        memory[ith]
    } else {
        val p = recursivelyWithMemoization(ith - 1, memory)
        val q = recursivelyWithMemoization(ith - 2, memory)
        memory[ith] = p + q
        memory[ith]
    }
}

private fun showClassicalRecSolution() {
    for (i in range) {
        println("$i: ${classicalRecursiveSolution(i)}")
    }
}

private fun showMemoizationSolution() {

    range.forEach {
        // +2 para poder criar um arrau de tamanho 3 no minimo
        val memory = Array(it + 2) { 0L }
        memory[1] = 1
        memory[2] = 1
        println("$it: ${recursivelyWithMemoization(it, memory)}")
    }
}


fun main() {
    timeSpentInSeconds {
        showClassicalRecSolution()
    }.show("%.3f")

    timeSpentInSeconds {
        showMemoizationSolution()
    }.show("%.3f")
}