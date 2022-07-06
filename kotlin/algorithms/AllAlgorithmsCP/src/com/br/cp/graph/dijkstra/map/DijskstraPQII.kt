package src.com.br.cp.graph.dijkstra.map

import java.util.*

/*
    https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/?ref=lbp
 */

data class Vertex(val q: Int, val weight: Int)

typealias PQueue = PriorityQueue<Vertex>

typealias Graph = Map<Int, List<Vertex>>


fun main() {

}