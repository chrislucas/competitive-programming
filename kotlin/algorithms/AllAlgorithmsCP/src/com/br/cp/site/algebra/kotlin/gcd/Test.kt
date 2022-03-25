package src.com.br.cp.site.algebra.kotlin.gcd

/**
 * https://pt.wikipedia.org/wiki/Algoritmo_de_Euclides_estendido
 * https://pt.wikipedia.org/wiki/Identidade_de_B%C3%A9zout
 */

private fun split() {
    fun split(a: Int, b: Int) {
        var aa = a
        var bb = b
        var r = aa % bb
        aa = bb
        bb = r
        /**
         * R(k+1) = R(k-1) - R(k)*Q(k)
         * em que
         * Qk = R(k-1)/R(k)
         */
        while (aa % bb != 0) {
            val remain = aa % bb
            val q = aa / bb
            val s = r - remain * q
            print("Step: $s")
            aa = bb
            bb = remain
            r = remain
        }
    }
    split(1914, 899)
}


fun main() {

}