package com.br.algo

private infix fun String.naiveReorder(target: String): Pair<String, Int> {

    if (target.length != this.length) {
        return Pair("", 0)
    }

    for (i in target.indices) {
        if (!this.contains(target[i]))
            return Pair("", 0)
    }

    val map = this.mapIndexed { idx, chr -> chr to idx }
        .associate { it }

    var acc = 0
    val copy = target.toCharArray()
    var idx = 0

    while (idx < copy.size) {
        if (copy[idx] == this[idx]) {
            idx += 1
        } else {
            // swap
            val ch = copy[idx]
            val realIdx: Int = map[ch] ?: -1
            if (realIdx > -1) {
                val cp = copy[realIdx]
                copy[realIdx] = ch
                copy[idx] = cp
                acc += 1
            } else {
                return Pair("", 0)
            }
        }
    }
    return Pair(copy.joinToString(""), acc)
}


fun main() {
    println("query" naiveReorder "queyr")
    println("query" naiveReorder "ruqye")
    println("chris" naiveReorder "sirhc")
    println("christoffer" naiveReorder "sirhcotefrf")
}