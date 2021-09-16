package com.br.algo.integer.bitwise

val Int.rangeBits: IntRange
    get() {
        var range = 0..1
        for (i in 1 until this) {
            range = range.last + 1 until (1 shl i + 1)
        }
        return range
    }


fun main() {
    println(3.rangeBits)
    println(4.rangeBits)
    println(10.rangeBits)
}