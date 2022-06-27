package src.com.br.cp.ds.trees.bintree.height

import java.lang.Integer.max

/**
 * https://www.baeldung.com/cs/binary-tree-height
 * */


class TreeNode<T : Comparable<T>>(val value: T, private var le: TreeNode<T>? = null, private var ri: TreeNode<T>? = null)  {

    fun insert(value: T) {
        fun insert(root: TreeNode<T>, value: T) {

        }

        insert(this, value)
    }

    fun transversal(order: String = "in") {

    }

    fun height() : Int {

        fun height(node: TreeNode<T>?): Int {
            return if (node == null) {
                0
            } else {
                val l = height(node.le)
                val r = height(node.ri)
                max(l, r) + 1
            }
        }

        return height(this)
    }
}

private fun checkHeight() {

}

fun main() {

}