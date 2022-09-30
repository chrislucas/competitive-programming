package src.com.br.cp.site.ds.kotlin.fenwick.bit2d.v2

import java.lang.StringBuilder

/*
    https://robert1003.github.io/2020/01/27/fenwick-tree.html
    TODO nao deixar de implementar
 */


operator fun Array<Array<Int>>.set(x: Int, y: Int, value: Int) {
    this[x][y] = value
}

operator fun Array<Array<Int>>.get(x: Int, y: Int) = this[x][y]

val <T> Array<Array<T>>.string: String
    get() {
        val sb = StringBuilder()
        sb.append("[")
        for (i in 0 until this.size) {
            sb.append(if (i > 0) "\n[" else "[")
            for (j in 0 until this[i].size) {
                sb.append(if (j == 0) "${this[i][j]}" else ", ${this[i][j]}")
            }
            sb.append(if (i < this.size - 1) "]," else "]")
        }
        sb.append("]")
        return sb.toString()
    }


class BIT2D(private val values: Array<Array<Int>>) {
    private val di = values.size
    private val dj = values[0].size

    private val bit = Array(di + 1) { Array(dj + 1) { 0 } }

    init {
        for(i in 1 .. di) {
            for(j in 1 .. dj) {
                build(i, j, values[i-1, j-1])
            }
        }
    }


    private fun build(i: Int, j: Int, delta: Int) {

    }

    fun update(i: Int, j: Int, value: Int) {
        build(i, j, value)
        values[i - 1][j - 1] = value
    }

    private fun sum(x1: Int, y1: Int, x2: Int, y2: Int): Int {

        fun query(i: Int, j: Int): Int {
            return 0
        }

        val a = query(x2, y2)


        return a
    }

    private fun desc(value: Int) = value - (value and (-value))

    private fun parent(value: Int) = value + (value and (-value))
}


fun main() {

}