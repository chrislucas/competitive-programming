package src.com.br.cp.site.codesignal.arcade.intro.lvl2

/*
    https://app.codesignal.com/arcade/intro/level-2/2mxbGwLzvkTCKAJMG
    DONE
 */

fun strangeSolution(seq: MutableList<Int>): Boolean {
    var counter = 0
    var min = seq[0]
    val map = mutableMapOf<Int, Boolean>()
    map[min] = true
    for (i in 1 until seq.size - 1) {
        if (seq[i] <= min) {
            val hasKey = map.containsKey(seq[i])
            val keysGreatThan = map.keys.count { it > seq[i] }
            if (seq[i] < seq[i + 1] && !hasKey && keysGreatThan == 1) {
                min = seq[i]
            }
            counter += 1
        } else {
            map[seq[i]] = true
            min = seq[i]
        }
        if (counter > 1)
            return false
    }

    if (seq[seq.size - 1] <= min && counter == 1) {
        return false
    }
    return true
}


/*
    Essa aqui ainda nao resolve o problema
 */
fun straightSolution(seq: MutableList<Int>): Boolean {
    var counter = 0
    for (i in 1 until seq.size - 1) {
        if (seq[i] <= seq[i - 1])
            counter += 1
        if (counter > 1) {
            return true
        }
        if (i > 2 && seq[i] <= seq[i - 2] && seq[i + 1] <= seq[i - 1]) {
            return false
        }
    }
    return true
}

fun s3(seq: MutableList<Int>): Boolean = straightSolution(seq)


fun main() {
    arrayOf(
        mutableListOf(10, 1, 2, 3, 4, 5), // true
        mutableListOf(1, 2, 5, 3, 5), // true
        mutableListOf(3, 6, 5, 8, 10, 20, 15), // false
        mutableListOf(40, 50, 60, 10, 20, 30) // false - test 11
    ).forEach {
        println(strangeSolution(it))
        println(straightSolution(it))
    }
}