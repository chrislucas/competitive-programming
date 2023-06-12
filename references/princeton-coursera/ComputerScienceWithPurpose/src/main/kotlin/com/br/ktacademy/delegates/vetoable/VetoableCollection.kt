package com.br.ktacademy.delegates.vetoable

/**
 * @sse com.br.ktacademy.delegates.observable.observing.ObservableMutableCollection
 * TODO
 */

class VetoableCollection<E>(
    private val collection: MutableList<E> = mutableListOf()
):  MutableList<E> by collection {

}


fun main() {

}