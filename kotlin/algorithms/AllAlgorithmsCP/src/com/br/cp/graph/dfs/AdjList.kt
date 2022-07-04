package src.com.br.cp.graph.dfs

import java.util.ArrayList

/*
    https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/?ref=lbp
 */

typealias Adj = ArrayList<ArrayList<Int>>

private fun graph(vertices: Int): Adj {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    val size = vertices + 1
    return with(ArrayList<ArrayList<Int>>(size)) {
        for (i in 0 until size) {
            this += arrayListOf<Int>()
        }
        this
    }
}

private fun Adj.dfs(start: Int) {

    fun dfs(start: Int, values: MutableList<Int>, vertices: Array<Boolean>) {

    }

}


fun main() {

}