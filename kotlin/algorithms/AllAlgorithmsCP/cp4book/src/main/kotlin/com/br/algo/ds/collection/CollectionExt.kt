package com.br.algo.ds.collection


fun <T : Comparable<T>, I : Collection<T>> I.upperBound(left: Int = 0, right: Int = size, value: Int) {
    var le = left
    var ri = right
    while (le < ri) {
        val mid = (ri - le) / 2 + le
    }
}


fun <T : Comparable<T>, I : Collection<T>> I.lowerBound(left: Int = 0, right: Int = size, value: Int) {
    var le = left
    var ri = right
    while (le < ri) {
        val mid = (ri - le) / 2 + le

    }
}



fun main() {

}