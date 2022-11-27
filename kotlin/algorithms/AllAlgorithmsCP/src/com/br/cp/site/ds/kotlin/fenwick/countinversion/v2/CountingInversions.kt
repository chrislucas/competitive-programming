package src.com.br.cp.site.ds.kotlin.fenwick.countinversion.v2

import java.util.*


/*
    https://tutorialspoint.dev/data-structure/advanced-data-structures/count-inversions-array-set-3-using-bit
 */

private class CountingInvertionBinIndexedTree(private val values: Array<Int>) {

    // TODO teste para competicao
    private val tree = Array(values.size + 1) { 0 }
    private val size = tree.size

    private fun getOrderedPosition(): Array<Int> {
        // funcao lower bound
        fun lessThanOrEqual(values: Array<Int>, left: Int, right: Int, target: Int): Int {
            var le = left
            var ri = right
            while (le < ri) {
                val mid = (ri - le) / 2 + le
                if (target > values[mid]) {
                    le += 1
                } else {
                    ri = mid
                }
            }
            return le
        }

        val temp = Array(values.size) { 0 }
        val position = Array(values.size) { 0 }
        System.arraycopy(values, 0, temp, 0, temp.size)
        Arrays.sort(temp)
        for (i in values.indices) {
            position[i] = lessThanOrEqual(temp, 0, values.size, values[i]) + 1
        }
        return position
    }

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
            tree[ci] += 1
            ci = parent(ci)
        }
    }

    fun countInversions(): Int {
        var acc = 0
        val positions = getOrderedPosition()
        var n = values.size - 1
        while (n >= 0) {
            acc += sum(positions[n] - 1)
            update(positions[n])
            n -= 1
        }
        return acc
    }

    private fun child(value: Int) = value - (value and (-value))

    private fun parent(value: Int) = value + (value and (-value))

}

private fun checkCases() {
    arrayOf(
        CountingInvertionBinIndexedTree(arrayOf(7, -90, 100, 1)),
        CountingInvertionBinIndexedTree(arrayOf(8, 4, 2, 1)),
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