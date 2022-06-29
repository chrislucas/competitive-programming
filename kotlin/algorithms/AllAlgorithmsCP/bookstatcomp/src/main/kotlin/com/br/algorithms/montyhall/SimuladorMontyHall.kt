package com.br.algorithms.montyhall

import kotlin.random.Random

/*
*
*  TODO criar uma funcao que simule varios jogos com o jogador trocando de porta para
*   verificar se é possível chegar no resultado de 2/3 de acertos
* */


private fun randomValue(a: Int, b: Int) = Random.nextInt(a, b)

private fun checkChooseAndChange() {
    // SIMULAR a escolha da porta de forma randomica
    val a: Int = randomValue(1, 3)
    //  escolher a porta ganhadora de forma randomica
    val b: Int = randomValue(1, 3)
    // TODO rever esse algoritmo
    val c = if (a == b) {
        if (a < 3) {
            a + 1
        } else {
            a - 1
        }
    } else if (a < b) {
        b
    } else {
        a
    }
}

/*
    TODO simular varias jogos de monty hall cujo o jogador nao troca sua escolha
 */