package src.com.br.cp.graph.dijkstra

import java.util.*

// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/

typealias PQueue = PriorityQueue<Vertex>

typealias Graph = ArrayList<ArrayList<Vertex>>

data class Vertex(val q: Int, val weight: Int)

val comparator = Comparator<Vertex> { p, q -> p.weight - q.weight }

private fun Graph.add(p: Int, q: Int, w: Int) {
    this[p].add(Vertex(q, w))
    this[q].add(Vertex(p, w))
}

private fun create(vertex: Int): Graph {
    val size = vertex + 1
    return with(ArrayList<ArrayList<Vertex>>(size)) {
        for (i in 0 until size) {
            this += arrayListOf<Vertex>()
        }
        this
    }
}

private fun dijkstra() {
    val graph = create(9)
    graph.add(0, 1, 4)
    graph.add(0, 8, 7)
    graph.add(1, 2, 8)
    graph.add(1, 7, 11)
    val pQueue = PQueue(comparator)
}

fun main() {
    dijkstra()
}