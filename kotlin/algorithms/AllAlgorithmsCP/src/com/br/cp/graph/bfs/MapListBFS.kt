package src.com.br.cp.graph.bfs

import java.util.*

/*
    https://www.geeksforgeeks.org/applications-of-depth-first-search/
    https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/?ref=lbp
 */

class Edge(val p: Int, val q: Int, val w: Int = 0)

typealias GraphMap = MutableMap<Int, ArrayList<Edge>>

operator fun GraphMap.plusAssign(edge: Edge) {
    this[edge.p]?.plusAssign(edge)
}

private fun create(vertices: Int): GraphMap {
    return with(mutableMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until vertices) {
            this[i] = arrayListOf()
        }
        this
    }
}

private fun GraphMap.bfs(start: Int): List<Int> {
    val visited = hashMapOf<Int, Boolean>()
    visited[start]= true
    val queue: Queue<Int> = LinkedList()
    queue += start
    val transversal = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val vertice = queue.poll()
        transversal += vertice
        val it = this[vertice]?.iterator()
        while (it?.hasNext() == true) {
            val edge = it.next()
            if (!visited.contains(edge.q)) {
                visited[edge.q] = true
                queue += edge.q
            }
        }
    }
    return transversal
}

private fun Pair<Int, Int>.toEdge() = Edge(first, second)

private val testCases = arrayOf(
    4 to arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3),
    7 to arrayOf(0 to 1, 1 to 2, 1 to 3, 2 to 4, 2 to 5, 3 to 5, 4 to 5, 4 to 6, 5 to 6)
)

private fun checkBfs() {
    testCases.forEach { (vertices, edges) ->
        val graph = create(vertices)
        edges.forEach { pair ->
            graph += pair.toEdge()
        }
        println(graph.bfs(0))
    }
}

fun main() {
    checkBfs()
}

