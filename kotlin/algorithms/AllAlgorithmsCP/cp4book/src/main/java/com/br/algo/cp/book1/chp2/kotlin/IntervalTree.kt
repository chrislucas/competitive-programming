package com.br.algo.cp.book1.chp2.kotlin

/*
https://www.geeksforgeeks.org/interval-tree/
*/
class IntervalTree {


    data class Interval(val low: Int, val high: Int) {
        override fun toString(): String = "[$low, $high]"
    }

}