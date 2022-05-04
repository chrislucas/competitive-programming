package com.br.algo.math.integer.bitwise

val Int.toBinary: String
    get() {
        var value = this
        val buffer = StringBuilder()
        while (value > 0) {
            buffer.append(value % 2)
            value = value shr 1
        }
        return buffer.toString().reversed()
    }