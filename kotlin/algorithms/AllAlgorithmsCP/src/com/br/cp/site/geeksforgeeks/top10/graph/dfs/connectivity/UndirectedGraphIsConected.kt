package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.connectivity

/*
    TODO
    https://algorithms.tutorialhorizon.com/check-if-given-undirected-graph-is-connected-or-not/
 */


private class CheckIfUndirectedGraphIsConnectedWitthDFS(size: Int) {
    val graph = ArrayList<ArrayList<Int>>()

    private val isVisited = Array(size) { false }

    init {
        for (i in 0 .. size) {
            graph += arrayListOf<Int>()
        }
    }

    operator fun plusAssign(edge: Pair<Int, Int>) {
        val (u, v) = edge
        graph[u] += v
        graph[v] += u
    }

    fun isConnedted(): Boolean {
        dfs(0)
        return isVisited.all { true }
    }

    private fun dfs(u: Int) {
        for (v in graph[u]) {
            if (!isVisited[v]) {
                dfs(v)
            }
        }
    }
}