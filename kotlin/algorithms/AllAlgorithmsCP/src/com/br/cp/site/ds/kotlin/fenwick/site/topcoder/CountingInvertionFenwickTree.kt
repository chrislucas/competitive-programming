package src.com.br.cp.site.ds.kotlin.fenwick.site.topcoder

/*
    https://noic.com.br/materiais-informatica/problemas-da-semana-old/avancado-informatica-semana-3/solucao-bale-semana-3/
 */


private fun coutingInversionPositiveInt(values: Array<Int>): Int {

    var max = values[0]
    for (i in 1 until values.size) {
        if (values[i] > max) {
            max = values[i]
        }
    }

    // READY
    val bit = Array(max + 1) { 0 }

    fun insert(x: Int, n: Int) {
        var cx = x
        while (cx <= n) {
            bit[cx] += 1
            cx += (cx and -cx)
        }
    }

    fun sum(x: Int): Int {
        var acc = 0
        var cx = x
        while (cx > 0) {
            acc += bit[cx]
            cx -= (cx and -cx)
        }
        return acc
    }

    var acc = 0
    val n = values.size
    for (i in values.indices) {
        insert(values[i], n)
        acc += sum(max) - sum(values[i])
    }

    return acc
}


private class CountingInvertionFenwickTree(private val values: Array<Int>) {
    /*
        https://tutorialspoint.dev/data-structure/advanced-data-structures/count-inversions-array-set-3-using-bit
     */
}

private fun checkCountingInversion() {
    arrayOf(
        arrayOf(2, 1, 3),
        arrayOf(3, 2, 1),
        arrayOf(3, 2, 1, 4),
        arrayOf(4, 1),
    ).forEach {
        println(coutingInversionPositiveInt(it))
    }
}


fun main() {
    checkCountingInversion()
}