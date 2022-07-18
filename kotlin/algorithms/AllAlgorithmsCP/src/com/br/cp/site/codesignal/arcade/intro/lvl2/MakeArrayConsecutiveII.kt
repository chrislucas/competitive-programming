package src.com.br.cp.site.codesignal.arcade.intro.lvl2

/*
    https://app.codesignal.com/arcade/intro/level-2/bq2XnSr5kbHqpHGJC
 */


private fun s2(statues: MutableList<Int>): Int {
    var acc = 0
    statues.sort()
    for (i in 1 until statues.size) {
        val diff = statues[i] - statues[i - 1]
        if (diff > 1) {
            acc += diff - 1
        }
    }
    return acc
}

fun main() {

}