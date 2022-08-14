package src.com.br.cp.graph.dfs.map

import java.util.ArrayList

/*
    https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/?ref=lbp

    Applications
    https://www.geeksforgeeks.org/applications-of-depth-first-search/?ref=rp

 */

data class Edge(val p: Int, val q: Int, val w: Int = 0)

typealias GraphMap = MutableMap<Int, ArrayList<Edge>>

operator fun GraphMap.plusAssign(edge: Edge) {
    val(p, q , w) = edge
    this[p]?.plusAssign(edge)
    // se a aresta nao for de ida e volta comente a linha abaixo
    // this[q]?.plusAssign(Edge(q, p, w))
}

operator fun GraphMap.plusAssign(edge: Pair<Int, Int>) {
    val(p, q) = edge
    this[p]?.plusAssign(Edge(p, q))
    // se a aresta nao for de ida e volta comente a linha abaixo
    // this[q]?.plusAssign(Edge(q, p))
}

private fun create(vertices: Int): GraphMap {
    return with(mutableMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until vertices) {
            this[i] = arrayListOf()
        }
        this
    }
}

private fun GraphMap.dfs(start: Int): MutableList<Int> {

    fun dfs(start: Int, graphMap: GraphMap, visited: HashMap<Int, Boolean>, transversal: MutableList<Int>) {
        transversal += start
        visited[start] = true
        graphMap[start]?.forEach { vertice ->
            val q = vertice.q
            if (!visited.contains(q)) {
                visited[q] = true
                dfs(q, graphMap, visited, transversal)
            }
        }
    }

    val transversal = mutableListOf<Int>()
    dfs(start, this, hashMapOf(), transversal)
    return transversal
}


private fun Pair<Int, Int>.toEdge() = Edge(first, second)

private val testCases = arrayOf(
    4 to arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3),
    7 to arrayOf(0 to 1, 1 to 2, 1 to 3, 2 to 4, 2 to 5, 3 to 5, 4 to 5, 4 to 6, 5 to 6)
)

private fun checkDfs() {
    testCases.forEach { (vertices, edges) ->
        val graph = create(vertices)
        edges.forEach { pair ->
            graph += pair.toEdge()
        }
        println(graph.dfs(0))
    }
}

fun main() {
    checkDfs()
}