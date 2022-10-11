package src.com.br.geeksforgeeks.math.section

import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

/*
    Efficient program to print all prime factors of a given number
    https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
 */


/*
    Solucao 1: Complexidade O(sqrt(n))
    A abordagem 1 usa a ideia que
    1 - elimanos os fatores primos pares ao dividir N por 2
    ate N se tornar par
    2 - dividir N de 3 ate sqrt(N)
        - sabemos que os fatores primos de N nao podem ser maiores
        do que sqrt(n) porque senao existiriam
        2 numeros a e b tal que a * b > sqrt(N)
        o que seria um absurdo
 */
private fun approach1(n: Int): Pair<Int, Map<Int, Int>> {
    val factors = mutableMapOf<Int, Int>()
    var cn = n
    while (cn % 2 == 0) {
        factors[2] = factors[2]?.plus(1) ?: 1
        cn /= 2
    }
    for (i in 3..sqrt(cn * 1.0).toInt()) {
        while (cn % i == 0) {
            factors[i] = factors[i]?.plus(1) ?: 1
            cn /= i
        }
    }
    if (cn > 2) {
        factors[cn] = 1
    }
    return n to factors
}


private fun checkApproach1() {

    (120000..120500).forEach {
        val time = measureTimeMillis {
            println(
                approach1(it)
            )
        }
        println(String.format("%.6f", time / 1000.0))
    }

    //println(approach1(Int.MAX_VALUE))
    //println(approach1(Int.MAX_VALUE - 1))
}


/*
    Abordagem 2: Similar ao Crivo de Eratosthenes
    Complexidade: O(log n)

    - É possivel recuperar todos os numeros compostos De N ao
    dividi-lo comecando por 2 e subindo
        - Essa abordagem funciona pq numeros compostos tem
        seus fatores primos em pares
            - 6 = 2 * 2, 10 = 2 * 5
        - E numeros primos tbm porém os pares são 1 e ele mesmo
 */
private fun approach2(n: Int): Pair<Int, Map<Int, Int>> {
    val factors = mutableMapOf<Int, Int>()
    var div = 2
    var cn = n
    while (cn > 1) {
        if (cn % div == 0) {
            factors[div] = factors[div]?.plus(1) ?: 1
            cn /= div
        } else {
            div += 1
        }
    }
    return n to factors
}

private fun checkApproach2() {
    println(approach2(315))
    println(approach2(Int.MAX_VALUE))
    println(approach2(Int.MAX_VALUE - 1))
    println(approach2(Int.MAX_VALUE - 2))
}

private fun compareApproaches(range: IntProgression) {

    val map = mapOf<Int, MutableList<Pair<Int, Pair<Double, Double>>>>(
        1 to mutableListOf(),
        2 to mutableListOf(),
        3 to mutableListOf()
    )

    for (i in range) {
        val p = measureTimeMillis {
            approach1(i)
        } / 1000.0

        val q = measureTimeMillis {
            approach2(i)
        } / 1000.0

        if (p < q) {
            map[1]?.plusAssign(Pair(i, p to q))
        } else if (p > q) {
            map[2]?.plusAssign(Pair(i, p to q))
        } else {
            map[3]?.plusAssign(Pair(i, p to q))
        }
    }


    val count = map.flatMap { entry ->
        listOf(
            Pair(entry.key, entry.value.size)
        )
    }

    println("$count")
}


fun main() {

    arrayOf(
        Int.MAX_VALUE downTo (Int.MAX_VALUE - 50),
        Int.MAX_VALUE downTo (Int.MAX_VALUE - 100)
    ).forEach { progression ->
        compareApproaches(progression)
        println("************************************")
    }
}