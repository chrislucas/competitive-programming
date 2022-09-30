package src.com.br.cp.site.ds.kotlin.fenwick.countinversion.v2


/*
    https://tutorialspoint.dev/data-structure/advanced-data-structures/count-inversions-array-set-3-using-bit
 */

private class CountingInvertionBinIndexedTree(private val values: Array<Int>) {

    private val max = values.maxOr()

    private val tree = Array(max + 1) { 0 }
    private val size = tree.size

    fun sum(idx: Int): Int {
        var acc = 0
        var i = idx
        while (i > 0) {
            acc += tree[i]
            i = child(i)
        }
        return acc
    }

    private fun update(idx: Int) {
        var i = idx
        while (i < size) {
            tree[i] += 1
            i = parent(i)
        }
    }

    private fun Array<Int>.maxOr(default: Int = 0) = maxOrNull() ?: default

    fun countInversions() {
        var acc = 0
        for (i in values.size - 1 downTo 0) {
            val value = values[i] - 1
            acc += sum(value)
            update(values[i])
        }
    }

    private fun child(value: Int) = value - (value and (-value))

    private fun parent(value: Int) = value + (value and (-value))

}

private fun checkCases() {
    arrayOf(
        CountingInvertionBinIndexedTree(arrayOf(5, 1, 3, 2)),
        CountingInvertionBinIndexedTree(arrayOf(1, -9, 5, 4, 3)),
        CountingInvertionBinIndexedTree(arrayOf(5, 4, 3, 1, -9)),
        CountingInvertionBinIndexedTree(arrayOf(8, 4, 2, 1)),
        CountingInvertionBinIndexedTree(arrayOf(1, 2, 4, 6)),
        CountingInvertionBinIndexedTree(arrayOf(5, 4, 3, 1, -9))

    ).forEach { tree ->
        println(tree.countInversions())
        println("####################################### case #######################################")
    }
}

fun main() {
    checkCases()
}