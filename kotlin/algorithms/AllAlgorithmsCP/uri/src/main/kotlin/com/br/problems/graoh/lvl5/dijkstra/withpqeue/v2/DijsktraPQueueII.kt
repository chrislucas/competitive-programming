package com.br.problems.graoh.lvl5.dijkstra.withpqeue.v2

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
 * https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
 */

private data class Edge(val v: Int = 0, val w: Int = 0) : Comparable<Edge> {
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

private fun Adj.add(p: Int, edge: Edge) {
    val (v, w) = edge
    this[p]?.plusAssign(edge)
    this[v]?.plusAssign(Edge(p, w))
}


private fun Adj.dijkstra(source: Int): Array<Int> {
    val inf = Int.MAX_VALUE
    val distance = Array(this.size) { inf }
    val pq = PQ()
    pq += Edge(source, 0)
    distance[0] = 0
    while (pq.isNotEmpty()) {
        val edge = pq.poll()
        val u = edge.v
        this[u]?.forEach { (v, w) ->
            val uv = distance[u] + w
            if (distance[v] > uv) {
                distance[v] = uv
                pq += Edge(v, distance[v])
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
        0 to Edge(1, 4),
        0 to Edge(7, 8),
        1 to Edge(2, 8),
        1 to Edge(7, 11),
        2 to Edge(3, 7),
        2 to Edge(5, 4),
        2 to Edge(8, 2),
        3 to Edge(4, 9),
        3 to Edge(5, 14),
        4 to Edge(5, 10),
        5 to Edge(6, 2),
        6 to Edge(7, 1),
        6 to Edge(8, 6),
        7 to Edge(8, 7)
    ).forEach { (origin, edge) ->
        graph.add(origin, edge)
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