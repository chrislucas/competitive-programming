package com.br.algo.ds.list

/**
 * https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
 * https://www.geeksforgeeks.org/floyds-cycle-finding-algorithm/
 *
 * */

data class Node<T>(val value: T, var next: Node<T>? = null)


class SimpleLinkedList<T> {
    var head: Node<T>? = null

    fun insert(value: T) {
        if (head == null) {
            head = Node(value)
        } else {
            var temp = head
            while (temp != null) {
                if (temp.next == null) {
                    temp.next = Node(value)
                }
                temp = temp.next
            }
        }
    }

    fun aInsert(value: T) {
        if (head == null) {
            head = Node(value)
        } else {
            var temp = Node(value)
            if (head == null) {
                head = temp
            } else {
                temp.next = head
                head = temp
            }
        }
    }

    fun hasNext(node: Node<T>?): Boolean = node != null

    fun next(node: Node<T>?): Node<T>? = if (hasNext(node)) {
        node?.next
    } else {
        null
    }

    fun hasCycle(): Boolean {
        var slow = head
        var fast = head
        while (slow != null && fast != null && fast.next != null) {
            slow = next(head)
            fast = next(next(head))
            if (slow == fast)
                return true
        }
        return false
    }

    fun hasCycle2() {

    }
}


fun checkCycleI() {

    fun <T> check(linkedList: SimpleLinkedList<T>) {
        var temp = linkedList.head
        // adicionando um ciclo, o ultimo elemento aponta para o primeiro
        while (temp?.next != null)
            temp = temp.next
        // ultimo -> primeiro
        temp?.next = linkedList.head

        println(String.format("%s",if (linkedList.hasCycle()) "S" else "N" ))
    }

    fun checkOne() {
        val linkedList = SimpleLinkedList<Int>()
        linkedList.insert(10)
        linkedList.insert(20)
        linkedList.insert(30)
        linkedList.insert(40)
        linkedList.insert(50)
        check(linkedList)
    }

    fun checkTwo() {
        val linkedList = SimpleLinkedList<Int>()
        linkedList.aInsert(10)
        linkedList.aInsert(20)
        linkedList.aInsert(30)
        linkedList.aInsert(40)
        linkedList.aInsert(50)
        check(linkedList)
    }

    checkTwo()
}


fun main() {
    checkCycleI()
}