package com.br.algo.math.lib.algebra

import kotlin.math.exp
import kotlin.math.log2
import kotlin.math.roundToLong


/**
 * Troca de bases
 *
 * log A base B = C -> B ^ C  = A
 *
 * log A base B pode ser escrito -> log A base D / log B base D
 * */
fun log(base: Int, argument: Int) = log2(argument * 1.0) / log2(base * 1.0)

fun log(base: Double, argument: Double) = log2(argument) / log2(base)

fun logE(argument: Double) = log(Math.E, argument)

fun Int.digits(base: Int = 10) = log(base * 1.0, this * 1.0) + 1


/**
 * Propriedades logaritmicas
 *
 * Logaritmo de produto
 * log A * C base B = log A base B + log C base B
 *
 * Logaritmo de quociente
 * log A / C base B = log A base B - log C base B
 *
 * logaritmo de potencia
 * log A ^ C base B =  C * log A base B
 *
 * Mudanca de base
 * log A base B = log A Base C / log B base C
 *
 * consequencias diretas da definicao de logaritmo
 *
 * por definicao log B base A  = C pq A ^ C = B
 *
 * 1) A ^ (log B base A) = B
 *
 * log B base A = C -> A ^ C = B
 *
 * 2) log A ^ M base A = M
 *
 * log A base A = 1, log A ^ 2 base A = 2, log A ^ 3 base A = 3 ... log A ^ M base A = M
 *
 * 3) Se log A base B e log C base B sao iguais B e C sao iguais
 *
 * */


/**
 * n root (p ^ m)  = p ^ (m/n)
 *
 * 2 root (10 ^ 10) = 10 ^ (10 / 2)
 *
 * n-esima raiz de x ^ m = x ^ (m/n) ->
 *
 * indice root (argumento) ^ m (geralmente 1) = raiz
 *
 * root = (argumento) ^ m / indice = raiz
 *
 * exp fractional
 * https://www.mathsisfun.com/algebra/exponent-fractional.html
 * */
fun ithIntRoot(argument: Int, e: Int = 1, index: Int): Double =
    exp(log(Math.E, argument * 1.0) * ((e * 1.0) / index))

/**
 * funcao raiz
 *
 * n-esima raiz de x ^ m = x ^ (m/n)
 * A biblioteca de matematica de muitas linguagens tem uma funcao chamada exp que calcula
 * a exponencial do numero de Euler na N
 * https://www.geeksforgeeks.org/exp-function-cpp/
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/exp.html
 *
 * Exponential Identity
 * https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Exponential_identity
 * https://pt.wikipedia.org/wiki/Identidade_de_Euler
 * http://tobybartels.name/MATH-0950/2007SP/monomials/
 * https://www.mathsisfun.com/numbers/nth-root.html
 * */

fun ithDoubleRoot(argument: Double, e: Int = 1, index: Int): Double =
    exp(log(Math.E, argument) * ((e * 1.0) / index))

/**
 * e = numero de euler
 *
 * n-esima raiz de S ^ m =  e ^ (m/n * ln S)
 **/
fun ithDouble2Root(argument: Double, e: Int = 1, index: Int): Double =
    squaringDouble2Exp(Math.E, log(Math.E, argument) * (e / index))