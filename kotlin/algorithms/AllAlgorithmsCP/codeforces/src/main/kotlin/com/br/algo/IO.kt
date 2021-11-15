package com.br.algo

private fun readLong() = readLine()!!.toLong()

private fun readLongs(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toLong() }.toTypedArray()

private fun readInt() = readLine()!!.toInt()

private fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }.toTypedArray()


private fun readIn() = readLine()!!.toInt()

private inline fun <reified T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }.toTypedArray()