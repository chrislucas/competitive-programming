package com.br.algo.cp.book1.chp2.kotlin.fenwick.v3

/*
   https://medium.com/carpanese/a-visual-introduction-to-fenwick-tree-89b82cac5b3c

    Chamamos a fenwick de BIT pq utilizamos do menor bit signidica para navegar
    pela arvore e construi-la

    - Usamos a representacao binaria de cada indice para indicar
        1 - o intervalo ou tamanho do bloco (quantos indices) um determinado indice
        do array eh responsavel
            - Exemplo
                - 1 = 0001b o indice 1 eh responsavel pelo indice 1
                – 2 = 0010b o indice 2 eh responsavel de 1 a 2
                – 3 = 0011b o indice 3 eh responsavel pelo indice 3
                – 4 = 0100b o indice 4 eh responsavel de 0 a 4
                - 5 = 0101b o indice 5 eh responsavel pelo indice 5
                - 6 = 0110b o indice 6 eh responsavel de 5 a 6

        2 - O menor bit significativo permite quebrar o numero antes dele
        e depois, formando um prefixo e um sufixo
            - 2 = 0010b 00|10 prefixo 00, sufixo 10
            - 10 = 1010b 10|10 prefixo 10, sufixo 10
            - prefixo indica a ordem que o elemento está no nivel da arvore (0, 1, 2, 3)
            - sufixo indica a altura que esse mesmo elemento está na arvore (1, 2, 4, 8)
                - note que o sufixo sempre será uma potencia de 2


    Padrao binario da estrutura da arvore.
 */

class FenwickTreeIII(val values: Array<Int>) {

    private val tree: Array<Int> = Array(values.size + 1) { 0 }

    private val size: Int
        get() = tree.size

    init {
        /*
            construindo a arvore: NAO CONFUNDA COM UM ARRAY DE PREFIXO
            lembrar que a arvore eh montada usando o bit menos significativo
            de cada indice do array
         */
        for (i in 1 until size) {
            add(i, values[i - 1])
        }
    }

    fun showPrefixSum() = println("PrefixSum = ${tree.toList()}")

    fun showValues() = println("Values = ${values.toList()}")

    /*
        least significant bit
        ponto importante
        -lsb(i) eu encontro o no ancestral de um nó (folha ou nao)
        +lsb(i) eu encontro o no descendente de um nó
     */

    //private fun lsb(value: Int) = value and -value

    private fun parent(value: Int) = value - (value and -value)

    private fun descendent(value: Int) = value + (value and -value)

    private fun query(i: Int): Int {
        var res = 0
        var ci = i
        while (ci > 0) {
            res += tree[ci]
            ci  = parent(ci)
        }
        return res
    }

    fun rangeSum(le: Int, ri: Int): Int {
        val cl = le + 1
        val cr = ri + 1
        return if (cl == 1) {
            query(cr)
        } else {
            query(cr) - query(cl - 1)
        }
    }

    private fun add(idx: Int, delta: Int) {
        var i = idx
        while (i < size) {
            tree[i] += delta
            i = descendent(i)
        }
    }

    fun update(idx: Int, newValue: Int) {
        add(idx + 1, newValue - values[idx])
        values[idx] = newValue
    }
}

private class TestCase(
    private val fenwickTree: FenwickTreeIII, private val operations: List<Operation>
) {
    sealed class Operation
    data class Range(val start: Int, val end: Int) : Operation()
    data class Update(val index: Int, val value: Int) : Operation()

    fun hasCases() = operations.isNotEmpty()

    fun run() {
        for (op in operations) {
            when (op) {
                is Range -> {
                    val s = fenwickTree.rangeSum(op.start, op.end)
                    println("RangeSum(${op.start}, ${op.end}) = $s")
                }
                is Update -> {
                    print("Antes: ")
                    fenwickTree.showValues()
                    fenwickTree.update(op.index, op.value)
                    println("Update(${op.index}, ${op.value})")
                }
            }
            fenwickTree.showValues()
            fenwickTree.showPrefixSum()
            println("--------------------------------------------------------------------")
        }
    }
}

private fun checkCases() {
    val cases = arrayOf(
/*
        TestCase(
            FenwickTreeIII(arrayOf(1, 2, 3, 4)), listOf(
                TestCase.Range(0, 3),
                TestCase.Range(2, 3),
                TestCase.Range(1, 3),
                TestCase.Update(3, 10),
                TestCase.Range(0, 3)
            )
        ),

        TestCase(
            FenwickTreeIII(arrayOf(-5, 7, 0, 1, 3, 2, -1, 0, 2)),
            listOf(
                TestCase.Range(1, 4),
                TestCase.Update(3, 5),
                TestCase.Range(1, 4)
            )
        ),

 */
        TestCase(
            FenwickTreeIII(arrayOf(4, 8, 5, 2, 6, 1, 0, 8, 1, 5, 4, 9, 1, 0, 6, 6)),
            listOf(
                TestCase.Range(0, 1),
                TestCase.Range(0, 15),
                TestCase.Range(1, 1),
                TestCase.Range(7, 8),
                TestCase.Range(0, 0),
                TestCase.Range(15, 15),
            )
        )
    )

    cases.forEach {
        if (it.hasCases()) {
            it.run()
            println("***************************** FIM ***********************************")
        }
    }
}

fun main() {
    checkCases()
}