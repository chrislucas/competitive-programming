package com.br.cp.dp.graph

typealias G = MutableList<MutableList<Pair<Int, Int>>>

private fun add(p: Int, q: Int, w: Int, graph: G) {
    graph[p].add(q to w)
    graph[q].add(p to w)
}

fun main() {

}