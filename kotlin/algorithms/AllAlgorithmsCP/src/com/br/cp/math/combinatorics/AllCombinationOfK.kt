package src.com.br.cp.math.combinatorics


import java.lang.StringBuilder

infix fun Int.isSet(nth: Int) = this and (1 shl (nth - 1)) > 0

fun allCombinationOfK(k: Int): String{
    val list = mutableListOf<String>()
    for (i in 0 until (1 shl k)) {
        val sb = StringBuilder()
        for (j in k downTo 1) {
            sb.append(if(i isSet j) "1" else "0")
        }
        list.add(sb.toString())
    }
    return list.joinToString("\n")
}

private fun check1() {
    (2 .. 5).forEach {
        println("$it\n${allCombinationOfK(it)}")
    }
}

fun main() {
    check1()
}