package src.com.br.cp.graph.bfs

import java.util.*

/*
    https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */

/*
    Pair(vertice, peso)
 */
typealias Adj = ArrayList<ArrayList<Pair<Int, Int>>>


private fun graph(vertices: Int): Adj {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    val size = vertices + 1
    return with(Adj(size)) {
        for (i in 0 until size) {
            this += arrayListOf<Pair<Int, Int>>()
        }
        this
    }
}


private operator fun Adj.plusAssign(pair: Pair<Int, Pair<Int, Int>>) {
    val (p, q) = pair
    this[p] += q
}

private fun Adj.addEdge(p: Int, q: Int, w: Int) {
    this[p] += q to w
}

private fun Adj.bfs(start: Int): List<Int> {
    val vertices = this.size
    val visited = Array(vertices) { false }
    visited[start] = true
    val queue: Queue<Int> = LinkedList()
    queue += start
    val values = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val target = queue.poll()
        values += target
        val it = this[target].iterator()
        while (it.hasNext()) {
            val next = it.next()
            if (!visited[next.first]) {
                visited[next.first] = true
                queue += next.first
            }
        }
    }
    return values
}

private fun checkBfs() {
    val g = graph(4)
    /*
        g.addEdge(0, 1, 0);
        g.addEdge(0, 2, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(2, 0, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(3, 3, 0);
     */
    arrayOf(
        0 to (1 to 0),
        0 to (2 to 0),
        1 to (2 to 0),
        2 to (0 to 0),
        2 to (3 to 0),
        3 to (3 to 0)
    ).forEach {
        g += it
    }
    println(g.bfs(2))
}


fun main() {
    checkBfs()
}