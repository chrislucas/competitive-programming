package com.br.algo.math.lib.algebra

fun gdcLong(a: Long, b: Long): Long {
    var aa = a
    var bb = b
    while (aa % bb != 0L) {
        val aux = bb
        bb = aa % aux
        aa = aux
    }
    return bb
}

fun gcdInt(a: Int, b: Int): Int {
    var aa = a
    var bb = b
    while (aa % bb != 0) {
        val aux = bb
        bb = aa % aux
        aa = aux
    }
    return bb
}

fun gcdLong2(a: Long, b: Long): Long {
    return if (a % b == 0L) b else gcdLong2(b, a % b)
}


fun Array<Int>.gdcInt(): Int {
    fun gcdInt(a: Int, b: Int): Int {
        var aa = a
        var bb = b
        while (aa % bb != 0) {
            val aux = bb
            bb = aa % aux
            aa = aux
        }
        return bb
    }

    return if (size > 1) {
        var acc = gcdInt(this[0], this[1])
        for (i in 2 until size) {
            acc = gcdInt(acc, this[i])
        }
        acc
    } else {
        0
    }
}


// https://kotlinlang.org/docs/extensions.html#extension-properties
val Array<Int>.gdc: Int
    get() {
        fun gcdInt(a: Int, b: Int): Int {
            var aa = a
            var bb = b
            while (aa % bb != 0) {
                val aux = bb
                bb = aa % aux
                aa = aux
            }
            return bb
        }

        return if (size > 1) {
            this.slice(1 until size)
                .fold(this[0]) { acc, i -> gcdInt(acc, i) }
        } else {
            0
        }
    }

val Array<Int>.lcmInt: Int
    get() {
        fun gcdInt(a: Int, b: Int): Int {
            var aa = a
            var bb = b
            while (aa % bb != 0) {
                val aux = bb
                bb = aa % aux
                aa = aux
            }
            return bb
        }
        return if (size > 1) {
            this.slice(1 until size)
                .fold(this[0]) { acc, i -> acc * i / gcdInt(acc, i) }
        } else {
            0
        }
    }



