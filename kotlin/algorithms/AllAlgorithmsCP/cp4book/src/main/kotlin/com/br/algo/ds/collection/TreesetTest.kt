package com.br.algo.ds.collection

import java.util.TreeSet

/*
    https://codeforces.com/blog/entry/79402
 */


private fun checkHigherAndLowerFun() {
    val treeset = TreeSet<Int>()
    treeset.add(1)
    treeset.add(2)
    treeset.add(4)
    treeset.higher(2)?.let { println(it) }
    treeset.lower(4)?.let { println(it) }
}

private fun checkAddTreeSet() {
    val set = TreeSet<Int>()

    set += 10
    set += 20
    set += 30
    set += 40
    println(set)
    set += 5
    println(set)
    set += 7
    println(set)
}

fun main() {
    //checkHigherAndLowerFun()
    checkAddTreeSet()
}