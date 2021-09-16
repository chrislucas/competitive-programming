package com.br.algo.integer.bitwise

import java.lang.IllegalArgumentException

val Int.rangeBits: IntRange
    get() {
        return if (this < 31) {
            if(this < 2) 0 .. 1 else (1 shl this - 1) until (1 shl this)
        }
        else if (this == 31) {
            (1 shl this - 1) until (1 shl this) - 1
        }
        else {
            throw IllegalArgumentException("")
        }
    }


fun main() {
    for (bits in 1 .. 31) {
        println("Bits: $bits, Range: ${bits.rangeBits}")
    }

}