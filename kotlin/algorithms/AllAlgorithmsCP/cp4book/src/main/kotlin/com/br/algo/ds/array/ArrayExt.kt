package com.br.algo.ds.array

/*
    Referencias
    https://www.geeksforgeeks.org/implementing-upper_bound-and-lower_bound-in-c/
    https://www.geeksforgeeks.org/upper_bound-in-cpp/?ref=lbp
 */

fun <T : Comparable<T>> Array<T>.upperBound(value: T, left: Int = 0, right: Int = size): Int {
    /*
        https://www.geeksforgeeks.org/upper_bound-in-cpp/#
        funcao builtin na linguagem cpp. Retornar um uterator point do primeiro elemento
        entre o intervalo [first, last) que eh maior do que um dado valor. Os elementos
        dentro do intervalo devem estar ordenados
     */
    var le = left
    var ri = right
    while (le < ri) {
        val mid = (ri - le) / 2 + le
        if (this[mid] > value) {
            ri = mid
        } else {
            le = mid + 1
        }
    }

    return if (le < size && this[le] <= value) {
        le += 1
        -1
    } else {
        le
    }
}
private fun checkUpperBound() {
    arrayOf(
        arrayOf(4, 6, 10, 12, 18, 20) to 6,                 // 2
        arrayOf(10,20,30,30,20,10,10,20) to 20,
        arrayOf(10, 20, 30, 40, 50) to 30,                  // 4
        arrayOf(10, 20, 30, 40, 50) to 45,                  // 4
        arrayOf(10, 20, 30, 40, 50) to 50,                  // 4
        arrayOf(10, 20, 30, 40, 50) to 35,                  // 3
        arrayOf(10, 20, 30, 40, 50) to 55,                  // -1
        arrayOf(10, 20, 30, 30, 30, 40, 50) to 30           // 5
    ).forEach { (data, value) ->
        val upper = data.upperBound(value)
        val msg = if (upper == data.size) {
            "Não existe UpperBound para $value"
        } else {
            "Upper bound é: ${upper - 1}"
        }
        println(msg)
    }
}


fun <T : Comparable<T>> Array<T>.lowerBound(value: T, left: Int = 0, right: Int = size): Int {
    /*
        https://www.geeksforgeeks.org/lower_bound-in-cpp/?ref=lbp
        funcao builtin na linguagem cpp. Ela retorna um iterator point para o maior
        elemento que não seja maior que maior que um dado valot T.
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
        if (value <= this[mid]) {
            ri = mid
        } else {
            le = mid + 1
        }
    }

    return if (le < size && this[le] < value) {
        le += 1
        le
    } else {
        le
    }
}

private fun checkLowerBound() {

    arrayOf(
        arrayOf(10, 20, 30, 40, 50) to 55,                  // 5
        arrayOf(4, 6, 10, 12, 18, 20) to 6,                 // 0
        arrayOf(10,20,30,30,20,10,10,20) to 20,
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

private fun checkBoth() {
    arrayOf(
        arrayOf(10, 20, 30, 40, 50) to 55,                  // lower = 5; upper = -1
        arrayOf(4, 6, 10, 12, 18, 20) to 6,                 // 0
        arrayOf(10,20,30,30,20,10,10,20) to 20,
        arrayOf(10, 20, 30, 40, 50) to 40,                  // 2
        arrayOf(10, 20, 30, 40, 50) to 30,                  // 1
        arrayOf(10, 20, 30, 40, 50) to 35,                  // 2
        arrayOf(10, 20, 30, 30, 30, 30, 40, 50) to 30,      // 1
    ).forEach { (values, target) ->
        val upper = values.upperBound(target)
        val lower = values.lowerBound(target)
        println("Upper = $upper, Lower = $lower")
    }
}

fun main() {
    checkBoth()
    //checkLowerBound()
    //checkUpperBound()
}