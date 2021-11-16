package src.com.br.cp.math.geom.espacial

import kotlin.math.PI
import kotlin.math.sqrt

/*
    https://mundoeducacao.uol.com.br/matematica/cone.htm
    https://www.somatematica.com.br/emedio/espacial/espacial22_2.php
    https://mundoeducacao.uol.com.br/matematica/tronco-de-cone.htm

 */

object TruncatedCone {

    // calculadora: https://keisan.casio.com/exec/system/1223372110

    // (PI * h  / 3 * R¨2 + r¨2 + Rr
    fun volume(raioMenor: Double, raioMaior: Double, h: Double) =
        (PI * h / 3.0) * (raioMaior * raioMaior + raioMaior * raioMenor + raioMenor * raioMenor)

    fun lateralArea(raioMenor: Double, raioMaior: Double, h: Double) =
        PI * (raioMenor + raioMaior) * sqrt((raioMenor - raioMaior) * (raioMenor - raioMaior) + h*h)

    fun surfaceArea(raioMenor: Double, raioMaior: Double, h: Double) =
        lateralArea(raioMenor, raioMaior, h) + PI * (raioMaior*raioMaior + raioMenor*raioMenor)
}

data class DataTruncatedCone(val raioMenor: Double, val raioMaior: Double, val  h: Double) {
    val volume: Double
        get() =   (PI * h / 3.0) * (raioMaior * raioMaior + raioMaior * raioMenor + raioMenor * raioMenor)

    val lateralArea: Double
        get() =  PI * (raioMenor + raioMaior) * sqrt((raioMenor - raioMaior) * (raioMenor - raioMaior) + h * h)

    val surfaceArea: Double
        get() = lateralArea + PI * (raioMaior*raioMaior + raioMenor*raioMenor)

    override fun toString(): String = "(V: $volume, Area Lateral: $lateralArea, Surface Area: $surfaceArea)"
}


private fun checkVolumeTroncoCone(raioMenor: Double, raioMaior: Double, h: Double) {
    println(TruncatedCone.volume(raioMenor, raioMaior, h))
}

private fun checkLateralTroncoCone(raioMenor: Double, raioMaior: Double, h: Double) {
    println(TruncatedCone.lateralArea(raioMenor, raioMaior, h))
}

private fun checkSuperficieTroncoCone(raioMenor: Double, raioMaior: Double, h: Double) {
    println(TruncatedCone.surfaceArea(raioMenor, raioMaior, h))
}

private fun checkDataTruncatedCone(raioMenor: Double, raioMaior: Double, h: Double) {
    println(DataTruncatedCone(raioMenor, raioMaior, h))
}



fun main() {

    arrayOf(
        DataTruncatedCone(1.0, 2.0, 3.0),
        DataTruncatedCone(11.0, 10.0, 30.0),
        DataTruncatedCone(5.0, 10.0, 30.0),
        DataTruncatedCone(2.0, 1.0, 3.0)
    ).forEach {
        val (rMenor, rMaior, h) = it
        checkVolumeTroncoCone(rMenor, rMaior, h)
        checkLateralTroncoCone(rMenor, rMaior, h)
        checkSuperficieTroncoCone(rMenor, rMaior, h)
        checkDataTruncatedCone(rMenor, rMaior, h)
        println("************************************************")
    }


}