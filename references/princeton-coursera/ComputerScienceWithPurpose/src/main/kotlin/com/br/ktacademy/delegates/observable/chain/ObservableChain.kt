package com.br.ktacademy.delegates.observable.chain

import kotlin.properties.Delegates

/**
 * TODO criar uma observable que avisa os seus observers e os observers dos observer
 */


interface ObserverChain<T> {
    fun notify(old: T, new: T)
    fun next(): ObserverChain<T>?
}


private class ObservableChain<T>(
    initValue: T,
    private val observers: MutableList<ObserverChain<T>> = mutableListOf()
) {

    var value: T by Delegates.observable(initValue) { _, old, new ->
        observers.forEach { it.notify(old, new) }
    }

    operator fun plusAssign(observer: ObserverChain<T>) {
        observers += observer
    }
}


fun main() {
    println(0xff)
}