package com.br.studies.dp.bitmask.func

import java.lang.StringBuilder
import kotlin.math.log10

fun not(i: Int) = i.inv()

fun complement2(i: Int) = not(not(i)) + 1

infix fun Int.set(nth: Int) = this or (1 shl nth)

// x unset y => x and ~(1 shl y) ou x & not(1 shl y)
infix fun Int.unset(nth: Int) = this and not(1 shl nth)

infix fun Int.toggle(nth: Int) = this xor (1 shl nth)

infix fun Int.isSet(nth: Int) = this and (1 shl nth) > 0

val Int.quantityBits: Int
    get() = ((log10(this * 1.0) / log10(2 * 1.0)) + 1).toInt()

val Int.rangeBits: IntRange
    get() = 0 until quantityBits


fun table(k: Int): String {
    val limit = (1 shl k) - 1
    val buffer = StringBuilder()
    for (i in 0..limit) {
        val acc = StringBuilder()
        for (j in k - 1 downTo 0) {
            acc.append(if (i isSet j) "1" else "0")
        }
        buffer.append(if (i == 0) "$acc" else "\n$acc")
    }
    return buffer.toString()
}

val <T> Array<T>.allSubsets: List<List<T>>
    get() {
        val size = this.size
        val limit = (1 shl size) - 1
        val set = mutableListOf<MutableList<T>>()
        for (i in 0 .. limit) {
            val subset = mutableListOf<T>()
            for (j in 0 until size) {
                if (i isSet j) {
                    subset.add(this[j])
                }
            }
            set.add(subset)
        }
        return set
    }

private fun checkSet() {
    println(8 set 1)
    println(8 set 0)
    println(10 set 0)
}

private fun checkUnset() {
    println(10 unset 3)
    println(7 unset 2)
    println(7 unset 2 unset 0)
}

private fun checkToggle() {
    println(10 toggle 0)
    println(7 toggle 2)
}

private fun checkInv() {
    (1..31).forEach {
        val p = if (it > 30) (1 shl it) - 1 else 1 shl it

        println(
            "$it ->\n2 ^ $it: $p\n" +
                    "not(2 ˆ $it):${not(p)}\n" +
                    "complement of 2 ($it): ${complement2(it)}\n" +
                    "complement of 2 (2 ^ $it): ${complement2(p)}\n"
        )
    }
}

private fun checkIsSet() {
    println(4 isSet 2)
    arrayOf(10, 15).forEach { n ->
        println("$n, bits: ${n.rangeBits}")
        n.rangeBits.forEach { nth ->
            println(n isSet nth)
        }
    }
}

private fun checkIsSet2() {

}

fun main() {
    //checkUnset()
    //checkInv()
    //checkIsSet()
    //println(table(3))
}