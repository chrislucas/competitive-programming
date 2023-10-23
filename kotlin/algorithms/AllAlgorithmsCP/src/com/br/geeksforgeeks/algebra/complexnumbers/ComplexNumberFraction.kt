package src.com.br.geeksforgeeks.algebra.complexnumbers

class ComplexNumberFraction(private val real: Fraction, private val im: Fraction) {

    data class Fraction(private val numerator: Int, private val denominator: Int) {

        private fun gcd(p: Int, q: Int): Int {
            /**
             * https://www.dcode.fr/gcd
             */
            var pp = p
            var qq = q
            while (pp % qq != 0) {
                val tmp = qq
                qq = pp % qq
                pp = tmp
            }
            return qq
        }


        fun simplify(): Fraction =
            gcd(numerator, denominator).let { common ->
                Fraction(numerator / common, denominator / common)
            }


        override fun toString(): String = "${numerator}/${denominator}"
    }


}


fun main() {

}