package src.com.br.cp.ds.trees.bst.height

import kotlin.math.max

/*
     https://www.geeksforgeeks.org/calculate-height-of-binary-tree-using-inorder-and-level-order-traversal/?ref=rp

     Dado 2 arrays o primero representando uma travessia inorder e o segundo sabendo a level order transversal
     de uma BTree, calcule a altera da arvore sem contruila
 */

class Tree<T : Comparable<T>> {

    data class Node<T : Comparable<T>>(
        var value: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null
    ) {
        val isLeaf: Boolean
            get() = this.left == null && this.right == null
    }

    private var root: Node<T>? = null

    fun insert(data: T) {
        fun insert(node: Node<T>?, data: T): Node<T> {
            return if (node == null) {
                Node(data)
            } else if (node.value > data) {
                val newNode = insert(node.left, data)
                node.left = newNode
                node
            } else {
                val newNode = insert(node.right, data)
                node.right = newNode
                node
            }
        }

        if (root == null) {
            root = Node(data)
        } else {
            root?.let { node ->
                root = if (node.value > data) {
                    insert(node, data)
                } else {
                    insert(node, data)
                }
            }
        }
    }

    fun height(): Int {
        fun height(node: Node<T>?): Int {
            return if (node == null) {
                0
            } else {
                val le = height(node.left)
                val ri = height(node.right)
                max(le, ri) + 1
            }
        }
        return height(root)
    }
}

private fun <T : Comparable<T>> Array<T>.toBST(): Tree<T> =
    this.run {
        val tree = Tree<T>()
        forEach { tree.insert(it) }
        tree
    }


private fun checkGetHeight() {
    val data = arrayOf(
        arrayOf(50, 30, 70, 20, 40, 60, 80),
        arrayOf(50, 30, 70, 20, 40, 60, 80, 10, 25),
        arrayOf(50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 41),
        arrayOf(100, 20, 500, 10, 30, 40),
        arrayOf(50, 30, 20, 40, 70, 60, 80),
        arrayOf(8, 3, 10, 1, 6, 4, 7, 14, 13),
        arrayOf(30, 50, 15, 20, 10, 40, 60),
        arrayOf(1, 2, 3, 4, 5),
        arrayOf(25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90),
    )
    data.forEach {
        println(it.toBST().height())
    }
}

private val testCases = listOf(
    listOf(
        listOf(4, 8, 10, 12, 14, 20, 22),
        listOf(20, 8, 22, 4, 12, 10, 14)
    ),  // case 1

    listOf(
        listOf(4, 8, 10, 12, 14),
        listOf(8, 4, 12, 10, 14)
    ),
    listOf(
        listOf(22),
        listOf(22)
    )
)

fun main() {
    checkGetHeight()
}