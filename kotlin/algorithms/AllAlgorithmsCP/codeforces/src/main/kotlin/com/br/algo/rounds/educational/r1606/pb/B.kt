package com.br.algo.rounds.educational.r1606.pb

// https://codeforces.com/contest/1606/problem/B

private fun readInt() = readLine()!!.toInt()

private inline fun <reified T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }.toTypedArray()


private fun check1(n: Long, k: Long) {
    if (k > 0) {
        fun solver(n: Long, k: Long) {
            var counter = 0
            var cn = n - 1
            var p = 1 shl counter
            while (p < k) {
                cn -= p
                counter += 1
                p = 1 shl counter
            }
            println(if (cn < 0) counter else (cn / k) + (cn % k) + counter)
        }
        solver(n, k)
    } else {
        println("${n - 1L}")
    }
}


private fun check2(n: Long, k: Long) {

}

fun main() {
    var queries = readInt()
    while (queries > 0) {
        val (n, k) = readValues { it.toLong() }
        check1(n, k)
        queries -= 1
    }
}