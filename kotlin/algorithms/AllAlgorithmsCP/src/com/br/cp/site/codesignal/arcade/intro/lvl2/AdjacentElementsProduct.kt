package src.com.br.cp.site.codesignal.arcade.intro.lvl2

import kotlin.math.max

/*
    https://app.codesignal.com/arcade/intro/level-2/xzKiBHjhoinnpdh6m
 */

fun solution(input: MutableList<Int>): Int {

    fun s1(input: MutableList<Int>): Int {
        var acc = input[0] * input[1]
        for (i in 1 until input.size - 1) {
            val current = input[i] * input[i + 1]
            if (current > acc) {
                acc = current
            }
        }
        return acc
    }


    return s1(input)

}