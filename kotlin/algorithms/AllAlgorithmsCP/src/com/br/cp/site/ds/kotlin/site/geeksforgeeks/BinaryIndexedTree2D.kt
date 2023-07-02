package src.com.br.cp.site.ds.kotlin.site.geeksforgeeks

/*
    https://www.geeksforgeeks.org/two-dimensional-binary-indexed-tree-or-fenwick-tree/

    A estruttura BinaryIndexedTree(BIT) 2D uma matriz 2D onde cada elemento é uma estrutura BIT

    Como faremos as consultas

    P(x1, y1), Q(x2, y2) -> Pair<Int, Int>
    Query(p, q) = sum(q.x, q.y) - sum(q.x, p,y-1) - sum(p.x-1, q.y) + sum(p.x-1, q.y-1)

    Query(p, q) onde p guarda a posicao do canto inferior esquerdo da submatriz que se quer consultar
    e 'q' a posicao superior direita



    Update(p, value)
    Ao atualizar uma posicao p(x,y) a funcao update ira atualizar toda a regiao x,y M,N onde
    M,N é o máximo da largura da matriz e o N o maximo da altura dela

    Uma consulta Q(x,y) nos da o resultado entre [ (0,0) .. (m,n)] assumindo que m e n eh a dimensao
    da matriz

 */

typealias IntMatrix = Array<Array<Int>>

typealias IntPair = Pair<Int, Int>

operator fun src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntMatrix.set(x: Int, y: Int, value: Int) {
    this[x][y] = value
}

operator fun src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntMatrix.get(x: Int, y: Int) = this[x][y]

class BinaryIndexedTree2D(private val values: src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntMatrix) {

    private val dim = src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntPair(values.size, values[0].size)
    private val bit = Array(dim.first + 1) { Array(dim.second + 1) { 0 } }
    private val cpy = Array(dim.first + 1) { Array(dim.second + 1) { 0 } }

    init {
        construct()
    }

    private fun updateTree(pos: src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntPair, value: Int) {
        var (px, py) = pos
        val (x, y) = dim
        while (px <= x) {
            while (py <= y) {
                bit[px, py] = bit[px, py] + value
                py = descendent(py)
            }
            px = descendent(px)
        }
    }

    private fun sum(px: Int, py: Int): Int {
        var sum = 0
        val (x, y) = dim
        var cx = px
        var cy = py
        while (cx <= x) {
            while (cy <= y) {
                sum += bit[cx, cy]
                cy = parent(cy)
            }
            cx = parent(cx)
        }
        return sum
    }

    fun rangeSum(p: src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntPair, q: src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntPair): Int {
        val (xa, ya) = p
        val (xb, yb) = q
        val a = sum(xb, yb)
        val b = sum(xb, ya - 1)
        val c = sum(xa - 1, yb)
        val d = sum(xa - 1, ya - 1)
        return a - b - c + d
    }

    private fun construct() {
        val (x, y) = dim
        for (j in 1..y) {
            for (i in 1..x) {
                cpy[i, j] = values[y - j, i - 1]
            }
        }

        for (j in 1..y) {
            for (i in 1..x) {

                val a = sum(i, j)
                val b = sum(i, j - 1)
                val c = sum(i - 1, j - 1)
                val d = sum(i - 1, j)


                updateTree(Pair(i, j), cpy[i, j] - (a - b - d + c))
            }
        }
    }

    private fun parent(value: Int) = value - (value and (-value))
    private fun descendent(value: Int) = value + (value and (-value))
}


private class TestCase(private val tree: src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.BinaryIndexedTree2D, private val operations: List<src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.TestCase.Operation>) {
    sealed class Operation
    data class Range(val p: src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntPair, val q: src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.IntPair) : src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.TestCase.Operation()
    data class Update(val index: Int, val value: Int) : src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.TestCase.Operation()
    data class Sum(val index: Int) : src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.TestCase.Operation()

    fun run() {
        for (op in operations) {
            when (op) {
                is src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.TestCase.Range -> {
                    val s = tree.rangeSum(op.p, op.q)
                }

                else -> {

                }
            }
        }
    }
}

private fun check() {
    // https://medium.com/carpanese/a-visual-introduction-to-fenwick-tree-89b82cac5b3c
    // https://www.geeksforgeeks.org/two-dimensional-binary-indexed-tree-or-fenwick-tree/
    arrayOf(
        src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.TestCase(
            src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.BinaryIndexedTree2D(
                arrayOf(
                    arrayOf(1, 2, 3, 4),
                    arrayOf(5, 3, 8, 1),
                    arrayOf(4, 6, 7, 5),
                    arrayOf(2, 4, 8, 9)
                )
            ),
            listOf()
        ),

        src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.TestCase(
            src.com.br.cp.site.ds.kotlin.site.geeksforgeeks.BinaryIndexedTree2D(
                arrayOf(
                    arrayOf(-5, 7, 1, 0, 3, 7, -1, 0, 2),
                    arrayOf(-1, 8, 0, 1, 3, 3, -2, 0, 1),
                    arrayOf(0, 7, 0, 7, 3, 4, -3, 1, 2),
                    arrayOf(11, 9, 1, 0, 3, 6, -4, 0, 2)
                )
            ), listOf()
        )
    ).forEach { case ->
        case.run()
    }


}

fun main() {

}