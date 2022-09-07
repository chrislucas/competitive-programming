package com.br.algo.cp.book1.chp2.kotlin.fenwick

/*
    https://cp-algorithms.com/data_structures/fenwick.html

    Seja F um grupo de operacoes (funcoes binaias sobre um conjunto de elementos) e A um
    arrau de inteiros de tamanho N

    Fenwick Tree é uma estrutura de dados que
 */


class FenwickTree(private val values: Array<Int>) {
    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    init {
        System.arraycopy(values, 0, tree, 1, values.size)
    }

    fun update(index: Int, value: Int) {

    }

    fun rangeSum(start: Int, end: Int): Int {
        return 0
    }

    private fun sum(value: Int): Int {
        var acc = 0
        var cValue = value
        while (cValue > 0) {
            acc += tree[cValue]
            cValue = rsb(cValue) - 1
        }

        return acc
    }

    private fun rsb(value: Int) = value and (-value)
}

class TestCase(val values: Array<Int>) {
    sealed class Operation
    data class Range(val start: Int, val end: Int) : Operation()
    data class Update(val index: Int, val value: Int) : Operation()


    fun run(fenwickTree: FenwickTree, operations: List<Operation>) {
        for (op in operations) {
            when (op) {
                is Range -> {
                    fenwickTree.rangeSum(op.start, op.end)
                }
                is Update -> {
                    fenwickTree.update(op.index, op.value)
                }
            }
        }
    }
}

fun main() {

}