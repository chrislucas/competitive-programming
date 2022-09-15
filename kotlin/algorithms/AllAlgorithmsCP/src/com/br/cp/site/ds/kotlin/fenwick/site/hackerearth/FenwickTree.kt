package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth

/*
    https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/
 */

class BinaryIndexTree(private val values: Array<Int>) {

    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    private val size = tree.size

    init {

    }

    fun showPrefixSum() = println("PrefixSum = ${tree.toList()}")

    fun showValues() = println("Values = ${values.toList()}")

    // removendo o bit menos significativo
    private fun parent(value: Int) = value - (value and (-value))

    private fun descendent(value: Int) = value + (value and (-value))

    fun updateIndex(index: Int, value: Int) {

    }

    fun rangeSum(start: Int, end: Int): Int {
        return 0
    }
}

private class TestCase(private val tree: BinaryIndexTree, private val operations: List<Operation>) {

    sealed class Operation
    data class Range(val start: Int, val end: Int) : Operation()
    data class Update(val index: Int, val value: Int) : Operation()

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
            }
            tree.showValues()
            tree.showPrefixSum()
            println("--------------------------------------------------------------------")
        }
    }
}





fun main(args: Array<String>) {

}