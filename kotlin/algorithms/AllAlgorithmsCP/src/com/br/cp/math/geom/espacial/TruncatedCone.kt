package src.com.br.cp.math.geom.espacial

import kotlin.math.PI
import kotlin.math.sqrt

/*
    https://mundoeducacao.uol.com.br/matematica/cone.htm
    https://www.somatematica.com.br/emedio/espacial/espacial22_2.php
    https://mundoeducacao.uol.com.br/matematica/tronco-de-cone.htm
    https://www.ck12.org/book/ck-12-middle-school-math-concepts-grade-8/section/8.9/

    area lateral e total de um tronco de um cone
    https://www.somatematica.com.br/emedio/espacial/espacial22_2.php

 */

object TruncatedCone {

    // calculadora: https://keisan.casio.com/exec/system/1223372110

    // (PI * h  / 3 * R¨2 + r¨2 + Rr
    fun volume(raioMenor: Double, raioMaior: Double, h: Double) =
        (PI * h / 3.0) * (raioMaior * raioMaior + raioMaior * raioMenor + raioMenor * raioMenor)

    // PI * (r + R) * geratriz(r, R, h) => PI * (r+R) * g
    fun lateralArea(raioMenor: Double, raioMaior: Double, h: Double) =
        PI * (raioMenor + raioMaior) * sqrt((raioMenor - raioMaior) * (raioMenor - raioMaior) + h*h)

    //  LA(r, R, h) + PI * R^2 + r^2 => PI * (rr + RR + g * (R+r))
    fun surfaceArea(raioMenor: Double, raioMaior: Double, h: Double) =
        lateralArea(raioMenor, raioMaior, h) + PI * (raioMaior*raioMaior + raioMenor*raioMenor)

    //  PI * (rr + RR + g * (R+r))
    fun anotherWaySurfaceArea(raioMenor: Double, raioMaior: Double, h: Double):Double {
        val g = sqrt((raioMaior - raioMenor) * (raioMaior - raioMenor) + h*h)
        return PI * (raioMenor*raioMenor + raioMaior*raioMaior + g * (raioMaior+raioMenor))
    }


    // https://www.ck12.org/book/ck-12-middle-school-math-concepts-grade-8/section/8.9/
    // surfaceArea
    // s = slantHeight
    // PI [s * (R + r) + R^2 + r^2]
    fun surfaceAreaWithSlantHeight(raioMenor: Double, raioMaior: Double, s: Double) =
        PI * (s * (raioMaior + raioMenor) + raioMaior*raioMaior + raioMenor*raioMenor)

    // novamente pitagora g^2 = (R-r)^2 + h^2 =>  g = sqrt((R-r)^2 + h^2)
    fun geratriz(raioMenor: Double, raioMaior: Double, h: Double) =
        sqrt((raioMaior - raioMenor) * (raioMaior - raioMenor) + h*h)

    fun altura(raioMenor: Double, raioMaior: Double, g: Double)
        = sqrt(g*g - (raioMaior - raioMenor) * (raioMaior - raioMenor))
}

data class DataTruncatedCone(val raioMenor: Double, val raioMaior: Double, val  h: Double) {
    val volume: Double
        get() =   (PI * h / 3.0) * (raioMaior * raioMaior + raioMaior * raioMenor + raioMenor * raioMenor)

    val lateralArea: Double
        get() =  PI * (raioMenor + raioMaior) * sqrt((raioMenor - raioMaior) * (raioMenor - raioMaior) + h * h)

    val surfaceArea: Double
        get() = lateralArea + PI * (raioMaior*raioMaior + raioMenor*raioMenor)

    val g: Double
        get() = sqrt((raioMaior - raioMenor) * (raioMaior - raioMenor) + h*h)

    override fun toString(): String = "(V: $volume, Area Lateral: $lateralArea, Surface Area: $surfaceArea), G: $g"
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

private fun checkArray() {
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

private fun check() {
    val (maior, menor, s) = arrayOf(6.0, 8.0, 6.0)
    println(TruncatedCone.surfaceAreaWithSlantHeight(menor, maior, s))
    println(TruncatedCone.geratriz(5.0, 13.0, 6.0))
    println(TruncatedCone.altura(5.0, 13.0, 10.0))
}

private fun checkFormulaSurfaceAreaAndVolume() {
    /*
    Exemplo em: https://mundoeducacao.uol.com.br/matematica/tronco-de-cone.htm
 */
    println(TruncatedCone.surfaceArea(6.0, 14.0, 15.0))
    println(TruncatedCone.anotherWaySurfaceArea(6.0, 14.0, 15.0))
/*
    Exemplo em: https://mundoeducacao.uol.com.br/matematica/tronco-de-cone.htm
 */
    println(TruncatedCone.volume(6.0, 14.0, 15.0))

}

/*
    Planificacao do tronco de um cone
    a estrutura e dado por
    r: raio menor
    R: raio maior
    g: geratriz
    Podemos calcular a altura do Cone a partir dessas informacoes
    usando pitagoras
    g^2 = (R-r)^2 + h^2
    h^2 = g^2 - (R-r)^2
    h = sqrt( (R-r) * (R-r) - (g*g) )
 */

private fun checkHeight() {
    // Questao 1 espcex
    println(TruncatedCone.altura(6.0, 11.0, 13.0))
}

fun main() {
    //checkFormulaSurfaceAreaAndVolume()
    checkHeight()
}