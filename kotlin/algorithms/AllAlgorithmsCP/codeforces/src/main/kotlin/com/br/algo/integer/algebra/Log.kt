package com.br.algo.integer.algebra


import kotlin.math.log10
import kotlin.math.log2

/**
 * https://en.wikipedia.org/wiki/Logarithm#Change_of_base
 * https://brasilescola.uol.com.br/matematica/mudanca-bases.htm#
 * https://brasilescola.uol.com.br/matematica/propriedades-operatorias-dos-logaritmos.htm
 *
 * Properties
 * http://dl.uncw.edu/digilib/Mathematics/Algebra/mat111hb/EandL/logprop/logprop.html
 * https://en.wikipedia.org/wiki/List_of_logarithmic_identities
 *
 * CS
 * https://www.geeksforgeeks.org/logarithm/
 * https://www.cs.bham.ac.uk/~jdk/Modules/LecSlides/logs.pdf
 * https://www.britannica.com/science/logarithm
 *
 * */

// log A base B = log A base C / log B base C
// log X base B + 1 = numero de digitos de X na base B
fun Int.countDigits(base: Int): Int = (log2(this * 1.0) / log2(base * 1.0)).toInt() + 1

// log A base B = log A base C / log B base C
infix fun Int.log(base: Int) = log10(this * 1.0) / log10(base * 1.0)