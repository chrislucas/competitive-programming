package src.com.br.cp.site.ds.kotlin.trees.fenwick

/**
 * https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/?ref=leftbar-rightbar
 *
 * Texto interessante explicando visualmente como funcionar uma BIT
 * https://medium.com/carpanese/a-visual-introduction-to-fenwick-tree-89b82cac5b3c
 *
 */

class BIT(private val values: Array<Int>) {
    // @COMP
    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    private val size = tree.size

    init {
        for (i in values.indices) {
            update(i, values[i])
        }
    }

    // soma de 0 a i
    fun sum(idx: Int): Int {
        var sum = 0
        var i = idx + 1
        while (i > 0) {
            sum += tree[i]
            i = parent(i)
        }
        return sum
    }

    fun rangeSum(le: Int, ri: Int): Int {
        val cl = le + 1
        val cr = ri + 1
        fun query(idx: Int): Int {
            var sum = 0
            var i = idx
            while (i > 0) {
                sum += tree[i]
                i = parent(i)
            }
            return sum
        }
        return if (cl == 1) {
            query(cr)
        } else {
            query(cr) - query(cl - 1)
        }
    }

    private fun update(idx: Int, delta: Int) {
        var i = idx + 1
        while (i < size) {
            tree[i] += delta
            i = descendent(i)
        }
    }

    fun updateIndex(idx: Int, value: Int) {
        update(idx, value - values[idx])
        values[idx] = value
    }

    fun showPrefixSum() = println("PrefixSum = ${tree.toList()}")

    fun showValues() = println("Values = ${values.toList()}")

    // removendo o bit menos significativo
    private fun parent(value: Int) = value - (value and (-value))

    private fun descendent(value: Int) = value + (value and (-value))

}

private class TestCase(private val tree: BIT, private val operations: List<Operation>) {

    sealed class Operation
    data class Range(val start: Int, val end: Int) : Operation()
    data class Update(val index: Int, val value: Int) : Operation()
    data class Sum(val start: Int) : Operation()

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
                    println("Sum(0, ${op.start}) = ${tree.sum(op.start)}")
                }
            }
            tree.showValues()
            tree.showPrefixSum()
            println("--------------------------------------------------------------------")
        }
    }
}

private fun checkTestCase() {
    arrayOf(
        /*
        TestCase(
            BIT(
                arrayOf(
                    2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9
                )
            ), listOf(
                TestCase.Range(0, 11),
                TestCase.Sum(11),
                TestCase.Sum(5),
                TestCase.Update(3, 6),
                TestCase.Sum(5),
                TestCase.Sum(0),
                TestCase.Range(0, 0)
            )
        ),
        TestCase(
            BIT(arrayOf(1, 2, 3, 4)), listOf(
                TestCase.Sum(3),
                TestCase.Range(0, 3),
                TestCase.Range(2, 3),
                TestCase.Range(1, 3),
                TestCase.Update(3, 10),
                TestCase.Range(0, 3),
                TestCase.Sum(0),
                TestCase.Range(0, 0),
                TestCase.Range(1, 1),
                TestCase.Range(2, 2),
                TestCase.Range(3, 3),
            )
        ),
        */
        TestCase(
            BIT(
                arrayOf(-5, 7, 0, 1, 3, 2, -1, 0, 2)
            ),
            listOf(
                //TestCase.Range(0, 3),
                //TestCase.Range(1, 4),
                TestCase.Range(1, 8),   // exemplo interessante
                //TestCase.Update(3, 5),
                //TestCase.Range(1, 4),
                //TestCase.Range(1, 8)
            )
        )

    ).forEach { case ->
        if (case.hasCases()) {
            case.run()
            println("========================= FIM =========================")
        }
    }
}


fun main(args: Array<String>) {
    checkTestCase()
}