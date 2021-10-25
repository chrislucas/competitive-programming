package com.br.chp40

// codigo baseado no livro elements of kotlin version 1.0 da commonsware

/**
 * Funcoes inline em kotlin funcionam como o recurso de macros preprocessadas em c e c++
 *
 * As macros possibilitavam criar instrucoes que eram pre processadas antes de passarem
 * pelo compilador, permitindo criar funcoes que nao passariam por questoes de alocamento
 * de memoria e chamadas de funcoes como em funcoes normais, elas funcionariam como uma instrucao incorporada a uma
 * funcao, como se fizesse parte dela. Isso permite economia de memoria e ganho de desempenho,
 * porem aumenta o tamanho da aplicacao no final.
 *
 * # macros
 * https://gcc.gnu.org/onlinedocs/cpp/Macros.html
 * https://docs.microsoft.com/pt-br/cpp/preprocessor/c-cpp-preprocessor-reference?view=msvc-160
 * https://docs.microsoft.com/pt-br/cpp/preprocessor/macros-and-cpp?view=msvc-160
 *
 * */

// inline fun max(x: Int, y: Int) = if(x > y) x else y

private inline fun evaluate(x: Int, y: Int, fn: (Int, Int) -> Int) {
    println(fn(x, y))
}

private fun checkEvaluate() {
    evaluate(10, 20) { x, y ->
        if (x > y) x else y
    }


    evaluate(30, -20) { x, y ->
        if (x > y) x else y
    }
}

fun main() {
    checkEvaluate()
}