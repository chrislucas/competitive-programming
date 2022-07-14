package src.com.br.cp.site.codesignal

import kotlin.io.*;

/*
Write a function that takes an integer as an input and return the next larger number that is a palindrome.

Example Input: 1000
Example Output: 1001

Example Input: 1200
Example Output: 1221
*/


// O (n)
fun make(value: Int): String {
    val str = "$value"
    val lim = if(str.length % 2 == 1) str.length / 2  - 1 else str.length / 2
    val start = str.substring(0, lim)

    val reversed = start.reversed()
    val possiblePalindrome: String = start + reversed
    // println("$possiblePalindrome, ${possiblePalindrome.toInt()}")

    return if(possiblePalindrome.toInt() <= value) {
        val newStart = "${start.toInt() + 1}"
        val newReversed = newStart.reversed()
        newStart + newReversed
    } else {
        possiblePalindrome
    }

    // return possiblePalindrome

}

private fun findNextPalindrome(value: Int): String {

    // O(n)
    fun isPalidrome(value: Int) : Boolean {

        var str = "$value"
        var i = 0
        var lim = if(str.length % 2 == 1) str.length / 2  - 1 else str.length / 2
        var j = str.length - 1

        while(i <= lim) {
            if(str[i] != str[j]) {
                return false
            }
            i += 1
            j -= 1
        }

        return true
    }


    var target = value + 1
    // O(nˆ2)
    while(!isPalidrome(target)) {
        target += 1
    }

    return "$target"
}

fun main(args: Array<String>) {
    arrayOf(1000, 1200, 123320, 12300, 123322, 11, 22).forEach {
            value ->
        // println(findNextPalindrome(value))
        println(make(value))
    }
    // 1201 -> 1221
    // 123322 -> 124421

    // 12300 - 12 3 00 -> 12 3 21 -> 12321
    // 12340 -> 12421
}
