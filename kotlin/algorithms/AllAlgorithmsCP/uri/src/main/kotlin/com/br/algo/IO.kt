package com.br.algo

private fun readInt() = readLine()!!.toInt()

private fun <T> readValues(delimiter: String = " ", transform: (String) -> T ) =
    readLine()!!.split(delimiter).map(transform)

private fun Char.toInt() = Character.getNumericValue(this)

private fun <T> Array<T>.show(prefix: String = "") = "$prefix${this.joinToString(" ")}"


fun main() {
    readValues { it.toInt() }
}