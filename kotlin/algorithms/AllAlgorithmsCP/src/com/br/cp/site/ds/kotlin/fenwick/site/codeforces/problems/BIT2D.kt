package src.com.br.cp.site.ds.kotlin.fenwick.site.codeforces.problems

/*
    https://robert1003.github.io/2020/01/27/fenwick-tree.html
    https://acervolima.com/arvore-indexada-binaria-bidimensional-ou-arvore-de-fenwick-1/
 */

operator fun Array<Array<Int>>.set(x: Int, y: Int, value: Int) {
    this[x][y] = value
}

operator fun Array<Array<Int>>.get(x: Int, y: Int) = this[x][y]


private class BIT2D(private val values: Array<Array<Int>>) {
    private val dim = Pair(values.size, values[0].size)
    private val bit = Array(dim.first + 1) { Array(dim.second + 1) { 0 } }

    private fun parent(value: Int) = value - (value and (-value))

    private fun descendent(value: Int) = value + (value and (-value))
}

fun main() {

}