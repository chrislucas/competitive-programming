package src.com.br.cp.site.codesignal.arcade.intro.lvl2

/*
    https://app.codesignal.com/arcade/intro/level-2/2mxbGwLzvkTCKAJMG
 */

fun s3(seq: MutableList<Int>): Boolean {
    var counter = 0
    var min = seq[0]
    val map = mutableMapOf<Int, Boolean>()
    for (i in 0 until seq.size - 1) {
        if (seq[i + 1] <= seq[i]) {
            counter += 1
        }
        if (counter > 1)
            return false

        min = seq[i]
    }

    return true

}

fun main() {

}