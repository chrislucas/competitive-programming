package src.com.br.geeksforgeeks.algebra.complexnumbers


/*
    https://brasilescola.uol.com.br/matematica/numeros-complexos.htm#fromHistory
    https://cplusplus.com/reference/complex/
    https://www.geeksforgeeks.org/complex-numbers-c-set-1/
 */

data class ComplexNumber(private val real: Double, private val im: Double) {

    constructor(r: Int, i: Int) : this(r.toDouble(), i.toDouble())

    operator fun plus(p: ComplexNumber): ComplexNumber = ComplexNumber(real + p.real, im + p.im)

    operator fun minus(p: ComplexNumber): ComplexNumber = ComplexNumber(real - p.real, im - p.im)

    companion object {
        private val values: Array<ComplexNumber>
            get() =  arrayOf(
                ComplexNumber(1, 0),    // i ^ 0 = 1
                ComplexNumber(0, 1),    // i ^ 1 = i
                ComplexNumber(-1, 0),   // i ^ 2 = sqrt(-1) ^ 2 = -1
                ComplexNumber(0, -1)    // i ^ 3 = i ^ 2 * i = -1 * i = -i
            )


        fun exponentialImPart(e: Int): ComplexNumber = values[e % 4]
    }

    operator fun times(p: ComplexNumber): ComplexNumber =
        /*
            z1 (a + bi)
            z2 (c + di)
            z3 = z1 * z2
               = ac + adi + cbi + bd i^2
               = ac + adi + cbi - bd
               = ac - db + adi + cbi
               = ac - db + (ad + cb)i
         */
        ComplexNumber(
            (real * p.real) - (im * p.im), real * p.im + p.real * im
        )


    operator fun div(that: ComplexNumber): ComplexNumber {

        /*
            https://www.hackmath.net/en/calculator/complex-number
            z1 (a + bi); z2 (c + di)
            z1 / z2 =  (z1 * conj(z2)) / (z2 * conj(z2))

            (a + bi) / (c + di) = (a + bi)*(c - di) / (c + di)*(c - di)

            (ac + bd) / (c^2 + d^2) + ((bc - ad) / (c^2 + d^2))i
         */

        return that.conjugate().let { conj ->
            val a = this * conj
            val b = that * conj

            val (aReal, aIm) = a
            val (bReal, bIm) = b

            ComplexNumber(if (bReal > 0) aReal / bReal else aReal, if(bIm > 0) aIm / bIm else aIm / bReal)
        }
    }

    private operator fun unaryMinus() = ComplexNumber(real, -im)

    private fun conjugate() = -this

    override fun toString(): String = if (im == 0.0) {
        "($real)"
    } else if(im < 0.0){
        "($real${im}i)"
    } else {
        "($real+${im}i)"
    }
}




private fun checkComplexNumberSum() {
    var p = ComplexNumber(2, 3)
    val q = ComplexNumber(1, 2)
    p += q
    println(p)
}


private fun checkComplexNumberMinus() {
    var p = ComplexNumber(2, 3)
    val q = ComplexNumber(1, 2)
    p -= q
    println(p)
}


private fun checkComplexNumberMultiply() {
    var p = ComplexNumber(2, 3)
    val q = ComplexNumber(1, -4)
    p *= q
    println(p)
}


private fun checkComplexNumberDiv() {

    arrayOf(
        Pair(ComplexNumber(2, 3), ComplexNumber(1, 2)),
        Pair(ComplexNumber(6, -4), ComplexNumber(4, 2)),
        Pair(ComplexNumber(2.0, 3.0), ComplexNumber(1.0,  -3.0)),
    ).forEach { (p, q) ->
        val r = p / q
        println(r)
        println("************************************************************************")

    }

}

private fun checkExponentialComplexNumber() {
    println(ComplexNumber.exponentialImPart(10))
}

private fun checkOp() {
    checkComplexNumberSum()
    checkComplexNumberMinus()
    checkComplexNumberMultiply()
    checkComplexNumberDiv()
}


fun main() {
    checkComplexNumberDiv()
}