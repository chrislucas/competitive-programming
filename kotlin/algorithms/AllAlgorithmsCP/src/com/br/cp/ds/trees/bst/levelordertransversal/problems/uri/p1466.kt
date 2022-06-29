package src.com.br.cp.ds.trees.bst.levelordertransversal.problems.uri

import java.lang.Integer.max
import java.util.*


/*
    https://www.beecrowd.com.br/judge/en/problems/view/1466
    DONE
 */

class BSTree<T : Comparable<T>>(value: T) {

    data class Node<T : Comparable<T>>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null)

    private var root: Node<T>? = Node(value)

    private val <T : Comparable<T>> Node<T>.isLeaf: Boolean
        get() = this.le == null && this.ri == null

    fun insert(value: T): BSTree<T> {
        fun insert(node: Node<T>?, value: T): Node<T> {
            return if (node != null) {
                if (node.value > value) {
                    node.le = insert(node.le, value)
                } else {
                    node.ri = insert(node.ri, value)
                }
                node
            } else {
                Node(value)
            }
        }
        root = insert(root, value)
        return this
    }

    private fun height(): Int {
        fun height(node: Node<T>?): Int {
            return if (node == null) {
                0
            } else {
                val l = height(node.le)
                val r = height(node.ri)
                max(l, r) + 1
            }
        }
        return height(root)
    }

    fun levelOrderTransversal(): List<T> {
        val rs = mutableListOf<T>()
        fun levelOrder(node: Node<T>?, buffer: MutableList<T>, level: Int) {
            if (node != null) {
                if (level == 1) {
                    buffer += node.value
                } else if (level > 1) {
                    levelOrder(node.le, buffer, level - 1)
                    levelOrder(node.ri, buffer, level - 1)
                }
            }
        }
        val h = height()
        for (i in 1..h) {
            levelOrder(root, rs, i)
        }
        return rs
    }

    fun itLevelOrderTransversal(): List<T> {
        val rs = mutableListOf<T>()
        val queue = LinkedList<Node<T>?>()
        queue += root
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            temp?.run {
                rs += value
                le?.let { queue += it }
                ri?.let { queue += it }
            }
        }
        return rs
    }
}

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


private fun solver() {

    fun <T : Comparable<T>> List<T>.toBST(): BSTree<T>? {
        return if (this.isNotEmpty()) {
            val tree = BSTree(this[0])
            for (i in 1 until this.size) {
                tree.insert(this[i])
            }
            tree
        } else {
            null
        }
    }

    var cases = 1
    testCases(readValue(String::toInt)) {
        val s = readValue(String::toInt)
        readValues(transform = String::toInt).toBST()?.let {
            val a = it.levelOrderTransversal().joinToString(" ")
            //val b = it.itLevelOrderTransversal().joinToString(" ")
            println("Case $cases:\n$a\n" )
        }
        cases += 1
    }
}

fun main(args: Array<String>) = solver()