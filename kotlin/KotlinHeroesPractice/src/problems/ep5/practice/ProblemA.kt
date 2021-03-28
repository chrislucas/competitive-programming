package problems.ep5.practice

// https://codeforces.com/contest/1432/problem/A


fun main() {
    readLine()?.toInt()?.let {
        it ->
        var cases = it
        while (cases > 0) {
            val (a, b) = readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: break
            println(a + b)
            cases -= 1
        }
    }
}