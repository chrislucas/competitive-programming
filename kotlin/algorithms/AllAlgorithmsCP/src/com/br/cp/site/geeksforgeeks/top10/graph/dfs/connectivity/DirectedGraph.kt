package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.connectivity

/**
 * https://www.geeksforgeeks.org/check-if-a-directed-graph-is-connected-or-not/#
 */

private class DirectedGraph(private val size: Int) {

    private val graph = ArrayList<ArrayList<Int>>()
    private val reversed = ArrayList<ArrayList<Int>>()

    init {
        for (i in 0 until size) {
            graph += arrayListOf<Int>()
            reversed += arrayListOf<Int>()
        }
    }

    operator fun plusAssign(edge: Pair<Int, Int>) {
        val (u, v) = edge
        graph[u] += v
        reversed[v] += u
    }

    operator fun plusAssign(edges: Array<Pair<Int, Int>>) {
        for (edge in edges) {
            plusAssign(edge)
        }
    }

    fun isConnected(): Boolean {
        val v1 = Array(size) { false }
        val v2 = Array(size) { false }
        dfs(0, graph, v1)
        dfs(0, reversed, v2)
        for (i in 0 until size) {
            if (!v1[i] && !v2[i]) {
                return false
            }
        }
        return true
    }

    private fun dfs(u: Int, g: ArrayList<ArrayList<Int>>, visited: Array<Boolean>) {
        visited[u] = true
        for (v in graph[u]) {
            if (!visited[v]) {
                dfs(v, g, visited)
            }
        }
    }
}

private fun checkIsConnected() {
    arrayOf(
        arrayOf(Pair(0, 1), Pair(0, 2), Pair(1, 2), Pair(2, 3)) to 4,
        arrayOf(Pair(0, 1), Pair(0, 2), Pair(1, 2), Pair(3, 3)) to 4,
        arrayOf(Pair(0, 1), Pair(2, 3)) to 4
    ).forEach { (edges, size) ->
        val g = DirectedGraph(size)
        g += edges
        println(g.isConnected())
    }
}


fun main() {
    checkIsConnected()
}