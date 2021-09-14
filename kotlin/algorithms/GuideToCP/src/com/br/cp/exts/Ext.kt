package com.br.cp.exts

fun <T> timeSpentInSeconds(exec: () -> T): Double {
    val s = System.currentTimeMillis()
    exec()
    return (System.currentTimeMillis() - s) / 1000.0
}

fun Double.show(format: String) = println(String.format(format, this))