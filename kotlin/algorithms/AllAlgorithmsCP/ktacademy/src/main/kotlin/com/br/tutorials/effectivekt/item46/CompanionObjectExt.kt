package com.br.tutorials.effectivekt.item46

/*
    https://kotlinlang.org/docs/extensions.html#companion-object-extensions
 */
class Clazz {
    companion object
}

fun Clazz.Companion.extFun() {
    println(0xff)
}

fun main() {
    Clazz.extFun()
}