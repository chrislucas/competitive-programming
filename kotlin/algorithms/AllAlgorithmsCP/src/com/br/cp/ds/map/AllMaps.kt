package src.com.br.cp.ds.map

import java.util.Collections
import java.util.SortedMap
import java.util.TreeMap
import kotlin.random.Random

/**
 *
 */


fun CharRange.shuffling(): List<Char> {
    /**
     *  https://algs4.cs.princeton.edu/20sorting/
     *  https://algs4.cs.princeton.edu/lectures/keynote/21ElementarySorts-2x2.pdf
     */

    val size = count()
    val chars = this.toMutableList()
    fun swap(chars: MutableList<Char>, p: Int, q: Int) {
        val aux = chars[p]
        chars[p] = chars[q]
        chars[q] = aux
    }

    for (i in 0 until size) {
        val idx = Random.nextInt(size)
        swap(chars, i, idx)
    }

    return chars
}


private fun checkTypeOfMaps() {

    fun createSortedMap(values: List<Char>): SortedMap<Int, Char> =
        values
            .mapIndexed { i, c -> i to c }
            .associateTo(TreeMap()) { it }

    fun createTreeMap(values: List<Char>): TreeMap<Int, Char> =
        values
            .mapIndexed { i, c -> i to c }
            .associateTo(TreeMap()) { it }

    fun createHashMap(values: List<Char>) =
        values
            .mapIndexed { i, c -> i to c }
            .associateTo(HashMap()) { it }

    fun createLinkedHashMap(values: List<Char>) =
        values
            .mapIndexed { i, c -> i to c }
            .associateTo(LinkedHashMap()) { it }


    val shuffled = CharRange('a', 'z').shuffled()
    println(shuffled)
    println("SortedMap\n${createSortedMap(shuffled)}")
    println("TreeMap\n${createTreeMap(shuffled)}")
    println("HashMap\n${createHashMap(shuffled)}")
    println("LinkedHashMap\n${createLinkedHashMap(shuffled)}")
}



private fun checkMapBehavior() {

    fun <T, M : MutableMap<Int, T>> List<T>.grouping(map: M) =
        mapIndexed { i, c -> i to c }.associateTo(map) { it }


    val shuffled = CharRange('a', 'z').shuffled()
    println(shuffled)
    println("Treemap\n${shuffled.grouping(TreeMap<Int, Char>())}")
    println("Treemap as SortedMap\n${shuffled.grouping(TreeMap())}")
    println("Hashmap\n${shuffled.grouping(HashMap())}")
    println("LinkedHashmap\n${shuffled.grouping(LinkedHashMap())}")
    val map = shuffled.grouping(Collections.synchronizedSortedMap(TreeMap()))
    println("SynchronizedSortedMap\n$map")
    val sortedMap: SortedMap<Int, Char> = TreeMap(map)
    println("SortedMap\n$sortedMap")
    //println("UnmodifiableSortedMap\n${shuffled.grouping(Collections.unmodifiableSortedMap(map))}")
    //println("UnmodifiableSortedMap\n${shuffled.grouping(Collections.unmodifiableSortedMap(TreeMap()))}")
}

private fun checkSortedMapAndExtFunShuffling() {
    /**
     * https://www.geeksforgeeks.org/sortedmap-java-examples/
     *
     * "The elements cab be traversed in sorted order of keys"
     * - Uma interface que herda da interface Map. Foi criada para prover uma estrutura
     * de dados que ordena seus elementos pela chave
     */
    fun createSortedMap(range: List<Char>): SortedMap<Int, Char> =
        range.mapIndexed { i, c -> i to c }
            .associateTo(TreeMap()) { it }

    val charRange = CharRange('a', 'z')
    val shuffled = charRange.shuffled()

    println(charRange)
    println(shuffled)
    println(createSortedMap(shuffled))
    println("*********************************************************")
    val shuffled1 = charRange.shuffling()
    println(shuffled1)
    println(createSortedMap(shuffled1))

}

fun main() {
    //checkTypeOfMaps()
    //println("********************************************")
    checkMapBehavior()
}