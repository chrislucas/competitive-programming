package src.com.br.cp.site.ds.kotlin.site.hackerearth

/*
    https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/
    Quando
 */

class BinaryIndexTree(private val values: Array<Int>) {
    // @COMP
    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    private val size = tree.size

    init {
        for (i in values.indices) {
            update(i, values[i])
        }
    }

    fun showPrefixSum() = println("PrefixSum = ${tree.toList()}")

    fun showValues() = println("Values = ${values.toList()}")

    // removendo o bit menos significativo
    private fun parent(value: Int) = value - (value and (-value))

    private fun descendent(value: Int) = value + (value and (-value))

    fun rangeSum(l: Int, r: Int): Int {
        fun query(index: Int): Int {
            var acc = 0
            var idx = index
            while (idx > 0) {
                acc += tree[idx]
                idx = parent(idx)
            }
            return acc
        }

        val cl = l + 1
        val cr = r + 1
        return if (l == 1) {
            query(cr)
        } else {
            query(cr) - query(cl - 1)
        }
    }

    fun sum(index: Int): Int {
        var acc = 0
        var idx = index + 1
        while (idx > 0) {
            acc += tree[idx]
            idx = parent(idx)
        }
        return acc
    }

    private fun update(index: Int, delta: Int) {
        var idx = index + 1
        while (idx < size) {
            tree[idx] += delta
            // encontrando os nós descendentes de idx na binary indexed tree
            idx = descendent(idx)
        }
    }

    fun updateIndex(index: Int, value: Int) {
        update(index, values[index] - value)
        values[index] = value
    }
}

private class TestCase(private val tree: BinaryIndexTree, private val operations: List<Operation>) {

    sealed class Operation
    data class Range(val start: Int, val end: Int) : Operation()
    data class Update(val index: Int, val value: Int) : Operation()
    data class Sum(val index: Int) : Operation()

    fun hasCases() = operations.isNotEmpty()

    fun run() {
        for (op in operations) {
            when (op) {
                is Range -> {
                    val s = tree.rangeSum(op.start, op.end)
                    println("RangeSum(${op.start}, ${op.end}) = $s")
                }
                is Update -> {
                    print("Antes: ")
                    tree.showValues()
                    tree.updateIndex(op.index, op.value)
                    println("Update(${op.index}, ${op.value})")
                }
                is Sum -> {
                    println("Sum(0, ${op.index}) = ${tree.sum(op.index)}")
                }
            }
            tree.showValues()
            tree.showPrefixSum()
            println("-------------------------------------------------------------------------------")
        }
    }
}


private fun checkTestCase() {
    arrayOf(
        TestCase(
            BinaryIndexTree(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)),
            listOf(
                TestCase.Range(0, 15),
                TestCase.Sum(15),
                TestCase.Range(0, 0),
                TestCase.Sum(0)
            )
        ),
        TestCase(
            BinaryIndexTree(arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)),
            listOf(
                TestCase.Range(0, 16),
                TestCase.Sum(16),
                TestCase.Range(0, 0),
                TestCase.Sum(0)
            )
        ),
        TestCase(
            BinaryIndexTree(arrayOf(2, 1, 4, 6, -1, 5, -32, 0, 1)),
            listOf(
                TestCase.Range(0, 8),
                TestCase.Sum(8)
            )
        ),
        /*

        TestCase(
            BinaryIndexTree(arrayOf(2, 3, -1, 0, 6)),
            listOf(
                TestCase.Range(0, 4)

            )
        )
         */
    ).forEach {
        if (it.hasCases()) {
            it.run()
            println("================================== FIM ==================================")
        }
    }
}


fun main(args: Array<String>) {
    checkTestCase()
}