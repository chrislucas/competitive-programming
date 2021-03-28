package com.br.cp.dp

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

fun greedySolution(values:  Array<Int>, target: Int) : Map<Int, Int> {
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
    else if(target == 0)
        return 0
    var min = INF
    for (v in values) {
        val p = rec(values, target - v) + 1
        min = min(min, p)
    }
    return min
}

fun it(values: Array<Int>, target: Int): Int {
    val (l, c) = arrayOf(target + 1, values.size + 1)
    val memo = Array(l) { Array(c) { 0 } }
    for (i in 1 .. 6) {
        for (j in values.indices) {
            memo[i][j] = min(memo[i-1][j] + 1, memo[i][j])
        }
    }

    return memo[l - 1][c - 1]
}


private fun sampleGreedyAlgorithm() {
    println(greedySolution(arrayOf(1,2,5), 12))
    println(greedySolution(arrayOf(2,1,5), 12))
    /**
     * Aqui temos um exemplo onde a solucao com um algoritmo guloso falha
     * a saida otimizada eh 3:2 (2 moedas de valor 3), mas a que o algoritmo produz
     * eh 4:1, 1:2 (1 moeda de 4 e 2 de 1)
     * */
    println(greedySolution(arrayOf(1,3,4), 6))
}


private fun sampleRec() {
    println(rec(arrayOf(1,3,4), 6))
}


fun main() {
    sampleRec()
}
