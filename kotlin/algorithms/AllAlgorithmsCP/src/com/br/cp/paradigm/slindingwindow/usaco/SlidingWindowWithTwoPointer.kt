package src.com.br.cp.paradigm.slindingwindow.usaco

/**
 * https://usaco.guide/gold/sliding-window?lang=cpp
 */

private fun checkSlidingWindowMax() {

    /**
     * O metodo abaixo devolver o intervalo de tamanho K com a maior soma
     */
    fun slidingWindowMaxIntervalSum(values: List<Int>, k: Int): List<Int> {
        /*
            Criamos uma "janela" de inteiros ordenados de 0 .. k
            onde k é o tamanho da nossa janela ou intervalo de interesse
            da funcao maxSum.
            Seja V o conjunto inicial de inteiros, mover a janela do
            intervalo i .. j para i+i .. j+1 e mesmo que
            subtrair V[i] e adicionar V[j+i] da janela de intervalo.
            podemos aplicar essa operacao de movimentar a janela e procurar
            o maxSum ou minSum em O(logn)
         */
        val window = values.subList(0, k).toSortedSet()
        val acc = mutableListOf<Int>()
        for (i in k until values.size) {
            acc += window.last()
            val mostLeft = values[i - k]
            window.find { it == mostLeft }
                ?.let {
                    window.remove(it)
                }
            window += values[i] // mostRight
        }

        return acc + window.last()
    }


    val values = listOf(
        listOf(1, 4, 2, 10, 23, 3, 1, 0, 20) to 4, // 39
        listOf(100, 200, 300, 400) to 2, // 700
        listOf(1, 4, 2, 10, 2, 3, 1, 0, 20) to 4, // 24
        listOf(4, 2, 10, 230) to 4, // 246
        listOf(5, 2, -1, 0, 3) to 5, // 9
        listOf(1, 4, 2, 10, 2, 3, 1, 0, 20) to 4
    )

    val rs = values
        .map { (values, k) ->
            slidingWindowMaxIntervalSum(values, k)
        }
        .flatten()

    println("$rs. ${rs.sum()}")
}


fun main() {
    checkSlidingWindowMax()
}