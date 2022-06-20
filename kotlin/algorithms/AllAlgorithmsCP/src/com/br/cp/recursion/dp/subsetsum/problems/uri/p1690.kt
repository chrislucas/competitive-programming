package src.com.br.cp.recursion.dp.subsetsum.problems.uri

/*
    https://www.beecrowd.com.br/judge/en/problems/view/1690\
    DONE
 */

private inline fun <T> readValues(delimiter: String = " ", transform: (String) -> T) =
    readLine()!!.split(delimiter).map { transform(it) }


private inline fun <T> readValue(transform: (String) -> T) = readLine()!!.run(transform)

private inline fun testCases(times: Int, exec: (Int) -> Unit) =
    repeat(times, exec)

private fun fastsolution() {
    testCases(readValue(String::toInt)) {
        val s = readValue(String::toInt)
        val values = readValues(transform = String::toLong).sorted()
        var answer = 1L
        for (i in values) {
            // se o ith elemento da lista for maior que a variavel answwer
            // nenhum valor posterior pode ser usado, pq
            // por definicao ANSWER e um numero menor que i logo nenhum subconjuto admite ele ou os numeros
            // posteriores a ele numa soma

            /*
                exemplo S = [3,4,5]
                comecamos com answer = 1
                nenhuma soma de nenhum subconjunto de S é <= a answer. Logo o menor valor não encontrado
                na soma do subconjutno é 1

                exemplo S = [1, 2, 5], answer = 1
                Como 1 e 2 aparecem em S eles nao podem ser a resposta, 0 3 também é a soma do subconjuto [1. 2
                entao o menor numero eh o 4.
                Toda vez que encontrarmos um numero em S <= answer somamos a answer pois isso quer dizer
                que pelo menos o menor numero esta depois de answer + S[i]

             */
            if (i > answer) {
                break
            }
            else {
                answer += i
            }
        }

        println(answer)
    }
}
/*
    TODO, tentar implementar essa solucao lebta para
    explorar subsets usando bitwise
 */
private fun naiveSolution(set: Array<Long>): Long {
    var le = 1L
    var ri = Int.MAX_VALUE * 1L
    val len = 1 shl set.size
    val table = HashSet<Long>()
    for (i in 1 until len) {
        var acc = 0L
        for (j in set.size - 1 downTo 0) {
            if (i and (1 shl j) > 0)
                acc += set[j]
        }
        if (acc == le && !table.contains(acc))
            le += 1
        table += acc
    }
    return le
}

fun main(args: Array<String>) {
    fastsolution()
}