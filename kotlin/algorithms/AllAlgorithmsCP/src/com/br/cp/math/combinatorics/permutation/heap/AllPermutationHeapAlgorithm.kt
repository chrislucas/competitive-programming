package src.com.br.cp.math.combinatorics.permutation.heap

import kotlin.collections.LinkedHashSet

/*

    Algoritmo de Heap
    https://pt.wikipedia.org/wiki/Algoritmo_de_Heap

    https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
    https://en.wikipedia.org/wiki/Heap%27s_algorithm
    https://www.cs.princeton.edu/~rs/talks/perms.pdf
    https://greatdeveloper66.medium.com/heaps-algorithm-1cb10b73a92b
    https://cs.stackexchange.com/questions/60708/need-explanation-of-heaps-algorithm
 */


// Baseado em : https://pt.wikipedia.org/wiki/Algoritmo_de_Heap
private fun recursiveHeapSolution(elements: Int, set: Array<Int>, allPermutations: LinkedHashSet<String>) {
    fun <T> swap(p: Int, q: Int, set: Array<T>) {
        val r = set[p]
        set[p] = set[q]
        set[q] = r
    }

    if (elements == 1) {
        allPermutations.add(set.joinToString("|"))
    } else {
        for (i in 0 until elements) {
            recursiveHeapSolution(elements - 1, set, allPermutations)
            if (elements and 1 == 0) {
                swap(i, elements - 1, set)
            } else {
                swap(0, elements - 1, set)
            }
        }
    }
}

//
/**
 * Baseado em: https://en.wikipedia.org/wiki/Heap%27s_algorithm
 * total de permutacoes de um array de N elementos eh N fatorial = N!
 * o algoritmo abaixo para N = 5 nao devolve uma linkedHashSet de tamanos 120 por exemplo
 * */
private fun solution(elements: Int, set: Array<Int>, allPermutations: LinkedHashSet<String>) {
    fun <T> swap(p: Int, q: Int, set: Array<T>) {
        val r = set[p]
        set[p] = set[q]
        set[q] = r
    }

    if (elements == 1) {
        allPermutations.add(set.joinToString("|"))
    } else {
        solution(elements - 1, set, allPermutations)
        for (i in 0 until elements) {
            if (elements and 1 == 0) {
                swap(i, elements - 1, set)
            } else {
                swap(0, elements - 1, set)
            }
            solution(elements - 1, set, allPermutations)
        }
    }
}


private val data = arrayOf(
    (1..3).toList().toTypedArray(),
    (3..5).toList().toTypedArray(),
    //(1..5).toList().toTypedArray(),
    //(3..10).toList().toTypedArray(),
)

val <T> LinkedHashSet<T>.string: String
    get() = this.joinToString("\n")

private fun checkRecursiveSolution() {
    data.forEach {
        val allPermutations = linkedSetOf<String>()
        val k = it.size
        recursiveHeapSolution(k, it, allPermutations)
        println("${allPermutations.string}\nQ: ${allPermutations.size}")
    }
}

private fun check2ndSolution() {
    val array = (1 .. 5).toList().toTypedArray()
    val allPermutations = linkedSetOf<String>()
    val k = array.size
    solution(k, array, allPermutations)
    println("${allPermutations.string}\nQ: ${allPermutations.size}")
}

fun main() {
    checkRecursiveSolution()
    //check2ndSolution()
}
