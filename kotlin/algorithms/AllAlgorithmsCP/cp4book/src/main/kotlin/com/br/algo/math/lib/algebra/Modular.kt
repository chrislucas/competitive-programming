package com.br.algo.math.lib.algebra


/**
 * Properties
 * https://brilliant.org/wiki/modular-arithmetic/#modular-arithmetic-addition
 * http://www.crypto-it.net/eng/theory/modular-arithmetic.html
 * https://en.wikipedia.org/wiki/Modular_arithmetic
 * */

fun multiply(a: Int, b: Int, m: Int) = (a % m * b % m) % m

fun multiply(a: Long, b: Long, m: Long) = (a % m * b % m) % m

fun sum(a: Int, b: Int, m: Int) = (a % m + b % m) % m

fun sum(a: Long, b: Long, m: Long) = (a % m + b % m) % m