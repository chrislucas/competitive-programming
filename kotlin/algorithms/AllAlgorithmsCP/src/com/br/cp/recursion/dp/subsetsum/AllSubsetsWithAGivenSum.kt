package src.com.br.cp.recursion.dp.subsetsum

/*
    https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/?ref=lbp

    Given an array of integers and a sum, the task is to print all subsets of the
    given array with a sum equal to a given sum.
 */


private val testCases = arrayOf(
    arrayOf(2, 3, 5, 6, 8, 10) to 10,
    arrayOf(2, 3, 5, 6, 8, 10) to 8
)

private fun allSubsetsWithGivenSum(set: Array<Int>, target: Int) : HashSet<MutableSet<Int>> {
    val data = HashSet<MutableSet<Int>>()
    val len = 1 shl set.size
    for (i in 0 until len) {
        val subset = mutableSetOf<Int>()
        var acc = 0
        for (j in set.size - 1 downTo 0) {
            if (acc > target)
                break
            else {
                if (i and (1 shl j) > 0) {
                    acc += set[j]
                    subset += set[j]
                }
            }
            if (acc == target)
                data += subset
        }
    }
    return data
}

private fun checkAllSubsetsWithGivenSum() {
    testCases.forEach { (case, target) ->
        val s = allSubsetsWithGivenSum(case, target)
        println("$s\n")
    }
}

fun main() {
    checkAllSubsetsWithGivenSum()
}