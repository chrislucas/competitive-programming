package com.br.ktacademy.delegates.vetoable

import kotlin.properties.Delegates

/**
 * vetoable delegate
 * https://kt.academy/article/ak-observable-vetoable?utm_source=newsletter&utm_medium=email&utm_campaign=kotlindispatchersliveqa
 *
 * "Veto" do latim, proibir/vetar. Vetoable é Muito semelhante ao observable podendo ainda "vetar"
 * que a propriedada observada mude. Por isso a expressao lambda passada pra funcao vetoable e executada
 * antes de mudar o valor da propriedade.
 *
 * - A expressao lambda esperada por vetoable deve retornar um boolean. Esse valor define se a
 * valor da propiedade vai mudar, se VERDADEIRO a valor muda
 */

private data class VetoableChagenData<T>(
    private val init: T,
    private val vetoable: (old: T, new: T) -> Boolean
) {
    var value: T by Delegates.vetoable(init) { _, old, new -> vetoable(old, new) }
}

private fun checkVetoable() {
    val wrapperInt = VetoableChagenData(2) { _, new -> new % 2 == 1 }
    wrapperInt.value = 4
    println(wrapperInt)
    wrapperInt.value = 1
    println(wrapperInt)
    wrapperInt.value = 3
    println(wrapperInt)
}

// Alternativa ao vetoable

/**
 * @see com.br.ktacademy.delegates.vetoable.DelegatesObservableI
 */


private fun <T> operation(old: T, new: T, verify: (T, T) -> Boolean) = verify(old, new)
private var test: String = ""
    set(value) {

        // encapsulando a logica numa funcao só para
        // explorar outras formas de fazer a mesma coisa
        fun evaluation(value: String) {
            val isDifferent: (String, String) -> Boolean = { a, b -> a != b }
            if (operation(field, value, isDifferent)) {
                field = value
            }
        }

        // outa fora
        operation(field, value) { a, b -> a < b }
            .let {
                if (it) {
                    field = value
                }
            }
    }

private fun checkVetoableI() {
    test = "a"
    println(test)
    test = "b"
    println(test)
    test = "a"
    println(test)
}


var chars: List<Char> by Delegates.vetoable(emptyList()) { _, old, new ->
    old.size < new.size
}

private fun checkVetoableII() {
    chars = listOf('a', 'b')
    println(chars)
    chars = listOf('a')
    println(chars)
}


private fun checkVetoableIII() {
    /*
        vetoable delegate
        POdemos usar quando uma propriedae tem algum requirimento para ser definido
        e sempre que mudar tiver que ter alguma validacao
     */
    var onlyOdd: Int by Delegates.vetoable(1) { _, _, newValue ->
        newValue and 1 == 1
    }

    onlyOdd = 2
    println(onlyOdd)
    onlyOdd = 3
    println(onlyOdd)
    onlyOdd = 4
    println(onlyOdd)
    onlyOdd = 5
    println(onlyOdd)
    onlyOdd = 6
    println(onlyOdd)

}

fun main() {
    // checkVetoableI()
    checkVetoableII()
}