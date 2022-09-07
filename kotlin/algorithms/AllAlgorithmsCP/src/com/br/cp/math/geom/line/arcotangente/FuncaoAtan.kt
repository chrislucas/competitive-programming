package src.com.br.cp.math.geom.line.arcotangente

import java.lang.Math.PI
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

/*
    https://www.geeksforgeeks.org/java-atan-method-examples/
    funcao atan (arcotangente) retorna
    https://en.wikipedia.org/wiki/Inverse_trigonometric_functions
 */


private fun Double.toRadian() = this * PI / 180.0

private fun Double.toDegree() = this * 180.0 / PI

private fun checkConvertion() {
    println(360.0.toRadian())
    println(360.0.toRadian().toDegree())
    println(Math.toRadians(360.0))
    println(Math.toDegrees(Math.toRadians(360.0)))
}


private fun checkAtan() {
    /*
        a funcao arcotangente tem valores entre -pi/2 e pi/2
        pi = 180
     */
    var p = -PI / 2.0
    val q = -p
    while (p <= q) {
        println(
            "Radians: $p | Degree: ${Math.toDegrees(p)} | " +
                    "ArcoTangente: ${atan(p)} _ ${Math.toDegrees(atan(p))} | " +
                    "Tangente: ${tan(p)}"
        )
        p += 0.1
    }
}

private fun checkArcTangent() {
    /*
        https://www.calculadoraonline.com.br/arco-tangente
        O arcotangente eh usado para uma vez sabendo a tangente, obter o angulo.
        O dominnio da funcao arcotangente está entre -pi/2 e pi/2 - -90 ate 90 gratua
     */


    arrayOf(
        -PI / 6.0, -PI / 4.0, -PI / 3.0, -PI / 2.0,
        PI / 6.0, PI / 4.0, PI / 3.0, PI / 2.0
    ).forEach { p ->
        val t1 = sin(p) / cos(p) // tangente = sin/cos
        val t2 = tan(p)
        println(
            String.format(
                "%.5f, %.5f,\n%.5f, %.5f,\n%.5f, %.5f\n",
                t1,
                t2,
                atan(t1),
                atan(t2),
                Math.toDegrees(atan(t1)),
                Math.toDegrees(atan(t2)),
            )
        )
    }


}


fun main() {
    //checkConvertion()
    //checkAtan()
    checkArcTangent()
}