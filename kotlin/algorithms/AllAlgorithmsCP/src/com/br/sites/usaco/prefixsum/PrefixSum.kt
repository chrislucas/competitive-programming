package src.com.br.sites.usaco.prefixsum

/*
    https://usaco.guide/silver/prefix-sums?lang=cpp
    https://darrenyao.com/usacobook/cpp.pdf#page=60

    Imagine um Array S com N elementos e queremos executar Q consutlas para encontrar a soma
    dos elementos entre os indices A e B inclusive. Cada consulta Q terá A e B diferentes.

    Aqui eh previsto que o Array S tem n+1 elementos sendo o S[0] = 0, entao os intervalos
    validos sao entre 1 e n
 */

private val values = arrayOf(
    arrayOf(0, 1, 6, 4, 2, 5, 3),
    arrayOf(0, 1, 7, 11, 13, 18, 21)
)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }

private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private fun prefixSumArrayDummyIndex(values: Array<Int>, queries: Int) {

    fun prefixSum(values: Array<Int>): Array<Int> {
        val prefix = Array(values.size) { 0 }
        for (i in values.indices) {
            prefix[i] = if (i == 0) {
                values[0]
            } else {
                prefix[i - 1] + values[i]
            }
        }
        return prefix
    }

    val prefix = prefixSum(values)
    repeat(queries) {
        val (p, q) = readValues(transform = String::toInt)
        if (p in 1..q && q < prefix.size) {
            /**
             * Soma dos intervalos p e q
             * prefix contem = S[0, sum[0, 1], sum (0, 2), sum(0, 3) ...]
             *
             * Para obter a soma entre p e q usamos a seguinte expressao
             * prefix[q] - prefix[p - 1].
             * Por que ?
             * até q temos a soma de 0 a q
             * ate p temos a soma de 0 a p
             * a soma de 0 a q inclui 0 a p para p <= q
             * entao de 0 a p-1 sao os valores que queremos remover do somatório
             * entao subtraimos de prefix[0 .. q] os valores antes de [0 .. p] que sao de [0 .. p-1]
             */
            println(prefix[q] - prefix[p - 1])
        } else if (p - 1 <= 0 && q < prefix.size) {
            println(prefix[q])
        }
    }
}

private fun prefixSumArrayWithoutDummyIndex() {
    val test = arrayOf(
        arrayOf(1, 6, 4, 2, 5, 3),
        arrayOf(1, 7, 11, 13, 18, 21)
    )

    fun prefixSum(values: Array<Int>): Array<Int> {
        val prefix = Array(values.size) { 0 }
        for (i in values.indices) {
            prefix[i] = if (i == 0) {
                values[0]
            } else {
                prefix[i - 1] + values[i]
            }
        }
        return prefix
    }

    test.forEach { case ->
        val prefix = prefixSum(case)
        val queries = readValue(String::toInt)
        repeat(queries) {
            val (p, q) = readValues(transform = String::toInt)
            if (p - 1 < 0) {
                println(prefix[q])
            } else if (p in 1..q && q < prefix.size) {
                println(prefix[q] - prefix[p - 1])
            }
        }
    }
}

private fun checkQueries() {
    values.forEach {
        prefixSumArrayDummyIndex(it, 10)
    }
}

private fun checkPrefixSumArrayWithoutDummyIndex() {
    prefixSumArrayWithoutDummyIndex()
}

fun main() {
    //checkQueries()
    checkPrefixSumArrayWithoutDummyIndex()
}