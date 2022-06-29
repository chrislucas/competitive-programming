package src.com.br.cp.ds.trees.bintree

/*
    https://www.geeksforgeeks.org/binary-tree-set-2-properties/
    Propriedades de uma bin tree
 */

class KBTree<T : Comparable<T>>(value: T) {

    data class Node<T : Comparable<T>>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null)

    private var root: Node<T>? = Node(value)

    private val <T : Comparable<T>> Node<T>.isLeaf: Boolean
        get() = this.le == null && this.ri == null
}