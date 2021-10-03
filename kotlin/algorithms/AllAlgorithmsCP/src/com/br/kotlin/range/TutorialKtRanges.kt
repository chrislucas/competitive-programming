package src.com.br.kotlin.range

import java.lang.StringBuilder

// https://www.baeldung.com/kotlin/ranges


private fun checkIteratingRange() {
    println("RangeTo")
    println((0 .. 9).joinTo(StringBuilder(), "|"))
    println( 0.rangeTo(9).joinTo(StringBuilder(), "|"))
    println( (0 .. 9 step  3).joinTo(StringBuilder(), "|"))

    println("\nDownTo")
    println( 9.downTo(1).joinTo(StringBuilder(), "|"))
    println( 9.downTo(1).step(3).joinTo(StringBuilder(), "|"))
    println( (100 downTo 5 step 5).joinTo(StringBuilder(), "|"))
}

private fun checkOperatorIn() {
    println(1 in -10 .. 10)
}


private fun <T:Comparable<T>> checkIteratingRangeByLoop() {
    for (i in 9 downTo 3 step 3) {
        println(i)
    }
    // rangeTo
    for(i in 3 .. 9 step 3) {
        println(i)
    }

    // rangeTo = from S to E-1
    for(i in 3 until 9 step 3) {
        println(i)
    }
}

private fun <T> checkIteratingTProgression(progression: Iterable<T>) {
    /*
    for (i in progression) {
        println(i)
    }
     */

    println(progression.joinTo(StringBuilder(), "|"))
}
fun main() {
    checkIteratingTProgression('z' downTo 'a' step 2)
    checkIteratingTProgression('z' downTo 'a' step 25)
    checkIteratingTProgression('z' downTo 'a' step 26)
    checkIteratingTProgression('a' .. 'z' step 2)

}