package com.br.cp.dp.ccp

import com.br.cp.simpleCounterTime
import java.lang.Integer.min


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

fun greedySolution(values: Array<Int>, target: Int): Map<Int, Int> {
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

const val INF = Int.MAX_VALUE - 1

fun rec(values: Array<Int>, target: Int): Int {
    if (target < 0)
        return INF
    else if (target == 0)
        return 0
    var min = INF
    for (v in values) {
        val p = rec(values, target - v) + 1
        min = min(min, p)
    }
    return min
}

fun memoization(values: Array<Int>, memo: Array<Int>, target: Int): Int {
    if (target < 0) {
        return INF
    } else if (memo[target] in 0 until INF) {
        return memo[target]
    }
    var min = INF
    for (v in values) {
        val p = memoization(values, memo, target - v) + 1
        min = min(min, p)
    }
    memo[target] = min
    return memo[target]
}

/*
    values = [c1, c2, c3 .. ck], target = n >= 0
    S [i][j] = espaco da solucao numa matriz 2D
    A dimensao do espaco de solucao eh  [target + 1] x [values.size]

    Seja o vetor values = [1,3,4] e  target = 6

*  0 [0,..., 0] -> para o target = 0 nenhuma soma usando valores do vetor values[] satisfaz a equacao
*  1 [] -> para o Target = 1  a solucao eh

*  2 []
*  3 []
*  4 []
*  5 []
*  6 []
* */

fun it(values: Array<Int>, target: Int): Int {
    val solution = Array(target + 1) { Array(values.size) { 0 } }
    /**
     * O espaco da solucao usando a tecnica bottom Up vai de 1 .. target
     * construindo a solucao "debaixo para cima"
     * */
    for (iTarget in 1..target) {
        for (j in values.indices) {
            solution[iTarget][j] = INF
            val subTarget = iTarget - values[j]
            //  values[j] > iTarget esse valor nao entra na subsolucao do problema
            if (subTarget >= 0) {
                solution[iTarget][j] = if (j == 0) {
                    solution[iTarget][subTarget] + 1
                } else {
                    min(solution[iTarget][j], solution[iTarget][subTarget] + 1)
                }
            } else {
                solution[iTarget][j] = solution[iTarget - 1][j]
            }
        }
    }

    return solution[target][values.size]
}

fun itOptimized(values: Array<Int>, target: Int): Int {
    return 0
}


private fun sampleGreedyAlgorithm() {
    println(greedySolution(arrayOf(1, 2, 5), 12))
    println(greedySolution(arrayOf(2, 1, 5), 12))
    /**
     * Aqui temos um exemplo onde a solucao com um algoritmo guloso falha
     * a saida otimizada eh 3:2 (2 moedas de valor 3), mas a que o algoritmo produz
     * eh 4:1, 1:2 (1 moeda de 4 e 2 de 1)
     * */
    println(greedySolution(arrayOf(1, 3, 4), 6))
}

private fun sampleRec() {
    println(rec(arrayOf(1, 3, 4), 6))
}

private fun compareRecAndItSolution() {
    INSTANCE_PROBLEMS.forEach { (coins, target) ->
        val (b, timeB) = simpleCounterTime {
            it(coins, target)
        }
        val (a, timeA) = simpleCounterTime {
            rec(coins, target)
        }
        val (d, timeD) = simpleCounterTime {
            val memory = Array(target + 1) { INF }
            memory[0] = 0
            memoization(coins, memory, target)
        }
        val (c, timeC) = simpleCounterTime {
            itOptimized(coins, target)
        }


        println(
            String.format(
                "Rec (%f, %d)\nBottomUpd(%f, %d)\nBottomUpOptimized(%f, %d)",
                timeA / 1000.0,
                a,
                timeB / 1000.0,
                b,
                timeC / 1000.0,
                c
            )
        )
    }
}


fun main() {
    compareRecAndItSolution()
}
