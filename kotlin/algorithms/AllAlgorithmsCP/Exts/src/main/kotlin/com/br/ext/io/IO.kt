package com.br.ext.io

fun readInt() = readLine()!!.toInt()

fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }

fun <T> readValues(delimiter: String = " ", func: (String) -> T) = readLine()!!.split(delimiter).map { func(it) }
