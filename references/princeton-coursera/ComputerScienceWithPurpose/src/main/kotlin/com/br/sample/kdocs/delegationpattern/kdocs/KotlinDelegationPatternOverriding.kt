package com.br.sample.kdocs.delegationpattern.kdocs


/**
 * https://kotlinlang.org/docs/delegation.html#overriding-a-member-of-an-interface-implemented-by-delegation
 */
interface Base {
    /*
        sobre Sobreescrita de membros:
        Membros de classe que sao sobbrescritos
     */
    val message: String
    fun functionA()
    fun functionB()
}


private class BaseImpl(override val message: String): Base {

    override fun functionA() {
        println("Fun A $message")
    }

    override fun functionB() {
        println("Fun B $message")
    }
}

private class CompositeBaseImpl(val base: Base): Base by base {
    override val message: String
        get() = "Mensagem sobreescrita na classe Composta"

    override fun functionA() {
        println("Sobreescrito: [$message].\n" +
                "Base:[${base.message}]\n")
    }
}

private fun checkOverriding() {
    val base = BaseImpl("Mensagem na classe Base")
    val compositeBaseImpl = CompositeBaseImpl(base)
    compositeBaseImpl.functionA()
    println(compositeBaseImpl.message)
}

fun main() {
    checkOverriding()
}