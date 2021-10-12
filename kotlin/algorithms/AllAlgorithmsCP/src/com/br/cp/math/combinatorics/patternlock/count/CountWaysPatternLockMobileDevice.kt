package src.com.br.cp.math.combinatorics.patternlock.count

// https://www.geeksforgeeks.org/number-of-ways-to-make-mobile-lock-pattern/


const val DOTS = 9

/**
 * visited = nos visitados no board
 * possibleJumps = celula que fica entre 2 outras celular no board -> [1][3] = 2, entre a tecla 1 e 3 do teclado em a 2
 * source = qual tecla que se inicia a DFS
 * qDots = quantos teclas foram usadas para criar o pattern de bloqueio do teclado
 * */

private fun countWays(visited: Array<Boolean>, possibleJumps: Array<Array<Int>>, source: Int, qDots: Int): Int {
    if (qDots <= 0) {
        return if (qDots == 0) 1 else 0
    }
    var ways = 0
    visited[source] = true
    for (dot in 1..DOTS) {
        val p = possibleJumps[dot][source] // p == 0 entao dot e source sao pontos adjacentes no grid
        // se visited[possibleJumps[dot][source]]  dot e source podem nao ser adjacentes mas source
        // seja q = possibleJumps[dot][source], q pode ter sido adicionado no padrao
        if (!visited[dot] && (p == 0 || visited[p])) {
            ways += countWays(visited, possibleJumps, dot, qDots - 1)
        }
    }
    visited[source] = false
    return ways
}


private fun numberOfPatterns(min: Int, max: Int): Int {

    val possibleJumps = Array(DOTS + 1) { Array(DOTS + 1) { 0 } }

    // entrea celula 1 e 3 e vice e versa
    possibleJumps[1][3] = 2
    possibleJumps[3][1] = 2
    possibleJumps[1][7] = 4
    possibleJumps[7][1] = 4

    // entre 7 e 9 tem o 8
    possibleJumps[7][9] = 8
    possibleJumps[9][7] = 8
    possibleJumps[3][9] = 6
    possibleJumps[9][3] = 6

    // 5 no meio do teclado
    possibleJumps[1][9] = 5
    possibleJumps[9][1] = 5
    possibleJumps[2][8] = 5
    possibleJumps[8][2] = 5
    possibleJumps[3][7] = 5
    possibleJumps[7][3] = 5
    possibleJumps[4][6] = 5
    possibleJumps[6][4] = 5

    val visited = Array(DOTS + 1) { false }
    var counter = 0
    for (i in min..max) {
        /**
         * O problema trata-se de contar quantos padroes sao possiveis desenhar num teclado de desbloqueio
         * ANDROID com uma quantidade minima e maxima de PONTOS utilizados
         *
         * O teclado de pattern lock do android e uma matrix 3x3. Podemos resolver esse problema sem precisar
         * testar todas as teclas, usando a simetria
         *
         * 1, 3, 7, 9 fazem parte do mesmo grupo
         * 2, 4, 6, 8 tambem
         * 5 e o terceiro grupo
         * dessa forma podemos testar 1, 2 e 5 e para 1 e 2 multiplicamos o resultado por 4
         * */
        counter += 4 * countWays(visited, possibleJumps, 1, i - 1)
        counter += 4 * countWays(visited, possibleJumps, 2, i - 1)
        counter += countWays(visited, possibleJumps, 5, i - 1)
    }
    return counter
}

private fun check() {
    println(numberOfPatterns(3, 9))
    println(numberOfPatterns(4, 6))
    println(numberOfPatterns(4, 9))
}

fun main() {
    check()
}