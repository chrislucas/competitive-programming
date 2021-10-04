package src.com.br.kotlin.range

/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/
 *
 * Represents a range of values
 *
 *  * Intervalos
 * https://www.infoescola.com/matematica/intervalo/
 *
 * INTERVALOS ABERTOS
 *
 * Intervalo aberto ] x, y [ = {q  existe nos Reais: x < q < y }
 * dizemos que um intervalo eh aberto  quando seus extremos nao estao incluidos
 *
 * x = -5, y = 0 -> x < q < y -> ]-5, 0 [ -> S = {q Existe N: x < q < y}
 *
 * intervalo aberto indidando um dos extremos
 *  -> ] x, +inf [ aberto a DIREITA
 *  -> ] -inf, y [ aberto a ESQUERDA
 * intervalo aberto a direita ] x, +inf [ -> {q Existe Reais : q > x }
 * intervalo aberto a esquerda ] -inf, y [ -> {q Existe Reais : q < y}
 *
 * INTERVALO FECHADO: Aquele em que seus extremos sao inclusidos
 * [a, b] = { x Existe R : a <= x <= b }
 *
 * INTERVALO SEMI-ABERTO ou SEMI-FECHADO: Aquele cujo um dos extremos é incluido
 *
 * [ a, b [ = semi aberto  a direita = {x E R: a <= x < b}
 * // com extremos infinito
 * [ a, +INF [ = semi aberto  a direita = {x E R: a <= x }
 *
 * ] a, b ] = semi aberto  a esquerda = {x E R: a < x <= b}
 *
 * // com extremos infinito
 * ] -INF, b ] = semi aberto  a esquerda = {x E R: x <= b}
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

class GenClosedRange<T : Comparable<T>>(
    override val start: T,
    override val endInclusive: T
) : ClosedRange<T> {
    override fun toString(): String = "$start .. $endInclusive"
}


private fun checkMyComparableClosedRange() {
    val range = GenClosedRange(1, 20)
    println(range)
    println(range.contains(19))

    val charRange = GenClosedRange('a', 'z')
    println(charRange)
    println(charRange.contains('c'))
}

private fun checkCharRange() {
    /**
     * definicao da classe CharRange
     * class CharRange(start: Char, endInclusive: Char) :
     *  CharProgression(start, endInclusive, 1), ClosedRange<Char>
     *
     * */
    val range = ('a'..'z')
    val reversedRange = range.reversed()
    println(range.joinTo(StringBuilder(), separator = "|").toString())
    println(reversedRange)
    println(reversedRange.joinTo(StringBuilder(), separator = "|").toString())
}

private fun checkIntRange() {
    val range = (1..25)
    val reversedRange = range.reversed()
    println("$range\n$reversedRange")
    println(range.joinTo(StringBuilder(), separator = "|").toString())
    println(reversedRange.joinTo(StringBuilder(), separator = "|").toString())
}

private fun checkIntRangeWithStep() {
    val range = (1..25 step 5)
    val reversedRange = range.reversed()
    println("$range\n$reversedRange")
    println(range.joinTo(StringBuilder(), separator = "|").toString())
    println(reversedRange.joinTo(StringBuilder(), separator = "|").toString())


    val anotherRange = (100 downTo 25 step 6)
    println(anotherRange.joinTo(StringBuilder(), separator = "|").toString())

}

private fun checkCharRangeWithStep() {
    val range = ('z' downTo 'a' step 5)
    val reversedRange = range.reversed()
    println("$range\n$reversedRange")
    println(range.joinTo(StringBuilder(), separator = "|").toString())
    println(reversedRange.joinTo(StringBuilder(), separator = "|").toString())
}

fun main() {
    checkMyComparableClosedRange()
}
