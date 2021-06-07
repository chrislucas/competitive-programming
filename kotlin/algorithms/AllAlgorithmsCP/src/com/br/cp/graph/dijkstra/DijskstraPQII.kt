package com.br.cp.graph.dijkstra

typealias G = MutableList<MutableList<Pair<Int, Int>>>

private fun G.add(p: Int, q: Int, w: Int) {
    this[p].add(q to w)
    this[q].add(p to w)
}

fun main() {

}