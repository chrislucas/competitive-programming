package src.com.br.cp.site.algebra.kotlin.gcd.extended


class ExtendedGCDIt {
    data class GCDExtendedResult(val a: Long, val b: Long, val u: Long, val v: Long, val gcd: Long)

    // https://cp-algorithms.com/algebra/extended-euclid-algorithm.html
    fun extendedIt(a: Long, b: Long) {
        var aa = a
        var bb = b

        while (aa % bb != 0L) {
            val q = aa / bb
            val r = aa % bb
            aa = bb
            bb = r
        }
    }

    // https://brilliant.org/wiki/extended-euclidean-algorithm/
    fun extendedIt2() {}

}

fun main() {

}