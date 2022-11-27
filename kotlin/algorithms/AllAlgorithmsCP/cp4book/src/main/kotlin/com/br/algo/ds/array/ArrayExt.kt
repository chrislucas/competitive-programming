package com.br.algo.ds.array

/*
    Referencias
    https://www.geeksforgeeks.org/implementing-upper_bound-and-lower_bound-in-c/
    https://www.geeksforgeeks.org/upper_bound-in-cpp/?ref=lbp
    Problems
    https://geeksforgeeks.adochub.com/next-greater-element-set-2-using-upper-bound/amp/
 */

// primeiro elemento > que value
fun <T : Comparable<T>> Array<T>.upperBound(value: T, left: Int = 0, right: Int = size): Int {
    /*
        https://www.geeksforgeeks.org/upper_bound-in-cpp/#
        https://en.cppreference.com/w/cpp/algorithm/lower_bound
        funcao builtin na linguagem cpp. Retornar um iterator point do primeiro elemento
        entre o intervalo [first, last) que  satisfaca a seguinte proposicao
        value < element

        o intervalo devem estar ordenados
     */
    var le = left
    var ri = right
    while (le < ri) {
        val mid = (ri - le) / 2 + le
        if (this[mid] <= value) {
            le = mid + 1
        } else {
            ri = mid
        }
    }
    return le
}

// primeiro elemento >= a value
fun <T : Comparable<T>> Array<T>.lowerBound(value: T, left: Int = 0, right: Int = size): Int {
    /*
        https://www.geeksforgeeks.org/lower_bound-in-cpp/?ref=lbp
        funcao builtin na linguagem cpp. Ela retorna um iterator point apara
        o primeiro elemento que satisfaca a seguinte condicao

        value < element

        Exemplo
        num conjuto S {10,20,30,40,50}, seja T = 30, a funaco lower_bound retornara
        o indice 1 que corresponde ao valor 20 do conjunto S, pos esse é o maior
        valor menor que T
        seja S {10,20,30,40,50} e T = 35, a funcao retornara 3, sendo S[3] = 30

       https://www.geeksforgeeks.org/implementing-upper_bound-and-lower_bound-in-c/
     */

    var le = left
    var ri = right
    while (le < ri) {
        val mid = (ri - le) / 2 + le
        if (this[mid] < value) {
            le = mid + 1
        } else if (this[mid] == value) {
            le = mid
            break
        } else {
            ri = mid
        }
    }
    return le
}


/*
    TODO - primeiro menor que value
    S = {10, 20, 20, 20, 30} Value = 30
    return 1
    S = {10, 20, 20, 20, 30} Value = 5
    return -1
    S = {10, 20, 20, 20, 30} Value = 35
    return 4
 */

fun <T : Comparable<T>> Array<T>.firstLessThan(value: T, left: Int = 0, right: Int = size): Int {
    return 1
}

/*
    TODO - ultimo menor que value
    S = {10, 20, 20, 20, 30} Value = 30
    return 3
    S = {10, 20, 20, 20, 30} Value = 5
    return -1
    S = {10, 20, 20, 20, 30} Value = 35
    return 4
    S = {10, 20, 20, 20, 30, 30} Value = 35
    return 5
 */
fun <T : Comparable<T>> Array<T>.lastLessThan(value: T, left: Int = 0, right: Int = size): Int {
    return 1
}

/*
    TODO - ultimo maior que value
    S = {10, 20, 20, 20, 30} value = 10
    return 3
 */
fun <T : Comparable<T>> Array<T>.lastGreaterThan(value: T, left: Int = 0, right: Int = size): Int {
    return 1
}


private fun checkUpperBound() {
    arrayOf(
        arrayOf(4, 6, 10, 12, 18, 20) to 6,                 // 2
        arrayOf(10, 20, 30, 30, 20, 10, 10, 20) to 20,
        arrayOf(10, 20, 30, 40, 50) to 30,                  // 4
        arrayOf(10, 20, 30, 40, 50) to 45,                  // 4
        arrayOf(10, 20, 30, 40, 50) to 50,                  // 4
        arrayOf(10, 20, 30, 40, 50) to 35,                  // 3
        arrayOf(10, 20, 30, 40, 50) to 55,                  // -1
        arrayOf(10, 20, 30, 30, 30, 40, 50) to 30           // 5
    ).forEach { (data, value) ->
        println(data.mapIndexed { i, v -> "$i:$v" })

        val upper = data.upperBound(value)
        val msg = if (upper == data.size) {
            "Não existe UpperBound para $value"
        } else {
            "Upper bound é: ${upper - 1}"
        }
        println(msg)
        println("*********************************")
    }
}

private fun checkLowerBound() {
    arrayOf(
        arrayOf(10, 20, 30, 40, 50) to 55,                  // 5
        arrayOf(4, 6, 10, 12, 18, 20) to 6,                 // 0
        arrayOf(10, 20, 30, 30, 20, 10, 10, 20) to 20,
        arrayOf(10, 20, 30, 40, 50) to 40,                  // 2
        arrayOf(10, 20, 30, 40, 50) to 30,                  // 1
        arrayOf(10, 20, 30, 40, 50) to 35,                  // 2
        arrayOf(10, 20, 30, 30, 30, 30, 40, 50) to 30,      // 1
    ).forEach { (data, value) ->
        val lower = data.lowerBound(value)
        val msg = if (lower == -1) {
            "Não existe LowerBound para $value"
        } else {
            "Lower bound é: ${lower - 1}"
        }
        println(msg)
    }
}

private fun checkLowerAndUpperI() {
    arrayOf(
        arrayOf(10, 20, 30, 40, 50) to 55,                  // lower = 5; upper = -1
        arrayOf(4, 6, 10, 12, 18, 20) to 6,                 // 0
        arrayOf(10, 20, 30, 30, 20, 10, 10, 20) to 20,
        arrayOf(10, 20, 30, 40, 50) to 40,                  // 2
        arrayOf(10, 20, 30, 40, 50) to 30,                  // 1
        arrayOf(10, 20, 30, 40, 50) to 35,                  // 2
        arrayOf(10, 20, 30, 30, 30, 30, 40, 50) to 30,      // 1
    ).forEach { (values, target) ->
        println(values.mapIndexed { i, v -> "$i:$v" })
        val upper = values.upperBound(target)
        val lower = values.lowerBound(target)
        println("Target: $target - Upper = idx($upper), Lower = idx($lower)")
        println("****************************************************************")
    }
}

private fun checkLowerAndUpperII() {

    listOf(
        (1 .. 6).toList(),
        listOf(1, 2, 4, 5, 5, 6)
    ).forEach { it ->
        println(it.mapIndexed { i, v -> "$i:$v" })

        val data = it.toTypedArray()
        for (i in 0 until 8) {
            // procura o primeiro elemento >= i
            val lower = data.lowerBound(i)
            // procurar o primeiro elemento > i
            val upper = data.upperBound(i)
            println("Target: $i - Upper = idx($upper), Lower = idx($lower)")
            println("-------------------------------------------------------------")
        }

        println("\n---------------------------- next ------------------------------\n")
    }

    println("\n---------------------------- end ------------------------------\n")

}

fun main() {
    checkLowerAndUpperII()
    //checkLowerAndUpperI()
    //checkLowerBound()
    //checkUpperBound()
}