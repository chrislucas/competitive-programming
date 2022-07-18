package com.br.problems.ds.lvl3.bintree.tutorials.fromtransversal.pretopost

/*
    https://www.tutorialspoint.com/find-postorder-traversal-of-bst-from-preorder-traversal-in-cplusplus
    pre order - 5, 2, 4, 7, 12
        - root - left - right

    post order - 4, 2, 12, 7,
        - left - right - root
 */

private val testCases = arrayOf(
    arrayOf(5, 2, 4, 7, 12), // {4, 2, 12, 7, 5}
    arrayOf(40,30,35,80,100),  // 35 30 100 80 40
    arrayOf(40,30, 32, 35, 80, 90, 100, 120) // 35 32 30 120 100 90 80 40
)


private fun fromPreOrderToPostOrder(preOrder: Array<Int>): MutableList<Int> {

    fun fromPreToPost(
        preOrder: Array<Int>, transversal: MutableList<Int>,
        n: Int, lower: Int, upper: Int, idx: Int
    ) {
        if (n == idx || preOrder[idx] < lower || preOrder[idx] > upper) {
            return
        }

        val currrent = preOrder[idx]

        fromPreToPost(preOrder, transversal, n, lower, currrent, idx + 1)
        fromPreToPost(preOrder, transversal, n, currrent, upper, idx + 1)

        transversal += currrent
    }

    val transversal = mutableListOf<Int>()
    fromPreToPost(preOrder, transversal, preOrder.size, Int.MIN_VALUE, Int.MAX_VALUE - 1, 0)
    return transversal
}

/*
      https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/
 */
private fun fromPreToPost() {

}

private fun checkFromPreOrderToPostOrder() {
    testCases.forEach {
        println(fromPreOrderToPostOrder(it))
    }
}

fun main() {
    checkFromPreOrderToPostOrder()
}