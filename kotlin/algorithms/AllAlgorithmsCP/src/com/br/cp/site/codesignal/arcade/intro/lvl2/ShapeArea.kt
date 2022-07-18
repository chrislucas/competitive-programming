package src.com.br.cp.site.codesignal.arcade.intro.lvl2

/*
    https://app.codesignal.com/arcade/intro/level-2/yuGuHvcCaFCKk56rJ
 */

fun solution(n: Int): Int {

    fun rec(n: Int): Int {
        return if (n < 2) {
            1
        } else {
            solution(n - 1) + (4 * (n - 1))
        }
    }

    fun it(n: Int): Int {
        return if (n < 2) {
            1
        } else {
            var acc = 1
            for (i in 2..n) {
                acc += (4 * (i - 1))
            }
            acc
        }
    }

    return it(n)

}


fun main() {
    (1..10).forEach {
        println("$it = ${solution(it)}")
    }
}