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

fun isDivisibleBy7(value: Int): Boolean {
    val last = (value % 10) * 2

    return true
}

fun isDivisibleBy11(value: Int): Boolean {
    return true
}

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
    //checkIsDivisibleBy(::isDivisibleBy3)
    //checkIsDivisibleBy(::isDivisibleBy4)
    //checkIsDivisibleBy(::isDivisibleBy5)
    //checkIsDivisibleBy(::isDivisibleBy6)
    //checkIsDivisibleBy(::isDivisibleBy7)
    //checkIsDivisibleBy(::isDivisibleBy8)
    //checkIsDivisibleBy(::isDivisibleBy9)
    checkIsDivisibleBy(::isDivisibleBy10)
    //checkIsDivisibleBy(::isDivisibleBy11)
    //checkIsDivisibleBy(::isDivisibleBy12)
}