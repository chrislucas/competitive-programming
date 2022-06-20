package src.com.br.cp.recursion.dp.subsetsum


/*
    https://www.geeksforgeeks.org/print-sums-subsets-given-set/
 */


private fun allSubsets(set: Array<Int>): HashSet<MutableSet<Int>> {
    val tree = HashSet<MutableSet<Int>>()
    val len = 1 shl set.size
    for (i in 0 until len) {
        val subset = mutableSetOf<Int>()
        /*
            Esse codigo funciona, mas quero usar uma aborsagem diferente.
            avaliar os bits do mais significativo para o menos signification
        for (j in set.indices) {
            if (i and (1 shl j) > 0) {
                print("1")
                subset += set[j]
            } else {
                print("0")
            }
        }

         */

        for (j in set.size - 1 downTo 0) {
            if (i and (1 shl j) > 0) {
                print("1")
                subset += set[j]
            } else {
                print("0")
            }
        }
        tree.add(subset)
        println()
    }
    return tree
}


private fun allSubsetsSum(set: Array<Int>): Array<Int> {
    val len = 1 shl set.size
    val sums = Array(len) { 0 }
    for (i in 1 until len) {
        var acc = 0
        /*
            esse trecho de codigo avalia do bit menos significativo para o mais,
            prefiro inverter essa abordagem
        for (j in set.indices) {
            if (i and (1 shl j) > 0)
                acc += set[j]
        }

         */
        for (j in set.size - 1 downTo 0) {
            if (i and (1 shl j) > 0) {
                print("1")
                acc += set[j]
            } else {
                print("0")
            }
        }
        println()
        sums[i] = acc
    }
    return sums
}


private val testCases = arrayOf(
    arrayOf(2, 3),
    arrayOf(2, 4, 5),
    arrayOf(5, 4, 3),
    arrayOf(2, 4, 5, 7),
    arrayOf(2, 4, 5, 7, 10),
)

private fun checkAllSubsets() {
    testCases.forEach { case ->
        val s = allSubsets(case)
        println("$s\n")
        println()
    }
}

private val <T> Array<T>.string: String
    get() = this.joinToString(", ", prefix = "[", postfix = "]")

private fun checkAllSubsetsSum() {
    testCases.forEach { case ->
        val s = allSubsetsSum(case)
        println("${s.string}\n")
    }
}


fun main() {
    //checkAllSubsets()
    checkAllSubsetsSum()
}