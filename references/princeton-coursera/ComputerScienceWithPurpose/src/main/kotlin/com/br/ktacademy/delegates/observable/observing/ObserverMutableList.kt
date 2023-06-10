package com.br.ktacademy.delegates.observable.observing

import kotlin.properties.Delegates

var list: MutableList<String> by Delegates.observable(mutableListOf()) { _, old, new ->
    println("$old, $new")
}

private fun checkBehaviorDelegateObserver() {
    list += "chris"
    list += "lucas"
    list -= "chris"
    // Somente aqui o método do Observer sera chamado.
    // o observavel e a lista como um t0do e nao seu conteudo individual
    list = mutableListOf("nova", "lista")
}





fun main() {

}