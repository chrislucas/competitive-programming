package com.br.cp.algebra.number.systems

import java.math.BigInteger

typealias BigInt = BigInteger

infix fun BigInt.mod(value: String): BigInt = this.mod(BigInt(value))

fun String.toBigInt(): BigInt = BigInt(this)

val BigInt.binary: String
    get() {
        var value = this
        val buffer = StringBuilder()

        while (value > BigInt.ZERO) {
            buffer.append(value mod "2")
            value = value shr 1
        }

        return buffer.toString().reversed()
    }


private fun test() {
    println("1023".toBigInt().binary)
    println("127".toBigInt().binary)
    println("128".toBigInt().binary)
}


fun main() {
    test()
}