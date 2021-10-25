package com.br.algo.rounds.div3.r748.pb

// https://codeforces.com/contest/1593/problem/B


private fun readLong(): Long = readLine()!!.toLong()



fun main() {
    var cases = readLong()
    while (cases > 0) {
        var n = readLong()
        var acc = 0
        while (n % 25L != 0L) {
            acc +=1
        }

        println(acc)
    }

}