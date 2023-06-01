package src.com.br.cp.ds.set

import java.util.*
import kotlin.Comparator

/**
 * https://www.devmedia.com.br/diferencas-entre-treeset-hashset-e-linkedhashset-em-java/29077#
 */

data class WrapperInt(val data: Int) : Comparable<WrapperInt> {
    override fun compareTo(other: WrapperInt): Int = data - other.data

}


private fun simpleCheckSets() {
    fun checkHashSet() {
        /**
         * Hashset utiliza a HashTable como estrutura de dados implementada
         * pelo HashMap
         * https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
         *
         * - Nao e garantido que a ordem dos elementos se mantenha constante conforme
         * operacoes de insercao sao feitas
         *
         * - A classe aceita null
         * - As principais operacoes sao realizadas em tempo constante (add, remove,
         * contains e size) assumindo que a funcao de hash dispersa os elementos de forma
         * adequada
         *
         * - iterar leva o tempo da SOMA dos elementos que estao na estrutura + um valor
         * C definido na instancia de HashMap para alocar de espaço auxiliar
         */

        /*
        val set = hashSetOf(
            WrapperInt(2),
            WrapperInt(1),
            WrapperInt(3),
            WrapperInt(5),
            WrapperInt(4)
        )

         */

        val set = HashSet(
            listOf(
                WrapperInt(2),
                WrapperInt(5),
                WrapperInt(4),
                WrapperInt(1),
                WrapperInt(3)
            )
        )

        println("HashSet:$set")

        val it = set.iterator()
        while (it.hasNext()) {
            println(it.next())
        }

        println(
            set.iterator().asSequence().joinToString(",")
        )
        println("**************************************************")
    }

    fun checkTreeSet() {
        /**
         *
         * A treeset implementa uma RB-Tree
         */
        val set = TreeSet(
            listOf(
                WrapperInt(2),
                WrapperInt(1),
                WrapperInt(3),
                WrapperInt(5),
                WrapperInt(4)
            )
        )
        println("TreeSet:$set")
    }

    fun checkTreeSetWithComparable() {
        val set = TreeSet(
            Comparator<WrapperInt> { p, q -> q.data - p.data }
        )
        set.addAll(
            listOf(
                WrapperInt(2),
                WrapperInt(1),
                WrapperInt(3),
                WrapperInt(5),
                WrapperInt(4)
            )
        )
        println("TreeSet:$set")
    }

    fun checkLinkedHashSet() {
        /**
         * Os elementos ficam na mesma ordem que foram inseridos
         */
        val set = LinkedHashSet(
            listOf(
                WrapperInt(2),
                WrapperInt(1),
                WrapperInt(3),
                WrapperInt(5),
                WrapperInt(4)
            )
        )

        println("LinkedHashSet:$set")

        val set2 = linkedSetOf(
            WrapperInt(2),
            WrapperInt(1),
            WrapperInt(3),
            WrapperInt(5),
            WrapperInt(4)
        )

        println("LinkedHashSet:$set2")

    }

    checkHashSet()
    checkTreeSet()
    checkTreeSetWithComparable()
    checkLinkedHashSet()
}


fun main() {
    simpleCheckSets()
}