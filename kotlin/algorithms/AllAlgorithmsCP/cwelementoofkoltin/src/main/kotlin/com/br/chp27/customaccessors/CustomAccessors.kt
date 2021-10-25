package com.br.chp27.customaccessors


class WrapperInt {
    var value: Int = 0
        get() {
            return if (field > 0) 1 else 0
        }
        set(value) = if (value > 127) {
            throw IllegalArgumentException("$value > 127")
        } else {
            field = value
        }
}

val pair = mapOf("A" to 1)

val checkPair: Int?
        get() = pair["a"]



