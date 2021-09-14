package com.br.algorithms.ext

import java.lang.StringBuilder

val <T> Array<T>.string: String
    get() {
        val buffer = StringBuilder()
        this.forEachIndexed { i, value ->
            if (i > 0) {
                buffer.append(", $value")
            } else {
                buffer.append("$value")
            }
        }
        return buffer.toString()
    }