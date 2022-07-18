package com.br.problems.graoh.lvl5.dijkstra.withpqeue

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
 * https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
 */

private data class Edge(val u: Int, val v: Int = 0, val w: Int = 0) : Comparable<Edge> {
    override fun compareTo(other: Edge) = w - other.w
}

private typealias Adj = HashMap<Int, ArrayList<Edge>>

private typealias PQ = PriorityQueue<Edge>

private fun graph(v: Int): Adj {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    return with(hashMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until v) {
            this[i] = arrayListOf()
        }
        this
    }
}

private operator fun Adj.plusAssign(edge: Edge) {
    val (u, v, w) = edge
    this[u]?.plusAssign(edge)
    this[v]?.plusAssign(Edge(v, u, w))
}

private fun Adj.dijkstra(source: Int): Array<Int> {
    val inf = Int.MAX_VALUE
    val distance = Array(this.size) { inf }
    val pq = PQ()
    pq += Edge(source, source, 0)
    distance[0] = 0
    while (pq.isNotEmpty()) {
        val edge = pq.poll()
        this[edge.u]?.forEach { (u, v, w) ->
            val uv = distance[u] + w
            if (distance[v] > uv) {
                distance[v] = uv
                pq += Edge(v, u, distance[v])
            }
        }
    }
    return distance
}

private fun <T> Array<T>.string(separator: String = "|"): String =
    joinToString(separator, prefix = "[", postfix = "]")

private fun checkDijkstra() {
    val graph = graph(9)
    arrayOf(
        Edge(0, 1, 4),
        Edge(0, 7, 8),
        Edge(1, 2, 8),
        Edge(1, 7, 11),
        Edge(2, 3, 7),
        Edge(2, 5, 4),
        Edge(2, 8, 2),
        Edge(3, 4, 9),
        Edge(3, 5, 14),
        Edge(4, 5, 10),
        Edge(5, 6, 2),
        Edge(6, 7, 1),
        Edge(6, 8, 6),
        Edge(7, 8, 7)
    ).forEach { edge ->
        graph += edge
    }
    measureTimeMillis {
        println(graph.dijkstra(0).string())
    }.let {
        println(it / 1000.0)
    }
}


fun main() {
    checkDijkstra()
}