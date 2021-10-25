package com.br.studies.dp.bitmask.permutation.allsubsets

infix fun Int.isSet(nth: Int) = this and (1 shl nth) > 0

val <T> Array<T>.allsubsets: List<List<T>>
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

fun main() {
    println(arrayOf(1, 2, 3, 4).allsubsets)
}