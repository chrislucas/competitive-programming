package com.br.cp

fun <T> simpleCounterTime(fn:  () -> T): Pair<T, Long> = run {
    val start = System.currentTimeMillis()
    val r = fn()
    Pair(r, System.currentTimeMillis() - start)
}