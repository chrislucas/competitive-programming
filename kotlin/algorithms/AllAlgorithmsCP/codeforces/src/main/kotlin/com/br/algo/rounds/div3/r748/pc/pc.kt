package com.br.algo.rounds.div3.r748.pc

// https://codeforces.com/contest/1593/problem/C
// DONE

private fun readLong() = readLine()!!.toLong()

private fun readLongs(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toLong() }.toTypedArray()

private fun solver(fn: () -> Unit) {
    var cases = readLong()
    while (cases > 0) {
        fn()
        cases -= 1
    }
}

private fun reversedNaiveSolution() {
    solver {
        val (goal, _) = readLongs()
        val positions = readLongs().sortedArray().reversedArray()
        var idx = 0
        var acc = 0
        var cat = 0L
        while (true) {
            if (positions.all { it == goal })
                break
            val s = positions.size
            if (positions[idx % s] == goal) {
                idx = (idx + 1) % s
                continue
            }
            positions[idx % s] += 1L
            if(positions[idx % s] == goal)
                acc += 1
            if (positions.all { it == goal })
                break
            idx = (idx + 1) % s
            for (i in positions.indices) {
                if (positions[i] == cat) {
                    positions[i] = goal
                }
            }
            cat += 1
        }
        println(acc)
    }
}

private fun naive() {
    solver {
        val (goal, mouses) = readLongs()
        val positions = readLongs().sortedArray().reversedArray()

        val array = Array(mouses.toInt()) { 0L }

        for (i in array.indices) {
            array[i] = goal - positions[i]
        }

        var idx = 0
        var acc = 0
        var cat = 0L
        while (true) {
            if (array.all { it == 0L })
                break
            val s = array.size
            if (array[idx % s] == 0L) {
                idx +=1
                continue
            }

            array[idx % s] -= 1L
            if(array[idx % s] == 0L)
                acc += 1
            idx += 1

            cat += 1
            for (i in array.indices) {
                if (array[i] == (goal - cat)) {
                    array[i] = 0
                }
            }
        }
        println(acc)
    }
}

private fun solver() {
    solver {
        val (goal, _) = readLongs()
        val positions = readLongs().sortedArray().reversedArray()
        val array = Array(positions.size) { 0L }
        array[0] = goal - positions[0]
        for(i in 1 until positions.size) {
            array[i] = goal - positions[i] + array[i - 1]
        }
        println(array.count { it < goal })
    }
}

fun main() {
    solver()
}