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

    fun insert(value: T) {
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



}

fun main() {

}