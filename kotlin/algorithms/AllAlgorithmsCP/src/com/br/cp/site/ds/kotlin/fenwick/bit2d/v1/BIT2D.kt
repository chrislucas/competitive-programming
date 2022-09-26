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

/*
        Exemplo de uma matriz 2x2 transformada numa binary indexed tree
            ____
            -
            1 2
        ||1 1 2
        | 2 3 4
            ___
            -
            1 2
       || 1 1 3
       |  2 4 10

       -------------------------------------------------------------------------------------------
          __________
          ___
          _   _
          1 2 3 4
     ||1  1 2 3 4
     | 2  5 6 7 8
      |3  9 10 11 12


          ________
          ___
          _   _
          1 2 3 4
      ||1 1 1 0 1
      | 2 1 1 0 1
       |3
 */

private class BIT2D(private val values: Array<Array<Int>>) {
    private val dim = Pair(values.size, values[0].size)

    private val bit = Array(dim.first + 1) { Array(dim.second + 1) { 0 } }

    init {
        for (i in 0 until dim.first) {
            for (j in 0 until dim.second) {
                build(PII(i + 1, j + 1), values[i, j])
            }
        }
    }

    fun showValues() = println(values.string)

    fun showTree() = println(bit.string)

    private fun build(p: PII, value: Int) {
        val (i, j) = p
        val (m, n) = dim
        var ci = i
        while (ci <= m) {
            var cj = j
            while (cj <= n) {
                bit[ci, cj] += value
                cj = parent(cj)
            }
            ci = parent(ci)
        }
    }

    fun update(p: PII, value: Int) {
        build(p, value)
        values[p.first - 1, p.second - 1] = value
    }

    fun query(p: PII, q: PII): Int {
        val (x2, y2) = q
        val (x1, y1) = p
        fun query(i: Int, j: Int): Int {
            var acc = 0
            var ci = i
            var cj = j
            while (ci > 0) {
                cj = j
                while (cj > 0) {
                    acc += bit[ci, cj]
                    cj = desc(cj)
                }
                ci = desc(ci)
            }
            return acc
        }

        val a = query(x2, y2)
        val b = query(x1 - 1, y2)
        val c = query(x2, y1 - 1)
        val d = query(x1 - 1, y1 - 1)
        return a - b - c + d
    }

    private fun desc(value: Int) = value - (value and (-value))

    private fun parent(value: Int) = value + (value and (-value))
}


private class TestCase(
    private val bit2D: BIT2D,
    private val operations: List<Operation>
) {

    sealed class Operation
    class Query(val query: Pair<PII, PII>) : Operation()
    data class Update(val pair: PII, val value: Int) : Operation()

    fun run() {
        for (operation in operations) {
            bit2D.showValues()
            when (operation) {
                is Query -> {
                    val (p, q) = operation.query
                    println("Query($p, $q) = ${bit2D.query(p, q)}")
                }

                is Update -> {
                    val (pair, value) = operation
                    bit2D.update(pair, value)
                    println("Update($pair) -> $value")
                    bit2D.showTree()
                }
                else -> {}
            }
        }
    }
}


private fun checkOneCase() {

    arrayOf(
        TestCase(
            BIT2D(
                arrayOf(
                    arrayOf(1, 2, 3, 4),
                    arrayOf(5, 6, 7, 8),
                    arrayOf(9, 10, 11, 12),
                )
            ),
            listOf(
                TestCase.Query(Pair(PII(1, 1), PII(2, 2))),
                TestCase.Query(Pair(PII(1, 1), PII(3, 3))),
                TestCase.Query(Pair(PII(1, 1), PII(1, 3))),
                TestCase.Query(Pair(PII(1, 1), PII(4, 4))),
            )
        ),
        TestCase(
            BIT2D(
                arrayOf(
                    arrayOf(1, 2),
                    arrayOf(3, 4),
                )
            ),
            listOf(
                TestCase.Query(Pair(PII(1, 1), PII(1, 2))),
                TestCase.Query(Pair(PII(1, 1), PII(2, 2)))
            )
        ),
        TestCase(
            BIT2D(
                arrayOf(
                    arrayOf(1, 2, 3),
                    arrayOf(4, 5, 6),
                    arrayOf(7, 8, 9),
                )
            ),
            listOf(
                TestCase.Query(Pair(PII(1, 1), PII(2, 2))),
                TestCase.Query(Pair(PII(1, 1), PII(3, 3))),
                TestCase.Query(Pair(PII(1, 1), PII(1, 3)))
            )
        ),
        TestCase(
            BIT2D(
                arrayOf(
                    arrayOf(1, 1, 2, 2),
                    arrayOf(3, 3, 4, 4),
                    arrayOf(5, 5, 6, 6),
                    arrayOf(7, 7, 8, 8),
                )
            ),
            listOf(
                TestCase.Query(Pair(PII(1, 1), PII(2, 2))),
                TestCase.Query(Pair(PII(2, 2), PII(4, 4)))
            )
        )
    ).forEach { case ->
        case.run()
    }


}

fun main() {
    checkOneCase()
}