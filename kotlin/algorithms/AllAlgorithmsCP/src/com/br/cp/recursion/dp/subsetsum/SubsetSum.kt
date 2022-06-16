package src.com.br.cp.recursion.dp.subsetsum

/**
 * https://discuss.codechef.com/t/uva-562-dividing-coins/7584
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 *
 * Dado um comjunto de inteiros S e um numero N, encontre se existe
 * um subconjunto em S cuja a soma seja N
 *
 */

private fun findSubsetSum(set: Array<Int>, target: Int, idx: Int) : Boolean {
    return if (target > 0 && idx <= 0) {
        false
    } else {
        true
    }
}


fun main() {

}