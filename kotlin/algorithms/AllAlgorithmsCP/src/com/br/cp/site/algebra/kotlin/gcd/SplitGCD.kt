package src.com.br.cp.site.algebra.kotlin.gcd


/**
 * https://pt.wikipedia.org/wiki/Algoritmo_de_Euclides_estendido
 */
data class StepGCD(val step: Long, val divisor: Long, val dividendo: Long, val quo: Long, val resto: Long)

fun splitGCD(a: Long, b: Long): List<StepGCD> {
    var aa = a
    var bb = b
    val steps = mutableListOf<StepGCD>()
    var step = 1L
    do {
        steps += StepGCD(step, aa, bb, aa / bb, aa % bb)
        val resto = aa % bb
        aa = bb
        bb = resto
        step += 1
    } while (resto != 0L)
    return steps
}

fun anotherSplit(a: Long, b: Long): MutableList<StepGCD> {
    var aa = a
    var bb = b
    var step = 1L
    val steps = mutableListOf<StepGCD>()
    steps += StepGCD(step, aa, bb, aa/bb, aa%bb)
    while (aa % bb != 0L) {
        val resto = aa % bb
        aa = bb
        bb = resto
        step += 1
        steps += StepGCD(step, aa, bb, aa/bb, aa%bb)
    }

    return steps
}

fun recursiveSplit(a: Long, b: Long, step: Long, steps: MutableList<StepGCD>) {
    if (a % b == 0L) {
        steps += StepGCD(step, a, b, a / b, a % b)
        return
    } else {
        steps += StepGCD(step, a, b, a / b, a % b)
        recursiveSplit(b, a % b, step + 1, steps)
    }
}

private fun checkSplitGCD() {
    println(splitGCD(10, 15))
    println(splitGCD(35, 10))
    println(splitGCD(31, 2))
    println(splitGCD(31, 15))
}

private fun checkAnotherSplitGCD() {
    println(anotherSplit(120, 23))
    println(anotherSplit(10, 15))
    println(anotherSplit(35, 10))
    println(anotherSplit(31, 2))
    println(anotherSplit(31, 15))
}

private fun checkRecursiveSplit() {
    val steps = mutableListOf<StepGCD>()
    recursiveSplit(10, 15, 0, steps)
    println(steps)
}

fun main() {
    //checkSplitGCD()
    //checkRecursiveSplit()
    checkAnotherSplitGCD()
}