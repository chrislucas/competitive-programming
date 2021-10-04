package src.com.br.kotlin.range.trygeneric

/**
 * Explorando ideias de generalizacao
 * */

val <T : Comparable<T>> ClosedRange<T>.reversed: ClosedRange<T>
    get() = endInclusive..start


class ComparableRange<T : Comparable<T>>(
    private val startRange: T, private val end: T, step: (T) -> T
) :
    ComparableProgression<T>(startRange, end, step), ClosedRange<T> {

    override val endInclusive: T
        get() = end

    override val start: T
        get() = startRange

}

open class ComparableProgression<T : Comparable<T>>(
    private val start: T,
    private val end: T,
    private val step: (T) -> T
) :
    Iterable<T> {

    class ComparableIterator<T : Comparable<T>>(private val first: T, private val last: T, private val step: (T) -> T) :
        Iterator<T> {

        var current = first

        override fun hasNext(): Boolean = current > last

        override fun next(): T {
            if (hasNext()) {
                current = step(current)
            }
            return current
        }
    }

    override fun iterator(): Iterator<T> = ComparableIterator(start, end, step)
}

private fun <T : Comparable<T>> checkRange(range: ClosedRange<T>) {
    val reversedRange = range.reversed
    println(reversedRange)
}

fun main() {

}