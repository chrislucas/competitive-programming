package src.com.br.cp.graph.coloring

import java.util.*
import kotlin.collections.ArrayList
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

data class Edge(val u: Int, val v: Int, val w: Int = 0)

typealias GraphMap = HashMap<Int, ArrayList<Edge>>

operator fun GraphMap.plusAssign(edge: Edge) {
    val (p, q, w) = edge
    this[p]?.plusAssign(edge)
    // Se o grafo  for bidirecional nao remova o comentario abaixo
    // this[q]?.plusAssign(Edge(q, p, w))
}

operator fun GraphMap.plusAssign(edge: Pair<Int, Int>) {
    val (p, q) = edge
    this[p]?.plusAssign(Edge(p, q))
    // Se o grafo  for bidirecional nao remova o comentario abaixo
    this[q]?.plusAssign(Edge(q, p))
}

private fun create(vertices: Int): GraphMap {
    return with(hashMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until vertices) {
            this[i] = arrayListOf()
        }
        this
    }
}

private fun GraphMap.dfs(start: Int): List<Int> {

    fun depthFirstSearch(
        start: Int,
        graphMap: GraphMap,
        visited: HashMap<Int, Boolean>,
        transversal: MutableList<Int>
    ) {
        transversal += start
        visited[start] = true
        graphMap[start]?.forEach { vertice ->
            val q = vertice.v
            if (!visited.contains(q)) {
                visited[q] = true
                depthFirstSearch(q, graphMap, visited, transversal)
            }
        }
    }

    /*
        TODO revisar esse algoritmo que procura conjuntos disjuntos com dfs
        https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
     */
    // Para um conjunto disjunto
    fun disconnected(start: Int): List<Int> {
        val transversal = mutableListOf<Int>()
        val visited = hashMapOf<Int, Boolean>()
        val vertices = this.size - 1
        for (i in start..vertices) {
            if (!visited.contains(i)) {
                depthFirstSearch(i, this, visited, transversal)
            }
        }
        return transversal
    }

    fun simpleTransversal(start: Int): List<Int> {
        val transversal = mutableListOf<Int>()
        depthFirstSearch(start, this, hashMapOf(), transversal)
        return transversal
    }

    return disconnected(start)
}

private fun Pair<Int, Int>.toEdge() = Edge(first, second)

private val testCases = arrayOf(
    4 to arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3),
    7 to arrayOf(
        0 to 1, 1 to 2, 1 to 3, 2 to 4, 2 to 5,
        3 to 5, 4 to 5, 4 to 6, 5 to 6
    )
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
        - https://www.zib.de/groetschel/teaching/SS2012/GraphCol%20and%20FrequAssignment.pdf
        - Frequencias designadas para todas as torres na mesma localicazao devem ser diferentes
        - Essa eh uma variacao do problema de coloracao onde cada torre representa um vertice do
        grafo e a aresta entre 2 torres diz que uma esta ao alcance da outra

     ------------------------------------------------------------------------------------------------
     3 - sudoku
        - Tbm eh uma variacao de graph coloring onde cada celula do tabuleiro representa um vertice.
        - A uma aresta entre 2 vertices se esses vertices estao na mesma linha, columa ou bloco

     4 - Register Allocation
        - https://www.geeksforgeeks.org/register-allocations-in-code-generation/
        - https://www.geeksforgeeks.org/register-allocation-algorithms-in-compiler-design/
        - Em otimizacao de compiladores, alocacao de registro e o processo de designacao um
        numero grande de variaveis de programas num numero pequeno de registradores de CPG.
     5 - Bipartite Graphs:
        - https://www.geeksforgeeks.org/bipartite-graph/
        - podemos chegar se um grafo eh bipartido ou nao colorindo seus vertices com 2 cores.
        - Se o
     ------------------------------------------------------------------------------------------------

    Greedy algorithm
    https://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/

    No pior caso a complexidade eh O(v^2 + E)
 */


private fun GraphMap.greedyColoring(): Array<Int> {
    // iniciando os vertices sem cor
    val vertexColors = Array(size) { -1 }
    val sourceVertex = 0
    // vertice 0 com a cor 0
    vertexColors[sourceVertex] = 0
    /*
        val available = Array(size) { false }
        estrutura que armazena as cores disponiveis. Se
        se available[i] for falso significa que a cor i
        esta designada para um vertice adjacente logo a cor i
        nao esta "disponivel"
     */
    val availableColors = Array(size) { true }
    // caso o grafo seja  direcionado, a linha abaixo pode ser util para
    // marcar que o vertice de origem ja foi colorido
    //availableColors[sourceVertex] = false

    // adicionar cores aos vertices restantes
    for (u in 1 until size) {
        /*
            todos os vertices v adjacentes a u que tiverem cores definidas devem
            ser usados para marcar quais cores nao estao mais disponiveis
         */
        this[u]?.forEach { (_, v, _) ->
            if (vertexColors[v] != -1) {
                availableColors[vertexColors[v]] = false
            }
        }

        // encontrar a primeira cor disponivel
        for (i in 0 until size) {
            if (availableColors[i]) {
                vertexColors[u] = i
                break
            }
        }
        // marcar todas as cores como disponiveis para a proxima iteracao
        Arrays.fill(availableColors, true)
    }
    return vertexColors
}

private fun checkGreedyColoring() {
    val cases = arrayOf(
        /*
              v 0 - cor 0
              v 1 - cor 1
              v 2 - cor 2
              v 3 - cor 0
              v 4 - cor 1
         */
        5 to arrayOf(
            0 to 1,
            0 to 2,
            1 to 2,
            1 to 3,
            2 to 3,
            3 to 4
        ),
        /*
              v 0 - cor 0
              v 1 - cor 1
              v 2 - cor 2
              v 3 - cor 0
              v 4 - cor 3
         */
        5 to arrayOf(
            0 to 1,
            0 to 2,
            1 to 2,
            1 to 4,
            2 to 4,
            4 to 3
        ),
    )

    cases.forEach { (vertex, case) ->
        val graph = create(vertex)
        case.forEach { pair ->
            graph += pair
        }
        println(graph.greedyColoring().joinToString(", ", prefix = "[", postfix = "]"))
    }
}


fun main() {
    //checkDfs()
    checkGreedyColoring()
}