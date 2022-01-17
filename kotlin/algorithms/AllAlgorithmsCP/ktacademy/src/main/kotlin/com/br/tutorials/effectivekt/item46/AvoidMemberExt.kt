package com.br.tutorials.effectivekt.item46

import kotlin.reflect.KFunction

/*
    https://kt.academy/article/ek-member-extensions
 */


// member extensions

interface PhoneBook {
    /*
        Dicas do tutorial
        Evite criar extension member function mesmo sendo possivel, a menos que esteja criando uma DSL.
        Para criar extension function com restricoes de visibilidade, use os MODIFICADORES DE ACESSO CORRETAMNENTE
    */
    fun String.isPhoneNumber(): Boolean
}


private val brazilianPhoneFormat = Regex("\\d{2}\\s\\d{4,5}-*\\d{4}")

class ImplPhoneBook : PhoneBook {
    override fun String.isPhoneNumber(): Boolean = this.matches(brazilianPhoneFormat)
}


/*
    Criar um extension function como funcao membro de uma classe com o proposito de encapsulada
    nao funciona muito bem. Abaixo vemos que o unico resultao e dificultar o acesso a funcao
 */

private fun failEncapsulate() {
    val rs = ImplPhoneBook().run {
        "22 9999-0000".isPhoneNumber()
    }
    println(rs)
}

private fun String.isPhoneNumber(): Boolean = this.matches(brazilianPhoneFormat)

class MyPhoneBook(private val number: String, private val validator: (String) -> Boolean) {
    fun verify() {
        /*
            eh possivel usar o let para validar um
         */
        println(number.let(this::validator.get()))

        println(
            number.takeIf(this::validator.get())
        )

        println(number.takeIf(validator))

        println(number.let(validator))
    }
}

/*
    Por que evitar ext function

    1) Referencias nao sao suportadas
 */

private fun checkUnsupportedReference() {
    val ref  = String::isPhoneNumber
    println(ref)
    val number = "11 999990000"
    val boundedRef = number::isPhoneNumber
    println(boundedRef)
    println(boundedRef.invoke())


    /*
        unsupported reference
        Obviamente pq essas extension function/
     */
    //val ref1 = ImplPhoneBoo::isPhoneNumber
    //val ref2 = ImplPhoneBook()::isPhoneNumber



   val ref3 = MyPhoneBook("11 90000-0000") { it.isPhoneNumber() }::verify
    println(ref3)
}


fun main() {
    /*
    val phoneBook = MyPhoneBook("11 90000-0000") { it.isPhoneNumber() }
    phoneBook.verify()

     */

    checkUnsupportedReference()
}