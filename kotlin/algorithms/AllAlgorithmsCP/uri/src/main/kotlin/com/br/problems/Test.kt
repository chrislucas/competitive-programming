package com.br.problems

private fun s(a: Int, b: Int): Int {
    fun fn(a: Int) = a * a

    return if(a > b) {
        0
    } else {
        fn(a) + s(a+1, b)
    }
}

private fun s1(x: Int): Int {
    return if(x<=100) {
        x + 10
    } else {
        s1(s1(x/5))
    }
}

private fun s2(x: Int): Int {
    return if(x<=1) {
        x
    } else {
        s2(x - 1) + s2(x - 2)
    }
}

fun main() {
    println(s(2, 5))
    println(s1(200))
    println(s2(9))
}