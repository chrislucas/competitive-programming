package com.br.algo.integer.bitwise

import java.math.BigInteger

typealias BigInt = BigInteger

infix fun BigInt.until(other: BigInt): ClosedRange<BigInt> = this..(other - BigInt.ONE)

val BigInt.rangeBit: ClosedRange<BigInt>
    get() {
        return if (this < BigInt("2")) {
            BigInt.ZERO..BigInt.ONE

        } else {
            BigInt.ONE.shl((this - BigInt.ONE).toInt())..BigInt.ONE.shl(this.toInt())
        }
    }


val Int.rangeBit: ClosedRange<BigInt>
    get() {
        return if (this < 2) {
            BigInt.ZERO..BigInt.ONE

        } else {
            BigInt.ONE.shl((this - 1).toInt()) until BigInt.ONE.shl(this.toInt())
        }
    }