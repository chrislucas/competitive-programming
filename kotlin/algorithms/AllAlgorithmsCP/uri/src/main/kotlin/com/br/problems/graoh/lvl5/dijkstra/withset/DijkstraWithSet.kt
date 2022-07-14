package com.br.problems.graoh.lvl5.dijkstra.withset

import java.util.ArrayList
import java.util.TreeSet

/*
    https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-set-in-stl/
 */

private data class Edge(val p: Int = 0, val q: Int = 0, val w: Int = 0) : Comparable<Edge> {
    override fun compareTo(other: Edge) = w - other.w
}

private typealias Adj = HashMap<Int, ArrayList<Edge>>

private fun graph(v: Int): Adj {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    val size = v
    return with(hashMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until size) {
            this[i] = arrayListOf()
        }
        this
    }
}

// permite adicionar uma aresta indo e voltando de pesos iguais
private operator fun Adj.plusAssign(edge: Edge) {
    val (p, q, w) = edge
    this[p]?.plusAssign(edge)
    this[q]?.plusAssign(Edge(q, p, w))
}

private fun <T> Array<T>.string(separator: String = "|"): String =
    joinToString(separator, prefix = "[", postfix = "]")


private fun Adj.dijkstra(source: Int): Array<Int> {
    val inf = Int.MAX_VALUE
    // usaremos o Treeset que eh uma estrutura que mantem a colecao ordenada
    val set = TreeSet<Edge>()
    set += Edge(source, source, 0)
    val distance = Array(this.size) { inf }
    distance[source] = 0
    while (set.isNotEmpty()) {
        val edge = set.pollFirst() ?: break
        // recuperar as areas que sao alcancaveis a pair do vertice p
        this[edge.p]?.forEach { (p, q, w) ->
            /*
                 Se o caminho de P a Q atual for mais custoso que um novo caminho
                 cujo peso for w, substitua esse gasto no vetor de distancia
             */
            val pqDistance = distance[p] + w
            if (distance[q] > pqDistance) {
                /*
                    Se a distancia != inf quer dizer que ja adicionamos essa aresta
                    no conjunto de caminhos.
                 */
                if (distance[q] != inf) {
                    val e = Edge(p, q, distance[q])
                    set.find { it == e }?.let { set.remove(it) }
                }
                // atualizando o novo gasto de p a q
                distance[q] = pqDistance
                set += Edge(q, p, distance[q])
            }
        }
    }
    return distance
}


private fun checkDijkstra() {
    val graph = graph(9)
    graph += Edge(0, 1, 4)
    graph += Edge(0, 7, 8)
    graph += Edge(1, 2, 8)
    graph += Edge(1, 7, 11)
    graph += Edge(2, 3, 7)
    graph += Edge(2, 5, 4)
    graph += Edge(2, 8, 2)
    graph += Edge(3, 4, 9)
    graph += Edge(3, 5, 14)
    graph += Edge(4, 5, 10)
    graph += Edge(5, 6, 2)
    graph += Edge(6, 7, 1)
    graph += Edge(6, 8, 6)
    graph += Edge(7, 8, 7)

    println(graph.dijkstra(0).string())
}


fun main() {
    checkDijkstra()
}