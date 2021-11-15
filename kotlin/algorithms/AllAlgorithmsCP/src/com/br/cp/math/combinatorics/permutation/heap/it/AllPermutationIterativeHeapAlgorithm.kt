package src.com.br.cp.math.combinatorics.permutation.heap.it


private val data = arrayOf(
    (1..3).toList().toTypedArray(),
    (3..5).toList().toTypedArray(),
    (1..5).toList().toTypedArray(),
    (3..10).toList().toTypedArray(),
)

private fun iterativeHeapSolution(elements: Int, set: Array<Int>, allPermutations: LinkedHashSet<String>) {
    fun <T> swap(p: Int, q: Int, set: Array<T>) {
        val r = set[p]
        set[p] = set[q]
        set[q] = r
    }
    allPermutations.add(set.joinToString("|"))
    val memory = Array(elements) { 0 }
    var i = 0
    while (i < elements) {
        if (memory[i] < i) {
            if (i and 1 == 0) {
                swap(0, i, set)
            } else {
                swap(memory[i], i, set)
            }
            allPermutations.add(set.joinToString("|"))
            memory[i] += 1
            i = 0
        } else {
            memory[i] = 0
            i += 1
        }
    }
}

private fun checkIterativeSolution() {
    data.forEach {
        array ->
        val allPermutations = linkedSetOf<String>()
        val k = array.size
        iterativeHeapSolution(k, array, allPermutations)
        println("$allPermutations\nQ: ${allPermutations.size}")
    }
}

fun main() {
    checkIterativeSolution()
}