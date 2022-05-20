package src.com.br.cp.recursion.dp.coin

/**
 * https://medium.com/cs-dojo/an-introduction-to-dynamic-programming-89fdd3549d54
 *
 * Considere um jogo onde o jogador pode fazer 3, 5 ou 10 pontos por jogada. Dado um total
 * de pontos N e sabendo quantos pontos um jogador por fazer por partida,
 * encontrar o numeo de formas de alcançae essa ponutacao.
 *
 * Esse é um problema de contagem de combinacao
 *
 * Exemplo, N = 20 temos 4 formas de alcançar esse resultdo
 *
 * 5, 5, 5, 5
 * 10, 10
 * 10, 5, 5
 * 3, 3, 3, 3, 3, 5
 *
 */


/**
 * Caracteristicas do problema
 * 1) possui uma subestrutura otima
 *    - Para computar o numero de formas de alcancar o valor N somando os valores um conjunto S de valroe
 *    podemos dividir o problema em:
 *      a - A solucao contem o valor S[i]
 *      b - A solucao nao contem o S[i]
 *
 *      Esse problema é similar ao problema das moedas.
 *      Sua coplexidade é de 2 ^ N
 *      Para cada valor "alvo" de 1 a N testamos se incluir ou nao o i-esima valor do conjunto S
 *      cabe na solucao ou nao
 *      Exemplo se o valor N = 2
 */

fun recursiveCountSolutions(targetValue: Int, set: Array<Int>, idx: Int): Int {
    return if (targetValue == 0) {
        1
    } else if (targetValue < 0 || idx < 0) {
        0
    } else if (set[idx] > targetValue) {
        recursiveCountSolutions(targetValue, set, idx - 1)
    } else {
        val p = recursiveCountSolutions(targetValue - set[idx], set, idx) // solucao com idx-value
        val q = recursiveCountSolutions(targetValue, set, idx - 1)   // solucao sem idx-value
        p + q
    }
}

fun testRecursiveCountSolutions(targetValue: Int, set: Array<Int>, idx: Int): Int {
    return if (targetValue == 0) {
        1
    } else if (targetValue < 0 || idx > set.size - 1) {
        0
    } else if (set[idx] > targetValue) {
        recursiveCountSolutions(targetValue, set, idx + 1)
    } else {
        val p = recursiveCountSolutions(targetValue - set[idx], set, idx) // solucao com idx-value
        val q = recursiveCountSolutions(targetValue, set, idx + 1)   // solucao sem idx-value
        p + q
    }
}

private fun checkRecursiveCountSolutions() {
    arrayOf(
        Pair(arrayOf(1, 2, 3), 5),
        Pair(arrayOf(3, 5, 10), 20),
        Pair(arrayOf(3, 5, 10), 13),
        Pair(arrayOf(3, 5, 10), 35),
        Pair(arrayOf(3, 5, 10, 15, 20), 35),
    ).forEach { (values, target) ->
        val s = recursiveCountSolutions(target, values, values.size - 1)
        val r = testRecursiveCountSolutions(target, values, 0)
        val t = topDown(target, values, values.size - 1)
        println("$s, $r, $t")
    }
}

fun topDown(targetValue: Int, set: Array<Int>, idx: Int): Int {

    fun topDown(targetValue: Int, set: Array<Int>, buffer: Array<Int>, idx: Int): Int {
        return if (targetValue == 0) {
            1
        } else if (targetValue < 0 || idx < 0) {
            0
        } else if (buffer[targetValue] > 0) {
            buffer[targetValue]
        } else if (set[idx] > targetValue) {
            recursiveCountSolutions(targetValue, set, idx - 1)
        } else {
            val p = recursiveCountSolutions(targetValue - set[idx], set, idx) // solucao com idx-value
            val q = recursiveCountSolutions(targetValue, set, idx - 1)   // solucao sem idx-value
            buffer[targetValue] = p + q
            buffer[targetValue]
        }
    }

    val buffer = Array(targetValue + 1) { 0 }
    buffer[0] = 1
    return topDown(targetValue, set, buffer, idx)
}

fun bottoUp(targetValue: Int, set: Array<Int>) {
    val memory = Array(targetValue + 1) { Array(set.size) { 0 } }
    for (currentTarget in 1..targetValue) {
        for (idx in set.indices) {


            if (set[idx] <= currentTarget) {
                memory[currentTarget][idx] += 1
            } else {
                memory[currentTarget][idx] = 1
            }
        }
    }
}


fun main() {
    checkRecursiveCountSolutions()
}