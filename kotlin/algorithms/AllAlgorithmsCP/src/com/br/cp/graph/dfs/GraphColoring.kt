package src.com.br.cp.graph.dfs

import java.util.*
import kotlin.collections.HashMap

/*
    https://en.wikipedia.org/wiki/Graph_coloring
    https://www.geeksforgeeks.org/graph-coloring-applications/?ref=rp

    O problema se trata de adicionar cores a certos elementos do grafo estando sujeito a
    certas restricoes

    - Vertex Coloring e o problema de coloracao de um grafo mais comum.
        - Dado M cores encontre uma forma de colorir os vertices de um grafo
        tal que 2 vertices adjacentes nao sejam coloridos com a mesma cor

    - Edge coloring
        - Um outro problema de coloracao. nenhum vertice tem duas arestas com a mesma cor
        que incidem dele.

     - Face coloring/Geographical Map Coloring/Coloracao de um mapa geografico
        - Problema que pode ser transformado no vertex coloring

      - Chromatic Number:
        - O menor numero de cores necessarias para colorir um grafo G eh chamado de chromatic number

 */

class Edge(val p: Int, val q: Int, val w: Int = 0)

typealias GraphMap = MutableMap<Int, ArrayList<Edge>>

operator fun GraphMap.plusAssign(edge: Edge) {
    this[edge.p]?.plusAssign(edge)
}

private fun create(vertices: Int): GraphMap {
    return with(mutableMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until vertices) {
            this[i] = arrayListOf()
        }
        this
    }
}

private fun GraphMap.dfs(start: Int): List<Int> {

    fun dfs(start: Int, graphMap: GraphMap, visited: HashMap<Int, Boolean>, transversal: MutableList<Int>) {
        transversal += start
        visited[start] = true
        graphMap[start]?.forEach { vertice ->
            val q = vertice.q
            if (!visited.contains(q)) {
                visited[q] = true
                dfs(q, graphMap, visited, transversal)
            }
        }
    }

    // Para um conjunto disjunto
    fun disconnected(start: Int): List<Int> {
        val transversal = mutableListOf<Int>()
        val visited = hashMapOf<Int, Boolean>()
        val vertices = this.size - 1
        for (i in 0 ..  vertices) {
            if (!visited.contains(i)) {
                dfs(i, this, visited, transversal)
            }
        }
        return transversal
    }

    fun simpleTransversal(start: Int): List<Int> {
        val transversal = mutableListOf<Int>()
        dfs(start, this, hashMapOf(), transversal)
        return transversal
    }

    return disconnected(start)
}

private fun Pair<Int, Int>.toEdge() = Edge(first, second)

private val testCases = arrayOf(
    4 to arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3),
    7 to arrayOf(0 to 1, 1 to 2, 1 to 3, 2 to 4, 2 to 5, 3 to 5, 4 to 5, 4 to 6, 5 to 6)
)

private fun checkDfs() {
    testCases.forEach { (vertices, edges) ->
        val graph = create(vertices)
        edges.forEach { pair ->
            graph += pair.toEdge()
        }
        println(graph.dfs(0))
    }
}

/*
    Aplicacoes
    https://www.geeksforgeeks.org/graph-coloring-applications/?ref=rp

    - agendamento de tarefas
        - Supondo que queremos agendar testes para alunos numa universidade. Temos um conjunto
        de disciplinas e um conjunto de alunos matriculados nelas, conjunto de alunos que pode
        se repetir em outras disciplinas.

        1) Assim, como podemos fazer para marcar os exames de tal
        forma que nao haja  2 exames de 2 disciplinas com os mesmos alunos ao mesmo tempo

        2) Qual o valor minimo de tempo que sera necessario para agendar todos os exames ?

        Esse problema pode se representado como um grafo onde cada vertice

     ------------------------------------------------------------------------------------------------
      2 - Distribuicao de frequencia de radio movel - Mobile radio frequency Assignment
     ------------------------------------------------------------------------------------------------

    Greedy algorithm
    https://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/
 */


fun main() {
    checkDfs()
}