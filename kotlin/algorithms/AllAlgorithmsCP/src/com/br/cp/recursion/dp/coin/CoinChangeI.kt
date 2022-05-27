package src.com.br.cp.recursion.dp.coin

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 *
 * ith = i-esimo
 * recursao
 *
 * se value == 0 retorna 1
 * se value < 0 retorna 0
 *
 * senao
 * sem a ith-valor de S + com o ith-valor de S
 * f(S, idx-1, value) + f(S, idx, value - S[idx])
 *
 *
 *
 */

fun topDown(set: Array<Int>, value: Int, idx: Int): Int {
    return if (value == 0) {
        1
    } else if (value < 0 || idx < 0) {
        0
    } else if (set[idx] > value) {
        topDown(set, value, idx - 1)
    } else {
        val p = topDown(set, value - set[idx], idx)
        val q = topDown(set, value, idx - 1)
        p + q
    }
}


fun optBottomUp(set: Array<Int>, targetValue: Int): Int {
    val states = Array(targetValue + 1) { 0 }
    // estado[0] targetValue = 0, estado[n] targetValue = n
    states[0] = 1
    for (value in set) {
        for (j in value..targetValue) {
            states[j] += states[j - value]
        }
    }
    return states[targetValue]
}

fun bottomUp(set: Array<Int>, targetValue: Int): Int {
    val m = targetValue + 1
    val n = set.size
    val states = Array(m) { Array(n) { 0 } }
    for (i in 0 until n) {
        states[0][i] = 1
    }

    for (state in 1..targetValue) {
        for (k in 0 until n) {
            val p = if (state - set[k] >= 0) {
                states[state - set[k]][k]
            } else {
                0
            }
            val q = if (k > 0) {
                states[state][k - 1]
            } else {
                0
            }
            states[state][k] = p + q
        }
    }

    return states[targetValue][n - 1]
}

val testCases = arrayOf(
    /*
    Pair(arrayOf(), 0),
    Pair(arrayOf(), 4),
    Pair(arrayOf(1), 100),
     */
    Pair(arrayOf(2, 3), 4),
    Pair(arrayOf(1, 2, 3), 4),
    Pair(arrayOf(1, 2, 3), 5),
    Pair(arrayOf(3, 5, 10), 20),
    Pair(arrayOf(3, 5, 10), 13),
    Pair(arrayOf(3, 5, 10), 35),
    Pair(arrayOf(3, 5, 10, 15, 20), 35)
)


fun checkSolvers() {
    testCases.forEach { (set, value) ->
        val topDown = topDown(set, value, set.size - 1)
        val opBottomUp = optBottomUp(set, value)
        val bottomUp = bottomUp(set, value)
        println("$topDown, $opBottomUp, $bottomUp")
    }
}

fun main() {
    checkSolvers()
}