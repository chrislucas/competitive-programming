package com.br.algo

import java.lang.StringBuilder
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


/**
 * https://www.baeldung.com/java-decimalformat
 *
 * Special Pattern Characters
 * 0 - Imprime um digito se existir ou 0
 * # - Imprime um digito se existir ou nada do contrario
 * . - indica onde por o separador decimal
 * , - indica onde pot o separador de grupo
 *
 * */


private val constant = arrayOf(
    23.45,
    23.0,
    3243223.0,
    3243223.55,
    3243223.73,
    232312.23,
    3243223.73,
    123243223.73,
    999999999.73,
    999999999999.73,
    -999999999999.73,
    Double.MAX_VALUE,
    Double.MIN_VALUE,
    Double.MIN_VALUE + 1.0,
    4.9E-23,
    4.9E-7,
    4.9E-70,
    1 / 4.0,
    1 / 60.0,
)

private fun test1() {
    val decimalFormatSymbols = DecimalFormatSymbols()
    decimalFormatSymbols.decimalSeparator = '.'
    val decimalFormat = DecimalFormat("#.0#", decimalFormatSymbols)
    println("test1")
    constant.forEach {
        println(decimalFormat.format(it))
    }
}


private fun test2() {
    val decimalFormat = DecimalFormat("#,###.0#")
    println("test2")
    constant.forEach {
        println(decimalFormat.format(it))
    }
}

fun test3() {
    val decimalFormatSymbols = DecimalFormatSymbols()
    decimalFormatSymbols.decimalSeparator = '.'
    val decimalFormat = DecimalFormat("#,##0.0#", decimalFormatSymbols)
    println("test 3")
    constant.forEach {
        println(decimalFormat.format(it))
    }
}


fun test4() {
    val decimalFormatSymbols = DecimalFormatSymbols()
    decimalFormatSymbols.decimalSeparator = '.'
    val decimalFormat = DecimalFormat("+#,##0.0#;-#", decimalFormatSymbols)
    println("test 4")
    constant.forEach {
        println(decimalFormat.format(it))
    }
}


fun decimalPrecision(places: Int): String =
    (0 .. places).run {
        val str = StringBuilder()
        repeat(last - first) {
            str.append("#")
        }
        str.toString()
    }


fun test5() {
    val decimalFormatSymbols = DecimalFormatSymbols()
    decimalFormatSymbols.decimalSeparator = '.'
    val decimalFormat = DecimalFormat(
        "+#,##0.0${decimalPrecision(90)};-#",
        decimalFormatSymbols
    )
    println("test 4")
    constant.forEach {
        println(decimalFormat.format(it))
    }
}


fun main(args: Array<String>) {

    test5()
}