package src.com.br.cp.site.ds.kotlin.site.hackerearth.problems.tutorial.v2


/*
    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/akash-and-gcd-1-15/editorial/
    TODO corrigir algoritmo, algumas entradas nao estao tendo as saidas corretas
    TODO verificar a eficiencia do algoritmo, para algumas entradas esta dando TLE
 */


private const val mod = 1000000007
private const val n = 1000010

private class FenwickTree(private val values: Array<Int>, val computedGcdSum: Array<Int>) {

    private val tree = Array(values.size + 1) { 0 }

    init {
        for (i in values.indices) {
            build(i, computedGcdSum[values[i]])
        }
    }

    private fun sum(a: Int, b: Int, m: Int) = (a % m + b % m) % m

    private fun minus(a: Int, b: Int, m: Int) = (a % m - b % m) % m

    private fun build(i: Int, value: Int) {
        var ci = i + 1
        while (ci < tree.size) {
            tree[ci] = sum(value, tree[ci], mod)
            ci = descendent(ci)
        }
    }

    private fun query(i: Int): Int {
        var acc = 0
        var ci = i
        while (ci > 0) {
            acc = sum(acc, tree[ci], mod)
            ci = parent(ci)
        }
        return acc
    }

    fun query(i: Int, j: Int): Int {
        return if (i == 1) {
            query(j)
        } else {
            query(j) - query(i - 1)
        }
    }

    fun update(i: Int, value: Int) {
        build(i - 1, minus(computedGcdSum[value], computedGcdSum[values[i - 1]], mod))
        values[i - 1] = value
    }

    private fun parent(value: Int) = value - (value and (-value))

    private fun descendent(value: Int) = value + (value and (-value))
}

private inline fun <reified T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }.toTypedArray()

private fun readString(delimiter: String = " ") = readLine()!!.split(delimiter)

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun computeGcdSum(): Array<Int> {
    fun eulerTotientRange(n: Int): Array<Int> {
        val phi = Array(n + 1) { it }
        for (i in 2..n) {
            if (phi[i] == i) {
                phi[i] = i - 1  // maximo de coprimos que N pode ter eh n-1
                var j = i * 2
                while (j <= n) {
                    phi[j] -= phi[j] / i
                    j += i
                }
            }
        }
        return phi
    }

    val phi = eulerTotientRange(n)
    val sum = Array(n + 1) { 0 }
    for (divisor in 1..n) {
        var i = 1
        var j = divisor
        while (j <= n) {
            sum[j] += divisor * phi[i]
            j += divisor
            i += 1
        }
    }
    return sum
}

private fun solver() {
    val computedGcdSum = computeGcdSum()
    readValue(String::toInt)
    val bit = FenwickTree(readValues(transform = String::toInt), computedGcdSum)
    testCases(readValue(String::toInt)) {
        val (type, i, j) = readString()
        val ci = i.toInt()
        val cj = j.toInt()
        if (type == "C") {
            // consultar gcd sum de ci a cj
            println(bit.query(ci, cj))
        } else {
            // atualizar bit[ci] = cj
            bit.update(ci, cj)
        }
    }
}

private fun check() {
    // [0, 1, 3, 5, 8, 9, 15, 13, 20, 21, 27]
    // [0, 1, 3, 5, 8, 9, 15, 13, 20, 21, 27]
    println(computeGcdSum().toList())
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
}

fun main() {
    solver()
}