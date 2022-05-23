package com.br.competitions.c1674.pb

inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)


private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


val table = ('a'..'z').associateWith { (it - 97).code }

/**
 * https://codeforces.com/contest/1674/problem/B
 * DONE
 */

fun init() : MutableMap<Char,Int>{
    val secondTable = mutableMapOf<Char, Int>()

    var acc = 0
    for (k in table.keys) {
        secondTable[k] = acc
        acc += 26
    }
    return secondTable
}


fun createTable() : MutableMap<String, Int> {
    val s = ('a'..'z').toMutableList()
    val map = mutableMapOf<String, Int>()
    var acc = 1
    for (i in 0 until s.size) {
        for (k in 0 until s.size) {
            if (s[i] == s[k])
                continue
            val aux = "${s[i]}${s[k]}"
            map[aux] = acc
            acc += 1
        }

    }
    return map
}

private fun solver1() {
    val map = createTable()
    testCases(readValue { it.toInt() }) {
        readLine()?.let {
            println(map[it])
        }
    }
}

fun main() {
    solver1()
}