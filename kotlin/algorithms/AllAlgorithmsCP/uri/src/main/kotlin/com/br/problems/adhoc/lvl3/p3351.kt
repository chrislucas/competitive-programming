package com.br.problems.adhoc.lvl3

/*
    https://www.beecrowd.com.br/judge/en/problems/view/3351
    TODO
    binary search
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Long, exec: () -> Unit) {
    for (i in 0 until times) {
        exec()
    }
}


private fun s1() {
    val (n, targetViews) = readValues(transform = String::toLong)
    val values = mutableListOf<Pair<Long, Long>>()
    for (i in 0 until n) {
        val (first, timeWaiting) = readValues(transform = String::toLong)
        values += first to timeWaiting
    }

    values.sortedWith(compareBy({it.first}, {it.second}))
/*
    values.sortedWith { p, q ->
        if (p.first == q.first) {
            if (p.second < q.second) {
                -1
            } else if (p.second == q.second) {
                0
            } else {
                1
            }
        } else {
            if (p.first < q.first) {
                -1
            } else {
                1
            }
        }
    }

 */
    var views = 1L
    var minimal = values.first().first
    while (views < targetViews) {
        val (firstViewTime, firstViewDuration) = values[0]
        val nextViewTimeForFirstView = firstViewTime + firstViewDuration
        var minimalLocal = nextViewTimeForFirstView
        for (i in 1 until values.size) {
            val (cFirstViewTime, cFirstrstViewDuration) = values[i]
            if (cFirstViewTime <= nextViewTimeForFirstView) {
                views += 1
                values[i] = cFirstViewTime + cFirstrstViewDuration to cFirstrstViewDuration
                minimalLocal = cFirstViewTime
            }
        }

        values[0] = firstViewTime + firstViewDuration to firstViewDuration
        views += 1
        minimal = minimalLocal
    }

    println(minimal)
}

private fun s2() {
    val (n, targetViews) = readValues(transform = String::toLong)
    val values = mutableListOf<Pair<Long, Long>>()
    for (i in 0 until n) {
        val (first, timeWaiting) = readValues(transform = String::toLong)
        values += first to timeWaiting
    }
}

fun main(args: Array<String>) {
    s1()
}

/*
3 10
5 3
10 1
10 2

5 8 11 14 17 20
10 11 12 13 14 15
10 12 14 16 18 20

5 8 10 10 11 11 12 12 13 14

3 15
5 3
10 5
2 6

5 8 11 14 17 20 23
10 15 20 25 30 35 40
2 8 14 20 26 32 38

2 5 8 8 10 11 14 14 15 17 20 20 20 23 25

3 16
5 3
10 5
2 6
 */