package src.com.br.kotlin.range


infix fun ClosedRange<Double>.step(step: Double) =
    if (step < 0.0) {
        throw IllegalArgumentException("")
    } else {
        DoubleProgression(start, endInclusive, if (start <= endInclusive) step else -step)
    }


infix fun DoubleProgression.step(value: Double) =
    if (value < 0.0) {
        throw IllegalArgumentException("")
    } else {
        DoubleProgression(this, value)
    }

infix fun Double.by(that: Double) = DoubleProgression(this, that, 1.0)

infix fun Double.downTo(that: Double): ClosedRange<Double> = this.rangeTo(that)

class DoubleProgression(private val start: Double, private val end: Double, private val step: Double) :
    Iterable<Double> {

    constructor(instance: DoubleProgression, step: Double) : this(
        instance.start,
        instance.end,
        // se eu quiser que a expressao by funcione para start > end
        if (instance.start <= instance.end) step else -step
        // senao comento a linha de cima e descomento a linha de baixo
        // step
    )

    class DoubleIterator internal constructor(
        start: Double,
        private val end: Double,
        private val step: Double
    ) : Iterator<Double> {

        private var mStart = start

        override fun hasNext(): Boolean {
            return if (isNotEmpty()) {
                if (step > 0) {
                    mStart <= end
                } else {
                    mStart >= end
                }
            } else {
                false
            }
        }

        private fun isNotEmpty() = !isEmpty()

        private fun isEmpty(): Boolean {
            return if (step > 0) {
                mStart > end
            } else {
                mStart < end
            }
        }

        override fun next(): Double {
            val current = mStart
            mStart += step
            return current
        }
    }

    override fun iterator(): Iterator<Double> = DoubleIterator(start, end, step)
}

private fun checkClosedDoubleRange(progression: DoubleProgression) {
    println(progression.joinTo(StringBuilder(), "|"))
}

private fun checkDownTo(progression: DoubleProgression) {
    println(progression.joinTo(StringBuilder(), "|"))
}


private fun check1() {
    checkClosedDoubleRange(10.5.rangeTo(15.5) step .5)
    // testantdo o rangeTO com start > end
    checkClosedDoubleRange(15.5.rangeTo(10.5) step .5)
}

private fun check2() {
    checkDownTo(13.5 downTo 10.5 step .5)
    checkDownTo(15.5 downTo 10.5 step .5)
    checkDownTo(15.5 downTo 15.5 step .5)
    // testando  start < end num progressao decrescente
    checkDownTo(15.5 downTo 16.5 step .5)
}

private fun check3() {
    for (i in 10.5 by 16.5) {
        println(i)
    }
    println("")
    for (i in 10.5 by 16.5 step .5) {
        println(i)
    }
}

private fun check4() {
    println((10.5 by 16.5).joinTo(StringBuilder(), "|"))
    println((10.5 by 16.5 step .5).joinTo(StringBuilder(), "|"))
    println((16.5 by 16.0 step .5).joinTo(StringBuilder(), "|"))
    println((16.5 by 0.0 step .5).joinTo(StringBuilder(), "|"))
}


fun main() {
    check4()
}