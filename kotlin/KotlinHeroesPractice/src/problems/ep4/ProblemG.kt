package problems.ep4

// https://codeforces.com/contest/1346/problem/G


/**
 * Problema
 *
 * Temos 2 cameras capazes de tirar fotos a partir de um momento
 * M dentro de um intervalo de tempo K, onde o valor do intervalo eh ja eh pre
 * definido pelo fabricante da camera num com de tamanho N (i1, i2, in)
 *
 * Dado um conjunto M que denota momentos de interesse (m1, m2 ... mn)
 * queremos configurar as cameras tal que ao menos uma delas tire uma foto
 * em cada momento.
 *
 * Entao, devemos configurar quando a camera comeca a tirar fotos e o intervalo
 * entre uma foto e a proxima (i1, i2, in)
 *
 * O problema que queremos resolver eh que as cameras tirem a foto no momento
 * exato definido no conjunto M (momentos)
 *
 *
 * */


fun gdc(a: Int, b: Int): Int {
    var (na, nb) = arrayOf(a, b)
    while (na % nb > 0) {
        val m = na % nb
        na = nb
        nb = m
    }
    return na
}

fun Array<Int>.gdc(): Int {
    var rs = gdc(this[0], this[1])
    for (i in 2 until this.size) {
        rs = gdc(rs, this[i])
    }
    return rs
}


fun readInts(): Array<Int>? =
    readLine()
        ?.split(" ")
        ?.map { it -> it.toInt() }
        ?.toTypedArray()

fun solver1() {
    val (pp, mm) = readInts()!!
    val periods = readInts()!!
    val moments = readInts()!!
    for (m in 0 until moments.size - 1) {
        for (p in periods) {
            if ((moments[m+1] - moments[m]) % p == 0) {
                continue
            }
        }
    }
}


fun main() {
    solver1()
}