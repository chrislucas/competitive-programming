package com.br.ktacademy.delegates.observable.observing


/*
    Fonte
    https://stackoverflow.com/questions/57062977/property-observers-in-kotlin-while-adding-elements-to-arraylist
 */

private fun <T> observableArrayListOf(
    observerArray: ObservableArrayList.ObserverArray<T> = DefaultObserverArray(), size: Int = 2
): MutableList<T> = ObservableArrayList(observerArray, size)

class ObservableArrayList<T>(private val notify: ObserverArray<T>, override val size: Int) : ArrayList<T>(size) {

    interface ObserverArray<T> {
        fun onChange(old: List<T>, new: List<T>)
    }

    operator fun plusAssign(element: T) {
        add(element)
    }

    override fun add(element: T): Boolean {
        notify.onChange(this, (this + element))
        return super.add(element)
    }

    operator fun minusAssign(element: T) {
        remove(element)
    }

    override fun remove(element: T): Boolean {
        notify.onChange(this, (this - element))
        return super.remove(element)
    }
}

class DefaultObserverArray<T> : ObservableArrayList.ObserverArray<T> {
    override fun onChange(old: List<T>, new: List<T>) {
        println("$old, $new")
    }
}


fun main() {
    val observableArrayList = observableArrayListOf<String>()
    observableArrayList += "chris"
    observableArrayList += "lucas"
    observableArrayList -= "chris"
}