package com.br.problems.ds.lvl3.bintree.tutorials.fromtransversal.postorder.impl3

/*
    https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
    Implementacao 3
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


private fun buildPostOrder(inOrder: Array<Int>, preOrder: Array<Int>): MutableList<Int> {

    fun findIndexRoot(inOrder: Array<Int>, root: Int, s: Int, e: Int): Int {
        for (i in s until e) {
            if (inOrder[i] == root) return i
        }
        return -1
    }


    fun utils(
        inOrder: Array<Int>,
        preOrder: Array<Int>,
        transversal: MutableList<Int>,
        cache: HashMap<Int, Int>,
        s: Int,
        e: Int,
        preOrderIdx: Int
    ) {

    }

    fun build(inOrder: Array<Int>, preOrder: Array<Int>, transversal: MutableList<Int>) {
        val n = inOrder.size
        val map = hashMapOf<Int, Int>()
        for (i in 0 until n) {
            map[inOrder[i]] = i
        }
        utils(inOrder, preOrder, transversal, map, 0, n-1, 0)
    }

    val transversal = mutableListOf<Int>()
    build(inOrder, preOrder, transversal)
    return transversal
}