package com.br.ktacademy.delegates.observable.observing

import kotlin.properties.Delegates

/*
    https://kt.academy/article/ak-observable-vetoable?utm_source=newsletter&utm_medium=email&utm_campaign=kotlindispatchersliveqa

    Exemplo de inspiracao
    var presenters: List<Presenter> by
    observable(emptyList()) { _, old, new ->
        (new - old).forEach { it.onCreate() }
        (old - new).forEach { it.onDestroy() }
    }

    O Objetivo aqui é criar varios tipos de observadores e ao remove ou adicionar 1 avisa-los de que foram
    removidos
 */

class ObserversOfObserver<T>(initObservers: MutableList<Observer<T>> = mutableListOf()) {


    private val observersOfObserver: MutableList<Observer<T>> by Delegates.observable(initObservers) { _, old, new ->
        // newers
        val newers = (new - old.toSet())
        newers.forEach { it.onAddObserver() }

        // olders
        val olders = (old - new.toSet())
        olders.forEach { it.onRemoveObserver() }
    }

    operator fun plusAssign(observer: Observer<T>) {
        observersOfObserver += observer
    }
}