package com.br.ktacademy.delegates

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * https://kt.academy/article/ak-observable-vetoable?utm_source=newsletter&utm_medium=email&utm_campaign=kotlindispatchersliveqa
 * "This is a chapter from the book Advanced Kotlin. You can find it on LeanPub."
 * - Um  delegate implementado na biblioteca padrao do kotlin (stdlib) eh o observable vindo objeto Delegates. Especifca
 * uma funcao que sera executada sempre que a propriedade set de u objeto for chamada
 *
 * "Usamos o observable delegate quano queremos tmar uma acao sempre que um valor de uma propriedade muda"
 * TODO
 */



// a funcao lambda inclue 2 paramtros: referencia ao objeto, valor antigo e novo
private var name: String by Delegates
    .observable("Empty") { property, oldValue, newValue ->
        println("Property: $property, Old: $oldValue, Neww: $newValue")
    }

private fun funWithSimpleDelegatesObservable() {
    CharRange('a', 'z').forEach { name = "$it" }
}

// solucao alternativa com setter

fun KProperty<*>.observable(oldValue: String, newValue: String) {
    println("Extension Fun Observable - Property: $this, Old: $oldValue, Neww: $newValue")
}
private var otherName: String = ""
    set(value) {
        field = value
        ::otherName.observable(field, value)
    }

private fun funWithExtFunObservableProperty() {
    CharRange('a', 'z').forEach { otherName = "$it" }
}


fun main() {
    //funWithSimpleDelegatesObservable()
    funWithExtFunObservableProperty()
}