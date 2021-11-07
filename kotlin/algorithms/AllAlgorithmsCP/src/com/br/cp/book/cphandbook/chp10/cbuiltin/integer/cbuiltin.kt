package src.com.br.cp.book.cphandbook.chp10.cbuiltin

import src.com.br.cp.book.cphandbook.chp10.shift.isSet

/**

Competitive Programmer’s Handbook
Antti Laaksonen
Draft July 3, 2018

 * */

fun Int.unsetRightMostSetBit() =  this and (this - 1)

// count leading zeros
// https://blog.stephencleary.com/2010/10/implementing-gccs-builtin-functions.html
val Int.clz: Int
    get() {
        var y = 0
        var copy = this
        var bits = 32

        y = copy shr 16
        if (y != 0) {
            bits -= 16
            copy = y
        }
        y = copy shr 8
        if (y != 0) {
            bits -= 8
            copy = y
        }
        y = copy shr 4
        if (y != 0) {
            bits -= 4
            copy = y
        }
        y = copy shr 2
        if (y != 0) {
            bits -= 2
            copy = y
        }
        y = copy shr 1
        if (y != 0) {
           return bits - 2
        }
        return bits - copy
    }

fun Int.clz(): Int {
    var y = 0
    var copy = this
    var bits = 32
    var start = 16
    while (start > 0) {
        y = copy shr start
        if (y != 0) {
            if (start == 1) {
                return bits - 2
            }
            bits -= start
            copy = y
        }
        start = start shr 1
    }

    return bits - copy
}

// FONTE: https://blog.stephencleary.com/2010/10/implementing-gccs-builtin-functions.html
// counting trailing zeros
val Int.ctz: Int
    get() {
        var n = 1
        var copy = this
        if (copy and 0xFFFF == 0) {
            n += 16
            copy = copy shr 16
        }

        // FFFF shr 8
        if (copy and 0xFF == 0) {
            n += 8
            copy = copy shr 8
        }

        // FF shr 4
        if (copy and 0xF == 0) {
            n += 4
            copy = copy shr 4
        }

        // F shr 2
        if (copy and 0x3 == 0) {
            n += 2
            copy = copy shr 2
        }

        return n - (copy and 1)
    }

fun Int.ctz(): Int {
    var offset = 16
    var n = 1
    var copy = this
    var param = 0xFFFF
    while (offset > 1) {
        if (copy and param == 0){
            n += offset
            copy = copy shr offset
        }
        offset = offset shr 1
        param = param shr offset
    }

    return n - (copy and offset)
}

// contar quantos bits 1 um numero tem
val Int.popcount: Int
    get() {
        var acc = 0
        var copy = this
        while (copy > 0) {
            copy = copy and (copy - 1)
            acc += 1
        }
        return acc
    }


val Int.parityInfo: Pair<Int, Int>
    get() {
        return Pair(0,0)
    }

/**
 * Se o numero possuir uma quantidade de bits 1 impares retornar true senao false
 * */
val Int.parity: Boolean
    get() {
        var copy = this
        var answer = false
        while (copy > 0) {
            copy = copy and (copy - 1)
            answer = !answer
        }
        return answer
    }

val Int.binaryString: String
    get() {
        val builder = StringBuilder()
        for (i in 31 downTo 0) {
            builder.append(if (this isSet i) "1" else "0")
        }
        return builder.toString()
    }

private fun checkpopcount() {
    (0 .. 1024).forEach {
        println("$it ${it.popcount}")
    }
}

private fun checkparity() {
    (0 .. 15).forEach {
        println("$it: parity: ${it.parity}")
    }
}

private fun checkCountLeadingZerosPropAndFunc() {

    var (p, k) = arrayOf(1, 0)
    while (k <= 31) {
        p = if (k < 31) 1 shl k else (1 shl k) - 1
        println("$p|$k: ${p.clz} | ${p.clz()} | ${p.binaryString}")
        k += 1
    }

    /*
        for (i in (3..(1 shl 10))) {
            println("$i: ${i.clz} | ${i.clz()} | ${i.binaryString} ")
        }
     */
}

private fun checkCountTrailingZerosPropAndFunc() {
    var (p, k) = arrayOf(1, 0)
    while (k <= 31) {
        p = if (k < 31) 1 shl k else (1 shl k) - 1
        println("$p|$k: ${p.ctz} | ${p.ctz()} | ${p.binaryString}")
        k += 1
    }

    /*
        for (i in (3..(1 shl 15)) step (1 shl i)){
            println("$i: ${i.ctz} | ${i.ctz()} | ${i.binaryString}")
        }
     */
}


fun main() {
    //checkparity()
    //checkCountLeadingZerosPropAndFunc()
    checkCountTrailingZerosPropAndFunc()
}