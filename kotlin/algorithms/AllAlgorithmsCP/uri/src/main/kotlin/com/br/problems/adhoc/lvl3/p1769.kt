package com.br.problems.adhoc.lvl3

/**
 * https://www.beecrowd.com.br/judge/en/problems/view/1769
 * DONE
 */

fun validateCpfV1(cpf: String) {

    var flag = true
    for (i in 0..cpf.length - 2) {
        if (cpf[i] != cpf[i + 1]) {
            flag = false
            break
        }
    }
    if (flag) {
        println("CPF invalido")
        return
    }

    var acc = 0
    var sum = 0
    cpf.substring(0..cpf.length - 3).forEach {
        acc += 1
        sum += Character.getNumericValue(it) * acc
    }

    val r = if (sum % 11 == 10) {
        0
    } else {
        sum % 11
    }

    sum = 0
    cpf.substring(0..cpf.length - 3).forEach {
        sum += Character.getNumericValue(it) * acc
        acc -= 1
    }

    val s = if (sum % 11 == 10) {
        0
    } else {
        sum % 11
    }

    val t = Character.getNumericValue(cpf[cpf.length - 2])
    val u = Character.getNumericValue(cpf[cpf.length - 1])

    if (r == t && s == u) {
        println("CPF valido")
    } else {
        println("CPF invalido")
    }
}

private fun validateCpfV2(cpf: String) {
    var flag = true
    for (i in 0..cpf.length - 2) {
        if (cpf[i] != cpf[i + 1]) {
            flag = false
            break
        }
    }
    if (flag) {
        println("CPF invalido")
        return
    }

    var acc = 10
    var sum = 0
    cpf.substring(0..cpf.length - 3).forEach {
        sum += Character.getNumericValue(it) * acc
        acc -= 1
    }

    val r = if (sum * 10 % 11 == 10) {
        0
    } else {
        sum * 10 % 11
    }

    acc = 11
    sum = 0
    cpf.substring(0..cpf.length - 2).forEach {
        sum += Character.getNumericValue(it) * acc
        acc -= 1
    }

    val s = if (sum * 10 % 11 == 10) {
        0
    } else {
        sum * 10 % 11
    }

    val t = Character.getNumericValue(cpf[cpf.length - 2])
    val u = Character.getNumericValue(cpf[cpf.length - 1])

    if (r == t && s == u) {
        println("CPF valido")
    } else {
        println("CPF invalido")
    }
}


fun main(args: Array<String>) {
    do {
        val cpf = readLine()?.filter { it.isDigit() } ?: break
        validateCpfV1(cpf)
        //validateCpfV2(cpf)
    } while (true)
}