package src.com.br.cp.recursion.dp.subsetsum.problems.uri

/*
    https://www.beecrowd.com.br/judge/en/problems/view/1690
 */


private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)


private fun naiveSolution(set: Array<Long>): Long {
    var le = 1L
    var ri = Int.MAX_VALUE * 1L
    val len = 1 shl set.size
    val table = HashSet<Long>()
    for (i in 1 until len) {
        var acc = 0L
        for (j in set.size - 1 downTo 0) {
            if (i and (1 shl j) > 0)
                acc += set[j]
        }
        if (acc == le && !table.contains(acc))
            le += 1
        table += acc
    }
    return le
}


fun main(args: Array<String>) {
    testCases(readValue(String::toInt)) {
        val size = readValue(String::toInt)
        val set = readValues(transform = (String::toLong)).toTypedArray()
        println(naiveSolution(set))
    }
}