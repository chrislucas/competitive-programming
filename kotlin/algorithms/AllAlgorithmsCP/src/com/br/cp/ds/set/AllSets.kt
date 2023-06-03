package src.com.br.cp.ds.set

import java.util.*
import kotlin.Comparator

/**
 * https://www.devmedia.com.br/diferencas-entre-treeset-hashset-e-linkedhashset-em-java/29077#
 */

data class ComparableWrapperInt(val data: Int) : Comparable<ComparableWrapperInt> {
    override fun compareTo(other: ComparableWrapperInt): Int = data - other.data
}

data class Wrapper<T>(val data: T)


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
                ComparableWrapperInt(2),
                ComparableWrapperInt(5),
                ComparableWrapperInt(4),
                ComparableWrapperInt(1),
                ComparableWrapperInt(3)
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
         * A treeset implementa uma RB-Tree. Ela immplementa
         * a interface
         * @see SortedSet ao inves de Set (Sorted herda de Set),
         * permitindo eter elementos ordenados automaticamente conforme
         * vamos inserindo dados na estrutura
         * - Custos
         *   - A complexidade para adicionar remover e verificar se esta na estrutura
         *   O(log(n)), maior que do HashSet O(1)
         *
         */
        val set = TreeSet(
            listOf(
                ComparableWrapperInt(2),
                ComparableWrapperInt(1),
                ComparableWrapperInt(3),
                ComparableWrapperInt(5),
                ComparableWrapperInt(4)
            )
        )
        println("TreeSet:$set")
    }

    fun checkLinkedHashSet() {
        /**
         * Os elementos ficam na mesma ordem que foram inseridos.
         * Essa estrutura nos proporciona a performance de um HashSet.
         *
         * https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/LinkedHashSet.html
         * A implementacao difere do HashSet no fato que mantem uma lista duplamente ligada
         *  - A lista ligada define a ordem que os elementos foram inseridos e estao dispostos
         */
        val set = LinkedHashSet(
            listOf(
                ComparableWrapperInt(2),
                ComparableWrapperInt(1),
                ComparableWrapperInt(3),
                ComparableWrapperInt(5),
                ComparableWrapperInt(4)
            )
        )

        println("LinkedHashSet:$set")

        val set2 = linkedSetOf(
            ComparableWrapperInt(2),
            ComparableWrapperInt(1),
            ComparableWrapperInt(3),
            ComparableWrapperInt(5),
            ComparableWrapperInt(4)
        )

        println("LinkedHashSet:$set2")

    }

    checkHashSet()
    checkTreeSet()
    checkLinkedHashSet()
}

private fun checkTreeSetWithComparable() {
    val set = TreeSet(
        Comparator<Wrapper<Pair<Int, Int>>> { p, q ->
            val (pf, ps) = p.data
            val (qf, qs) = q.data
            if (pf == qf) {
                ps - qs
            } else {
                pf - qs
            }
        }
    )
    set.addAll(
        listOf(
            Wrapper(2 to 1),
            Wrapper(1 to 2),
            Wrapper(3 to 5),
            Wrapper(5 to 3),
            Wrapper(4 to 4)
        )
    )
    println("TreeSet:$set")
}


/**
 * Ranking de performance
 * 1 - Hashset
 * 2 - LinkedHashSet
 * 3 - TreeSet
 */

fun main() {
    //simpleCheckSets()
    checkTreeSetWithComparable()
}