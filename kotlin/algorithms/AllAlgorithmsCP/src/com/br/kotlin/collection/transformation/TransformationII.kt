package src.com.br.kotlin.collection.transformation

/*
    https://kotlinlang.org/docs/collection-transformations.html#map
 */


/*
      https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/with-index.html
 */
private fun checkIteratorWithIndexFunc() {
    val iterator = ('a'..'z').iterator()
    for ((index, value) in iterator.withIndex()) {
        println("The element at $index is $value")
    }
}

private fun checkAssociateFunc() {
    val iterator = ('a'..'z').iterator()
    val map = iterator.withIndex()
        .asSequence()
        .associate { it -> it.index to it.value }
    println(map)
}

fun main() {
    checkAssociateFunc()
}