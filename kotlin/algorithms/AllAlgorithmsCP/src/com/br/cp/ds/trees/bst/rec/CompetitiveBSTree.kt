package src.com.br.cp.ds.trees.bst.rec

import java.util.*

class BSTree<T : Comparable<T>>(value: T) {

    data class Node<T>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null) {
        val isLeaf: Boolean
            get() = this.le == null && this.ri == null
    }

    private var root: Node<T>? = Node(value)

    fun insert(value: T): BSTree<T> {
        fun insert(node: Node<T>?, value: T): Node<T> {
            return if (node != null) {
                if (node.value > value) {
                    node.le = insert(node.le, value)
                } else {
                    node.ri = insert(node.ri, value)
                }
                node
            } else {
                Node(value)
            }
        }
        root = insert(root, value)
        return this
    }

    fun iterativeInsert(value: T) {
        if (root == null) {
            root = Node(value)
        } else {
            var parent: Node<T>? = null
            var temp = root
            while (temp != null) {
                parent = temp
                temp = if (parent.value > value) {
                    temp.le
                } else {
                    temp.ri
                }
            }
            parent?.run {
                if (this.value > value) {
                    this.le = Node(value)
                } else {
                    this.ri = Node(value)
                }
            }
        }
    }

    fun height(): Int {
        fun height(node: Node<T>?): Int {
            return if (node == null) {
                0
            } else {
                val l = height(node.le)
                val r = height(node.ri)
                Integer.max(l, r) + 1
            }
        }
        return height(root)
    }

    fun levelOrderTransversal(): List<T> {
        val rs = mutableListOf<T>()
        fun levelOrder(node: Node<T>?, buffer: MutableList<T>, level: Int) {
            if (node != null) {
                if (level == 1) {
                    buffer += node.value
                } else if (level > 1) {
                    levelOrder(node.le, buffer, level - 1)
                    levelOrder(node.ri, buffer, level - 1)
                }
            }
        }

        val h = height()
        for (i in 1..h) {
            levelOrder(root, rs, i)
        }
        return rs
    }

    fun iterativeLevelOrderTransversal(): List<T> {
        val rs = mutableListOf<T>()
        val queue = LinkedList<Node<T>?>()
        queue += root
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            temp?.run {
                rs += value
                le?.let { queue += it }
                ri?.let { queue += it }
            }
        }
        return rs
    }
}


fun main() {

}