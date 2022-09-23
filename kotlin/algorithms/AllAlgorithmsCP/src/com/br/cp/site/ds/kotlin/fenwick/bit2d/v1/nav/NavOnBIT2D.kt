package src.com.br.cp.site.ds.kotlin.fenwick.bit2d.v1.nav

import src.com.br.cp.site.ds.kotlin.fenwick.bit2d.v1.get
import src.com.br.cp.site.ds.kotlin.fenwick.bit2d.v1.set


operator fun Array<Array<Int>>.set(x: Int, y: Int, value: Int) {
    this[x][y] = value
}

operator fun Array<Array<Int>>.get(x: Int, y: Int) = this[x][y]


private fun navParent(values: Array<Array<Int>>) {

    val bit = Array(values.size + 1) { Array(values[0].size + 1) { 0 } }

    fun update(i: Int, j: Int, value: Int) {
        val (m, n) = Pair(values.size, values[0].size)
        var ci = i
        println("Parent: ${Pair(i, j)}")
        while (ci <= m) {
            var cj = j
            val pairs = mutableListOf<Pair<Int, Int>>()
            while (cj <= n) {
                //bit[ci, cj] += value
                pairs += Pair(ci, cj)
                cj += cj and (-cj)
            }
            println(pairs)
            ci += ci and (-ci)
        }
        //values[i, j] = value
    }

    fun query(x1: Int, y1: Int, x2: Int, y2: Int): Int {

        fun query(i: Int, j: Int): Int {
            var acc = 0
            var ci = i
            var cj = j
            println("Parent: ${Pair(i, j)}")
            while (ci > 0) {
                cj = j
                val pairs = mutableListOf<Pair<Int, Int>>()
                while (cj > 0) {
                    acc += bit[ci, cj]
                    pairs += Pair(ci, cj)
                    cj -= cj and (-cj)
                }
                println(pairs)
                ci -= ci and (-ci)
            }
            return acc
        }

        val a = query(x2, y2)
        val b = query(x1- 1, y2)
        val c = query(x2, y1 - 1)
        val d = query(x1 - 1, y1 - 1)

        return a - b - c + d
    }

    println("******************************************** query *******************************************************")

    for (i in values.indices) {
        for (j in 0 until values[0].size) {
            update(i + 1, j + 1, values[i, j])
        }
    }

    println("******************************************** update *******************************************************")


    val k = bit.size - 1
    val l = bit[0].size - 1

    for (i in values.indices) {
        for (j in 0 until values[0].size) {
            query(i + 1, j + 1, k, l)
        }
    }

}


fun main() {
    arrayOf(
        arrayOf(
            arrayOf(1, 1, 2),
            arrayOf(3, 3, 4),
            arrayOf(5, 5, 6),
        ),

        arrayOf(
            arrayOf(1, 1, 2),
            arrayOf(3, 3, 4),
            arrayOf(5, 5, 6),
            arrayOf(7, 7, 8),
        ),

        arrayOf(
            arrayOf(1, 1, 2, 2),
            arrayOf(3, 3, 4, 4),
            arrayOf(5, 5, 6, 6),
            arrayOf(7, 7, 8, 8),
        )
    ).forEach { matrix ->
        navParent(matrix)
        println("***************************************************************************************************")
    }
}