package src.com.br.cp.graph.dfs

/*
    https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/?ref=lbp

    Applications
    https://www.geeksforgeeks.org/applications-of-depth-first-search/?ref=rp

 */

typealias Adj = ArrayList<ArrayList<Int>>

private fun graph(vertices: Int): Adj {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    val size = vertices + 1
    return with(ArrayList<ArrayList<Int>>(size)) {
        for (i in 0 until size) {
            this += arrayListOf<Int>()
        }
        this
    }
}

operator fun Adj.plusAssign(pair: Pair<Int, Int>) {
    val (p, q) = pair
    this[p] += q
}

private fun Adj.dfs(start: Int): MutableList<Int> {
    fun dfs(start: Int, graph: Adj, transversal: MutableList<Int>, visited: Array<Boolean>) {
        visited[start] = true
        for (v in graph[start]) {
            if (!visited[v]) {
                transversal += v
                dfs(v, graph, transversal, visited)
            }
        }
    }

    val transversal = mutableListOf<Int>()
    val visited = Array(this.size + 1) { false }
    dfs(start, this, transversal, visited)
    return transversal
}


private val testCases = arrayOf(
    4 to arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3),
    7 to arrayOf(0 to 1, 1 to 2, 1 to 3, 2 to 4, 2 to 5, 3 to 5, 4 to 5, 4 to 6, 5 to 6)
)

private fun checkDfs() {

    testCases.forEach { (vertices, edges) ->
        val adj = graph(vertices)

        edges.forEach { edge ->
            adj += edge
        }

        println(adj.dfs(0))
    }


}


fun main() {

}