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

val cases = arrayOf(
    /*
    Pair(arrayOf(), 0),
    Pair(arrayOf(), 4),
    Pair(arrayOf(1), 4),
    Pair(arrayOf(2), 4),
     */
    Pair(arrayOf(2, 3), 4),
    Pair(arrayOf(1, 2, 3), 5),
    Pair(arrayOf(1, 2, 3), 4),
    Pair(arrayOf(3, 5, 10), 20),
    Pair(arrayOf(3, 5, 10), 13),
    Pair(arrayOf(3, 5, 10), 35),
    Pair(arrayOf(3, 5, 10, 15, 20), 35)
)

private fun checkRecursiveCountSolutions() {
    cases.forEach { (values, target) ->
        val r = recursiveCountSolutions(target, values, values.size - 1)
        val s = testRecursiveCountSolutions(target, values, 0)
        val t = topDown(target, values, values.size - 1)
        val u = bottoUp(target, values)
        val v = optBottomUp(target, values)
        println("$s, $r, $t $u, $v")
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

fun bottoUp(targetValue: Int, set: Array<Int>): Int {
    val m = targetValue + 1
    val n = set.size
    val states = Array(m) { Array(n) { 0 } }
    for (i in 0 until n) {
        states[0][i] = 1
    }
    for (currentState in 1..targetValue) {
        for (idx in 0 until n) {
            // usando o i-esimo valor caso ele seja menor ou igual
            val value = currentState - set[idx]
            val x = if (value >= 0) {
                states[value][idx]
            } else {
                0
            }
            // sem a i-esimo valor de set
            val y = if (idx > 0) {
                states[currentState][idx - 1]
            } else {
                0
            }
            states[currentState][idx] = x + y
        }
    }

    return states[targetValue][n - 1]
}

fun optBottomUp(targetValue: Int, set: Array<Int>): Int {
    val state = Array(targetValue + 1) { 0 }
    state[0] = 1
    for (value in set) {
        for (j in value..targetValue) {
            state[j] += state[j - value]
        }
    }
    return state[targetValue]
}


fun checkBottomUpSolution() {
    cases.forEach { (values, target) ->
        val u = bottoUp(target, values)
        val v = optBottomUp(target, values)
        println("$u, $v")
    }
}

fun main() {
    // checkRecursiveCountSolutions()
    checkBottomUpSolution()
}