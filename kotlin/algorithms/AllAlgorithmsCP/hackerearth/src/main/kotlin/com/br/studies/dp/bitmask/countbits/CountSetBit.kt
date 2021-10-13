package com.br.studies.dp.bitmask.countbits

val Int.countSetBits: Int
    get() {
        var counter = 0
        var copy = this
        while (copy > 0) {
            copy = copy and (copy - 1)
            counter += 1
        }
        return counter
    }


fun main() {
    (0 .. (1 shl 7)).forEach {
        println("$it: ${it.countSetBits}")
    }
}