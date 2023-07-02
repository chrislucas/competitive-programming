package src.com.br.cp.site.ds.kotlin.site.hackerearth.problems

/*
    https://www.hackerearth.com/challenges/competitive/code-monk-binary-indexed-tree/problems/
    https://www.hackerearth.com/practice/data-structures/advanced-data-structures/fenwick-binary-indexed-trees/practice-problems/algorithm/shil-and-palindrome-research/
    TODO achar uma solucao mais eficiente
 */

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private inline fun runTestCases(times: Int, exec: () -> Unit) = repeat(times) {
    exec()
}

/*
    5 4
    ababb
    2 2 3
    1 3 b
    2 1 4
    2 1 5

    1 int char -> modificar o ith caracter
    2 int int -> verificar se eh possivel formar um palindrome com a substring S(int, int)
 */


// TLE
private fun solver() {

    fun s1(str: Array<String>): MutableMap<String, Int> {
        val map = mutableMapOf<String, Int>()

        str.associateTo(map) {
            map[it]?.let { value -> Pair(it, value + 1) } ?: Pair(it, 1)
        }

        return map
    }

    val (s, query) = readValues(transform = String::toInt)
    val str = readLine()!!.split("").toTypedArray()

    var map: MutableMap<String, Int> = mutableMapOf()

    repeat(query) {
        val (type, a, b) = readValues(transform = String::toString)
        if ("1" == type) {
            str[a.toInt()] = b
        } else {
            val ca = a.toInt()
            val cb = b.toInt()
            val array = str.copyOfRange(ca, cb + 1)
            map = s1(array)
            val flag = if (array.size % 2 == 0) {
                map.values.none { it and 1 == 1 }
            } else {
                map.values.filter { it and 1 == 1 }.size < 2
            }
            println(if (flag) "yes" else "no")
        }
    }
}


private fun solver2() {
    val (s, query) = readValues(transform = String::toInt)
    val str = readLine()!!.split("").toTypedArray()
}

fun main() {
    solver()
}