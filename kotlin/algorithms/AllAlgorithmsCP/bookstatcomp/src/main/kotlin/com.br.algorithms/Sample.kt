package com.br.algorithms

import com.br.ext.countTime

fun main() {

    val (time, _) = countTime  {
        println(0xff)
    }

    println(time)
}