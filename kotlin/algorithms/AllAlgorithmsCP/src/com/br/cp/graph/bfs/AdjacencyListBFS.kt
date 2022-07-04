package src.com.br.cp.graph.bfs

import java.util.*

/*
    https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */

typealias AdjacencyList = ArrayList<ArrayList<Int>>


private fun graph(vertices: Int): AdjacencyList {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    val size = vertices + 1
    return with(ArrayList<ArrayList<Int>>(size)) {
        for (i in 0 until size) {
            this += arrayListOf<Int>()
        }
        this
    }
}


operator fun AdjacencyList.plusAssign(pair: Pair<Int, Int>) {
    val (p, q) = pair
    this[p] += q
}

private fun AdjacencyList.addEdge(p: Int, q: Int) {
    this[p] += q
}

private fun AdjacencyList.bfs(start: Int): List<Int> {
    val vertices = this.size + 1
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

private fun AdjacencyList.bfsOnfGraph(start: Int, qVertice: Int): Map<Int, List<Int>> {
    val allTransversal: MutableMap<Int, List<Int>> = mutableMapOf()
    val visitedVertices = Array(qVertice + 1) { false }
    for (i in start..qVertice) {
        if (!visitedVertices[i]) {
            visitedVertices[i]
            val vertices = mutableListOf<Int>()
            val queue: Queue<Int> = LinkedList()
            queue += i
            while (queue.isNotEmpty()) {
                val p = queue.poll()
                vertices += p
                val it = this[p].iterator()
                while (it.hasNext()) {
                    val v = it.next()
                    if (!visitedVertices[v]) {
                        visitedVertices[v] = true
                        queue += v
                    }
                }
            }
            allTransversal[i] = vertices
        }
    }

    return allTransversal
}

private fun checkBfs() {
    val g = graph(4)
    arrayOf(0 to 1, 0 to 2, 1 to 2, 2 to 0, 2 to 3, 3 to 3).forEach {
        g += it
    }
    println(g.bfs(2))
    println(g.bfsOnfGraph(0, 3))

    val g1 = graph(6)
    arrayOf(
        1 to 2,
        1 to 3,
        2 to 4,
        2 to 5,
        3 to 5,
        4 to 5,
        4 to 6,
        5 to 6,
    ).forEach {
        g1 += it
    }

    println(g1.bfs(1))
    println(g1.bfsOnfGraph(1, 6))
}


fun main() {
    checkBfs()
}