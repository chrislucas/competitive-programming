package src.com.br.cp.ds.trees.bst.iterative

import java.lang.StringBuilder
import java.util.*


// https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
data class Node<T : Comparable<T>>(val value: T, var left: Node<T>? = null, var right: Node<T>? = null)

val <T : Comparable<T>> Node<T>.isLeaf: Boolean
    get() = this.left == null && this.right == null

class Tree<T : Comparable<T>> {

    var root: Node<T>? = null

    fun insert(data: T) {
        val node = Node(data)
        if (root == null) {
            root = node
        } else {
            var copy = root
            var parent: Node<T> = Node(data)
            while (copy != null) {
                parent = copy
                if (copy.value < data) {
                    copy = copy.right
                } else if (copy.value > data) {
                    copy = copy.left
                }
            }
            if (parent.value < data) {
                parent.right = Node(data)
            } else {
                parent.left = Node(data)
            }
        }
    }

    fun inOrder(): String {
        val stack = Stack<Node<T>>()
        var leaf: Node<T>? = root
        val buffer = StringBuilder()
        while (leaf != null || !stack.isEmpty()) {
            if (leaf != null) {
                stack.add(leaf)
                leaf = leaf.left
            } else {
                leaf = stack.pop()
                if (buffer.isEmpty()) {
                    buffer.append("${leaf.value}")
                } else {
                    buffer.append(", ${leaf.value}")
                }
                leaf = leaf.right
            }
        }
        return buffer.toString()
    }

    fun preOrder(): String {
        val stack = Stack<Node<T>>()
        var leaf: Node<T>? = root
        val buffer = StringBuilder()
        while (leaf != null || !stack.isEmpty()) {
            if (leaf != null) {
                if (buffer.isEmpty()) {
                    buffer.append("${leaf.value}")
                } else {
                    buffer.append(", ${leaf.value}")
                }
                stack.add(leaf)
                leaf = leaf.left
            } else {
                leaf = stack.pop()
                leaf = leaf.right
            }
        }
        return buffer.toString()
    }

    /*
        TODO revisar esse metodo
     */
    fun posOrder(): String {
        val stack = Stack<Node<T>>()
        var leaf: Node<T>? = root
        val buffer = StringBuilder()
        while (leaf != null || !stack.isEmpty()) {
            if (leaf != null) {
                stack.add(leaf)
                leaf = leaf.left
            } else {
                leaf = stack.pop()
                if (leaf.isLeaf) {
                    if (buffer.isEmpty()) {
                        buffer.append("${leaf.value}")
                    } else {
                        buffer.append(", ${leaf.value}")
                    }
                }
                leaf = leaf.right
            }
        }
        return buffer.toString()
    }
}


private fun <T : Comparable<T>> Array<T>.toBinarySearchTree(): Tree<T> =
    this.run {
        val tree = Tree<T>()
        forEach { tree.insert(it) }
        tree
    }


private val data = arrayOf(
    arrayOf(100, 20, 500, 10, 30, 40),
    arrayOf(50, 30, 20, 40, 70, 60, 80),
    arrayOf(8, 3, 10, 1, 6, 4, 7, 14, 13),
    arrayOf(30, 50, 15, 20, 10, 40, 60),
    arrayOf(1, 2, 3, 4, 5),
    arrayOf(25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90),
)

private fun <T : Comparable<T>> checkInsert(tree: Tree<T>) {
    println(tree)
}

private fun checkInsertAndNavigation() {
    data.forEach {
        val tree = it.toBinarySearchTree()
        val a = tree.inOrder()
        val b = tree.preOrder()
        val c = tree.posOrder()
        println("In: $a\nPre: $b\nPos: $c")
        println("******************************************************************")
    }
}


fun main() {
    checkInsertAndNavigation()
}