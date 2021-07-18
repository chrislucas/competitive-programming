package com.br.algo

fun readInt() = readLine()?.toInt()

fun readInts(delimiter: String) = readLine()?.split(delimiter)?.map { it.toInt() }?.toIntArray()