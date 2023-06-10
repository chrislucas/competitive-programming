package com.br.ktacademy.delegates.observable.observing


import kotlin.properties.Delegates


interface Observer<T> : Comparable<Observer<T>> {

    fun notifyOnChange(old: T, new: T)

    fun onAddObserver()

    fun onRemoveObserver()

    fun getId(): String
}


private class ObservableData<T>(initValue: T, initObservers: MutableList<Observer<T>> = mutableListOf()) {

    /*
        https://kt.academy/article/ak-observable-vetoable?utm_source=newsletter&utm_medium=email&utm_campaign=kotlindispatchersliveqa

        Exemplo de inspiracao
        var presenters: List<Presenter> by
        observable(emptyList()) { _, old, new ->
            (new - old).forEach { it.onCreate() }
            (old - new).forEach { it.onDestroy() }
        }
        O "observavel" abaixo é a lista como um t0do e nao cada conteudo, ou seja para o metodo
        onChange ser chamado, a lista tem q ser modicada por inteiro, trocada por uma nova instancia
        de lista, como ela é imutavel, isso nao vai acontecer
     */

    private val observersOfData: MutableList<Observer<T>> by Delegates.observable(
        initObservers
    ) { _, old, new ->
        // newers
        val newers = (new - old.toSet())
        newers.forEach { it.onAddObserver() }

        // olders
        val olders = (old - new.toSet())
        olders.forEach { it.onRemoveObserver() }
    }


    var value: T by Delegates.observable(initValue) { _, old, new ->
        observersOfData.forEach { it.notifyOnChange(old, new) }
    }

    /*
        O Objetivo aqui é criar varios tipos de observadores e ao remove ou adicionar 1 avisa-los de que foram
        removidos
     */
    operator fun plusAssign(observer: Observer<T>) {
        val olders = observersOfData
        val newers = observersOfData + observer
        (newers - olders.toSet()).forEach { it.onAddObserver() }
        observersOfData += observer
    }

    operator fun minusAssign(id: String) {
        observersOfData
            .find { it.getId() == id }
            ?.let { found ->
                val olders = observersOfData
                val newers = observersOfData - found
                (olders - newers.toSet()).forEach { it.onRemoveObserver() }
                observersOfData -= found
            }
    }
}

/*
    Nao precisava ser uma sealed class, esse é só um teste

    Pesquisar sobre o uso do id em sealed class
    Accidental override: The following declarations have the same JVM signature (getId()Ljava/lang/String;):
    fun <get-id>(): String defined in com.br.ktacademy.delegates.observable.observing.Logger
    fun getId(): String defined in com.br.ktacademy.delegates.observable.observing.Logger
 */
sealed class Logger<T>(val loggerId: String) : Observer<T> {

    override fun compareTo(other: Observer<T>): Int =
        loggerId.compareTo(other.getId())


    class NewRelicSender<T>(id: String) : Logger<T>(id) {
        override fun notifyOnChange(old: T, new: T) {
            println("NewRelicLog NOTIFY: $loggerId - Sending[old: $old, new: $new]")
        }

        override fun onAddObserver() {
            println("NewRelicLog ADD: $loggerId - I'm onfire")
        }

        override fun onRemoveObserver() {
            println("NewRelicLog REMOVE: $loggerId - shutdown")
        }

        override fun getId(): String = loggerId
    }

    class DataDogSender<T>(id: String) : Logger<T>(id) {
        override fun notifyOnChange(old: T, new: T) {
            println("DataDog NOTIFY: $loggerId - Sending[old: $old, new: $new]")
        }

        override fun onAddObserver() {
            println("DataDog ADD: $loggerId - I'm onfire")
        }

        override fun onRemoveObserver() {
            println("DataDog REMOVE: $loggerId - shutdown")
        }

        override fun getId(): String = loggerId

    }

    class KibanaSender<T>(id: String) : Logger<T>(id) {
        override fun notifyOnChange(old: T, new: T) {
            println("Kibana NOTIFY: $loggerId - Sending[old: $old, new: $new]")
        }

        override fun onAddObserver() {
            println("Kibana ADD: $loggerId - I'm onfire")
        }

        override fun onRemoveObserver() {
            println("Kibana REMOVE: $loggerId - shutdown")
        }

        override fun getId(): String = loggerId
    }
}

private class UserSystem(val username: ObservableData<String>)


private fun checkChanges() {
    val userNameObserver = ObservableData("chris")
    userNameObserver += Logger.KibanaSender("Kibana #1")
    userNameObserver -= "Kibana #1"
    userNameObserver += Logger.KibanaSender("Kibana #2")
    userNameObserver += Logger.NewRelicSender("NewRelic #1")

    userNameObserver.value = "Lucas"
    userNameObserver += Logger.DataDogSender("DataDog #1")

    val userSystem = UserSystem(userNameObserver)
    userSystem.username += Logger.KibanaSender("#3")
    userSystem.username.value = "Mauro"

}


fun main() {
    checkChanges()
}