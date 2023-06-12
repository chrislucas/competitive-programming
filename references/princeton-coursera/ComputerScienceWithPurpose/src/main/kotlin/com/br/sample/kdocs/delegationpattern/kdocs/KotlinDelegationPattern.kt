package com.br.sample.kdocs.delegationpattern.kdocs


/**
 * https://kotlinlang.org/docs/delegation.html
 * Uma boa alternativa para implementar heranca
 */

interface Validator<T> {
    fun validate(value: T): Boolean
}


/*
    A clausula "by" faz com que o objeto passado no contrutor seja armazenado
    e utilizado por objetos do tipo Data<T> e o compilador gerara todos os metodos
    de Validator<T> que
 */
private class Data<T>(validator: Validator<T>) : Validator<T> by validator

private fun test() {

    val isOdd = object : Validator<Int> {
        override fun validate(value: Int): Boolean = value and 1 == 1
    }

    val pInt = Data(isOdd)
    (1 .. 10).forEach {
        println(pInt.validate(it))
    }
}

interface Callback {
    fun syncCall()
}

class BaseCallback: Callback {
    override fun syncCall() {
        println("Sync")
    }
}

interface AsybcCallback: Callback {
    fun asyncCall()
}

class BaseAsyncCallback: AsybcCallback {
    override fun asyncCall() {
        println("Async")
    }

    override fun syncCall() {
        println("Sync")
    }
}


class Task(callback: Callback): Callback by callback

class TaskOverrided(callback: Callback): Callback by callback {

    /*
        Sobre sobrescrita de metodos no padrao Delegation
     */
    override fun syncCall() {
        println("Override Sybc")
    }
}

private fun checkTask() {

    val task = Task(BaseAsyncCallback())
    task.syncCall()

    val taskOverrided = TaskOverrided(BaseAsyncCallback())
    taskOverrided.syncCall()
}

// Isso nao é possivel
// class GenericTask<C: Callback>(callback: C): C by callback


fun main() {
    test()
}