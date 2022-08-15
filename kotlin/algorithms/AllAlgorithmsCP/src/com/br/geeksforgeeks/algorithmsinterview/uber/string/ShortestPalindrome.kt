package src.com.br.geeksforgeeks.algorithmsinterview.uber.string

import kotlin.io.*;



fun main(args: Array<String>) {
    when {
        generateSmallestPalindrome("") != "" -> {
            println("failed base case!")
        }
        generateSmallestPalindrome("abba") != "abba" ||
                generateSmallestPalindrome("racecar") != "racecar" -> {
            println("failed already palindrome!")
        }
        generateSmallestPalindrome("abc") != "abcba" ||
                generateSmallestPalindrome("PALINDROME") != "PALINDROMEMORDNILAP" -> {
            println("failed generating simple palindrome!")
        }
        generateSmallestPalindrome("abcdc") != "abcdcba" -> {
            println("failed generating shortest palindrome!")
        }

        generateSmallestPalindrome("abcdc") == "abcdcba" -> {
            println("nice => abcdcba")
        }
        else -> {
            println("Pass!")
        }
    }
}

/**
 * Given an input String, add the required letters to generate the smallest palindrome.
 *
 * Palindrome is a word that can be read the same from left to right as from right to left.
 * In our case, it just means that, if we revert the String and we compare with the resulting one,
 * they will be the same.
 *
 * NOTE: Do not worry if the resulting word is not an english word or if it actually exists in any language.
 *
 * EXAMPLE
 * input:
 * PALINDROME
 *
 * Output:
 * PALINDROMEMORDNILAP
    abc -> abcba -> not abccba
    abcd -> abcdcba

    ba

 */
fun generateSmallestPalindrome(input: String): String {

    return if(input == input.reversed()) {
        input
    } else {
        /*
            abcdc -> abcdc dcba ->  abcdcba
            bcdc cba ->  bcdcdcba

            bcdcba -> bcdcdcb > bcdcb
        */
        val substring = input.substring(0, input.length - 1).reversed() // O (n)
        var idx = 1
        val len = substring.length - 1
        var possibleAnswer = input + substring
        // O (n ^ 2)
        while(idx < len) {
            val newString = substring.substring(idx, len + 1)
            val possible =input + newString
            if(possible == possible.reversed()) {
                possibleAnswer = possible
            }
            idx += 1
        }

        possibleAnswer
    }
}
