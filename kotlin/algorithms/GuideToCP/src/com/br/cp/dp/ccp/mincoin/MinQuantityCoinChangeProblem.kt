package com.br.cp.dp.ccp.mincoin

import com.br.cp.dp.ccp.INSTANCE_PROBLEMS
import com.br.cp.exts.log
import com.br.cp.exts.simpleCounterTime
import java.lang.Integer.min
import java.lang.StringBuilder


/**
 * Notas
 *
 * Dado um conjunto C= {c1, c2, c3, cn ...} de moeadas de valores distintos e um valor Total N, pergunta-se:
 * Como atiginmos a soma de valor N usando o minimo de moeadas do conjunto C
 *
 *  - Nao a restricoes no uso de uma moeada seja ela de qualquer valor
 *  - Porem espera-se uma solucao otimizada, onde o menor numero de mmedas possivel eh utilizado
 *
 *  Por exemplo:
 *  C = {1,2,5} e N = 12
 *  a solucao otimizada eh 5+5+2
 *
 * Basic Concepts
 *
 * */


/**
 *
 * Solucao com algoritmo goluso
 *
 * */

fun greedyAlgorithmSolution(values: Array<Int>, target: Int): Map<Int, Int> {
    var (acc, idx) = arrayOf(0, values.size - 1)
    values.sort()
    val h = mutableMapOf<Int, Int>()
    while (acc != target || idx < 0) {
        if (acc + values[idx] <= target) {
            acc += values[idx]
            h[values[idx]] = h[values[idx]]?.plus(1) ?: 1
        } else {
            idx -= 1
        }
    }
    return h
}

const val INFINITY = Int.MAX_VALUE - 1

fun findMinAmountOfCoinsRecursively(values: Array<Int>, target: Int): Int {
    if (target < 0)
        return INFINITY
    else if (target == 0)
        return 0
    var min = INFINITY
    for (v in values) {
        val p = findMinAmountOfCoinsRecursively(values, target - v) + 1
        min = min(min, p)
    }
    return min
}

private fun findMinAmountOfCoinsWithMemorization(memo: Array<Int>, values: Array<Int>, target: Int): Int {
    if (target < 0) {
        return INFINITY
    } else if (memo[target] != INFINITY) {
        return memo[target]
    }
    for (v in values) {
        val p = findMinAmountOfCoinsWithMemorization(memo, values, target - v) + 1
        memo[target] = min(p, memo[target])
    }
    return memo[target]
}

fun findMinAmountOfCoinsIteratively(values: Array<Int>, target: Int): Int {
    // [sub0, sub1, sub2, subn ... target] [values[0] .. values[n]]
    val memory = Array(target + 1) { Array(values.size + 1) { 0 } }
    /**
     * Restricao do problema
     * Seja T um target > 0 e S um conjunto nao vazio de valores inteiros > 0
     * para um subproblema onde T = 0 nao existe combinacao de S cuja some seja igual a T
     * Logo para solucao iterativa com uma matriz 2D M = [0 .. T][0 .. S.size]
     * M[i=0 .. T][0] = INF -> qualquer i-esimo subproblema que usa zero moedas tem resposta INF ou
     * melhor explicado nao tem solucao
     * */
    for (i in 0..target) {
        memory[i][0] = INFINITY
    }
    for (subProblem in 1..target) {
        for (i in 1..values.size) {
            val subTarget = subProblem - values[i - 1]
            // da para usar o ith-1 valor para resolver o subproblema
            if (subTarget < 0) {
                // nao
                memory[subProblem][i] = memory[subProblem][i - 1] //
            } else {
                // min(excluindo values[i], incluindo values[i]) na solucao
                memory[subProblem][i] = min(memory[subProblem][i - 1], memory[subTarget][i] + 1)
            }
        }
    }
    return memory[target][values.size]
}

private fun findMinimumCoinChangeBottomUpSolution(values: Array<Int>, target: Int): Int {
    // [values[0] .. values[n]] [sub0, sub1, sub2, subn ... target]
    val memory = Array(values.size + 1) { Array(target + 1) { 0 } }
    // pra zero moedas a resposta sera INF para qualquer valor TARGET
    for (i in 0..target) {
        memory[0][i] = INFINITY
    }
    for (i in 1..values.size) {
        for (subProblem in 1..target) {
            val subTarget = subProblem - values[i - 1]
            if (subTarget >= 0) {
                // min(excluindo values[i], incluindo values[i]) na solucao
                memory[i][subProblem] = min(memory[i - 1][subProblem], memory[i][subTarget] + 1)
            } else {
                memory[i][subProblem] = memory[i - 1][subProblem]
            }
        }
    }
    return memory[values.size][target]
}

private fun sampleGreedyAlgorithm() {
    println(greedyAlgorithmSolution(arrayOf(1, 2, 5), 12))
    println(greedyAlgorithmSolution(arrayOf(2, 1, 5), 12))
    /**
     * Aqui temos um exemplo onde a solucao com um algoritmo guloso falha
     * a saida otimizada eh 3:2 (2 moedas de valor 3), mas a que o algoritmo produz
     * eh 4:1, 1:2 (1 moeda de 4 e 2 de 1)
     * */
    println(greedyAlgorithmSolution(arrayOf(1, 3, 4), 6))
}

private fun compareAllImplementations() : String {
    val buffer = StringBuilder()
    val instances = arrayOf(
        arrayOf(2, 5) to 2,
        arrayOf(1, 3, 4) to 6,
        arrayOf(1, 3, 6) to 7,
        arrayOf(2, 3, 8) to 15,
        arrayOf(1, 2, 5) to 12,
        arrayOf(2, 1, 5) to 12,
        arrayOf(1, 2, 3, 4) to 4
    ) + INSTANCE_PROBLEMS
    instances.sliceArray(0 .. 15).forEachIndexed { i, ( values, target) ->
        val (a, timerA) = simpleCounterTime {
            findMinimumCoinChangeBottomUpSolution(values, target)
        }
        val (b, timerB) = simpleCounterTime {
            findMinAmountOfCoinsIteratively(values, target)
        }
        val (c, timerC) = simpleCounterTime {
            val memo = Array(target + 1) { INFINITY }
            memo[0] = 0
            findMinAmountOfCoinsWithMemorization(memo, values, target)
        }
        val (d, timerD) = simpleCounterTime {
            findMinAmountOfCoinsRecursively(values, target)
        }

        val msg = String.format(
            "P(%d) -> | instance %s | BottomUp - T(%.3f), R(%d) | BottomUp - T(%.3f), R(%d) | " +
                    "RecMemoization - T(%.3f), R(%d) | Rec T(%.3f), R(%d) | Unico: %s\n",
            i + 1,
            Pair(values.log(), target),
            timerA / 1000.0,
            a,
            timerB / 1000.0,
            b,
            timerC / 1000.0,
            c,
            timerD / 1000.0,
            d,
            arrayOf(a, b, c, d).distinct()
        )
        buffer.append(msg)
    }

    return buffer.toString()
}

fun main() {
    val (result, time) = simpleCounterTime {
        compareAllImplementations()
    }
    println(String.format("Tempo de execucao T(%.3f)\nResultado\n%s", time / 1000.0, result))
}
