package com.br.studies.dp.bitmask.problems.assign

/*
    https://www.geeksforgeeks.org/bitmasking-and-dynamic-programming-set-1-count-ways-to-assign-unique-cap-to-every-person/
 */

private fun readInt() = readLine()!!.toInt()

private fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }.toTypedArray()

infix fun Int.set(nth: Int) = this or (1 shl nth)

private infix fun Int.isSet(nth: Int) = this and (1 shl nth) > 0

typealias  Matrix<T> = Array<Array<T?>>

operator fun <T> Matrix<T>.set(i: Int, j: Int, value: T) {
    this[i][j] = value
}

operator fun <T> Matrix<T>.get(i: Int, j: Int) = this[i][j]

private inline fun <reified T> create(x: Int, y: Int, init: () -> T?):
        Matrix<T?> = Array(x) { Array(y) { init() } }

val Int.countSetBits: Int
    get() {
        var counter = 0
        var copy = this
        while (copy > 0) {
            copy = copy and (copy - 1)
            counter += 1
        }
        return counter
    }

val Int.lowestNonZeroBit: Int   // number of the lowest non-zero bit in the mask
    get() = 0

fun Int.nBit(i: Int) = if (this and (1 shl i) > 0) 1 else 0 // nth bit of the mask

/*
    dado uma S conjuntos de N numeros, de quantas formas é possivel escolher
    um subconjunto de tamanho S pegando 1 elemento de cada conjunto sem repetir numeros
    Exemplo
    S [ {5,100,1}, {2}, {5, 100} ] - S possui 3 conjuntos

    Possiveis conjuntos de tamanhao 3 sem repeticao

    {100,2,5}; {5,2,100}; {1,2,5}; {1,2,100}

    Caso o resultado seja um numero muito grande, podemos trabalhar com aritmetica modula
    e o resultado ser dado em modulo 1000000007
 */

const val M = 1000000007

typealias SparseMatrix<K, V> = LinkedHashMap<K, ArrayList<V>>

operator fun SparseMatrix<Int, Int>.get(i: Int, j: Int) = this[i]?.get(j)

operator fun SparseMatrix<Int, Int>.set(i: Int, value: Int) {
    if (this[i] == null)
        this[i] = arrayListOf()
    this[i]?.add(value)
}

private fun solver() {

    fun recCountWays(
        caps: SparseMatrix<Int, Int>, dp: Matrix<Int>,
        mask: Int, maskLimit: Int, i: Int, ids: Int
    ): Int {

        if (mask == maskLimit)
            return 1

        if (i > ids)
            return 0

        if (dp[mask][i] != -1)
            return dp[mask][i]!!

        var ways = recCountWays(caps, dp, mask, maskLimit, i + 1, ids)

        caps[i]?.let { matrix ->
            for (k in matrix) {
                if (!(mask isSet k)) {
                    val partial = recCountWays(caps, dp, mask set k,
                        maskLimit, i + 1, ids)
                    ways = ((ways % M) + (partial % M)) % M
                }
            }
        }

        dp[mask][i] = mask
        return mask
    }

    fun itCountWays(
        caps: SparseMatrix<Int, Int>, dp: Matrix<Int>,
        limit: Int, i: Int, ids: Int
    ): Int {
        var ways = 1
        if (i > ids)
            return 0

        for (mask in 0..limit) {
            for (id in 1 until ids) {
                for (k in caps[id]!!) {
                    if (!(mask isSet k)) {
                        ways = (ways % M)
                    }
                }
            }
        }

        return ways
    }

    val set = SparseMatrix<Int, Int>()
    var persons = readInt()
    val mask = persons
    val ids = 101 // ids de 1 a 100

    while (persons >= 0) {
        readInts().forEach {
            set[persons - 1] = it
        }
        persons -= 1
    }

    val dp = create(1 shl mask, ids) { -1 }

    println(recCountWays(set, dp, 0, 1 shl mask, 1, ids - 1))
}

fun main() {
    solver()
}