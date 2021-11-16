package src.com.br.cp.math.geom.espacial

import src.com.br.cp.math.geom.ConeEquilatero

/*
    Cone
    https://en.wikipedia.org/wiki/Cone
    https://mundoeducacao.uol.com.br/matematica/cone.htm
    https://www.ck12.org/book/ck-12-middle-school-math-concepts-grade-8/section/8.9/
    https://byjus.com/maths/cone/
    https://www.cuemath.com/geometry/cone/

    tronco
    https://www.somatematica.com.br/emedio/espacial/espacial22_2.php
    https://mundoeducacao.uol.com.br/matematica/tronco-de-cone.htm

    calculadora
    https://keisan.casio.com/exec/system/1223372110
 */


private fun checkVolume(raio: Double) {
    println(ConeEquilatero.volume(raio))
}

private fun chekAltura(raio: Double) {
    println(ConeEquilatero.altura(raio))
}


fun main() {

    checkVolume(4.0)
    chekAltura(4.0)
}