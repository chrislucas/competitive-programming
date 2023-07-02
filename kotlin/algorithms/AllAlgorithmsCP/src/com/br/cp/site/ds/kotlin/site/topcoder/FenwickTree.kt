package src.com.br.cp.site.ds.kotlin.site.topcoder

/*
    https://www.topcoder.com/thrive/articles/Binary%20Indexed%20Trees#2d
    TODO nao deixar de implementar

 */


class FenwickTree(private val values: Array<Int>) {

    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    private val size = tree.size


    private fun build() {

    }

    private fun query(i: Int): Int {
        var acc = 0

        return acc
    }

    fun query(i: Int, j: Int): Int {
        return 0
    }

    fun update(i: Int, value: Int) {
        values[i] = value
    }

    private fun child(value: Int) = value - (value and (-value))

    private fun parent(value: Int) = value + (value and (-value))
}

/*
    https://www.topcoder.com/thrive/articles/Binary%20Indexed%20Trees#read
 */
private fun FenwickTree.read(int: Int) {

}


fun main() {

}