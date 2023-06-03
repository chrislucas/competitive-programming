package src.com.br.cp.ds.map

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap


/**
 * Inspirado em:
 * https://www.geeksforgeeks.org/sortedmap-java-examples/
 * SortedMap: Uma interface filha da interface Map que prove uma colecao de elementos
 * ordenados baseado na ordem natural do Objeto que foi escolhido como chave do Mapa
 *
 * - Principal diferenca de um Map é que seus elementos sao armazenados na forma ordenada, a ordem
 * e definida pela ordem "natural" do tipo de Classe que e definido como chave, sendo essa classe
 * uma implemetncao da interface Comparable
 *
 * Abaixo temos o seguinte experimento
 * Dado um Array S, cria-se uma lista de Pares P(Int, T) a partir do array que foi devidamente
 * embaralhado usando o algoritmo de shuffle. O par armazena o indice i do S e seu respectivo valor.
 * A funcao que cria o Lista de pares é
 * - fun <T> Array<T>.shuffling(): List<Pair<Int, T>>
 *
 *  Como a lista é criada a partir de um array embaralhado, vamos obter uma lista de pares
 *  com os indices e valores do array tambem embaralhados e assim podemos testar o comportamento
 *  de armazenamento das chaves nas implementacoes de Mapa em Java
 *
 *  Com a lista embarada de pares Pair<Int, T> criamos um mapa Map<Int, T> para testarmos qual é a ordem
 *  que as chaves sao armazenadas no Mapa, a funcao que faz isso é
 *
 *   fun <T, M : MutableMap<Int, T>> List<Pair<Int, T>>.grouping(map: M)
 *
 *   As funcoes citadas permitem que vejamos o lista embaralhada e depois o mapa criado
 *   A funcoes
 *      - fun <reified T, M : MutableMap<Int, T>> Array<T>.groupingShuffledData(map: M)
 *      faz a mesma coisa, mas internamente ela embaralha o array, impedindo que possamos
 *      ver como ele ficou, só vemos o mapa final
 */

inline fun <reified T, M : MutableMap<Int, T>> List<T>.groupingShuffledData(map: M) =
    this.indices
        .shuffled()
        .map { it to this[it] }
        .associateTo(map) { it }



private fun checkMapShuffling() {
    val alpha = CharRange('a', 'z').toList()
    println(alpha)
    println("Treemap\n${alpha.groupingShuffledData(TreeMap<Int, Char>())}")
    println("Treemap as SortedMap\n${alpha.groupingShuffledData(TreeMap())}")
    println("Hashmap\n${alpha.groupingShuffledData(HashMap())}")
    println("LinkedHashmap\n${alpha.groupingShuffledData(LinkedHashMap())}")
    println("**************** SYNC MAPS **************** ")
    println("Sorted\n${alpha.groupingShuffledData(Collections.synchronizedSortedMap(TreeMap()))}")
    println("HashMap\n${alpha.groupingShuffledData(Collections.synchronizedMap(HashMap()))}")
    println("LinkedHashmap\n${alpha.groupingShuffledData(Collections.synchronizedMap(LinkedHashMap()))}")
}

fun <T> Array<T>.shuffling(): List<Pair<Int, T>> =
    this.indices
        .shuffled()
        .map { it to this[it] }


private fun checkNaturalOrderOfKey() {

    fun <T, M : MutableMap<Int, T>> List<Pair<Int, T>>.grouping(map: M) = map.apply {
        this@grouping.map { (k, v) ->
            this[k] = v
        }
    }

    val alpha = CharRange('a', 'z').toList().toTypedArray().shuffling()
    println(alpha)
    println("Java Treemap\n${alpha.grouping(TreeMap<Int, Char>())}")
    println("Hashmap\n${alpha.grouping(HashMap())}")
    println("LinkedHashmap\n${alpha.grouping(LinkedHashMap())}")
    println("**************** SYNC MAPS **************** ")
    println("SortedMap\n${alpha.grouping(Collections.synchronizedSortedMap(TreeMap()))}")
    println("HashMap\n${alpha.grouping(Collections.synchronizedMap(HashMap()))}")
    println("LinkedHashmap\n${alpha.grouping(Collections.synchronizedMap(LinkedHashMap()))}")
}

fun main() {
    checkNaturalOrderOfKey()
    println("\n************************************************************************************************\n")
    checkMapShuffling()
}