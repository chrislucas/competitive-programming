package src.com.br.cp.dp.tsp.sites.geeksforgeeks

import java.lang.Integer.min


/*
    https://www.geeksforgeeks.org/travelling-salesman-problem-set-1/

    Travelling salesman problem - TSP vendedor/caixeiro viajante

    Dado um conjunto de cidades e distance entre cada par de cidades, encontre a menor rota possivel
    para visitar cada cidade exatamente uma vez e retornar para o ponto inicial

        - Note que existe diferença entre esse problema e o problema de ciclo Hamiltoniano HCP
            - em HCP o problema eh encontrar se existe um caminho que visita todas as cidades
            exatamente uma vez, nesse problema sabemos que existe um caminho (pois o grafo eh completo)
            e muitos caminhos existem, o problema é encontrar o camnho de custo mínimo
 */


/*
    Considere o grafo abaixo
    https://media.geeksforgeeks.org/wp-content/cdn-uploads/Euler12.png

    Um caminho possivel para resolver o problema TSP nesse grafo de exemplo é
    1,2,4,3,1 com custo de 80 (10+25+30+15)

    Esse eh um famoso problem NP-hard, nao a um algoritmo em tempo polynomial conhecido
    que resolva esse problema

    Uma solucao ingenua
    1) tome como inicio da solucao partir da cidade 1
    2) permute as n-1 cidades/vertices restantes
    3) calcula o custo de cada permutacao e mantenha guardado o custo minimo encontrado
    4) retornar o conjunto de vertices cuja permutacao da o custo minimo

    Complexidade: O(n!)
 */


private fun dp() {
    val graph = arrayOf(
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 10, 15, 20),
        arrayOf(0, 10, 0, 25, 25),
        arrayOf(0, 15, 25, 0, 30),
        arrayOf(0, 20, 25, 30, 0)
    )

    val vertex = 4
    val max = Int.MAX_VALUE
    val memo = Array(vertex + 1) { Array(1 shl (vertex + 1)) {0} }

    /*
        DP solution
     */
    fun solver(vertex: Int, mask: Int, memo: Array<Array<Int>>): Int {

        return memo[vertex][mask]
    }

    var answer = max
    for (v in 1 .. vertex) {
        val partial = solver(v, (1 shl  (vertex + 1)) - 1, memo)
        answer = min(answer, partial) + graph[v][1]
    }

    println(answer)
}

fun main() {

}