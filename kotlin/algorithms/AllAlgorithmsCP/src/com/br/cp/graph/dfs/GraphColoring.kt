package src.com.br.cp.graph.dfs

import java.util.*
import kotlin.collections.HashMap

/*
    https://en.wikipedia.org/wiki/Graph_coloring
    https://www.geeksforgeeks.org/graph-coloring-applications/?ref=rp
    https://www.geeksforgeeks.org/graph-coloring-applications/?ref=rp
 */

class Edge(val p: Int, val q: Int, val w: Int = 0)

typealias GraphMap = MutableMap<Int, ArrayList<Edge>>

operator fun GraphMap.plusAssign(edge: Edge) {
    this[edge.p]?.plusAssign(edge)
}


private fun create(vertices: Int): GraphMap {
    return with(mutableMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0..vertices) {
            this[i] = arrayListOf()
        }
        this
    }
}

fun GraphMap.dfs(start: Int) {

    fun dfs(
        start: Int, graphMap: GraphMap, visited: HashMap<Int, Boolean>,
        transversal: MutableList<Int>
    ) {

        visited[start] = true

        graphMap[start]?.forEach { vertice ->
            val q = vertice.q
            if (!visited.contains(q)) {
                visited[q] = true
            }

        }



    }

}


private fun Pair<Int, Int>.toEdge() = Edge(first, second)

private val testCases = arrayOf(
    4 to arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3),
    7 to arrayOf(0 to 1, 1 to 2, 1 to 3, 2 to 4, 2 to 5, 3 to 5, 4 to 5, 4 to 6, 5 to 6)
)

fun check() {
    testCases.forEach { (vertices, edges) ->
        val graph = create(vertices)
        edges.forEach { pair ->
            graph += pair.toEdge()
        }
    }
}


fun main() {

}