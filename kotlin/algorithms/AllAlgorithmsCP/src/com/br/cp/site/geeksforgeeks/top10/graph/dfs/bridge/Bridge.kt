package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.bridge

import kotlin.math.min

/*
    TODO
    https://www.geeksforgeeks.org/bridge-in-a-graph/
    Um aresta num grafo nao direcionado e uma ponte (bridge) se ao ser removida cria um grafo desconexo.
    Para um grafo nao direcionado desconexo a definicao de ponte e similar, um ponte e uma aresta que se removida
    aumenta o numero de componentes desconexos.


    O algoritmo para encontrar as arestas-pontes eh similar ao usado para encontrar os vertices de articulacao.
    Realiza-se uma DFS e na arvore gerada uma aresta uv eh uma ponte se nao existe nenhuma aresta de retorno
    para o vertice u ou um vertice pai de u a partir de um vertice p que esteja na  subarvore formada por uma DFS
    que o vertice raiz é v
 */

private typealias SimpleAdjList = ArrayList<ArrayList<Int>>


private class GraphBridges(private val vertex: Int) {

    private val graph = SimpleAdjList()

    init {
        for (i in 0..vertex) {
            graph += arrayListOf<Int>()
        }
    }

    operator fun plusAssign(edge: Pair<Int, Int>) {
        val (u, v) = edge
        graph[u] += v
        graph[v] += u
    }

    operator fun plusAssign(edges: Array<Pair<Int, Int>>) {
        for (edge in edges) {
            plusAssign(edge)
        }
    }

    fun getBridges(): MutableList<Pair<Int, Int>> {
        val discoveryTime = Array(vertex) { 0 }
        val low = Array(vertex) { 0 }
        val visited = Array(vertex) { false }
        val parent = Array(vertex) { -1 }
        val bridges = mutableListOf<Pair<Int, Int>>()
        for (u in 0 until vertex) {
            if (!visited[u]) {
                dfs(u, visited, discoveryTime, low, parent, bridges, 1)
            }
        }
        return bridges
    }

    private fun dfs(
        u: Int,
        visited: Array<Boolean>,
        discoveryTime: Array<Int>,
        low: Array<Int>,
        parent: Array<Int>,
        bridges: MutableList<Pair<Int, Int>>,
        time: Int
    ) {

        visited[u] = true
        discoveryTime[u] = time
        low[u] = time

        for (v in graph[u]) {
            if (!visited[v]) {
                parent[v] = u
                dfs(v, visited, discoveryTime, low, parent, bridges, time + 1)
                /*
                    Verifica se a subarvore cuja raiz é o vertice v tem uma conecao com algum vertice
                    ancestral de u
                 */
                low[u] = min(low[u], low[v])
                /*

                 */
                if (low[v] > discoveryTime[u]) {
                    bridges += u to v
                }
            } else if (v != parent[u]) {
                low[u] = min(low[u], discoveryTime[v])
            }
        }
    }

}


private fun check() {
    arrayOf(
        arrayOf(0 to 1, 1 to 2, 2 to 3) to 4,
        arrayOf(1 to 0, 0 to 2, 2 to 1, 0 to 3, 3 to 4) to 5,
        arrayOf(0 to 1, 1 to 2, 2 to 0, 1 to 3, 1 to 4, 1 to 6, 3 to 5, 4 to 5) to 7
    ).forEach { (edges, size) ->
        val graph = GraphBridges(size)
        graph += edges
        println(graph.getBridges())
    }
}

fun main() {
    check()
}