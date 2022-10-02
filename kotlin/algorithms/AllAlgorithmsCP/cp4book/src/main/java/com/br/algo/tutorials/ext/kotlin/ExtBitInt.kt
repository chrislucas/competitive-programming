package com.br.algo.tutorials.ext.kotlin

import java.math.BigInteger

typealias BigInt = BigInteger

fun modularMultiply(a: BigInt, b: BigInt, m: BigInt) = (a % m * b % m) % m


fun main() {

}