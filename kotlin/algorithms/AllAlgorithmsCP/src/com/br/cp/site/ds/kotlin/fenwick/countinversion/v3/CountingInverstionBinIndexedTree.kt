package src.com.br.cp.site.ds.kotlin.fenwick.countinversion.v3


/*
    TODO entender e corrigir o problema desse algoritmo
     https://www.codingninjas.com/codestudio/library/count-inversions-using-fenwick-tree
 */

private fun Array<Int>.maxOr(default: Int = 0) = maxOrNull() ?: default


private class CountingInvertionBinIndexedTree(private val values: Array<Int>) {

    private val max = values.maxOr()

    private val tree = Array(max + 2) { 0 }
    private val size = tree.size

    fun sum(idx: Int): Int {
        var acc = 0
        var i = idx + 1
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

    fun countInversions(): Int {
        var acc = 0
        for (i in values.indices) {
            val value = values[i]
            update(value)
            acc += i - sum(value) + 1
        }
        return acc
    }

    private fun child(value: Int) = value - (value and (-value))

    private fun parent(value: Int) = value + (value and (-value))
}

private class CInvBit(private val values: Array<Int>) {

}


private fun checkCases() {
    arrayOf(
        CountingInvertionBinIndexedTree(arrayOf(5, 4, 3, 2, 1)),
        CountingInvertionBinIndexedTree(arrayOf(3, 1, 2)),
        CountingInvertionBinIndexedTree(arrayOf(1, 3, 2)),
        CountingInvertionBinIndexedTree(arrayOf(1, 2, 3, 4, 5)),
        CountingInvertionBinIndexedTree(arrayOf(6, 4, 3, 2, 1)),
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