package com.br.ktacademy.delegates

import kotlin.properties.Delegates

/**
 * https://kt.academy/article/ak-observable-vetoable?utm_source=newsletter&utm_medium=email&utm_campaign=kotlindispatchersliveqa
 * "Usamos observables quando queremos agir quando alguma propriedade observavel muda"
 */


private class ObservableData<T>(initValue: T, initObservers: List<(old: T, new: T) -> Unit> = emptyList()) {

    private val observers = mutableListOf<(old: T, new: T) -> Unit>()

    init {
        observers += initObservers
    }

    var value: T by Delegates.observable(initValue) { _, old, new ->
        observers.forEach { it(old, new) }
    }

    operator fun plusAssign(observer: (old: T, new: T) -> Unit) {
        observers += observer
    }
}

private data class Item(var name: ObservableData<String>, var quantity: ObservableData<Int>)

private fun checkObservableProperty() {
    val observableName = ObservableData("a")

    observableName += { old: String, new: String ->
        println("1-Observable Name Old: $old, New: $new")
    }

    observableName += { old: String, new: String ->
        println("2-Observable Name  Old: $old, New: $new")
    }

    val observableQuantity = ObservableData(12)
    observableQuantity += { old: Int, new: Int ->
        println("1-Observable Qtd Old: $old, New: $new")
    }
    observableQuantity += { old: Int, new: Int ->
        println("2-Observable Qtd Old: $old, New: $new")
    }
    observableQuantity += { old: Int, new: Int ->
        println("3-Observable Qtd Old: $old, New: $new")
    }


    val beer = Item(observableName, observableQuantity)

    beer.name.value = "b"
    beer.quantity.value = 2
}

private class UserSystem(val username: ObservableData<String>)

private fun checkInitObserver() {
    val observableUserName = ObservableData("chirs", listOf(
        { old: String, new: String ->
            println("1-Observable Name  Old: $old, New: $new")
        },

        { old: String, new: String ->
            println("2-Observable Name  Old: $old, New: $new")

        },
        { old: String, new: String ->
            println("3-Observable Name  Old: $old, New: $new")

        }
    ))
    val userSystem = UserSystem(observableUserName)
    userSystem.username.value = "lucas"
    userSystem.username.value = "eduardo"
    userSystem.username.value = "cassio"
}


fun main() {
    //checkObservableProperty()
    checkInitObserver()
}