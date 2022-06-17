package src.com.br.cp.recursion.dp.subsetsum

/**
 * https://discuss.codechef.com/t/uva-562-dividing-coins/7584
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * https://www.techiedelight.com/subset-sum-problem/
 * https://codeforces.com/blog/entry/60619
 * https://en.wikipedia.org/wiki/Subset_sum_problem
 *
 * Dado um comjunto de inteiros S e um numero N, encontre se existe
 * um subconjunto em S cuja a soma seja N
 *
 */


private val testCases = arrayOf(
    arrayOf(3, 34, 4, 12, 5, 2) to 9,
    arrayOf(3, 4, 5, 2) to 9,
    arrayOf(3, 34, 4, 12, 5, 2) to 30,
    arrayOf(7, 3, 2, 5, 8) to 14
)

private fun hasSubsetSum(values: Array<Int>, target: Int, idx: Int): Boolean {
    return if (target == 0) {
        true
    } else if (idx < 0 || target < 0) { // o condicional values[idx] > target nao permite que target seja < 0
        false
    } else if (values[idx] > target) {
        hasSubsetSum(values, target, idx - 1)
    } else {
        val i = hasSubsetSum(values, target - values[idx], idx - 1)
        val e = hasSubsetSum(values, target, idx - 1)
        i || e
    }
}

private fun memoization(set: Array<Int>, memo: MutableMap<String, Boolean>, target: Int, idx: Int): Boolean {
    return if (target == 0) {
        true
    } else if (memo.containsKey("$target:$idx")) {
        memo["$target:$idx"] ?: false
    } else if (idx < 0) {  // o condicional set[idx] > target nao permite que target seja < 0
        false
    } else if (set[idx] > target) {
        memoization(set, memo, target, idx - 1)
    } else {
        val i = memoization(set, memo, target - set[idx], idx - 1)
        val e = memoization(set, memo, target, idx - 1)
        memo["$target:$idx"] = i || e
        i || e
    }
}

/*
* Baseado em: https://www.techiedelight.com/subset-sum-problem/
* Nessa solucao tentamos incluir o ith valor do conjytno SET nos subproblem de 1 ate targer
* O loop mais externo inclui o ith valor do conjunto e o interno usa esse valor nos subproblemas
* */
private fun bottomUp(set: Array<Int>, target: Int): Boolean {
    // set X target
    // para S = {} qualquer valor T a resposta e: nao existe um subconjunto
    val dp = Array(set.size + 1) { Array(target + 1) { false } }
    // Quando o target = 0 todos os possiveis subcnjutos sao uma solucao valida
    for (i in set.indices) {
        dp[i][0] = true
    }
    // i = inclui o i-esimo valor do conjunto S na solucao do problema
    for (i in 1..set.size) {
        val v = set[i - 1]
        // com o i-esimo valor do conjunto S na solucao do problema verifique se ele cabe na solucao
        for (j in 1..target) {
            dp[i][j] = if (v > j) {
                dp[i - 1][j]
            } else {
                // inclui ou bao i-esimo valor do conjunto set
                dp[i - 1][j] || dp[i - 1][j - v]
            }
        }
    }
    return dp[set.size][target]
}

/*
    Baseado em: https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
    Nessa solucao o loop mais externo passa por todos os subproblemas e o loop mais interno tenta
    usar cada valor do do conjunto SET para resolver o ith-subproblema e ao final ter a solucao do
    problema que se quer resolver.
    A abordagem e o contrário da metodo acima chamado de bottomUp, mas ainad eh uma abordagem bottomUp
 */
private fun anotherBottomUp(set: Array<Int>, target: Int): Boolean {
    val dp = Array(target + 1) { Array(set.size + 1) { false } }
    // para o TARGET = 0 a resposta eh sempre TRUE
    for (i in 0..set.size) {
        dp[0][i] = true
    }
    for (t in 1..target) {
        for (i in 1..set.size) {
            val s = set[i - 1]
            dp[t][i] = if (s > t) {
                dp[t - 1][i - 1]
            } else {
                dp[t][i] || dp[t - s][i - 1]
            }
        }
    }
    return dp[target][set.size]
}

private fun checkAlgorithms() {
    testCases.forEach { (values, target) ->
        val a = hasSubsetSum(values, target, values.size - 1)
        val b = bottomUp(values, target)
        val c = memoization(values, mutableMapOf(), target, values.size - 1)
        val d = anotherBottomUp(values, target)
        println("TopDown: $a, BottoUp: $b, Memoization: $c, BottomUp: $d")
    }
}


fun main() {
    checkAlgorithms()
}