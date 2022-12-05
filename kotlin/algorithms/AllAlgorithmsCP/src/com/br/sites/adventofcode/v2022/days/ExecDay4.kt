package src.com.br.sites.adventofcode.v2022.days

import src.com.br.cp.math.combinatorics.patternlock.enumerate.contains

/*
    https://adventofcode.com/2022/day/4
 */


private typealias PII = Pair<Int, Int>

private fun PII.isContained(q: PII): Boolean {
    val (a, b) = this
    val (c, d) = q
    return a >= c && b <= d
}

private fun PII.toRange() = first..second

private fun IntRange.parcialIverlaping(q: IntRange): Boolean {
    return this.last >= q.first && this.first <= q.last
}

private fun checkPairContains() {

    arrayOf(
        Pair(5 to 7, 7 to 9),
        Pair(1 to 8, 2 to 7),
        Pair(2 to 8, 2 to 7),
        Pair(2 to 8, 2 to 8),
        Pair(7 to 8, 2 to 8),
        Pair(7 to 8, 2 to 9),
    ).forEach { (p, q) ->

        println("P: $p, esta contido em Q: $q ${p.isContained(q)}")
        println("Q: $q, esta contido em P: $p ${q.isContained(p)}")

        val rangeP = p.toRange()
        val rangeQ = q.toRange()

        println("P: $rangeP, Q: $rangeQ = ${rangeP.contains(rangeQ)}")
        println("Q: $rangeQ, P: $rangeP = ${rangeQ.contains(rangeP)}")

        println("************************************************************")

    }


}

fun main() {
    //checkPairContains()

    fun first() {
        var acc = 0
        while (true) {
            val line = readLine()
            if (line?.isNotEmpty() == true) {
                val s = line.split(",")
                val (a, b) = s[0].split("-").map(String::toInt)
                val (c, d) = s[1].split("-").map(String::toInt)
                val p = a .. b
                val q = c .. d
                if (p.contains(q) || q.contains(p) || p.parcialIverlaping(q) || q.parcialIverlaping(p)) {
                    acc += 1
                }
                println(acc)
            } else {
                break
            }
        }
    }

    fun second() {
        var acc = 0
        while (true) {
            val line = readLine()
            if (line?.isNotEmpty() == true) {
                val s = line.split(",")
                val (a, b) = s[0].split("-").map(String::toInt)
                val (c, d) = s[1].split("-").map(String::toInt)
                val p = a .. b
                val q = c .. d
                if (p.contains(q) || q.contains(p) || p.parcialIverlaping(q) || q.parcialIverlaping(p)) {
                    acc += 1
                }
                println(acc)
            } else {
                break
            }
        }
    }

    second()

}