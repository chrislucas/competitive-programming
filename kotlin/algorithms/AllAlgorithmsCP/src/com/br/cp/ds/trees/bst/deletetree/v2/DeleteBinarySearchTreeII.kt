package src.com.br.cp.ds.trees.bst.deletetree

/*
    https://www.techiedelight.com/deletion-from-bst/
 */

class Tree<T : Comparable<T>>(value: T) {

    data class Node<T : Comparable<T>>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null)

    private var root: Node<T>? = Node(value)

    private val <T : Comparable<T>> Node<T>.isLeaf: Boolean
        get() = this.le == null && this.ri == null

    fun deleteValue(value: T) : Tree<T>  {
        return this
    }
}

fun main() {

}