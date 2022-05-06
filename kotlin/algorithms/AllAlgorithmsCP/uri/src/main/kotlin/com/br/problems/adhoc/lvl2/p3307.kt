package com.br.problems.adhoc.lvl2

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.math.sqrt

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/3307
 * */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


/**
 *
 * r < 12 VER
 * <= 12 r < 15 AZUL
 * r > 15 AMARELO
 *
 * cm quadrado de vermelho .09
 * cm quadrado de azul .07
 * cm quadrado de amarelol .05
 * */

fun main(args: Array<String>) {
    // TODO acertar esse algoritmo
    val PI = 3.14
    val decimalFormat = DecimalFormat("#########.##")
    decimalFormat.decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ENGLISH)
    testCases(readValue(String::toInt)) {
        val area = readValue { it.toInt() }
        val r = sqrt(area / (4 * PI))
        when {
            r < 12.0 -> {
                println("vermelho = %s".format(decimalFormat.format(area * .09)))
            }
            r >= 12.0 && r < 15.0 -> {
                println("azul = %s".format(decimalFormat.format(area * .07)))
            }
            else -> {
                println("amarelo = %s".format(decimalFormat.format(area * .05)))
            }
        }
    }
}
