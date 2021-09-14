package com.br.algo.integer.bitwise

import kotlin.math.log2


// log A base B = log A base C / log B base C
fun Int.countDigits(base: Int): Int = (log2(this * 1.0) / log2(base * 1.0)).toInt() + 1