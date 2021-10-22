package com.br.chp40.inline.prop

class KeyValue<K, V>(val key: K, var value: V) {
    operator fun get(k: K): V? =
        if (key == k) {
            value
        } else {
            null
        }

    operator fun set(k: K, value: V) {
        if (key == k) {
            this.value = value
        }
    }
}

val pair = KeyValue("a", 1)

var value: Int?
    inline get() = pair["a"]

    inline set(value) {
        if (value != null) {
            pair["a"] = value
        }
    }


private fun checkInlineOperator() {
    value = 10
    println(value)
    println(pair)
}

fun main() {
    checkInlineOperator()
}