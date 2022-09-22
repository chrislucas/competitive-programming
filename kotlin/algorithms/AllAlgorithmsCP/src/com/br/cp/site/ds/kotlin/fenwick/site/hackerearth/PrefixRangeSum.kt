package src.com.br.cp.site.ds.kotlin.fenwick.site.hackerearth

class PrefixRangeSum(values: Array<Int>) {

    private val prefix = Array(values.size) { 0 }

    init {
        prefix[0] = values[0]
        for (i in 1 until values.size) {
            prefix[i] = prefix[i - 1] + values[i]
        }
    }

    fun range(p: Int, q: Int) =
        if (p < 1 || p == q) {
            prefix[q]
        } else if (p < q) {
            prefix[q] - prefix[p - 1]
        } else {
            0
        }
}


private fun check() {
    val prefixRangeSum = PrefixRangeSum(arrayOf(1, 2, 3))
    println(prefixRangeSum.range(0, 2))
    println(prefixRangeSum.range(1, 2))
    println(prefixRangeSum.range(0, 1))
    println(prefixRangeSum.range(2, 2))
    println(prefixRangeSum.range(0, 0))
    println(prefixRangeSum.range(1, 1))
}


fun main() {
    check()
}