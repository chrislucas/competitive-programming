package com.br.algo.ds.collection

import java.util.*


private fun checkHigherFunction() {
    val treemap = TreeMap<String, Int>()

    treemap.putAll(mapOf("1" to 1, "10" to 2, "11" to 3, "100" to 4))

    treemap.higherEntry("11")?.let { println(it) }
    treemap.higherKey("10")?.let { println(it) }

}

fun main() {


}