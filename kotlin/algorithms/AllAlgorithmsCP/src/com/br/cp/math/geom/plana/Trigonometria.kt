package src.com.br.cp.math.geom.plana

import java.lang.StringBuilder
import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.tan

/*
    https://www.todamateria.com.br/funcoes-trigonometricas/
 */

val Double.fromDegreeToRadian: Double
    get() =  this * PI / 180.0

val Double.fromRadianRoDegree: Double
    get() = this * 180.0 / PI


val Int.fromDegreeToRadian: Double
    get() = this * 1.0 * PI / 180.0

val Int.fromRadianRoDegree: Double
    get() = this * 1.0 * 180.0 / PI

private fun checkTangentFunction() {
    fun transform(i: Int): String {
        val radians = i.fromDegreeToRadian
        return "Tan($i:Graus) | $radians:Radianos | ${tan(radians)} | ${radians.fromRadianRoDegree}"
    }

    val s = (0..360).joinTo(StringBuilder(), "\n", transform = ::transform)
    println(s)
}


private fun checkSineFunction() {
    fun transform(i: Int): String {
        val radians = i.fromDegreeToRadian
        return "Seno($i:Graus) | $radians:Radianos | ${sin(radians)}"
    }

    val s = (0..360).joinTo(StringBuilder(), "\n", transform = ::transform)
    println(s)
}

private fun checkCosFunction() {
    fun transform(i: Int): String {
        val radians = i.fromDegreeToRadian
        return "Cosseno($i:Graus), $radians:Radianos, ${sin(radians)}"
    }
    val s = (0..360).joinTo(StringBuilder(), "\n", transform = ::transform)
    println(s)
}

/*
    Funcoes Inversas
    http://www.uel.br/projetos/matessencial/basico/trigonometria/trigo08.html
    https://pt.wikipedia.org/wiki/Fun%C3%A7%C3%B5es_trigonom%C3%A9tricas_inversas
 */



fun main() {
    checkTangentFunction()
}