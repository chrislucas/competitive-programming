package src.com.br.cp.ds.stack

import java.util.Stack

class StackAsQueue<T> {
    private val stackA = Stack<T>()
    private val stackB = Stack<T>()

    operator fun plusAssign(value: T) {
        if(stackA.isEmpty()) {
            stackB += value
        } else {
            stackA += value
        }
    }

    private fun pop(): T {
        return if(stackA.isEmpty() && stackB.isNotEmpty()) {
            while (stackB.isNotEmpty()) {
                stackA += stackB.pop()
            }
            stackA.pop()
        } else {
            val value  = stackA.pop()
            while (stackA.isNotEmpty()) {
                stackB += stackA.pop()
            }
            value
        }
    }


    fun popAll(): List<T> {
        val list = mutableListOf<T>()
        while (stackA.isNotEmpty() || stackB.isNotEmpty()) {
            list += pop()
        }
        return list
    }
}


private fun checkStackAsQueue() {
    val queue = StackAsQueue<Int>()
    queue += 1
    queue += 10
    queue += 5
    queue += 13
    queue += 12

    println(queue.popAll())
}


fun main() {
    checkStackAsQueue()
}