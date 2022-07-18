package com.br.problems.ds.lvl3.bintree

import java.util.*

/*
    https://www.beecrowd.com.br/judge/en/problems/view/1194
 */

class BSTree<T : Comparable<T>>(value: T) {

    data class Node<T>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null) {
        val isLeaf: Boolean
            get() = this.le == null && this.ri == null
    }

    private var root: Node<T>? = Node(value)

    private fun leaf(node: Node<T>, value: T) : Node<T> {
        var temp: Node<T>? = node
        var parent: Node<T> = node
        while (temp != null) {
            parent = temp
            temp = if (parent.value > value) {
                temp.le
            } else {
                temp.ri
            }
        }
        return parent
    }

    fun insert(value: T) {
        if (root != null)  {
            val leaf = leaf(root!!, value)
            if (leaf.value > value) {
                leaf.le = Node(value)
            } else {
                leaf.ri = Node(value)
            }
        }
        else  {
            root = Node(value)
        }
    }
}

fun main() {

}