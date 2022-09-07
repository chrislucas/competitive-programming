package com.br.competitions.circuit.aug.studies

/*
    https://www.geeksforgeeks.org/range-lcm-queries/
    https://tutorialspoint.dev/data-structure/arrays/range-lcm-queries
 */


private fun lcm(a: Long, b: Long): Long {
    fun gcd(a: Long, b: Long): Long =
        if (a % b == 0L) {
            b
        } else {
            gcd(b, a % b)
        }

    return a * b / gcd(a, b)
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

private fun Array<Long>.gcd(): Long {
    fun gcd(a: Long, b: Long): Long =
        if (a % b == 0L) {
            b
        } else {
            gcd(b, a % b)
        }

    var r = gcd(this[0], this[1])

    for (i in 2 until size) {
        r = gcd(r, this[2])
    }

    return r
}

private fun Array<Int>.gcd(): Int {

    fun gcd(a: Int, b: Int): Int =
        if (a % b == 0) {
            b
        } else {
            gcd(b, a % b)
        }

    return if (this.isEmpty()) {
        0
    } else if (this.size == 1) {
        this[0]
    } else {
        var r = gcd(this[0], this[1])
        for (i in 2 until size) {
            r = gcd(r, this[i])
        }
        r
    }
}

private fun Array<Int>.lcm(): Int {
    fun lcm(a: Int, b: Int): Int {
        fun gcd(a: Int, b: Int): Int =
            if (a % b == 0) {
                b
            } else {
                gcd(b, a % b)
            }
        return a * b / gcd(a, b)
    }

    return if (this.isEmpty()) {
        0
    } else if (this.size == 1) {
        this[0]
    } else {
        var r = lcm(this[0], this[1])
        for (i in 2 until size) {
            r = lcm(r, this[i])
        }
        r
    }
}


private fun checkArrayGcd() {
    // https://www.dcode.fr/gcd
    arrayOf(
        arrayOf(30, 32, 1024),
        arrayOf(30, 32, 1024, 900),
        arrayOf(30, 32, 900),
        arrayOf(30, 900),
        arrayOf(32, 900),
        arrayOf(30, 35, 50, 180, 300, 345, 2000, 2300, 2500, 3000)
    ).forEach { case ->
        println(case.gcd())
    }
}

private fun checkArrayLcm() {
    // https://www.dcode.fr/lcm

    arrayOf(
        arrayOf(2, 40, 100, 345)
    ).forEach { case ->
        println(case.lcm())
    }
}


private class LCMRangeQueries(private val data: Array<Int>) {

    private val tree = Array(data.size * 100) { 0 }

    init {
        createTree(1, 0, data.size - 1, tree, data)
    }

    private fun createTree(node: Int, s: Int, e: Int, tree: Array<Int>, data: Array<Int>) {
        if (s == e) {
            tree[node] = data[s]
        }
        val m = (e - s) / 2 + s
        createTree(node * 2, s, m, tree, data)
        createTree(node * 2 + 1, m + 1, e, tree, data)
        val left = tree[2 * node]
        val right = tree[2 * node + 1]
        tree[node] = lcm(left, right)
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

    fun query(range: IntRange) {
        fun query(node: Int, s: Int, e: Int, l: Int, r: Int): Int {
            return if (e < l || s > r) {
                1
            } else if (l <= s && r >= e) {
                tree[node]
            } else {
                val m = (e - s) / 2 + s
                val left = query(2 * node, s, m, l, r)
                val right = query(2 * node + 1, m + 1, e, l, r)
                lcm(left, r)
            }
        }
        query(1, 0, data.size - 1, range.first, range.last)
    }
}

private fun checkLCMRangeQuery() {
    val rangeQuery = LCMRangeQueries(
        arrayOf(5, 7, 5, 2, 10, 12, 11, 17, 14, 1, 44)
    )
    arrayOf(
        2..5,
        //5..10,
        //0..10
    ).forEach {
        println(rangeQuery.query(it))
    }
}


fun main() {
    //checkArrayGcd()
    //checkArrayLcm()
    checkLCMRangeQuery()
}