package src.com.br.kotlin.range

import java.lang.StringBuilder

/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/
 *
 * Represents a range of values
 *
 *  * Intervalos
 * https://www.infoescola.com/matematica/intervalo/
 *
 * Intervalos abertos
 *
 * Intervalo aberto ] x, y [ = {q  existe nos Reais: x < q < y }
 * dizemos que um intervalo eh aberto quando seus quando seus extremos nao estao incluidos
 *
 * x = -5, y = 0 -> x < q < y -> ]-5, 0 [ -> S = {q Existe N: x < q < y}
 *
 * intervalo aberto indidando um dos extremos ] x, +inf [ (direita), ]-inf, y[ (esqyerda)
 * intervalo aberto a direita ] x, +inf [ -> {q Existe R : q > x }
 * intervalo aberto a esquerda ] -inf, y [ -> {q Existe R: q < y}
 *
 * Intervalo fechado: Aquele em que seus extremos sao inclusidos
 * [a, b] =  { x Existe R : a <= x <= b }
 *
 * Intervalo semiaberto: Aquele cujo um dos extremos nao esta incluido
 *
 *
 *
 * https://brasilescola.uol.com.br/matematica/intervalos.htm
 *
 *
 *
 * ************************************************************************************************************
 *
 * interface ClosedRange<T : Comparable<T>>
 *
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/
 *
 * Operador rangeTo
 * public operator fun <T : Comparable<T>> T.rangeTo(that: T): ClosedRange<T> = ComparableRange(this, that)
 *
 * */

class MyComparableClosedRange<T : Comparable<T>>(override val endInclusive: T, override val start: T) : ClosedRange<T>


private fun checkCharRange() {
    /**
     * definicao da classe CharRange
     * class CharRange(start: Char, endInclusive: Char) : CharProgression(start, endInclusive, 1), ClosedRange<Char>
     *
     * */
    val range = ('a' .. 'z')
    val reversedRange = range.reversed()
    println(range.joinTo(StringBuilder(), separator = "|").toString())
    println(reversedRange)
    println(reversedRange.joinTo(StringBuilder(), separator = "|").toString())
}

fun main() {
    checkCharRange()
}
