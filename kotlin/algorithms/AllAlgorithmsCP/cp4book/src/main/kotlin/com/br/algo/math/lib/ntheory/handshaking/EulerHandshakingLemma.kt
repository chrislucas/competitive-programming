package com.br.algo.math.lib.ntheory.handshaking

/**
 * https://pt.wikipedia.org/wiki/Lema_do_aperto_de_m%C3%A3o
 * https://en.wikipedia.org/wiki/Handshaking_lemma
 *
 * O Lema do "aperto de mão" (handshake lemma) criado para
 * teoria dos grafos afirma que tod0 grafo nao direcionado
 * finito tem com um numero de vertices par tem grau
 * impar (arestas ligados ao vertice)
 *
 * Num exemplo mundano, num grupo de pessoas com a quantidae
 * par se comprimentarem com um aperto de mão, um numero impar
 * de comprimentos ocorreu
 *
 * A soma dos graus de cada vertice no grafo é igual a 2x o numerdo de arestas
 * existentes
 */


/**
 * N pessoas numa festa
 * a N-esima pessoa comprimenta a (n-1) pessoas
 * a (N-1)-esima pessoa comprimentar (n-2) pessoas
 * até a (N-P) == 2 que comprimentar 1 pessoas
 *
 * https://nrich.maths.org/6708/solution
 * https://mathworld.wolfram.com/HandshakeProblem.html
 *
 */

private fun howManyHandshakes(people: Long) =
    if (people < 2) {
        0L
    } else {
        (people * (people - 1)) / 2
    }

fun main() {
    println(howManyHandshakes(20))
    println(howManyHandshakes(161))
    println(howManyHandshakes(200))
}