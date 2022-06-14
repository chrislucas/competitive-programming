package com.br.studies.dp.introduction

import java.lang.Integer.max

/*
 * https://www.quora.com/Are-there-any-good-resources-or-tutorials-for-dynamic-programming-DP-besides-the-TopCoder-tutorial/answer/Michal-Danil%C3%A1k?share=1&srid=3OBi
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/

 */

/*
 "Imagine you have a collection of N wines placed next to each other on a shelf.
  For simplicity, let's number the wines from left to right as they are standing on the shelf with integers from 1 to N
  respectively. The price of the ith wine is pi. (prices of different wines can be different).

  Because the wines get better every year, supposing today is the year 1, on year y the price of the ith wine will be y*pi,
  i.e. y-times the value that current year.

  You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year.
  One more constraint - on each year you are allowed to sell only
  either the leftmost or the rightmost wine on the shelf
  and you are not allowed to reorder the wines on the shelf
  (i.e. they must stay in the same order as they are in the beginning).

    You want to find out, WHAT IS THE MAXIMUM PROFIT YOU CAN GET, if you sell the wines in optimal order?"
 */


private val testCases = arrayOf(
    arrayOf(1,4,2,3),
    arrayOf(2,3,5,1,4)
)

/**
 * abordagem usando backtracking
 * */
private fun profit(values: Array<Int>, year: Int, le: Int, ri: Int): Int {
    return if (le > ri) {
        0
    } else {
        val  p = profit(values, year + 1, le + 1, ri) + year * values[le]
        val  q = profit(values, year + 1, le, ri - 1) + year * values[ri]
        max(p, q)
    }
}


private fun checkSolutions() {
    testCases.forEach {
        val a = profit(it, 1, 0, it.size - 1)
        println(a)
    }
}

fun main() {
    checkSolutions()
}