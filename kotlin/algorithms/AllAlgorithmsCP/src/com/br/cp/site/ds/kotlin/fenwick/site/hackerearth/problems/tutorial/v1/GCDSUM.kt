package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth.problems.tutorial.v1

/*
    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/tutorial/
    TODO melhorar a performance desse algoritmo

    O problema dado para estudar o algoritmo eh esse
    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/akash-and-gcd-1-15/
 */


private class GcdSum(private val values: Array<Int>) {
    private val tree = Array(values.size + 1) { 0 }
    private val mod = 1000000007
    private val mapFunctionResult = mutableMapOf<Int, Int>()
    private val mapGcd = mutableMapOf<Pair<Int, Int>, Int>()
    init {
        for (i in values.indices) {
            build(i, values[i])
        }
    }

    private fun function(x: Int): Int {
        var acc = 0
        for (i in 1..x) {
            acc = (acc % mod + mapingGcd(i, x) % mod) % mod
        }
        return acc
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (a % b == 0) {
            b
        } else {
            gcd(b, a % b)
        }
    }

    private fun mapFunction(value: Int): Int = if (mapFunctionResult[value] != null) {
        mapFunctionResult[value]!!
    } else {
        mapFunctionResult[value] = function(value)
        mapFunctionResult[value]!!
    }

    private fun mapingGcd(i: Int, j: Int): Int =
        if (mapGcd[Pair(i, j)] != null) {
            mapGcd[Pair(i, j)]!!
        } else {
            mapGcd[Pair(i, j)] = gcd(i, j)
            mapGcd[Pair(i, j)]!!
        }


    private fun build(idx: Int, value: Int) {
        var ci = idx + 1
        while (ci < tree.size) {
            tree[ci] += mapFunction(value)
            ci = descendent(ci)
        }
    }

    fun query(i: Int, j: Int): Int {
        fun query(idx: Int): Int {
            var acc = 0
            var ci = idx
            while (ci > 0) {
                acc = (acc % mod + tree[ci] % mod) % mod
                //acc += tree[ci]
                ci = parent(ci)
            }
            return acc
        }

        return if (i == 1) {
            query(j)
        } else {
            query(j) - query(i - 1)
        }
    }

    fun update(idx: Int, value: Int) {
         fun up(idx: Int, value: Int) {
            var ci = idx + 1
            while (ci < tree.size) {
                ///tree[ci] += value
                tree[ci] = (tree[ci] % mod + value % mod) % mod
                ci = descendent(ci)
            }
        }
        up(idx, mapFunction(value) - mapFunction(values[idx - 1]))
        values[idx - 1] = value
    }

    private fun parent(value: Int) = value - (value and (-value))

    private fun descendent(value: Int) = value + (value and (-value))
}

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private fun readString(delimiter: String = " ") = readLine()!!.split(delimiter)

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun solver() {
    val size = readValue(String::toInt)
    val bit = GcdSum(readValues(transform = String::toInt).toTypedArray())
    testCases(readValue(String::toInt)) {
        val (type, i, j) = readString()
        val ci = i.toInt()
        val cj = j.toInt()
        if (type == "C") {
            println(bit.query(ci, cj))
        } else {
            bit.update(ci, cj)
        }
    }
}

fun main() {
    solver()
}

/*
3
3 4 3
6
C 1 2
C 1 3
C 3 3
U 1 4
C 1 3
C 1 2
 */