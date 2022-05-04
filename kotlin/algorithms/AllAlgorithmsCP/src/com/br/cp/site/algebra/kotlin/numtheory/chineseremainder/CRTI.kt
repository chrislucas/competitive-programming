package src.com.br.cp.site.algebra.kotlin.numtheory.chineseremainder

/**
 * https://www.geeksforgeeks.org/chinese-remainder-theorem-set-1-introduction/
 *
 * Problema
 *
 * dado um ARRAY N[0 .. k-1] e um ARRAY R [0 .. k-1], t0do o par é coprimo (gcd entre os pares = 1),
 * encontre um valor X mínimo positivo tal que
 *
 * x % N[0] = R[0]
 * ...
 * x % N[k-1] = R[k-1]
 *
 * Dado K números que em pares sao coprimos entre si, e dado mais k números que são restos de uma divisão
 * por um número x desconhecido, encontre o valor mínimo possível para x que produza tais restos
 *
 * Exemplo de entrada
 * N [5, 7]
 * R [1, 3]
 *
 * Saida
 * 31
 *
 * 31 é o menor valor para x tal que
 * 31 % 5 == 1
 * 31 % 7 == 3
 *
 * N [3, 4, 5]
 * R [2, 3, 1]
 * x = 11
 */


val CASES = arrayOf(
    mapOf(5 to 1, 7 to 3),
    mapOf(3 to 2, 4 to 3, 5 to 1)
)


private fun gcd(a: Int, b: Int): Int {
    return if (a % b == 0) {
        b
    } else {
        gcd(b, a % b)
    }
}

private fun gcd(array: Array<Int>): Int {
    var result = gcd(array[0], array[1])
    for (k in 2 until array.size) {
        result = gcd(result, array[k])
    }
    return result
}

private fun check() {
    CASES.forEach { case ->
        //val n = case.keys
        //val r = case.values
    }
}

// http://www.alcula.com/calculators/math/gcd/#gsc.tab=0
private fun checkGCDArray() {
    println(gcd(arrayOf(720, 200, 84)))
    println(gcd(arrayOf(200, 84, 23)))
    println(gcd(arrayOf(1232, 234, 120)))
    println(gcd(arrayOf(1232, 500, 234, 120)))
    println(gcd(arrayOf(15405, 12345, 14565, 132025)))
    println(gcd(arrayOf(345678, 123678, 345897)))
}

fun main() {
    checkGCDArray()
}