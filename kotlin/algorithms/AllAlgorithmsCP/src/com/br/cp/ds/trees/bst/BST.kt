package src.com.br.cp.ds.trees.bst

import kotlin.text.StringBuilder

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

    // primeiro as folhas a esquerda, depois as raiz/subraiz por ultimo as folhas a direita
    // a navegacao tras os items em ordem crescente
    fun inOrder(): String {
        val buffer = StringBuilder()
        fun inOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                inOrder(node.left, buffer)
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
                inOrder(node.right, buffer)
            }
        }
        inOrder(root, buffer)
        return buffer.toString()
    }

    // a ideia e ter um resultado invertido da navegacao inorder
    // que essa navegacao traga os elementos na ordem decrescente
    fun reverserInOrder(): String {
        val buffer = StringBuilder()
        fun transversal(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                transversal(node.right, buffer)
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
                transversal(node.left, buffer)
            }
        }
        transversal(root, buffer)
        return buffer.toString()
    }

    // primeiro a raiz/subraiz, depois as fiolhas a esquerda e por ultimo as folhas da direita
    fun preOrder(): String {
        val buffer = StringBuilder()
        fun preOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
                preOrder(node.left, buffer)
                preOrder(node.right, buffer)
            }
        }
        preOrder(root, buffer)
        return buffer.toString()
    }

    // primerio as folhas depois a esquerda/direita e por ultimo a raiz/subraiz
    fun posOrder(): String {
        val buffer = StringBuilder()
        fun posOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                posOrder(node.left, buffer)
                posOrder(node.right, buffer)
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
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


fun String.splitAndJoinTo(del: String = "", appendable: Appendable = StringBuilder(), separator: String = "|"): String {
    return this.split(del).joinTo(appendable, separator).toString()
}

private fun checkTransversal() {
    data.forEach { data ->
        val tree = data.toBinarySearchTree()
        println(tree.inOrder())
        println(tree.preOrder())
        println(tree.posOrder())
    }
}

private fun <T : Comparable<T>> checkTransversal(tree: Tree<T>) {
    println(tree.inOrder())
    println(tree.reverserInOrder())
    println(tree.preOrder())
    println(tree.posOrder())
}

private fun checkOperatorGet() {
    data.forEach {
        val tree = it.toBinarySearchTree()
        println(tree[40])
    }
}

private fun checkIfHasItem() {
    data[0].let {
        val tree = it.toBinarySearchTree()
        println(tree.hasItem(40))
    }
}

fun main() {
    //checkIfHasItem()
    checkTransversal(data[1].toBinarySearchTree())
}