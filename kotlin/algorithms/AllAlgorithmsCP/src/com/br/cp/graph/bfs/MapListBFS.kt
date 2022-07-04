package src.com.br.cp.graph.bfs

class Edge(p: Int, q: Int, w: Int = 0)

typealias GraphMap = MutableMap<Int, ArrayList<Edge>>


private fun GraphMap.add(p: Int, edge: Edge) {
    this[p]?.add(edge)
}


private fun GraphMap.bfs(start: Int) {

}


fun main() {

}

