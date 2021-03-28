package problems.ep5.practice


// https://codeforces.com/contest/1432/problem/B
// Done

fun main() {
    readLine()?.toInt()
        ?.let{
            it ->
            var cases = it
            while (cases > 0) {
                val value = readLine()?.toInt() ?: break
                println(if (value % 2 == 0) (value-1)/2 else value/2)
                cases--
            }
        }
}