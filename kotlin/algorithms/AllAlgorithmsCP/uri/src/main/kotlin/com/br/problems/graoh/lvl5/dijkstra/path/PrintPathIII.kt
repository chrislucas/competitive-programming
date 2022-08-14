package com.br.problems.graoh.lvl5.dijkstra.path

import java.util.*
import kotlin.collections.HashMap
import kotlin.system.measureTimeMillis

/*
    CP
   https://stackoverflow.com/questions/28998597/how-to-save-shortest-path-in-dijkstra-algorithm
 */

private data class Edge(val v: Int = 0, val w: Int = 0) : Comparable<Edge> {
    override fun compareTo(other: Edge) = w - other.w
}

private typealias Adj = HashMap<Int, ArrayList<Edge>>

private typealias PQ = PriorityQueue<Edge>

private fun graph(v: Int): Adj {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    return with(hashMapOf<Int, ArrayList<Edge>>()) {
        for (i in 0 until v) {
            this[i] = arrayListOf()
        }
        this
    }
}

private fun Adj.add(p: Int, edge: Edge) {
    val (v, w) = edge
    this[p]?.plusAssign(edge)
    this[v]?.plusAssign(Edge(p, w))
}


private fun Adj.dijkstra(source: Int): Array<Int> {
    val inf = Int.MAX_VALUE
    val distance = Array(this.size) { inf }
    val pq = PQ()
    pq += Edge(source, 0)
    distance[0] = 0
    while (pq.isNotEmpty()) {
        val edge = pq.poll()
        val u = edge.v
        this[u]?.forEach { (v, w) ->
            val uv = distance[u] + w
            if (distance[v] > uv) {
                distance[v] = uv
                pq += Edge(v, distance[v])
            }
        }
    }
    return distance
}


class Dijkstra(val source: Int, val distance: Array<Int>, private val parents: Array<Int>) {

    fun get(): HashMap<Int, Stack<Int>> {
        val allPaths = hashMapOf<Int, Stack<Int>>()
        for (i in parents.indices) {
            val path = Stack<Int>()
            var parent = i
            while (parent != parents[parent]) {
                path += parent
                parent = parents[parent]
            }
            path += parent
            allPaths[i] = path
        }
        return allPaths
    }
}

private fun Adj.trackPath(source: Int): Dijkstra {
    val inf = Int.MAX_VALUE
    val distance = Array(this.size) { inf }
    distance[source] = 0

    val visited = Array(this.size) { false }

    val pq = PQ()
    pq += Edge(source, 0)

    val parents = Array(this.size) { -1 }
    parents[source] = source

    while (pq.isNotEmpty()) {
        val edge = pq.poll()
        val u = edge.v
        if (!visited[u]) {
            visited[u] = true
            this[u]?.forEach { (v, w) ->
                val uv = distance[u] + w
                if (distance[v] > uv) {
                    distance[v] = uv
                    parents[v] = u
                    pq += Edge(v, distance[v])
                }
            }
        }
    }
    return Dijkstra(source, distance, parents)
}

private fun <T> Array<T>.string(separator: String = "|"): String =
    joinToString(separator, prefix = "[", postfix = "]")

private fun checkTrackPath() {
    val graph = graph(9)
    val testcases = arrayOf(
        arrayOf(
            0 to Edge(1, 4),
            0 to Edge(7, 8),
            1 to Edge(2, 8),
            1 to Edge(7, 11),
            2 to Edge(3, 7),
            2 to Edge(5, 4),
            2 to Edge(8, 2),
            3 to Edge(4, 9),
            3 to Edge(5, 14),
            4 to Edge(5, 10),
            5 to Edge(6, 2),
            6 to Edge(7, 1),
            6 to Edge(8, 6),
            7 to Edge(8, 7)
        ),
        // https://www.baeldung.com/java-dijkstra
        arrayOf(
            0 to Edge(1, 10),
            0 to Edge(2, 15),
            1 to Edge(3, 12),
            1 to Edge(5, 15),
            2 to Edge(4, 10),
            3 to Edge(4, 2),
            3 to Edge(5, 1),
            5 to Edge(4, 5),
        )
    )
    testcases[0].forEach { (origin, edge) ->
        graph.add(origin, edge)
    }
    measureTimeMillis {
        graph.trackPath(0).get().let {
            println(it)
        }
    }.let {
        println(it / 1000.0)
    }
}

fun main() {
    checkTrackPath()
}