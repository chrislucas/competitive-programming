package com.br.cp.exts

fun <T> Array<T>.log(): String {
    return StringBuffer().run buffer@{
        var first = true
        this.append("[")
        for (v in this@log) {
            if (!first) {
                this.append(", $v")
            } else {
                this.append(v)
            }
            first = false
        }
        this.append("]")
        this.toString()
    }
}