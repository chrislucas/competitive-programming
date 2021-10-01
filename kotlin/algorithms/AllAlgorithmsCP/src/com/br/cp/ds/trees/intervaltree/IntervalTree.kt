package com.br.cp.ds.trees.intervaltree

import kotlin.math.max

/**
 * https://en.wikipedia.org/wiki/Interval_tree
 *
 * Output-sensitive algorithm
 * https://en.wikipedia.org/wiki/Output-sensitive_algorithm
 *
 * Eh o tipo de algoritmo cujo tempo de execucao depende do tamano da SAIDA que ele dara, ao inves de ter relacao
 * com o tamanho da entrada que ele recebe
 *
 * Na wiki, o exemplo dado eh um algoritmo de divisao que devolve um QUOCIENTE e um RESTO. Esse algoritmo
 * e implementado com subtracoes sucessivas e somas sucessivas para computar respectivamente o RESTO e o QUOCIENTE
 * de uma divisao por 2 numeros
 *
 * uma variacao de Convex Hull, ultimate Convex Hull
 *
 * https://www.geeksforgeeks.org/interval-tree/
 *  - Definicao do problema
 *  - Imagine que temos um conjunto de intervalos  M .. N e precisamos executar as seguintes operacoes
 *      1) Adicionar um intervalor
 *      2) Remover um intervalor
 *      3) Dado um intervalor X, encontrar se X sobrepoe qualquer outro intervalor
 *
 *
 *  - O algoritmo proposto tem o objetivo de melhorar uma BST auto-balanceada (AVL, Red Black Tree)
 *      - Manter o conjunto de intervalor tal que totas as operacoes possam ser feitas em O (log n)
 *
 * */

/**
 * Os nos sao formados por
 * 1) um intervalor M..N
 * 2) o maior valor encontrado numa subarvore
 *
 * O menor valor do intervalo M..N e utilizado como key no nó da arvore para manter
 * a ordem da BST
 *
 *
 * A forma de insercao e remocao seguem a mesma idea de uma self-balancing BST
 *
 * */

class Node(val interval: IntRange, val highestValue: Int) {
    var left: Node? = null
    var right: Node? = null
}


class Tree {

    private var root: Node? = null

    fun insert(interval: IntRange) {
        if (root == null) {
            root = Node(interval, max(interval.first, interval.last))
        } else {
            root?.let { node ->
                if (interval.first < node.interval.first) {
                    node.left = insert(node.left, interval)
                } else {
                    node.right = insert(node.right, interval)
                }
            }
        }
    }

    private fun insert(node: Node?, interval: IntRange): Node {
        return if (node == null) {
            Node(interval, max(interval.first, interval.last))
        } else {
            if (interval.first < node.interval.first) {
                insert(node.left, interval)
            } else {
                insert(node.right, interval)
            }
        }
    }
}


fun main() {
    println(0xff)

}