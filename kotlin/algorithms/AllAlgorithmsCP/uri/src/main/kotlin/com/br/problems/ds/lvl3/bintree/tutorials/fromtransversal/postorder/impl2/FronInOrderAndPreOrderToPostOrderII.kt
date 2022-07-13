package com.br.problems.ds.lvl3.bintree.tutorials.fromtransversal.postorder.impl2

/*
    https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
    Implementacao 2
 */


class Transversal(val inOrder: Array<Int>, val preOrder: Array<Int>)

private val testCases = arrayOf(
    // Postorder traversal is {4, 5, 2, 6, 3, 1}
    Transversal(arrayOf(4, 2, 5, 1, 3, 6), arrayOf(1, 2, 4, 5, 3, 6)),
    // Postorder traversal is 4 2 7 8 5 6 3 1
    Transversal(
        arrayOf(4, 2, 1, 7, 5, 8, 3, 6), arrayOf(1, 2, 4, 3, 5, 7, 8, 6)
    )
)

/*
    TODO concertar esse algoritmo
 */
private fun buildPostOrder(inOrder: Array<Int>, preOrder: Array<Int>): MutableList<Int> {

    fun findIndexRoot(inOrder: Array<Int>, root: Int, s: Int, e: Int): Int {
        for (i in s until e) {
            if (inOrder[i] == root) {
                return i
            }
        }
        return -1
    }

    fun build(
        inOrder: Array<Int>,
        preOrder: Array<Int>,
        transversal: MutableList<Int>,
        s: Int,
        e: Int,
        preOrderIdx: Int
    ) {
        if (s > e) {
            return
        }

        val idx = findIndexRoot(inOrder, preOrder[preOrderIdx], s, e)
        build(inOrder, preOrder, transversal, s, idx - 1, preOrderIdx + 1)
        build(inOrder, preOrder, transversal, idx + 1, e, preOrderIdx + 1)

        transversal += inOrder[idx]
    }

    val transversal = mutableListOf<Int>()
    build(inOrder, preOrder, transversal, 0, inOrder.size - 1, 0)
    return transversal
}

private fun checkBuildPostOrder() {
    testCases.forEach {
        println(buildPostOrder(it.inOrder, it.preOrder))
    }
}

fun main() {
    checkBuildPostOrder()
}