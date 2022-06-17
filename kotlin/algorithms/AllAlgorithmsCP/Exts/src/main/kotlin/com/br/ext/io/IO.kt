package com.br.ext.io

private fun readInt() = readLine()!!.toInt()

private fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }

private fun <T> readValues(delimiter: String = " ", func: (String) -> T) = readLine()!!.split(delimiter).map { func(it) }
