package com.br.cp.dp.graph

import java.util.*

// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/

typealias PQueue = PriorityQueue<Vertice>

typealias Graph = MutableList<MutableList<Vertice>>

data class Vertice(val q: Int, val weight: Int)

val comparator = Comparator<Vertice> { p, q -> p.weight - q.weight }


private fun add(p: Int, q: Int, w: Int, graph: Graph) {
    graph[p].add(Vertice(q, w))
    graph[q].add(Vertice(p, w))
}

private fun instance() {
    val graph = MutableList<MutableList<Vertice>>(9) { mutableListOf() }
    add(0, 1, 4, graph)
    add(0, 8, 7, graph)
    add(1, 2, 8, graph)
    add(1, 7, 11, graph)
}

private fun shortestpath() {
    val pQueue = PQueue()
}

fun main() {
    instance()
}