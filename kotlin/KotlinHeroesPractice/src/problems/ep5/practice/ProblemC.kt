package problems.ep5.practice

// https://codeforces.com/contest/1432/problem/C
// DONE

fun main() {
    readLine()?.toInt()?.let { it ->
        var queries = it
        while (queries > 0) {
            val size = readLine()?.toInt() ?: break
            val values = readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: break
            val sum = values.sumBy { it }
            val mean = sum / size
            if (mean * size < sum) {
                println(mean + 1)
            } else {
                println(mean)
            }
            queries -= 1
        }
    }
}