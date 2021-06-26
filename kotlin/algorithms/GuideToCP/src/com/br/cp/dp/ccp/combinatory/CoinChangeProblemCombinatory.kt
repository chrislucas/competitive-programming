package com.br.cp.dp.ccp.combinatory

import com.br.cp.dp.ccp.INSTANCES_PROBLEM_COUNT_SOLUTION
import com.br.cp.dp.ccp.INSTANCE_PROBLEMS
import com.br.cp.exts.simpleCounterTime

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
 *
 * O problema resume-se a contar quantas solucoes existem
 *
 * Seja S o conjunto um conjunto de valores inteiros  i > 0 e T um valor inteiro positivo >= 0
 *
 * Imagine que existe uma quantidade infinita de moedas com os valorez contidos em S, de quantas formas podemos
 * juntar moedas de S cuja soma daria T
 *
 * Por exemplo: S = {1,3,5} e T = 5
 *
 * temos as seguintes solucoes
 * 1) {1,1,1,1,1}
 * 2) {1,1,3}
 * 3) {5}
 *
 * Exemplo 2) S {1,2,3} e T = 5
 * 1) {1,1,1,1,1}
 * 2) {1,1,1,2}
 * 2) {1,1,3}
 * 2) {2,3}
 * */


private fun solverRecursively(values: Array<Int>, target: Int): Int = helperRec(values, values.size, target)


private fun helperRec(values: Array<Int>, ith: Int, target: Int): Int {
    if (target < 0) {
        return 0
    } else if (target == 0) {
        return 1
    }

    /**
     * Se os valores no vetor values nao forem  a combinacao necessaria para atingir o
     * valor 'target',  essa instancia de problema nao possui solucao
     * */
    else if (ith <= 0 && target >= 1)
        return 0

    // inclui o ith-valor do vetor na solucao do problema
    val containIthValue = helperRec(values, ith, target - values[ith - 1])
    // nao inclui o ith-valor do vetor na solucao do problema
    val nContainIthValue = helperRec(values, ith - 1, target)
    return containIthValue + nContainIthValue
}

private fun solverWithMemoization(values: Array<Int>, target: Int): Int =
    helperWithMemoization(values, Array(values.size) { 0 }, values.size, target)

private fun helperWithMemoization(values: Array<Int>, memory: Array<Int>, ith: Int, target: Int): Int {
    if (target < 0)
        return 0
    else if (ith <= 0 && target >= 1)
        return 0
    else if (memory[ith - 1] >= 0)
        return memory[ith - 1]

    // inclui o ith-valor do vetor na solucao do problema
    val containIthValue = helperWithMemoization(values, memory, ith, target - values[ith - 1])
    // nao inclui o ith-valor do vetor na solucao do problema
    val nContainIthValue = helperWithMemoization(values, memory, ith - 1, target)
    return containIthValue + nContainIthValue
}


private fun compareSolutions() {
    (INSTANCES_PROBLEM_COUNT_SOLUTION + INSTANCE_PROBLEMS).forEachIndexed { idx, (values, target) ->

        val (rB, tB) = simpleCounterTime {
            solverWithMemoization(values, target)
        }

        val (rA, tA) = simpleCounterTime {
            solverRecursively(values, target)
        }
    }
}

fun main() {
    compareSolutions()
}