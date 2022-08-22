package com.br.competitions.circuit.aug.studies

/*
    https://www.geeksforgeeks.org/range-lcm-queries/
    https://tutorialspoint.dev/data-structure/arrays/range-lcm-queries
 */


private fun lcm(a: Long, b: Long): Long {
    fun gcd(a: Long, b: Long): Long =
        if(b % a == 0L) {
            b
        } else {
            gcd(b, a % b)
        }

    return a * b / gcd(a, b)
}


private fun lcm(a: Int, b: Int): Int {
    fun gcd(a: Int, b: Int): Int =
        if(b % a == 0) {
            b
        } else {
            gcd(b, a % b)
        }

    return a * b / gcd(a, b)
}