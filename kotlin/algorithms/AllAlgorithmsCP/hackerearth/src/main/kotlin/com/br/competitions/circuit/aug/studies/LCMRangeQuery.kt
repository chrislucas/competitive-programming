package com.br.competitions.circuit.aug.studies

/*
    https://tutorialspoint.dev/data-structure/arrays/range-lcm-queries
    https://www.tutorialcup.com/interview/tree/range-lcm-queries.htm
 */


class LCMRangeQuery(private val data: Array<Int>) {

    private val tree = Array(data.size * 100) { 0 }

    init {
        createTree(1, 0, data.size - 1)
    }

    private fun createTree(idx: Int, s: Int, e: Int) {
        if (s == e) {
            tree[idx] = data[s]
        }
        val m = (e - s) / 2 + s
        createTree(2 * idx, s, m)
        createTree(2 * idx + 1, m + 1, e)

        val left = tree[2 * idx]
        val right = tree[2 * idx + 1]

        tree[idx] = lcm(left, right)
    }

    private fun lcm(a: Int, b: Int): Int {
        fun gcd(a: Int, b: Int): Int =
            if (a % b == 0) {
                b
            } else {
                gcd(b, a % b)
            }
        return a * b / gcd(a, b)
    }

    fun query(range: IntRange): Int {

        fun query(idx: Int, s: Int, e: Int, le: Int, ri: Int): Int {
            if (e < le || s > ri) {
                return 1
            }
            return if (le <= s && ri >= e) {
                tree[idx]
            } else {
                val mi = (e - s) / 2 + s
                val leftChild = query(2 * idx, s, mi, le, ri)
                val rightChild = query(2 * idx + 1, mi + 1, e, le, ri)
                lcm(leftChild, rightChild)
            }
        }
        return query(1, 0, data.size - 1, range.first, range.last)
    }
}


private fun checkCases() {
    listOf(
        arrayOf(5, 7, 5, 2, 10, 12, 11, 17, 14, 1, 44) to listOf(2..5),
        arrayOf(2, 4, 6, 9, 10, 8, 7, 5, 14, 1) to listOf(2..5, 3..7, 5..8), // 360 2520 280
        arrayOf(3, 40, 5, 12) to listOf(1..2, 0..3)
    ).forEach { (data, queries) ->

        val rangeQuery = LCMRangeQuery(data)

        queries.forEach { range ->
            println(rangeQuery.query(range))
        }
    }
}


fun main() {

}