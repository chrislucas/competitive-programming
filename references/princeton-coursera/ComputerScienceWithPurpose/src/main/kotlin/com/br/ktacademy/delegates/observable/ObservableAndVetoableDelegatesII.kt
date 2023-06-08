package com.br.ktacademy.delegates

import kotlin.properties.Delegates
import kotlin.reflect.KProperty


/**
 * https://kt.academy/article/ak-observable-vetoable?utm_source=newsletter&utm_medium=email&utm_campaign=kotlindispatchersliveqa
 * @see VetoableDelegates
 */

interface ObservableDataChange<T> {
    fun onChange(property: KProperty<*>, oldValue: T, newValue: T)
}

private class DefaultObservableDataChange<T>: ObservableDataChange<T> {
    override fun onChange(property: KProperty<*>, oldValue: T, newValue: T) {
        println("DEFAULT[Property: $property, OldValue: $oldValue, NewValue: $newValue]")
    }
}

private class WrapperObservableData<T>(initValue: T, observable: ObservableDataChange<T> = DefaultObservableDataChange()) {
    var data: T by Delegates.observable(initValue, observable::onChange)
}


private class ObservableMutableData<T>(initValue: T): ObservableDataChange<T> {

    var data: T by Delegates.observable(initValue, this::onChange)

    override fun onChange(property: KProperty<*>, oldValue: T, newValue: T) {
        println("Property: $property, OldValue: $oldValue, NewValue: $newValue")
    }
}


private fun checkObservable() {
    val wrapper = WrapperObservableData(1)
    arrayOf(2, 3,4,5, 6).forEach {
        wrapper.data = it
    }

    println("********************************************************************")

    val observableMutableData = ObservableMutableData('a')
    CharRange('b', 'z').forEach {
        observableMutableData.data = it
    }

    println("********************************************************************")
    /**
     * BRincado com exemplo citado no artigo de uma lista de um RecyclerViewAdapter
     * cujo um elemento do indice i é alterado e podemos disparar um evento quando isso ocoore
     * por exemplo o notifyChange()
     */

    val values = arrayOf(
        WrapperObservableData(
            1 , DefaultObservableDataChange()
        ),
        WrapperObservableData(
            2 , DefaultObservableDataChange()
        ),
        WrapperObservableData(
            3 , DefaultObservableDataChange()
        )
    )
    values[0].data = 2
    values[0].data = 5
    values[0].data = 6

}


fun main() {
    checkObservable()
}