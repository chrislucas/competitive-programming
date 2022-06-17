package src.com.br.cp.math.combinatorics.permutation.backtracking

/*
    https://www.cs.princeton.edu/~rs/talks/perms.pdf
 */

val data = arrayOf(
    (1..3).toList().toTypedArray(),
    (3..5).toList().toTypedArray(),
    (1..5).toList().toTypedArray(),
    (3..10).toList().toTypedArray(),
    (3..12).toList().toTypedArray(),
)

private val <T> Array<T>.string: String
    get() = this.joinToString("|")

private fun backtrackingSolution(elements: Int, set: Array<Int>, allPermutations: LinkedHashSet<String>) {
    fun <T> swap(p: Int, q: Int, set: Array<T>) {
        val r = set[p]
        set[p] = set[q]
        set[q] = r
    }

    if (elements == 1) {
        allPermutations.add(set.string)
    }
    for (i in 0 until elements) {
        swap(i, elements - 1, set)
        backtrackingSolution(elements - 1, set, allPermutations)
        swap(i, elements  - 1, set)
    }
}

private fun checkBacktrackingSolution() {
    data.forEach {
        val allPermutations = linkedSetOf<String>()
        val k = it.size
        backtrackingSolution(k, it, allPermutations)
        println("$allPermutations\nQ: ${allPermutations.size}")
    }
}


fun main() {
    checkBacktrackingSolution()
}


