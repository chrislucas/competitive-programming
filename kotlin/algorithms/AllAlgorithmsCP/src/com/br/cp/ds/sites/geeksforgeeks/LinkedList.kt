package src.com.br.cp.ds.sites.geeksforgeeks

/*
    https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/#algo2
 */


class CusomtLinkedList<T : Comparable<T>> : Iterator<T> {
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

class SortedLinkedList<T : Comparable<T>> : Iterator<T>, Iterable<T> {
    private var head: Node<T>? = null
    private var current: Node<T>? = null

    data class Node<T>(val data: T, var next: Node<T>? = null)

    fun insert(data: T): SortedLinkedList<T> {
        if (head == null) {
            head = Node(data)
        } else {
            var last = head
            while (last?.next != null) {
                last = last.next
            }
            last?.next = Node(data)
        }
        current = head
        return this
    }

    override fun iterator(): Iterator<T> = this

    override fun hasNext(): Boolean = current != null

    override fun next(): T {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val data = current?.data
        current = current?.next
        return data ?: throw NoSuchElementException()
    }

    fun sortedInsert(data: T): SortedLinkedList<T> {
        if (head != null) {
            if (head?.data!! > data) {
                val next = Node(data)
                next.next = head
                head = next
            } else {
                var last: Node<T>? = head
                while (last?.next != null && last.next?.data!! < data) {
                    last = last.next
                }
                val next = Node(data)
                next.next = last?.next
                last?.next = next
            }
        } else {
            head = Node(data)
        }
        current = head
        return this
    }
}

private fun checkInsertSortedLinkedList() {
    val sortedLinkedList = SortedLinkedList<Int>()
    (0..100).forEach {
        sortedLinkedList.insert(it)
    }

    val it = sortedLinkedList.iterator()
    //while (it.hasNext()) { println(it.next()) }
    it.forEach {
        println(it)
    }
}

private fun checkSortedInsertSortedLinkedList() {
    /*
    val sortedLinkedList = SortedLinkedList<Int>()

    sortedLinkedList.sortedInsert(10)
    sortedLinkedList.sortedInsert(5)
    sortedLinkedList.sortedInsert(1)

     sortedLinkedList.iterator().forEach { println(it) }

     */

    val s2 = SortedLinkedList<Int>()

    s2.sortedInsert(5)
    s2.sortedInsert(10)
    s2.sortedInsert(7)
    s2.sortedInsert(1)
    s2.sortedInsert(9)

    s2.iterator().forEach {
        println(it)
    }

}


fun main() {
    //checkCustomLinkedList()
    //checkInsertSortedLinkedList()
    checkSortedInsertSortedLinkedList()
}