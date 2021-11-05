package src.com.br.cp.math.combinatorics.permutation.heap

private fun <T> recursiveGenerateAllPermutation(k: Int, set: Array<T>, permutation: LinkedHashSet<Array<T>>) {
    fun <T> swap(p: Int, q: Int, set: Array<T>) {
        val r = set[p]
        set[p] = set[q]
        set[q] = r
    }
}


private fun check() {
    arrayOf("chris".split("").toTypedArray()).forEach {
        array ->
        val allPermutations= linkedSetOf<Array<String>>()
        recursiveGenerateAllPermutation(array.size, array, allPermutations)
    }
}


fun main() {

}