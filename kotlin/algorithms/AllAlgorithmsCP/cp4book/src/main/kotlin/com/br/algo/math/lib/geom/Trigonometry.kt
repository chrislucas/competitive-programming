package com.br.algo.math.lib.geom

import com.br.algo.BigDec
import java.lang.StringBuilder
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

val Double.fromDegreeToRadian: Double
    get() = this * PI / 180.0

val Double.fromRadianRoDegree: Double
    get() = this * 180.0 / PI


val Int.fromDegreeToRadian: Double
    get() = this * 1.0 * PI / 180.0

val Int.fromRadianRoDegree: Double
    get() = this * 1.0 * 180.0 / PI

/*
    Circulo trigonometrico
    https://www.todamateria.com.br/circulo-trigonometrico/

    Reta das ordenadas - SENO (y) - ORDENADA esta para o CO
    Reta das abcissas - COSSENO (x) - ABSCISSA esta para CA
    Reta perpendicular a abscissas - TANGENTE
    Reta perpendicular a ordenada acima do circulo - COTANGENTE

    Continuacao da hipotenusa - SECANTE
    A secante se encontra num ponto com a tangente

    TANGENTE = CA / CO
    SENO = CO / HP
    COSSENO = CA / HP

    COT = COS / SEN
    COSS = 1 / SEN
    SEC = 1 / COS

 */

// https://www.todamateria.com.br/funcoes-trigonometricas/

/*
    Funcoes periodicas
    Funcoes que possuem um comportamento de periodo, seus valores
    occrrem em determinados intervalos de tempo


    Uma uncao f: A -> B eh periodica
    se existir um numero real positivo p tal que

    f(x) = f(x + p), para tod0 x exustente em A
 */


/**
 * Funcao Tangente
 */

private fun checkTangentFunction() {
    fun transform(i: Int): String {
        val radians = i.fromDegreeToRadian
        return "Tan($i) | $radians:Radianos | ${tan(radians)} | ${radians.fromRadianRoDegree}"
    }

    val s = (0..360).joinTo(StringBuilder(), "\n", transform = ::transform)
    println(s)
}

/*
    Funcao seno.
    Funcao periodo onde p = 2PI
    f(x) = sen x
    sen x é positivo nos quadrantes 1,2 e negativo no 3,4

    O eixo das ordenadas é o do seno.
    Conforme o
 */

private fun checkSinFunction() {
    fun transform(i: Int): String {
        val radians = i.fromDegreeToRadian
        val inRadian = sin(radians)
        val toDegree = inRadian.fromRadianRoDegree
        return "Sin($i) | $radians:Radianos | $inRadian | $toDegree | ${radians.fromRadianRoDegree}"
    }

    val s = (0..360).joinTo(StringBuilder(), "\n", transform = ::transform)
    println(s)
}

/*
    Funcao cosseno
 */

private fun checkCosineFunction() {
    fun transform(i: Int): String {
        val radians = i.fromDegreeToRadian
        return "Cos($i) | $radians:Radianos | ${cos(radians)} | ${radians.fromRadianRoDegree}"
    }

    val s = (0..360).joinTo(StringBuilder(), "\n", transform = ::transform)
    println(s)
}

// FUNCOES INVERSAS
// https://pt.wikipedia.org/wiki/Fun%C3%A7%C3%B5es_trigonom%C3%A9tricas_inversas#


fun main() {
    checkSinFunction()
}