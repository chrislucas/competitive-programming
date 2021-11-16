package src.com.br.cp.math.geom.espacial

import src.com.br.cp.math.geom.ConeReto

/*

 */

private fun checkCalculadoraComAltura(raio: Double, h: Double) {
    // Calculadora https://www.calculatorsoup.com/calculators/geometry-solids/cone.php
    println(ConeReto.comprimentoDoLado(raio, h))
    println(ConeReto.volumeComAltura(raio, h))
    println(ConeReto.areaLateralComAltura(raio, h))
    println(ConeReto.areaTotalComAltura(raio, h))
}

// https://www.calculatorsoup.com/calculators/geometry-solids/cone.php
private fun checkCalculadoraComprimentoLateral(raio: Double, c: Double) {
    println(ConeReto.areaTotalComLado(raio, c))
    println(ConeReto.altura(raio, c))
    println(ConeReto.volumeComLado(raio, c))
}


private fun checkCalculadoraComprimentoEAltura(c: Double, h: Double) {
    println(ConeReto.raio(c, h))
}

private fun check() {
    println(ConeReto.volumeComAltura(4.0, 12.0))
    // exemplo 1 https://www.varsitytutors.com/hotmath/hotmath_help/topics/cone
    println(ConeReto.areaLateralComLado(4.0, 5.0))
    // Exemplo 2 https://www.varsitytutors.com/hotmath/hotmath_help/topics/cone
    println(ConeReto.areaTotalComLado(6.0, 10.0))
    // exemplo 3 https://www.varsitytutors.com/hotmath/hotmath_help/topics/cone
    println(ConeReto.volumeComAltura(8.0, 15.0))
}


fun main() {
    //checkCalculadoraComAltura(24.0, 15.0)

    checkCalculadoraComprimentoLateral(10.0, 12.0)

    //checkCalculadoraComprimentoEAltura(15.0, 30.0)
}