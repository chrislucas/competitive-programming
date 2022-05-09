package com.br.algo.math


import java.math.BigInteger
import java.util.*


typealias BigInt = BigInteger



fun ClosedRange<BigInt>.randomBigInt() {

}

fun randomBigInt(p: BigInt, q: BigInt) {
    BigInt(p.bitCount(), Random(System.currentTimeMillis())) % q + p
}

fun main() {

    repeat(100) {

    }
}