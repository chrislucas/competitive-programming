package com.br.problems.adhoc.lvl2

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)


private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)


fun main() {

}