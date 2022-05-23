package com.br.competitions.c1674

/**
 * https://codeforces.com/contest/1674/problem/D
 */
inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun solver() {

    // left
    fun pl(a: Array<Int>, b: Array<Int>, c: Array<Int>) {
        var i = a.size - 1
        var j = 0
        // step 1
        while (i >= 0) {
            val last = a[i]
            if (j == 0) {
                b[j] = last
            } else {
                val middle = if (j and 1 == 0) {
                    j / 2 - 1   // a esquerda do meio
                } else {
                    j / 2       // o meio
                }
                b[middle] = last
            }
            j += 1
            i -= 1
        }
        // step 2
        i = b.size - 1
        while (i >= 0) {
            val middle = if (i == 0) {
                b[0]
            } else {
                val m = if (i and 1 == 0) {
                    i / 2 - 1 // quando i for par o meio que sera usado e o elemento da esquerda
                } else {
                    i / 2
                }
                b[m]
            }
            c[i] = middle
            i -= 1
        }
    }

    fun pr(a: Array<Int>, b: Array<Int>, c: Array<Int>) {
        var i = a.size - 1
        var j = 0
        // step 1
        while (i >= 0) {
            val last = a[i]
            if (i == 0) {
                b[j] = last
            } else {
                b[j / 2] = last // meio ou a direita do meio
            }
            j += 1
            i -= 1
        }
        // step 2
        i = b.size - 1
        while (i >= 0) {
            val middle = if (i == 0) {
                b[0]
            } else {
                b[i / 2]    // quando i for par o meio que sera usado e o elemento da direita
            }
            c[i] = middle
            i -= 1
        }
    }

    fun <C : Comparable<C>> isOrdered(data: Array<C>): Boolean {
        for (i in 0 until data.size - 2) {
            if (data[i] > data[i + 1])
                return false
        }
        return true
    }

    testCases(readValue(String::toInt)) {
        val size = readValue(String::toInt)
        val a: Array<Int> = readValues(transform = String::toInt).toTypedArray()
        var b = Array(size) { -1 }
        var c = Array(size) { -1 }
        pl(a, b, c)
        if (isOrdered(c)) {
            println("YES")
        } else {
            b = Array(size) { -1 }
            c = Array(size) { -1 }
            pr(a, b, c)
            if (isOrdered(c)) {
                println("YES")
            } else {
                println("YES")
            }
        }

    }
}

fun main(args: Array<String>) {
    solver()
}