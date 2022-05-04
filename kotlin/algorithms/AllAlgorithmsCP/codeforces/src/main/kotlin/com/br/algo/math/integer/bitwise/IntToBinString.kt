package com.br.algo.math.integer.bitwise

import kotlin.math.log2

val Int.binaryString: String
    get() {
        var value = this
        val buffer = StringBuilder()
        while (value > 0) {
            buffer.append(value % 2)
            value = value shr 1
        }

        fun countBinaryDigits(value: Int) = log2(value * 1.0).toInt() + 1

        fun nextPowerOf2(mValue: Int): Int {
            var value = mValue
            value -= 1
            value = value or (value shr 1)
            value = value or (value shr 2)
            value = value or (value shr 4)
            value = value or (value shr 8)
            value = value or (value shr 16)
            return value + 1
        }

        val next = nextPowerOf2(this)
        return if (buffer.length == countBinaryDigits(next)) {
            buffer.toString().reversed()
        } else {
            val zeros = StringBuilder()
            repeat(countBinaryDigits(next) - countBinaryDigits(this)) {
                zeros.append("0")
            }
            zeros.append(buffer.toString().reversed()).toString()
        }
    }