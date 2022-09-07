package src.com.br.cp.math.geom.cp.library.trigonometry

import src.com.br.cp.math.geom.cp.library.trigonometry.FuncaoTrigonometrica.allAnglesSin
import src.com.br.kotlin.range.step
import java.lang.Math.toDegrees
import java.lang.Math.toRadians
import kotlin.math.*

/*
    https://pt.wikipedia.org/wiki/Trigonometria
    https://en.wikipedia.org/wiki/Inverse_trigonometric_functions
 */

private object FuncaoTrigonometrica {
    /*
        tan(x) = sen(x)/cos(x)
        dominio: -pi/2 e pi/2
        tan(x) = cateto oposto / cateto adjacente
     */
    fun imageTangentFun() {
        val p = -PI / 2.0
        val q = PI / 2.0
        for (x in p..q step .01) {
            println(
                String.format(
                    "Radians: %.5f, Degree %.5f | Tan(%.5f) = %.5f or %.5f",
                    x, toDegrees(x), x, tan(x), sin(x) / cos(x)
                )
            )
        }
    }

    fun allAnglesTan() {
        for (x in 0.0..360.0 step 1.0) {
            println(
                String.format(
                    "Radians: %.5f, Degree %.5f | Sin(%.5f) = %.5f", toRadians(x), x, x, tan(toRadians(x))
                )
            )
        }
    }

    fun testTan() = "%.5f, %.5f".format(PI / 4.0, tan(PI / 4.0))

    /*
        reta dos senos = abscissa
        sin(x) = cateto oposto / hipotenusa
        No circulo trigonometrico, o seno de um angulo pode ser visuzalizado
        na projecao do seu raio (= 1) sobre o eixo da vertical (abscissa)
        imagem = [-1, 1]
     */

    fun allAnglesSin() {
        val message = (0.0..360.0 step 1.0).joinToString(separator = "\n") { x ->
            "Radians: %.5f, Degree %.5f | Sin(%.5f) = %.5f".format(toRadians(x), x, x, sin(toRadians(x)))
        }

        println(message)
    }

    /*
        reta oss cossenos = ordenada
        https://pt.wikipedia.org/wiki/Trigonometria
        cos(x) = cateto adjancete / hipotenusa
     */

    fun allAnglesCossine() {
        val message = (0.0..360.0 step 1.0).joinToString(separator = "\n") { x ->
            "Radians: %.5f, Degree %.5f | Cossine(%.5f) = %.5f".format(toRadians(x), x, x, cos(toRadians(x)))
        }
        println(message)
    }
}

private object FuncaoTrigonometricaInversa {

    fun domainArcTangentFun() {
        fun checkAtan(r: Double) {
            println(
                "Radian = %.5f, Tan = %.5f,  Atan = %.5f, AtanDegree = %.5f".format(
                    PI / r,
                    tan(PI / r),
                    atan(tan(PI / r)),
                    toDegrees(atan(tan(PI / r)))
                )
            )
            println("****************************************************************")
        }

        checkAtan(2.0)
        checkAtan(3.0)
        checkAtan(4.0)
        checkAtan(6.0)

        fun tryArctan() {
            val q = PI / 2.0
            val p = -q
            for (x in p..q step .1) {
                println(
                    "Radians: %.5f, Tan: %.5f, ArcTan: %.5f, ArcTanDegree: %.5f".format(
                        x,
                        tan(x),
                        atan(tan(x)),
                        toDegrees(atan(tan(x)))
                    )
                )
            }
        }
    }

}


fun main() {
    //domainArcTangentFun()
    allAnglesSin()
}