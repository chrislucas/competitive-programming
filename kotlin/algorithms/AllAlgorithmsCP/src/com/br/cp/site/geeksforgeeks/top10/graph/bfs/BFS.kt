package src.com.br.cp.site.geeksforgeeks.top10.graph.bfs

import java.util.LinkedList
import java.util.Queue

/*
    TODO
    https://www.geeksforgeeks.org/top-algorithms-and-data-structures-for-competitive-programming/?ref=lbp
 */


private typealias SimpleAdjList = ArrayList<ArrayList<Int>>


private class GraphI(private val size: Int) {
    val graph = SimpleAdjList()

    private val visited = Array(size) { false }

    init {
        for (i in 0..size) {
            graph += arrayListOf<Int>()
        }
    }

    operator fun plusAssign(edge: Pair<Int, Int>) {
        val (u, v) = edge
        graph[u] += v
    }

    operator fun plusAssign(edges: Array<Pair<Int, Int>>) {
        for (edge in edges) {
            plusAssign(edge)
        }
    }

    fun bfs(u: Int, fn: (Int) -> Unit) {
        val queue: Queue<Int> = LinkedList()
        queue += u
        while (queue.isNotEmpty()) {
            val p = queue.poll()
            fn(p)
            visited[p] = true
            for (v in graph[p]) {
                if (!visited[v]) {
                    queue += v
                }
            }
        }
    }

}

fun main() {

}