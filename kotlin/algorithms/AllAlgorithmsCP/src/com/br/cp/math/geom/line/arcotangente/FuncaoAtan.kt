package src.com.br.cp.math.geom.line.arcotangente

import kotlin.math.atan
import kotlin.math.tan

/*
    https://www.geeksforgeeks.org/java-atan-method-examples/
    funcao atan (arcotangente) retorna
 */


private fun Double.toRadian() = this * Math.PI / 180.0

private fun Double.toDegree() = this * 180.0 / Math.PI

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
    var p = -Math.PI / 2.0
    val q = -p
    while (p <= q) {
        println("Radians: $p | Degree: ${Math.toDegrees(p)} | " +
                "ArcoTangente: ${atan(p)} _ ${Math.toDegrees(atan(p))} | " +
                "Tangente: ${tan(p)}")
        p += 0.1
    }
}


fun main() {
    //checkConvertion()
    checkAtan()
}