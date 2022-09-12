package com.br.problems.beginner.lvl2

/*
    https://www.beecrowd.com.br/judge/en/problems/view/2653
    DONE
 */

private inline fun runWhiteTruth(fn: () -> Boolean) {
    while (true) {
        if (!fn()) {
            break
        }
    }
}

fun main(args: Array<String>) {

    fun s1() {
        val map = hashMapOf<String, Int>()
        runWhiteTruth {
            readLine()?.let { it ->
                map[it] = map[it]?.plus(1) ?:  1
                true
            } ?: false
        }
        println(map.keys.size)
    }

    s1()
}