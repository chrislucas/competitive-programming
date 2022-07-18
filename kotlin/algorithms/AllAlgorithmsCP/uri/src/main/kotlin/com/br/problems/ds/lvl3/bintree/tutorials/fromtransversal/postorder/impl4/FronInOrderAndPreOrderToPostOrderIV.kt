package com.br.problems.ds.lvl3.bintree.tutorials.fromtransversal.postorder.impl4

/*
    https://www.tutorialspoint.com/print-postorder-traversal-from-given-inorder-and-preorder-traversals
    Implementacao 4
 */


class Transversal(val inOrder: Array<Int>, val preOrder: Array<Int>)


private fun getPostOrderTransversal(inOrder: Array<Int>, preOrder: Array<Int>): MutableList<Int> {

    operator fun <T> Array<T>.get(i: Int, j: Int) = this.copyOfRange(i, j)


    fun findIndexRoot(inOder: Array<Int>, rootValue: Int, n: Int): Int {
        for (i in 0 until n) {
            if (inOder[i] == rootValue) {
                return i
            }
        }
        return -1
    }

    fun build(inOrder: Array<Int>, preOrder: Array<Int>, transversal: MutableList<Int>, n: Int) {
        val idx = findIndexRoot(inOrder, preOrder[0], n)

        if (idx != 0) {
            build(inOrder, preOrder[1, n], transversal, idx)
        }

        if (idx != n - 1) {
            build(inOrder[idx + 1, n], preOrder[idx + 1, n], transversal, n - idx - 1)
        }

        transversal += preOrder[0]
    }

    val transversal = mutableListOf<Int>()
    build(inOrder, preOrder, transversal, inOrder.size)
    return transversal
}

val testCases = arrayOf(
    // {4, 5, 2, 6, 3, 1}
    Transversal(
        arrayOf(4, 2, 5, 1, 3, 6),
        arrayOf(1, 2, 4, 5, 3, 6)
    ),
    // 4 2 7 8 5 6 3 1
    Transversal(
        arrayOf(4, 2, 1, 7, 5, 8, 3, 6),
        arrayOf(1, 2, 4, 3, 5, 7, 8, 6)
    )
)


private fun checkGetPostOrderTransversal() {
    testCases.forEach { transversal ->
        getPostOrderTransversal(transversal.inOrder, transversal.preOrder)
    }
}


fun main() {
    checkGetPostOrderTransversal()
}