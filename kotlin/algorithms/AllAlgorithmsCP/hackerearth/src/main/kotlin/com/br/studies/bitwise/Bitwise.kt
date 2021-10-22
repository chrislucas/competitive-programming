package com.br.studies.bitwise

infix fun Int.set(nth: Int) = this or (1 shl nth)

private infix fun Int.isSet(nth: Int) = this and (1 shl nth) > 0

fun not(i: Int) = i.inv()

fun complement2(i: Int) = not(not(i)) + 1

// x unset y => x and ~(1 shl y) ou x & not(1 shl y)
infix fun Int.unset(nth: Int) = this and not(1 shl nth)

infix fun Int.toggle(nth: Int) = this xor (1 shl nth)

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