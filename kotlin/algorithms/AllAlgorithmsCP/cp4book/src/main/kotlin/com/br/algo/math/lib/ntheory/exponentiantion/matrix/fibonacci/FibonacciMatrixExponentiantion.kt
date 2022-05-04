package com.br.algo.math.lib.ntheory.exponentiantion.matrix.fibonacci

/**
 * https://www.nayuki.io/page/fast-fibonacci-algorithms
 * https://www.nayuki.io/res/fast-fibonacci-algorithms/FastFibonacci.java
 */


/*
    val r = arrayOf(
        p[0, 0] * q[0, 0] + p[0, 1] * q[1, 1],
        p[0, 0] * q[0, 1] + p[0, 1] * q[1, 1]
    )
    val s = arrayOf(
        p[1, 0] * q[0, 0] + p[1, 1] * q[1, 0],
        p[1, 0] * q[0, 1] + p[1, 1] * q[1, 1]
    )
 */

// table https://r-knott.surrey.ac.uk/Fibonacci/fibtable.html
// https://www.nayuki.io/res/fast-fibonacci-algorithms/FastFibonacci.java

typealias IntMatrix = Array<Array<Int>>
typealias LongMatrix = Array<Array<Long>>

fun nthInt(n: Int): IntMatrix {
    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]
    fun fibonnaci(mat: IntMatrix, n: Int): IntMatrix {
        fun multiply(p: IntMatrix, q: IntMatrix): IntMatrix {
            val r = arrayOf(
                p[0, 0] * q[0, 0] + p[0, 1] * q[1, 0],
                p[0, 0] * q[0, 1] + p[0, 1] * q[1, 1]
            )
            val s = arrayOf(
                p[1, 0] * q[0, 0] + p[1, 1] * q[1, 0],
                p[1, 0] * q[0, 1] + p[1, 1] * q[1, 1]
            )
            return arrayOf(r, s)
        }
        var cn = n
        var cpy = mat
        var res = arrayOf(arrayOf(1, 1), arrayOf(1, 0))
        while (cn > 0) {
            if (cn and 1 == 1) {
                res = multiply(res, cpy)
            }
            cn = cn shr 1
            cpy = multiply(cpy, cpy)
        }
        return res
    }
    //[1, 1] = [ f(n+1), f(n)]
    //[1, 0] = [ f(n), f(n-1)]
    return fibonnaci(arrayOf(arrayOf(1, 1), arrayOf(1, 0)), n)
}

private fun checkIntFibonacci() {
    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]
    // limite do valor de N para obter uma resposta que nao exceda o valor
    // que pode ser definido para um int é 46
    (1..46).forEach {
        val arr = nthInt(it)
        println(
            String.format(
                "fb(%d): %d, %d, %d, %d", it,
                arr[0, 0], arr[0, 1], arr[1, 0], arr[1, 1]
            )
        )
    }
}

fun nthLong(n: Long): LongMatrix {
    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]
    fun exp(mat: LongMatrix, e: Long): LongMatrix {
        fun multiply(p: LongMatrix, q: LongMatrix): LongMatrix {
            val r = arrayOf(
                p[0, 0] * q[0, 0] + p[0, 1] * q[1, 0],
                p[0, 0] * q[0, 1] + p[0, 1] * q[1, 1]
            )
            val s = arrayOf(
                p[1, 0] * q[0, 0] + p[1, 1] * q[1, 0],
                p[1, 0] * q[0, 1] + p[1, 1] * q[1, 1]
            )
            return arrayOf(r, s)
        }
        var ce = e
        var cpy = mat
        var res = arrayOf(arrayOf(1L, 1L), arrayOf(1L, 0L))
        while (ce > 0) {
            if (ce and 1 == 1L) {
                res = multiply(res, cpy)
            }
            ce = ce shr 1
            cpy = multiply(cpy, cpy)
        }
        return res
    }
    //[1, 1] = [ f(n+1), f(n)]
    //[1, 0] = [ f(n), f(n-1)]
    return exp(arrayOf(arrayOf(1, 1), arrayOf(1, 0)), n)
}

private fun checkLongFibonacci() {
    operator fun <T> Array<Array<T>>.get(a: Int, b: Int) = this[a][b]
    // limit para o long eh o 92
    (1L..92L).forEach {
        val arr = nthLong(it)
        println(
            String.format(
                "fb(%d): %d, %d, %d, %d", it,
                arr[0, 0], arr[0, 1], arr[1, 0], arr[1, 1]
            )
        )
    }
}


fun main() {
    checkIntFibonacci()
    //checkLongFibonacci()
}