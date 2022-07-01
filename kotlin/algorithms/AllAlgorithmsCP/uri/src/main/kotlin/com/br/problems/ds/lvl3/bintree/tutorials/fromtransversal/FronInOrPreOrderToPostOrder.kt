package com.br.problems.ds.lvl3.bintree.tutorials.fromtransversal

/*
    https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
    https://www.techiedelight.com/pt/find-postorder-traversal-binary-tree-from-inorder-preorder-sequence/
 */


class Transversal<T : Comparable<T>>(val inOrder: Array<T>, val preOrder: Array<T>)

private val testCases = arrayOf(
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

    /*

     */
    fun <T> findIndexRoot(nodeValues: Array<T>, rootValue: T, lim: Int): Int {
        for (i in 0 until lim) {
            if (nodeValues[i] == rootValue)
                return i
        }
        return -1
    }

    fun postOrder(inOrder: Array<T>, preOrder: Array<T>, buffer: MutableList<T>, lim: Int) {
        /*
            Primeiro elemento no array preOrder é o elemento raiz da arvore
         */
        val index = findIndexRoot(inOrder, preOrder[0], lim)

        /*
            Se ao olharmos o array inOrder e o elemento rauz estiver no indice 0 quer
            dizer o lado esquerdo da arvore está vazio
         */
        if (index != 0) {
            postOrder(inOrder, preOrder.copyOfRange(1, lim), buffer, index)
        }

        /*

         */
        if (index != lim - 1) {
            postOrder(
                inOrder.copyOfRange(index + 1, lim),
                preOrder.copyOfRange(index + 1, lim),
                buffer,
                lim - index - 1
            )
        }

        buffer += preOrder[0]
    }

    val rs = mutableListOf<T>()
    postOrder(inOrder, preOrder, rs, inOrder.size)
    return rs
}

private fun solver() {

    testCases.forEach { transversal ->
        val s = findPostOrder(transversal.inOrder, transversal.preOrder)
        println(s)
    }
}