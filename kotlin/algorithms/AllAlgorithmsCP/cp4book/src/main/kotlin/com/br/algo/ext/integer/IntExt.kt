package com.br.algo.ext.integer

import java.lang.StringBuilder

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