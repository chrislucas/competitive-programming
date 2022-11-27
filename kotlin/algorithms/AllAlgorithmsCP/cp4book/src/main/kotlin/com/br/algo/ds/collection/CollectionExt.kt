package com.br.algo.ds.collection

/*
    TODO
 */
fun <T : Comparable<T>, I : Collection<T>> I.upperBound(left: Int = 0, right: Int = size, value: Int) {
    var le = left
    var ri = right
    while (le < ri) {
        val mid = (ri - le) / 2 + le
    }
}


/*
    TODO
 */
fun <T : Comparable<T>, I : Collection<T>> I.lowerBound(left: Int = 0, right: Int = size, value: Int) {
    var le = left
    var ri = right
    while (le < ri) {
        val mid = (ri - le) / 2 + le

    }
}

/*
    TODO
    Implementar algoritmo que mostra em que posicao deveria estar
    cada elemento a colecao para que ela estivesse ordenada
 */

fun <T : Comparable<T>,C : Collection<T>> C.sortedPosition() {

}




fun main() {

}