package src.com.br.cp.ds.sites.geeksforgeeks

/*
    https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/#algo2
 */


class CusomtLinkedList<T> : Iterator<T> {
    private var head: Node<T>? = null
    private var current: Node<T>? = null

    data class Node<T>(val data: T, var next: Node<T>? = null)

    fun insert(data: T): CusomtLinkedList<T> {
        if (head == null) {
            head = Node(data)
        } else {
            var last = head
            while (last != null) {
                if (last.next == null) {
                    last.next = Node(data)
                    break
                }
                last = last.next
            }
        }
        current = head
        return this
    }

    override fun hasNext(): Boolean = current != null

    override fun next(): T {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val data = current?.data
        current = current?.next
        return data ?: throw NoSuchElementException()
    }
}

private fun checkCustomLinkedList() {
    val list = CusomtLinkedList<Int>()
    list.insert(1).insert(2).insert(3)

   while (list.hasNext()) {
       println(list.next())
   }
}

class SortedLinkedList<T : Comparable<T>> {
    private var head: Node<T>? = null

    class Node<T>(val data: T, var next: Node<T>? = null)

    fun insert(): SortedLinkedList<T> {
        return this
    }
}


fun main() {
    checkCustomLinkedList()
}