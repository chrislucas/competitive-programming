package src.com.br.cp.paradigm.slindingwindow.geeksforgeeks

import java.lang.Integer.max
import java.lang.Integer.min


/**
 * https://www.geeksforgeeks.org/window-sliding-technique/
 * TODO
 * Essa técnica ajuda a diminuir a complexidade de algoritmos que tem loops aninhados, saindo as vezes de um
 * algoritmo quadratico para um linear((N^2) -> (N)) , ou um cubico para um quadratico  (N^3) -> (N^2)
 *
 * Problema proposto: Considere uma cadeia de barris conectadas, Suponha que queiramos adicionar oleo na cadeia
 * completa sem derramar
 *
 * Primeira forma de resolver
 *  1 - Pegar a quantidade suficiente de oleo e encher o primeiro barril
 *  2 - voltar e pegar mais uma quantidade e preencher o próximo barril
 *  3 - repetir o passo 2 até o ultimo barril
 *
 *  Uma outra forma é utilizar um pano que passe por toda a cadeia e derramar o oleo por ele até completar
 *  todos os barris, isso é chamado de sliding windows
 *
 *  Prerequisitos para usar a técnica
 *  - O tamanho da "janela" (Array ou uma estrutura de dados que possa armazenar um conjunto de dados)
 *  deve ser fixado ao longo do loop, somente o tempo de complexidade pode ser reduzido
 *
 *  Como utilizar
 *  - ache o tamanho da janela necessario
 *  - compute o resultado da primeira janela
 *  - entao use um loop para mover a janela uma posição a frente na estrutura (array) e continue computando
 *  o valor da janela e movendo-a
 */


/**
 * Um problema que podemos usar sliding window
 * Dado um array de tamanho N qual e o valor máximo que podemos obter somando K valores consecutivos
 */
private fun maxSumOfKConsecutivesValues() {


    fun naiveMaxSum(values: List<Int>, size: Int): Int {
        var acc = Integer.MIN_VALUE
        if (size <= values.size) {
            for (i in 0..values.size - size) {
                acc = max(acc, values.subList(i, i + size).sum())
            }
        }
        return acc
    }

    fun naiveMinSum(values: List<Int>, size: Int): Int {
        var acc = Integer.MAX_VALUE
        if (size <= values.size) {
            for (i in 0..values.size - size) {
                acc = min(acc, values.toList().subList(i, i + size).sum())
            }
        }
        return acc
    }

    fun windowSlidingMaxSum(values: List<Int>, windowSize: Int): Pair<Pair<Int, Int>, Int> {

        var windowSum = Integer.MIN_VALUE
        var p = 0
        var q = 0


        if (windowSize <= values.size) {
            windowSum = max(windowSum, values.subList(0, windowSize).sum())
            p = windowSize
            var current = windowSum
            for (i in 1..values.size - windowSize) {
                /*
                    movendo a janela
                    o truque está em remover o primeiro indice (values[i-1]) da sublista
                    e adicionar o proximo item baseado no tamanho da janela
                 */
                current += values[windowSize + i] - values[i - 1]
                if (current > windowSum) {
                    windowSum = current
                    p = i
                    q = windowSize + 1
                }
            }
        }
        return Pair(p to q, windowSum)
    }

    fun windowSlidingMinSum(values: List<Int>, s: Int): Pair<Pair<Int, Int>, Int> {
        var windowSum = Integer.MAX_VALUE
        var p = 0
        var q = 0

        if (s <= values.size) {
            windowSum = min(windowSum, values.subList(0, s).sum())
            p = s
            var current = windowSum
            for (i in 1 .. values.size - s) {
                current += values[s + i] - values[i - 1]
                if (current < windowSum) {
                    windowSum = current
                    p = i
                    q = s + 1
                }
            }
        }

        return Pair(p to q, windowSum)
    }

    val values = listOf(
        listOf(100, 200, 300, 400) to 2, // 700
        listOf(1, 4, 2, 10, 23, 3, 1, 0, 20) to 4, // 39
        listOf(1, 4, 2, 10, 2, 3, 1, 0, 20) to 4, // 24
        listOf(4, 2, 10, 230) to 4, // 246
        listOf(5, 2, -1, 0, 3) to 5, // 9
    )

    val max = values.map { (values, size) -> naiveMaxSum(values, size) }
    val min = values.map { (values, size) -> naiveMinSum(values, size) }
    println("$max, $min")
    val maxWindow = values.map { (values, size) -> windowSlidingMaxSum(values, size) }
    val minWindow = values.map { (values, size) -> windowSlidingMinSum(values, size) }

    println("$maxWindow, $minWindow")

}


fun main() {
    maxSumOfKConsecutivesValues()
}