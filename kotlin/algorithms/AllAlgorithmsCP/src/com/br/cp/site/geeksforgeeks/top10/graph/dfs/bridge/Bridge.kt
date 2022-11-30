package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.bridge

/*
    TODO
    https://www.geeksforgeeks.org/bridge-in-a-graph/
    Um aresta num grafo nao direcionado e uma ponte (bridge) se ao ser removida cria um grafo desconexo.
    Para um grafo nao direcionado desconexo a definicao de ponte e similar, um ponte e uma aresta que se removida
    aumenta o numero de componentes desconexos
 */

private typealias SimpleAdjList = ArrayList<ArrayList<Int>>


private class BridgeGraph(size: Int) {

    val graph = SimpleAdjList()

    init {
        for (i in 0..size) {
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

    fun find() {

    }

    private fun dfs(u: Int) {

    }

}


fun main() {

}