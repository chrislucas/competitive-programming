package com.br.problems.dp

import kotlin.math.sqrt

/*
    https://www.beecrowd.com.br/judge/en/problems/view/1166
    DONE
 */

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


fun Int.isSquare(): Boolean {
    val root = sqrt(this * 1.0).toInt()
    return root * root == this
}

private fun solution() {
    testCases(readValue(String::toInt)) {
        val size = readValue(String::toInt)
        var ans = 1
        val pegs = Array(size) { 0 }
        pegs[0] = 1
        var acc = 2
        var isPossible = true
        while (isPossible) {
            isPossible = false
            for (i in pegs.indices) {
                if ((pegs[i] + acc).isSquare() || pegs[i] == 0) {
                    pegs[i] = acc
                    ans += 1
                    acc += 1
                    isPossible = true
                    break
                }
            }
        }
        println(ans)
    }
}


fun main(args: Array<String>) = solution()