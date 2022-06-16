package src.com.br.cp.recursion.dp.subsetsum

/**
 * https://discuss.codechef.com/t/uva-562-dividing-coins/7584
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * https://www.techiedelight.com/subset-sum-problem/
 * https://codeforces.com/blog/entry/60619
 * https://en.wikipedia.org/wiki/Subset_sum_problem
 */


private val testCases = arrayOf(
    arrayOf(3, 34, 4, 12, 5, 2) to 9,
    arrayOf(3, 4, 5, 2) to 9,
    arrayOf(3, 34, 4, 12, 5, 2) to 30
)


private fun hasSubsetSum(values: Array<Int>, target: Int, idx: Int): Boolean {
    return if (idx < 0) {
        false
    } else if (target == 0) {
        true
    } else if (values[idx] > target) {
        hasSubsetSum(values, target, idx - 1)
    } else {
        val p = hasSubsetSum(values, target - values[idx], idx - 1)
        val q = hasSubsetSum(values, target, idx - 1)
        p || q
    }
}

private fun bottomUp(set: Array<Int>, target: Int): Boolean {

    // values X target
    val dp = Array(set.size + 1) { Array(target + 1) { false } }

    // para o valor 0 a resposta e TRUE que é o conjunto vazio
    for (i in set.indices) {
        dp[i][0] = true
    }

    // i = inclui o i-esimo valor do conjunto S na solucao do problema
    for (i in 1..set.size) {
        // com o i-esimo valor do conjunto S na solucao do problema verifique se ele cabe na solucao
        for (j in 1..target) {
            dp[i][j] = if (set[i - 1] > j) {
                dp[i - 1][j]
            } else {
                // valor anterior em values
                dp[i - 1][j] || dp[i - 1][j - set[i - 1]]
            }
        }
    }

    return dp[set.size][target]
}

private fun checkAlgorithms() {
    testCases.forEach { (values, target) ->
        val a = hasSubsetSum(values, target, values.size - 1)
        val b = bottomUp(values, target)
        println("$a $b")
    }
}


fun main() {
    checkAlgorithms()
}