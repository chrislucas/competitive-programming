package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.tarjan.v1

import java.lang.Integer.min
import java.util.Stack

/*
    https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/

    O algoritmo de Tarjan é baseado nos seguintes fatos
    - DFS search produces uma DFS tree/florest
    - SCC (Strongly Connected Components) formam subtrees de DFS trees
    - Se pudermos achar o "vertice raiz/head" de tais subtrees, podemos armazenar todos os nos
    dessa subtree e teremos uma SCC
    - Nao a uma aresta de retorno entre uma SCC e outra

    Tipos de arestas numa DFS
    https://en.wikipedia.org/wiki/Depth-first_search#Output_of_a_depth-first_search

    - O resultado de uma DFS num grafo pode ser descrito em termos de uma arvore de espalhamento (spanning tree)
    dos vertices alcancados durante a busca.

    -   Baseado na spanning tree, os vertices do grafo original podem ser divididos em 3 tipos
        - forward edges: aresta que sai de um vertice origem e chega num vertice destino: u -> v
        - back edges: um vertice que sai de um vertice v e aponta para um vertice u que é vertice ancestral
        de v
        - cross edge: Que nao eh nem um forward edge e nem um back edge
 */


private class Graph(private val size: Int) {
    val graph = ArrayList<ArrayList<Int>>()


    /**
     * first[u] indica o primeiro vertice que foi visitado que
     * pode ser alcancado a partir de uma subarvore/subgrafo cujo vertice raiz é o 'u'
     * num componente fortemente conectado.
     */
    private val lowestAncestor = Array(size + 1) { -1 }

    // disc[i] = quando o vertice i foi visitado pela primeira vez
    private val discoveryTime = Array(size + 1) { -1 }

    private var acc = 0

    init {
        for (i in 0..size) {
            graph += arrayListOf<Int>()
        }
    }

    operator fun plusAssign(pair: Pair<Int, Int>) {
        val (p, q) = pair
        graph[p] += q
    }

    operator fun plusAssign(edges: Array< Pair<Int, Int>>) {
        for (edge in edges) {
            plusAssign(edge)
        }
    }

    fun scc() {
        val stack = Stack<Int>()
        val visited = Array(size + 1) { false }
        for (v in 0 until size) {
            if (discoveryTime[v] == -1) {
                dfs(v, 1, visited, stack)
            }
        }
    }

    /*
        para construir os componentes conexos do grafo usando uma dfs temos 2 casos
        1 - quando o vertice v ainda nao foi visitado (Tree Edge - do no parente para o no descendente 'u')
        entao apos a DFS a partir de v o valor de low[u]
        low[u] = min(low[u], low[v])

        2 - quando o vertice v ja foi visitado (back edge)
        low[u] = min(low[u], disc[v])
     */
    private fun dfs(u: Int, counter: Int, visited: Array<Boolean>, stack: Stack<Int>) {
        discoveryTime[u] = acc
        lowestAncestor[u] = acc
        visited[u] = true
        stack += u
        for (v in graph[u]) {
            if (discoveryTime[v] == -1) {
                dfs(v, counter + 1, visited, stack)
                lowestAncestor[u] = min(lowestAncestor[u], lowestAncestor[v])
            } else if (visited[v]) {
                lowestAncestor[u] = min(lowestAncestor[u], discoveryTime[v])
            }
        }

        var head = -1
        if (lowestAncestor[u] == discoveryTime[u]) {
            while (head != u) {
                head = stack.pop()
                visited[head] = false
            }
        }
    }
}


fun main() {
    arrayOf(
        arrayOf(Pair(1, 0), Pair(0, 2), Pair(2, 1), Pair(0, 3), Pair(3, 4)) to 5,
        arrayOf(Pair(0, 1), Pair(1, 2), Pair(2, 3)) to 4
    ).forEach { (edges, size) ->
        val g = Graph(size)
        g += edges
        g.scc()
    }

}