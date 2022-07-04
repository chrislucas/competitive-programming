package src.com.br.cp.graph.bfs

import java.util.*

/*
    https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */

typealias AdjacencyList = ArrayList<ArrayList<Int>>


private fun graph(vertices: Int): AdjacencyList =
    with(ArrayList<ArrayList<Int>>(vertices)) {
        for (i in 0 until vertices) {
            this += arrayListOf<Int>()
        }
        this
    }


operator fun AdjacencyList.plusAssign(pair: Pair<Int, Int>) {
    val (p, q) = pair
    this[p] += q
}

private fun AdjacencyList.addEdge(p: Int, q: Int) {
    this[p] += q
}

private fun AdjacencyList.bfs(start: Int): List<Int> {
    val vertices = this.size
    val visited = Array(vertices) { false }
    visited[start] = true
    val queue: Queue<Int> = LinkedList()
    queue += start
    val buffer = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val target = queue.poll()
        buffer += target
        val it = this[target].iterator()
        while (it.hasNext()) {
            val next = it.next()
            if (!visited[next]) {
                visited[next] = true
                queue += next
            }
        }
    }
    return buffer
}

private fun checkBfs() {
    val g = graph(4)
    arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3).forEach {
        g += it
    }

    println(g.bfs(2))
}


fun main() {
    checkBfs()
}