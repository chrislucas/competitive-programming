package com.br.problems.ds.lvl3.bintree.tutorials.fromtransversal.postorder.impl1

/*
    https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
    Implementacao 1
 */


class Transversal<T : Comparable<T>>(val inOrder: Array<T>, val preOrder: Array<T>)

private val testCases = arrayOf(
    // Postorder traversal is {4, 5, 2, 6, 3, 1}
    Transversal(arrayOf(4, 2, 5, 1, 3, 6), arrayOf(1, 2, 4, 5, 3, 6)),
    // Postorder traversal is 4 2 7 8 5 6 3 1
    Transversal(
        arrayOf(4, 2, 1, 7, 5, 8, 3, 6), arrayOf(1, 2, 4, 3, 5, 7, 8, 6)
    )
)

/*
     1 - Sabemos que o primeiro elemento do array pre-order é a raiz da arvore
     2 - sabemos que na travessia pos-order a raiz eh visitada por ulitmo

     3 - No Array InOrder, todos so elementos antes do elemento que representa a rauz da arvore sao
     elementos que vai na subarvore a euqerda, os depois da raiz sao elementos que vao na subarvore a direta

     4 - No Array PreOrder
        - Seja i o indice do valor que representa a raiz no Array InOder
        - Todos os elementos depois desse indice No Array PreOrder sao elementos que estao
        na sub arvore a direita da raiz
 */

fun <T : Comparable<T>> findPostOrder(inOrder: Array<T>, preOrder: Array<T>): List<T> {

    operator fun Array<T>.get(i: Int, j: Int) = this.copyOfRange(i, j)

    fun postOrder(inOrder: Array<T>, preOrder: Array<T>, buffer: MutableList<T>, n: Int) {
        /*
             PreOrder
             - Primeiro elemento no array PreOrder é o elemento raiz da arvore
             - Seja idx o indice do elemento root no InOrder, todos os elemento após  idx
             no array PreOrder sao elementos da subarvore a direita e os elementos antes de idx
             inclusive o elemento em idx sao elementos na subarvore a esquerda


            InOrder
             - Procuramos o indice do elemento root no array InOrder
             - Elementos antes do elemento raiz no array inOrder estao na sub-arvore a esquerda e elementos
                do lado direito estao na sub-arvore a direita

              nodeValues = array com os elementos na ordem de uma travesia em in-order numa BTree
              rootValue = elemento na raiz da BTree. Ele eh retirado do array que pre-order
              lim - tamanho do array que eh igual a quantidade de nós da arvore
         */
        fun <T> findIndexRoot(inOrder: Array<T>, rootValue: T, n: Int): Int {
            for (i in 0 until n) {
                if (inOrder[i] == rootValue)
                    return i
            }
            return -1
        }

        val index = findIndexRoot(inOrder, preOrder[0], n)

        /*
            Se ao olharmos o array inOrder e o elemento raiz estiver no indice 0 quer
            dizer o lado esquerdo da arvore está vazio.
            LEMBRAR QUE A TRAVESSIA IN-ORDER PASSA PRIMEIRO PELA SUBARVORE A ESQUERDA
            DEPOIS A DIREITA E POR FIM A SUBRAIZ ATE PASSAR PELA ARVORE INTEIRA
         */
        if (index != 0) {
            val s = preOrder[1, n]
            postOrder(inOrder, s, buffer, index)
        }

        /*
            Se indice == 0 e n - 1 == 0 entao nao existe subarvore a direita tbm e estamos num nó folha
         */
        if (index != n - 1) {
            val l = inOrder[index + 1, n]
            val r = preOrder[index + 1, n]
            postOrder(l, r, buffer, n - index - 1)
        }

        buffer += preOrder[0]
    }

    val rs = mutableListOf<T>()
    postOrder(inOrder, preOrder, rs, inOrder.size)
    return rs
}

private fun solver() {
    testCases.forEach { transversal ->
        println(findPostOrder(transversal.inOrder, transversal.preOrder))
    }
}


fun main() {
    solver()
}