package com.br.problems.graoh.lvl5.dijkstra.withpqeue

import java.util.*

/**
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
 */

private data class Edge(val p: Int, val q: Int = 0, val w: Int = 0) : Comparable<Edge> {
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
    val (p, q, w) = edge
    this[p]?.plusAssign(edge)
    this[q]?.plusAssign(Edge(q, p, w))
}


private fun Adj.dijkstra(source: Int): Array<Int> {
    val inf = Int.MAX_VALUE
    val distance = Array(this.size) { inf }
    val queue = PQ()
    queue += Edge(source, source, 0)

    while (queue.isNotEmpty()) {
        val edge = queue.poll()
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

    println(graph.dijkstra(0).string())
}


fun main() {
    checkDijkstra()
}