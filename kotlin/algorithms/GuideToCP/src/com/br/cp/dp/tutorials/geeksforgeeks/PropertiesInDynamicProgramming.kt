package com.br.cp.dp.tutorials.geeksforgeeks

import com.br.cp.exts.log

/**
 * https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
 *  Propriedades
 * 1) Overlapping subproblems
 *
 *      Overlapping subproblems sao subproblemas que aparecem repetidas vezes num algoritmo e por
 *      essa caracteristica sao calculados todas as vezes, um desperdicio de tempo se pudermos de alguma
 *      forma armazenar esse resultado caso esse subproblema apareça novamente
 *
 *      Assim como na tecnica divider-n-conquer, DPs resolve uma instancia de um problema
 *      dividindo-a em subproblemas, resolvedo-as e combinando os seus resultados para chegar
 *      na solucao do problema original
 *
 *      Para evitar recalcular subproblemas iguais, algo que acontece em algoritmos recursos
 *      de problemas classiscos como sequencia de numeros (fibonacci), o problema da troca de moedas (coin change)
 *      ou o problema da mochila, a ideia eh armazenar os resultados em estruturas
 *      de dados (matrizes por exemplo) e se durante a execucao do algoritmo um subproblema que ja foi resolvido
 *      aparecer consulte a solucao nessa tabela, diminuindo o tempo de execucao.
 *
 *      Problemas de recursao que nao possuem subproblemas que aparecem repetidas vezes nao sao solucionaveis
 *      atraves de programacao dinamica, pq nao faz sentido armarzenar um resultado que nao sera reutilizado.
 */


private fun classicalFibonacciProblem(n: Int): Int {
    if (n < 2) {
        return 1
    } else {
        return classicalFibonacciProblem(n - 1) + classicalFibonacciProblem(n - 2)
    }
}

private fun classicalFibonacciProblemWithLookupTable(n: Int, lookup: Array<Int>): Int {
    // so tomando o devido cuidado com indices negativos
    return if (n >= 0) {
        // se eu nao tenho um resultdo pre calculado
        if (lookup[n] == -1) {
            // calculo
            if (n < 2) {
                lookup[n] = n
            } else {
                lookup[n] =
                    classicalFibonacciProblemWithLookupTable(n - 1, lookup) +
                            classicalFibonacciProblemWithLookupTable(n - 2, lookup)
            }
        }
        // se nao retorno o resultado que ja tenho
        lookup[n]
    } else {
        n
    }
}


fun main() {
    for (i in 1..40) {
        val lookup = Array(i + 1) { -1 }
        classicalFibonacciProblemWithLookupTable(i, lookup)
        println("$i: ${lookup.log()}")
    }
}