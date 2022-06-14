package com.br.studies.dp.introduction

/*
    https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/
    https://www.geeksforgeeks.org/count-ofdifferent-ways-express-n-sum-1-3-4/
    Let us say that you are given a number N,
    you've to find the number of different ways to write it as the sum of 1, 3 and 4.
    https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/
 */

private fun combineCoins(target: Int): Int {

    /*
        Let us say that you are given a number N,
        you've to find the number of different ways to write it as the sum of 1, 3 and 4.

        For example, if N = 5, the answer would be 6.

        1 + 1 + 1 + 1 + 1
        1 + 4
        4 + 1
        1 + 1 + 3
        1 + 3 + 1
        3 + 1 + 1
     */
    val size = if (target < 4) 4 else target + 1
    val dp = Array(size) { 0 }
    dp[0] = 1
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2

    for (i in 4..target) {
        dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4]
    }

    return dp[target]
}

private val testCases = arrayOf(
    Pair(1, arrayOf(1, 3, 4)),
    Pair(5, arrayOf(1, 3, 4)),
    Pair(4, arrayOf(1, 3, 4)),
    Pair(40, arrayOf(1, 3, 4)),
    Pair(14, arrayOf(12, 3, 1, 9)),
    Pair(7, arrayOf(1, 5, 6)),
    Pair(6, arrayOf(1, 2)),
)
// COIN CHANGE IMPL
fun topDownTest(target: Int, set: Array<Int>, idx: Int): Int {
    return if (target == 0) {
        1
    } else if (idx > set.size - 1 || target < 0) {
        0
    } else if (set[idx] > target) {
        topDownTest(target, set, idx + 1)
    } else {
        val p = topDownTest(target - set[idx], set, idx)
        val q = topDownTest(target, set, idx + 1)
        p + q
    }
}

fun topDown(target: Int, set: Array<Int>, idx: Int): Int {
    return if (target == 0) {
        1
    } else if (idx < 0 || target < 0) {
        0
    } else if (set[idx] > target) {
        topDown(target, set, idx - 1)
    } else {
        val p = topDown(target - set[idx], set, idx)
        val q = topDown(target, set, idx - 1)
        p + q
    }
}

fun memoization(buffer: Array<Int>, target: Int, set: Array<Int>, idx: Int): Int {
    return if (target == 0) {
        buffer[target]
    } else if (idx < 0 || target < 0) {
        0
    } else if (set[idx] > target) {
        memoization(buffer, target, set, idx - 1)
    }  else {
        val p = memoization(buffer, target - set[idx], set, idx)
        val q = memoization(buffer, target, set, idx - 1)
        buffer[target] = p + q
        buffer[target]
    }
}
// FIM COIN CHANGE IMPL


// Essa implementacao resolve o problema
fun bottomUp(target: Int, set: Array<Int>): Int {
    val buffer = Array(target + 1) { 0 }
    buffer[0] = 1
    for (ti in 1..target) {
        for (si in set) {
            if (si <= ti) {
                buffer[ti] += buffer[ti - si]
            }
        }
    }
    return buffer[target]
}


private fun check() {
    testCases.forEach { (w, set) ->
        val a = topDown(w, set, set.size - 1)

        val memo = Array(w + 1) { 0 }
        memo[0] = 1
        val b = memoization(memo, w, set, set.size - 1)

        val c = topDownTest(w, set, 0)
        val d = bottomUp(w, set)
        val e = combineCoins(w)
        println("$a, $b, $c, $d, $e")
    }
}

fun main() {
    check()
}