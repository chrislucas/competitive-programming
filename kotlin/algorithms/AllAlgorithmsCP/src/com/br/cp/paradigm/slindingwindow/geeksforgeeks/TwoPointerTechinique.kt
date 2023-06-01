package src.com.br.cp.paradigm.slindingwindow.geeksforgeeks

import java.util.TreeSet

/**
 * https://www.geeksforgeeks.org/two-pointers-technique/
 *
 * Tecnica usada para fazer busca por pares i, j que atendam a uma determinada
 * restricao numa colecao ordenada.
 */
private fun checkTwoPointersTechnique() {

    fun twoPointers(values: List<Int>, target: Int): Pair<Int, Int> {
        var rs = Pair(-1, -1)
        var i = 0
        var j = values.size - 1
        var k = 0
        while (i < j) {
            val s = values[i] + values[j]
            if (s == target) {
                rs = Pair(i, j)
                break
            } else if (s < target) {
                i += 1
            } else {
                j -= 1
            }
        }
        return rs
    }

    /**
     * Problema:
     * Dado um array ordenado de tamanho N,
     * verifique se existe algum par de elementos i, j cuja soma seja igual a X
     */

    val cases = listOf(
        listOf(10, 20, 35, 50, 75, 80) to 70,
        listOf(2, 3, 5, 8, 9, 10, 11) to 17
    )
    val rs = cases.map { (values, targer) -> twoPointers(values, targer) }
    println(rs)
}


private fun checkSlidingWindowWithTwoPointer() {
    val set = TreeSet<Int>()
}


fun main() {
    checkTwoPointersTechnique()
}