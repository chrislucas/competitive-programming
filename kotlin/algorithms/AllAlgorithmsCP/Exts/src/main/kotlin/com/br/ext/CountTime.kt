package com.br.ext


fun <R> countTime(fn: () -> R): Pair<Long, R> {
    val start = System.currentTimeMillis()
    return Pair(System.currentTimeMillis() - start, fn())
}
