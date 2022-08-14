package src.com.br.cp.graph.dijkstra.map

import java.util.*
import kotlin.collections.HashMap

/*
    https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/?ref=lbp
 */

data class Vertex(val v: Int, val weight: Int)

typealias PQueue = PriorityQueue<Vertex>

typealias Graph = HashMap<Int, MutableList<Vertex>>

private fun Graph.add(u: Int, vt: Vertex) {
    val (v, w) = vt
    this[u]?.plusAssign(vt)
    this[v]?.plusAssign(Vertex(u, w))
}


fun main() {

}