package src.com.br.cp.site.algebra.kotlin.numtheory

// https://usaco.guide/gold/divisibility?lang=java

private val interval = (1..6000)

fun isDivisibleBy3(value: Int): Boolean {
    var sum = 0
    var cpy = value
    while (cpy > 0) {
        sum += cpy % 10
        cpy /= 10
    }
    return sum % 3 == 0
}

fun isDivisibleBy9(value: Int): Boolean {
    var sum = 0
    var cpy = value
    while (cpy > 0) {
        sum += cpy % 10
        cpy /= 10
    }
    return sum % 9 == 0
}

// se a soma dos ultimos 2 digitos eh divisivel por 4
fun isDivisibleBy4(value: Int): Boolean = (value % 100) % 4 == 0

fun isDivisibleBy5(value: Int): Boolean = (value % 10) == 0 || (value % 10) == 5

fun isDivisibleBy6(value: Int): Boolean {
    fun isDivisibleBy3(value: Int): Boolean {
        var sum = 0
        var cpy = value
        while (cpy > 0) {
            sum += cpy % 10
            cpy /= 10
        }
        return sum % 3 == 0
    }
    return (value % 2) == 0 && isDivisibleBy3(value)
}

/**
 * pegue o ultimo digito e multiplique por 2
 * subtraido o resultado do numero original sem o ultumo digito
 * se a subtracao for multiplo de 7 entao o numero tambem eh
 * exemplo: 343
 * ultimo_digito = 3
 * 34 - (3 * 2) = 28
 * 28 mod 7 == 0
 */
fun isDivisibleBy7(value: Int): Boolean =
    ((value / 10) - (value % 10) * 2) % 7 == 0

/**
 * Similar ao algoritmo para divisibilidade por 7
 * Dum numero S remova o ultimo digito,
 * subtraia o resultado do numero que restou sem o ultimo digito
 * Exemplo: 121
 * 12 - 1 = 11
 * 11 mod 11 = 0
 */
fun isDivisibleBy11(value: Int): Boolean =
    (value / 10- value % 10) % 11 == 0


fun isDivisibleBy8(value: Int) = (value % 1000) % 8 == 0

fun isDivisibleBy10(value: Int) = value % 10 == 0

fun isDivisibleBy12(value: Int): Boolean {
    fun isDivisibleBy4(value: Int): Boolean = (value % 100) % 4 == 0

    fun isDivisibleBy3(value: Int): Boolean {
        var sum = 0
        var cpy = value
        while (cpy > 0) {
            sum += cpy % 10
            cpy /= 10
        }
        return sum % 3 == 0
    }

    return isDivisibleBy3(value) && isDivisibleBy4(value)
}


private fun checkIsDivisibleBy(divBy: (Int) -> Boolean) {
    interval.filter { divBy(it) }
        .joinToString(" ")
        .let { println(it) }
}

fun main() {
    //println(isDivisibleBy7(343))
    //checkIsDivisibleBy(::isDivisibleBy3)
    //checkIsDivisibleBy(::isDivisibleBy4)
    //checkIsDivisibleBy(::isDivisibleBy5)
    //checkIsDivisibleBy(::isDivisibleBy6)
    //checkIsDivisibleBy(::isDivisibleBy7)
    //checkIsDivisibleBy(::isDivisibleBy8)
    //checkIsDivisibleBy(::isDivisibleBy9)
    //checkIsDivisibleBy(::isDivisibleBy10)
    //checkIsDivisibleBy(::isDivisibleBy11)
    checkIsDivisibleBy(::isDivisibleBy12)
}