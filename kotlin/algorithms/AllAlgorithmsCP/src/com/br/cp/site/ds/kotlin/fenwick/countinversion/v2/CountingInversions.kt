package src.com.br.cp.site.ds.kotlin.fenwick.countinversion.v2


/*
    https://tutorialspoint.dev/data-structure/advanced-data-structures/count-inversions-array-set-3-using-bit
 */

private class CountingInvertionBinIndexedTree(private val values: Array<Int>) {


    private val max: Int = max()

    private fun max(): Int {
        var max = values[0]
        for (i in 1 until values.size) {
            if (values[i] > max) {
                max = values[i]
            }
        }
        return max
    }

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

    private fun update(i: Int) {
        var ci = i
        while (ci < size) {
            tree[ci] += i
            ci = parent(ci)
        }
    }


    fun countInversions() {
        var acc = 0

        for (i in values.indices) {
            update(values[i])
            acc += sum(max)
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