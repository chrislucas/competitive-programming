package com.br.algo.cp.book1.chp2.kotlin.fenwick.v1

/*
    https://cp-algorithms.com/data_structures/fenwick.html

    Seja F um grupo de operacoes (funcoes binaias sobre um conjunto de elementos) e A um
    arrau de inteiros de tamanho N

    Fenwick Tree é uma estrutura de dados que
        - dado uma funcao f(l, r), iso eh f[al, al+1, ... ar], ela calcula a funcao f em O(logn)
        - Atualiza qualquer elemento do Array A leva O(logn)
 */


class FenwickTree(private val values: Array<Int>) {
    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    private val size: Int
        get() = tree.size

    init {
        for (i in 1 until size) {
            add(i, values[i - 1])
        }
    }

    private fun add(idx: Int, delta: Int) {

    }

    fun update(index: Int, value: Int) {
        fun add(value: Int): Int {
            var acc = 0
            var cValue = value
            while (cValue > 0) {
                acc += tree[cValue]
                cValue = rsb(cValue) - 1
            }
            return acc
        }

        val delta = value - tree[index]
        add(delta)
        tree[index] = value
    }

    fun rangeSum(start: Int, end: Int): Int {
        return 0
    }

    private fun rsb(value: Int) = value and (-value)
}

private class TestCase(private val fenwickTree: FenwickTree, private val operations: List<Operation>) {
    sealed class Operation
    data class Range(val start: Int, val end: Int) : Operation()
    data class Update(val index: Int, val value: Int) : Operation()

    fun hasTestCase() = operations.isNotEmpty()

    fun run() {
        for (op in operations) {
            when (op) {
                is Range -> {
                    val s = fenwickTree.rangeSum(op.start, op.end)
                    println("RangeSum(${op.start}, ${op.end}) = $s")
                }
                is Update -> {
                    fenwickTree.update(op.index, op.value)
                    println("Update(${op.index}, ${op.value})")
                }
            }
        }
    }
}

private fun checkTestCase() {
    arrayOf(
        TestCase(FenwickTree(arrayOf(1,2,3,4)), listOf())
    ).forEach {
        if (it.hasTestCase()) {
            it.run()
            println("****************************************************************")
        }
    }
}

fun main() {
    checkTestCase()
}