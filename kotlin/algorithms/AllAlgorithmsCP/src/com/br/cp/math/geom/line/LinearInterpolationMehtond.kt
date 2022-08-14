package src.com.br.cp.math.geom.line

/*
    https://www.codesansar.com/numerical-methods/linear-interpolation-method-algorithm.htm
 */


private fun checkLerp() {

    // lerp"https://en.wikipedia.org/wiki/Linear_interpolation
    fun lerp(p: Double, q: Double, t: Double) = (1.0 - t) * p + q * t

    arrayOf(
        arrayOf(0.0, 5.0, 0.001),
        arrayOf(0.0, 5.0, 0.01),
        arrayOf(0.0, 5.0, 0.1),
        arrayOf(0.0, 5.0, 0.1),
    ).forEach {
        val (p, q, t) = it

        var counter = p
        while (counter <= q) {
            println(String.format("%.3f -> %.3f", counter, lerp(p, q, counter)))
            counter += t
        }

        println("*************************************************************")
    }


}

fun main() {
    checkLerp()
}