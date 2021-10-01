package com.br.cp.ds.trees.bst

import java.lang.StringBuilder

data class Node<T : Comparable<T>>(val value: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}

class Tree<T : Comparable<T>> {
    var root: Node<T>? = null

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

    operator fun get(data: T): Node<T>? {
        fun get(node: Node<T>?, data: T): Node<T>? {
            return if (node == null) {
                node
            } else if (node.value < data) {
                get(node.right, data)
            } else if (node.value > data) {
                get(node.left, data)
            } else {
                node
            }
        }
        return get(root, data)
    }

    fun hasItem(data: T): Boolean {
        fun hasItem(node: Node<T>?, data: T): Boolean {
            return if (node == null) {
                false
            } else if (node.value < data) {
                hasItem(node.right, data)
            } else if (node.value > data) {
                hasItem(node.left, data)
            } else {
                true
            }
        }
        return hasItem(root, data)
    }

    fun delete(data: T): Boolean {
        fun delete(node: Node<T>?, data: T): Boolean {
            return if (node == null) {
                false
            } else if (node.value < data) {
                delete(node.right, data)
            } else if (node.value > data) {
                delete(node.left, data)
            } else {
                var copy = node
                copy = null
                true
            }
        }
        return delete(root, data)
    }

    fun inOrder(): String {
        fun inOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                inOrder(node.left, buffer)
                buffer.append(node.value)
                inOrder(node.right, buffer)
            }
        }
        return ""
    }

    fun preOrder(): String {
        val buffer = StringBuilder()
        fun preOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                buffer.append(node.value)
                preOrder(node.left, buffer)
                preOrder(node.right, buffer)
            }
        }
        preOrder(root, buffer)
        return buffer.toString()
    }

    fun posOrder(): String {
        val buffer = StringBuilder()
        fun posOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                posOrder(node.left, buffer)
                posOrder(node.right, buffer)
                buffer.append(node.value)
            }
        }
        posOrder(root, buffer)
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
)


private fun checkTransversal() {
    data.forEach { data ->
        val tree = data.toBinarySearchTree()
        println(tree.inOrder())
        println(tree.preOrder())
        println(tree.posOrder())
    }
}

private fun checkOperatorGet() {
    data.forEach {
        val tree = it.toBinarySearchTree()
        println(tree[40])
    }
}

fun main() {
    checkOperatorGet()
}