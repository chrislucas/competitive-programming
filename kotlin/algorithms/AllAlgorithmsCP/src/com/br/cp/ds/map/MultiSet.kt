package src.com.br.cp.ds.map

import kotlin.random.Random

typealias MultiSet<T> = LinkedHashSet<Pair<Int, T>>


private fun <T : Comparable<T>> List<T>.toLinkedHashMap(): LinkedHashMap<T, Int> {
    return with(LinkedHashMap<T, Int>()) {
        associateWithTo(this) { value ->
            this[value]?.plus(1) ?: 1
        }
    }
}

private fun checkToLinkedHashMap() {
    val values = mutableListOf<Int>()
    val random = Random(System.currentTimeMillis())
    repeat(30) {
        values += random.nextInt(1, 10)
    }
    println(values.toLinkedHashMap())
    println(values)
    values.sort()
    println(values)
}

private fun <T> List<T>.toMultiSet(): MultiSet<T> =
    MultiSet<T>().apply {
        this@toMultiSet.forEachIndexed { idx, value ->
            this += idx to value
        }
    }


private fun checkToMultiSet() {
    val random = Random(System.currentTimeMillis())
    val values = MutableList(30) { random.nextInt(1, 10) }
    println(values.toMultiSet())
}


fun main() {
    checkToMultiSet()
}