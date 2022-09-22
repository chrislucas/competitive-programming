package src.com.br.cp.site.ds.kotlin.fenwick.bit2d.v1

import java.lang.StringBuilder

/*
    https://iq.opengenus.org/2d-fenwick-tree/
    https://robert1003.github.io/2020/01/27/fenwick-tree.html
    https://acervolima.com/arvore-indexada-binaria-bidimensional-ou-arvore-de-fenwick-1/
 */

typealias PII = Pair<Int, Int>

operator fun Array<Array<Int>>.set(x: Int, y: Int, value: Int) {
    this[x][y] = value
}

operator fun Array<Array<Int>>.get(x: Int, y: Int) = this[x][y]

val <T> Array<Array<T>>.string: String
    get() {
        val sb = StringBuilder()
        sb.append("[")
        for (i in 0 until this.size) {
            sb.append(if (i > 0) "\n[" else "[")
            for (j in 0 until this[i].size) {
                sb.append(if (j == 0) "${this[i][j]}" else ", ${this[i][j]}")
            }
            sb.append(if (i < this.size - 1) "]," else "]")
        }
        sb.append("]")
        return sb.toString()
    }


private class BIT2D(private val values: Array<Array<Int>>) {
    private val dim = Pair(values.size, values[0].size)

    private val bit = Array(dim.first + 1) { Array(dim.second + 1) { 0 } }

    init {
        for (i in 0 until dim.first) {
            for(j in 0 until dim.second) {
                update(PII(i + 1, j + 1), values[i][j])
            }
        }
    }

    fun showValues() = println(values.string)

    fun showTree() = println(bit.string)

    fun update(p: PII, value: Int) {
        var i = p.first
        val j = p.second
        val (m, n) = dim
        while (i <= m) {
            var cj = j
            while (cj <= n) {
                bit[i, cj] += value
                cj = descendent(cj)
            }
            i = descendent(i)
        }
        values[i, j] = value
    }

    fun query(p: PII, q: PII): Int {

        fun query(p: Int, q : Int): Int {
            var acc = 0
            var i = p
            val j = p
            while (i > 0) {
                var cj = j
                while (cj > 0) {
                    acc += bit[i][cj]
                    cj = parent(cj)
                }
                i = parent(i)
            }
            return acc
        }

        val a = query(q.first, q.second)
        val b = query(p.first - 1, q.second)
        val c = query(q.first, p.second - 1)
        val d = query(p.first - 1, p.second - 1)

        return a - b - c + d
    }

    private fun parent(value: Int) = value - (value and (-value))

    private fun descendent(value: Int) = value + (value and (-value))
}


private class TestCase (private val bit2D: BIT2D, private val operations: List<Operation>) {

    sealed class Operation
    class Query(val query: Pair<PII, PII>): Operation()
    data class Update(val pair: PII, val value: Int): Operation()

    fun run() {
        for (operation in operations) {
            when (operation) {
                is Query -> {
                    with(bit2D) {
                        showValues()
                    }
                    val (p, q) = operation.query
                    println(bit2D.query(p, q))
                }

                is Update -> {
                    val (pair, value) = operation
                    bit2D.update(pair, value)
                }

                else -> {

                }
            }
            with(bit2D) {
                showTree()
            }
        }
    }
}


private fun checkOneCase() {
    val matrix = arrayOf(
        arrayOf(1, 1, 2, 2),
        arrayOf(3, 3, 4, 4),
        arrayOf(5, 5, 6, 6),
        arrayOf(7, 7, 8, 8),
    )


    val testCase = TestCase(
        BIT2D(matrix),
        listOf(TestCase.Query(Pair(PII(2, 2), PII(4, 4))))
    )


    testCase.run()
}

fun main() {
    checkOneCase()
}