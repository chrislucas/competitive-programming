package com.br.algo.cp.book1.chp2.kotlin.fenwick

/*
   https://medium.com/carpanese/a-visual-introduction-to-fenwick-tree-89b82cac5b3c
 */

class FenwickTreeIII(values: Array<Int>) {

    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    init {
        //System.arraycopy(values, 0, tree,1, values.size)
        for (i in 1 .. values.size) {
            tree[i] = values[i - 1] + tree[i - 1]
        }
    }

    fun showPrefixSum() {
        println(tree.toList())
    }

    // last significant bit
    private fun lsb(value: Int) = value and -value

    fun query(i: Int): Int {
        var res = 0
        var ci = i
        while (ci > 0) {
            res += tree[ci]
            ci -= lsb(ci)
        }
        return res
    }

}

fun main() {
    val fenwickTreeIII = FenwickTreeIII(arrayOf(1,2,3,4))
    fenwickTreeIII.showPrefixSum()
}