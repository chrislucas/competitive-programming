package com.br.algo

fun Int.binary() : String {
    var c = this
    val buffer = StringBuilder()
    while (c > 0) {
        buffer.append(if(c and 1 == 1) "1" else "0")
        c = c shr 1
    }
    return buffer.reverse().toString()
}