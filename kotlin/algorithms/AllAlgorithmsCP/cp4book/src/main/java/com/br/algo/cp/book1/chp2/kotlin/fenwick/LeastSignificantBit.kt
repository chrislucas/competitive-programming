package com.br.algo.cp.book1.chp2.kotlin.fenwick

private fun lsb(value: Int) = value and (-value)

private fun checkLsb() {
    println(3 - lsb(3))
    println(7 - lsb(7))
}

private fun unsetLsb(value: Int) = value - (value and (-value))


private fun checkUnsetLsb() {
    println(unsetLsb(7))
    println(unsetLsb(10))
}


/*
    testando o comportamento ao realizar o somatorio do ultimo bit significativo
    a um numero do intervalor l ao r, assim como ocorre no algoritmo de rangem_sum
    da estrutura FenwickTree
 */
private fun checkSumLsb(range: IntRange) {
    var l = range.first
    val builder = StringBuilder()
    var first = true
    while (l <= range.last) {
        builder.append(if (first) "$l" else ", $l")
        l += lsb(l)
        first = false
    }
    println(builder)
}

fun main() {
    checkSumLsb(5 .. 1024)
}