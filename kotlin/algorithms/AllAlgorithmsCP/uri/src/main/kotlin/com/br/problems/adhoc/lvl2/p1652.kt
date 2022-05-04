package com.br.problems.adhoc.lvl2

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/1652
 * DOONE
 * */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun Char.isVowel() = this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'

private fun solver() {
    val (irregular, words) = readValues { it.toInt() }

    val irregulars = mutableMapOf<String, String>()

    testCases(irregular) {
        val (p, q) = readLine()!!.split(" ")
        irregulars[p] = q
    }

    testCases(words) {
        val word = readValue { it }
        val p = word[word.length - 2]
        val q = word[word.length - 1]

        if (irregulars[word] != null) {
            println(irregulars[word])
        } else if (!p.isVowel() && q == 'y') {
            val w = word.replaceRange(word.length - 1, word.length, "ies")
            println(w)
        } else if (q == 'o' || q == 's' || q == 'x' || (p == 'c' && q == 'h') || (p == 's' && q == 'h')) {
            println("${word}es")
        }
        else {
            println("${word}s")
        }
    }
}

fun main(args: Array<String>) {
    solver()
}