package src.com.br.cp.recursion.dp.maxsum

/**
 * https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */


private val testCases = arrayOf(
    arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4),
    arrayOf(4, -1, 2, 1),
    arrayOf(-2, 1, -3),
    arrayOf(-2, -3, -4, -1),
    arrayOf(-1, -3, -4, -2)
)


// n ^ 2
private fun naive(values: Array<Int>): Pair<Int, Pair<Int, Int>> {
    /**
     * Todo calcular todas as somas de todos os subarrays possiveis
     */
    var global = 0
    var p = 0
    var q = 0
    for (i in values.indices) {
        var acc = values[i]
        var local = acc
        var localQ = i
        for (k in i + 1 until values.size) {
            acc += values[k]
            if (acc > local) {
                local = acc
                localQ = k
            }
        }
        if (local > global) {
            global = local
            q = localQ
            p = i
        }
    }

    return Pair(global, p to q)
}

private fun kadaneForNegativeValues(values: Array<Int>): Pair<Int, Pair<Int, Int>> {
    var global = values[0]
    var local = 0
    var p = 0
    var q = 0
    var s = 0
    for (i in values.indices) {
        local += values[i]
        if (local > global) {
            global = local
            p = s
            q = i
        } else if (local < 0) {
            s = i + 1
            local = 0
        }
    }
    return Pair(global, p to q)
}

private fun checkSolutions() {
    testCases.forEach { values ->
        val a = naive(values)
        val b = kadaneForNegativeValues(values)
        println("$a, $b")
    }
}


fun main() {
    checkSolutions()
}