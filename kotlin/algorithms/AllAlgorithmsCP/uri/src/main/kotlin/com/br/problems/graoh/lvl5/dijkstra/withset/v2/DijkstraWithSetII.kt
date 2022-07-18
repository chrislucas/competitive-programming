package com.br.problems.graoh.lvl5.dijkstra.withset.v2

import java.util.ArrayList
import java.util.TreeSet
import kotlin.system.measureTimeMillis

/*
    https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-set-in-stl/
 */


private data class Edge(val v: Int = 0, val w: Int = 0) : Comparable<Edge> {
    override fun compareTo(other: Edge) = w - other.w
}

private typealias Graph = HashMap<Int, ArrayList<Edge>>

private fun graph(v: Int): Graph {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    return with(hashMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until v) {
            this[i] = arrayListOf()
        }
        this
    }
}

// permite adicionar uma aresta indo e voltando de pesos iguais
private fun Graph.add(p: Int, edge: Edge) {
    val (v, w) = edge
    this[p]?.plusAssign(edge)
    this[v]?.plusAssign(Edge(p, w))
}

private fun <T> Array<T>.string(separator: String = "|"): String =
    joinToString(separator, prefix = "[", postfix = "]")


private fun Graph.dijkstra(source: Int): Array<Int> {
    val inf = Int.MAX_VALUE
    val set = TreeSet<Edge>()
    set += Edge(source, 0)
    val distance = Array(this.size) { inf }
    distance[source] = 0
    while (set.isNotEmpty()) {
        val edge = set.pollFirst() ?: break
        val u = edge.v
        this[u]?.forEach { (v, w) ->
            val newDistance = distance[u] + w
            if (distance[v] > newDistance) {
                /*
                    Se a distancia != inf quer dizer que ja adicionamos essa aresta
                    no conjunto de caminhos.
                    TODO entender o que esta ocorrendo nesse if
                */
                if (distance[v] != inf) {
                    val e = Edge(v, distance[v])
                    set.find { it == e }?.let { set.remove(it) }
                }
                distance[v] = newDistance
                set += Edge(v, distance[v])
            }
        }
    }
    return distance
}


private fun checkDijkstra() {
    val graph = graph(9)
    graph.add(0, Edge(1, 4))
    graph.add(0, Edge(7, 8))
    graph.add(1, Edge(2, 8))
    graph.add(1, Edge(7, 11))
    graph.add(2, Edge(3, 7))
    graph.add(2, Edge(5, 4))
    graph.add(2, Edge(8, 2))
    graph.add(3, Edge(4, 9))
    graph.add(3, Edge(5, 14))
    graph.add(4, Edge(5, 10))
    graph.add(5, Edge(6, 2))
    graph.add(6, Edge(7, 1))
    graph.add(6, Edge(8, 6))
    graph.add(7, Edge(8, 7))

    measureTimeMillis {
        println(graph.dijkstra(0).string())
    }.let {
        println(it / 1000.0)
    }
}

fun main() {
    checkDijkstra()
}