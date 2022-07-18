package src.com.br.cp.graph.coloring

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
    this[p]?.plus(edge)
    this[q]?.plus(Edge(q, p, w))
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

    fun dfs(start: Int, graphMap: GraphMap, visited: HashMap<Int, Boolean>, transversal: MutableList<Int>) {
        transversal += start
        visited[start] = true
        graphMap[start]?.forEach { vertice ->
            val q = vertice.v
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
        for (i in 0..vertices) {
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
 */


private fun GraphMap.greedyColoring(): Array<Int> {
    // iniciando os vertices sem cor
    val vertexColors = Array(size) { -1 }
    // vertice 0 com a cor 0
    vertexColors[0] = 0
    /*
        val available = Array(size) { false }
        estrutura que armazena as cores disponiveis. Se
        se available[i] for falso significa que a cor i
        esta designada para um vertice adjacente logo a cor i
        nao esta "disponivel"
     */
    var available = Array(size) { true }

    /*
        adicionar cores aos vertices restantes
     */
    for (u in 1 until size) {

        /*
            passar pelos vertices adjacentes ao vertice u
         */
        this[u]?.forEach { (_, v, _) ->
            // se a cor nao for estiver definida marque-as como unavailable
            if (vertexColors[v] == -1) {
                available[vertexColors[v]] = false
            }
        }

        // encontrar a primeira cor disponivel
        var color = 0
        for (i in 0 until size) {
            if(available[i]) {
                color = i
                break
            }
        }
        vertexColors[u] = color
        available = Array(size) { true }
    }

    return vertexColors
}

private fun checkGreedyColoring() {
    val cases = arrayOf(
        5 to arrayOf(
            0 to 1,
            0 to 1
        ),

        5 to arrayOf(
            0 to 1,
            0 to 1
        ),
    )

    cases.forEach { case ->

    }
}


fun main() {
    checkDfs()
}