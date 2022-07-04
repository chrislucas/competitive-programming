package src.com.br.cp.graph


typealias AdjacencyList<T> = ArrayList<Array<T>>


private fun graph(vertices: Int): AdjacencyList<Int> =
    with(ArrayList<Array<Int>>(vertices)) {
        for (i in 0 until vertices) {
            this += Array(vertices) { 0 }
        }
        this
    }


fun <T> AdjacencyList<T>.addEdge(p: Int, q: Int, value: T) {
    this[p][q] = value
    this[q][p] = value
}

private fun checkAddEdge() {
    val graph = graph(2)
    graph.addEdge(0, 1, 1)
}


fun main() {
    checkAddEdge()
}