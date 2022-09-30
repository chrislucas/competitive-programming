package src.com.br.cp.site.ds.kotlin.fenwick.countinversion.v1


/*
    TODO nao deixar de implementar
    https://iq.opengenus.org/count-inversions-in-an-array-using-fenwick-tree/
    Questoes
    se a[i] > a[j[] para i < j entao o pair i,j esse par eh chamado de inversao no array
    - Inversao eh o numero de passos necessarios para ordenar um array
    - Se o array ja esta ordenado o numero de inversoes = 0
    - Se o array estiver ordenado de forma descendente o numero de inversoes eh o maximo
    - Merge sort pode ser usado para contar inversoes mas Fenwick e uma forma mais facil de contar
    inversoes

    Steps

    1 - mapear os elementos do array com range de 1 a n
        - os elementos do array podem ser negativos entao usamos os elementos do array como indices na Fenwick
        tree.
        -  Elementos do array nao estao uniformemente distribuido.  criamos uma arvore com tamanho N + 1,
        N = quantidade de elementos do array
        - para mapear o array o ordenamos

    2 - contar o numero de inversos do array transpassando de tras para frente de n-1 ate 0.
        - Ao iterar pelo array A, estando no elemento A[i] nós contamos os numeros que sao menores que A[i]
        - Para recuperar esse valor usamos o metodo que retorna a soma na posicao i
 */

private class CountingInvertionBinIndexedTree(private val values: Array<Int>) {

    private val tree = Array(values.size + 1) { 0 }
    private val size = values.size - 1

    init {
        val temp = values.copyOf()
        temp.sort()
        val position = hashMapOf<Int, Int>()

        var acc = 1
        for (i in temp.indices) {
            position[temp[i]] = acc
            acc += 1
        }

        // converter os valores do vetor values
        for (i in 0 until position.size) {
            values[i] = position[values[i]] ?: 0
        }

        for (i in values.indices) {
            buildTree(i, values[i])
        }
    }

    private fun sum(idx: Int): Int {
        var acc = 0
        var i = idx
        while (i > 0) {
            acc += tree[i]
            i = child(i)
        }
        return acc
    }

    private fun buildTree(idx: Int, delta: Int) {
        var i = idx + 1
        while (i < size) {
            tree[i] += delta
            i = parent(i)
        }
    }

    fun coutingInversions(): Int {
        var acc = 0
        for (i in size - 1 downTo 0) {
            val value = values[i]
            acc += sum(value - 1)
            buildTree(value, 1)
        }
        return acc
    }

    private fun child(value: Int) = value - (value and (-value))

    private fun parent(value: Int) = value + (value and (-value))
}


private fun test() {
    arrayOf(
        CountingInvertionBinIndexedTree(arrayOf(1, -3, 5, 4)),
        CountingInvertionBinIndexedTree(arrayOf(1, -9, 5, 4, 3)),
        CountingInvertionBinIndexedTree(arrayOf(5, 4, 3, 1, -9)),
        CountingInvertionBinIndexedTree(arrayOf(8, 4, 2, 1)),
        CountingInvertionBinIndexedTree(arrayOf(1, 2, 4, 6)),
        CountingInvertionBinIndexedTree(arrayOf(5, 4, 3, 1, -9))
    ).forEach { tree ->
        println(tree.coutingInversions())
    }
}

fun main() {
    test()
}