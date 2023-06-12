package com.br.ktacademy.delegates.observable.observing


/**
 * TODO estudar
 * https://stackoverflow.com/questions/57062977/property-observers-in-kotlin-while-adding-elements-to-arraylist
 *
 * @see com.br.sample.kdocs.delegationpattern.DelegationPattern
 * @see com.br.ktacademy.delegates.observable.observing.ObserversObservingObserver.kt
 *
 * @see com.br.sample.kdocs.delegationpattern.KotlinDelegationPattern.kt
 */
class ObservableMutableCollection<E>(
    private val collection: MutableList<E> = mutableListOf(),
    private val observers: MutableList<ObserverCollection<E>> = mutableListOf()
) : MutableList<E> by collection {

    interface ObserverCollection<E> {
        fun onAdd(old: List<E>, new: List<E>)

        fun onRemove(old: List<E>, new: List<E>)
    }

    override fun add(element: E): Boolean {
        val new = this + element
        val old = this
        observers.forEach {
            it.onAdd(new, old)
        }
        return collection.add(element)
    }

    override fun remove(element: E): Boolean {
        val new = this - element
        val old = this
        observers.forEach {
            it.onRemove(new, old)
        }
        return collection.remove(element)
    }

    operator fun plusAssign(newValue: E) {
        collection += newValue
    }

    operator fun minusAssign(newValue: E) {
        collection -= newValue
    }
}

private fun check() {
    val collection = ObservableMutableCollection<String>()
    collection += "chris"
    collection += "lucas"
    collection += "fernandes"
    collection += "santos"
    collection -= "chris"
}


fun main() {
    check()
}