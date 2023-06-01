package src.com.br.cp.ds.map

import kotlin.random.Random

typealias MultiSet<T> = LinkedHashMap<T, Int>


private fun <T : Comparable<T>> List<T>.toMultiSet(): MultiSet<T> {
    return with(MultiSet<T>()) {
        associateWithTo(this) {
            value -> this[value]?.plus(1) ?: 1
        }
    }
}

private fun checkMultiSet() {
    val values = mutableListOf<Int>()
    val random = Random(System.currentTimeMillis())
    repeat(30) {
        values += random.nextInt(1, 10)
    }
    println(values.toMultiSet())
    println(values)
    values.sort()
    println(values)
}

fun main() {
    checkMultiSet()
}