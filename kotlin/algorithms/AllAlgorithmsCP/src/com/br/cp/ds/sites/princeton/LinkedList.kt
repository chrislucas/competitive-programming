package src.com.br.cp.ds.sites.princeton

/*
    https://www.cs.princeton.edu/courses/archive/spring15/cos226/lectures/13StacksAndQueues-2x2.pdf
 */

class CustomStackLinkedList<T> {
    class Node<T>(val data: T, var next: Node<T>? = null)

    var first: Node<T>? = null

    fun isEmpty() = first == null

    fun add(data: T) {
        val oldest = first
        first = Node(data)
        first?.next = oldest
    }
}

fun main() {

}