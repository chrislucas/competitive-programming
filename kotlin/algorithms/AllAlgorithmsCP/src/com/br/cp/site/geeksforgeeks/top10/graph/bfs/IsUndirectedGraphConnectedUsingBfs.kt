package src.com.br.cp.site.geeksforgeeks.top10.graph.bfs

import java.util.LinkedList
import java.util.Queue

/*
    TODO
    https://algorithms.tutorialhorizon.com/check-if-given-undirected-graph-is-connected-or-not/
 */
class IsConnectedUnGraph(private val size: Int) {

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

    fun isConnected() : Boolean {
        bfs(0)
        return isVisited.all { true }
    }

    private fun bfs(u: Int) {
        val queue: Queue<Int> = LinkedList()
        queue += u
        isVisited[u] = true
        while (queue.isNotEmpty()) {
            for (v in graph[queue.poll()]) {
                if (!isVisited[v]) {
                    queue += v
                }
            }
        }
    }
}


fun main() {

}