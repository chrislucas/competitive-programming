package src.com.br.cp.math.geom.line

/*
    https://www.codesansar.com/numerical-methods/linear-interpolation-method-algorithm.htm
 */


private fun checkLerp() {

    // lerp"https://en.wikipedia.org/wiki/Linear_interpolation
    fun lerp(p: Double, q: Double, t: Double) = (1.0 - t) * p + q * t

    /*
          Resultado interessante: https://docs.unity3d.com/ScriptReference/Vector3.Lerp.html
          The value returned equals a + (b - a) * t (which can also be written a * (1-t) + b*t).
            When t = 0, Vector3.Lerp(a, b, t) returns a.
            When t = 1, Vector3.Lerp(a, b, t) returns b.
            When t = 0.5, Vector3.Lerp(a, b, t) returns the point midway between a and b.
     */

    arrayOf(
        arrayOf(0.0, 5.0, 0.001),
        arrayOf(0.0, 5.0, 0.01),
        arrayOf(0.0, 5.0, 0.1),
        arrayOf(0.0, 5.0, 0.2),
    ).forEach {
        val (p, q, t) = it

        var counter = 0.0
        while (counter <= 1.0) {
            println(String.format("%.3f -> %.3f", counter, lerp(p, q, counter)))
            counter += t
        }

        println("*************************************************************")
    }

}

/*
    https://www.youtube.com/watch?v=_QQU9OIPGYE
 */

private fun linearInterpolationProblem1() {

}



fun main() {
    checkLerp()
}