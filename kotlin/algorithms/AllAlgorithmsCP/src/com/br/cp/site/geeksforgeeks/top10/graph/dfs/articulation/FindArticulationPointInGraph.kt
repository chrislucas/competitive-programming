package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.articulation

/*
    TODO
    https://cp-algorithms.com/graph/cutpoints.html

    ---------------------------------------------------------------------------------------------------------
    Fontes
    https://www.baeldung.com/cs/graph-articulation-points#
 */

private class FindArticulationPointInGraph(private val vertex: Int) {

    private val graph = ArrayList<ArrayList<Int>>()

    init {
        for (i in 0..vertex) {
            graph += arrayListOf<Int>()
        }
    }

    operator fun plusAssign(edge: Pair<Int, Int>) {
        val (u, v) = edge
        graph[u] += v
        graph[v] += u
    }

    operator fun plusAssign(edges: Array<Pair<Int, Int>>) {
        for (edge in edges) {
            plusAssign(edge)
        }
    }

    fun getArticulationPoints() {

    }
}


fun main() {

}