package src.com.br.cp.math.geom.line.arcotangente

import kotlin.math.atan2


/*
    https://www.geeksforgeeks.org/java-lang-math-atan2-java/?ref=lbp
    https://en.wikipedia.org/wiki/Atan2

 */


private fun checkAtan2() {
    /*
        Pensando no circulo trigonometrico
         (x, y)
         (1.0, 0.0) -> ponto sob a abscissa -> quadrante 1
         (1.0, 1.0) -> quadrante 1
         (-1.0, 0.0) -> ponto sob a abscissa
         (0.0, -1.0) -> ponto sob a ordenada
     */
    /*
        https://en.wikipedia.org/wiki/Atan2
        atan2(y, x) = arctan(y/x)
        a funcao atan2 retorna o angulo entre o eixo X e a reta formada do ponto de origem (0, 0) e (x, y)
        A funcao atan2 vai de -pi ate pi
     */
    // os argumento da funcao atan2 (y, x)
    println("${Math.toDegrees(atan2(0.0, 1.0))}")       // 0 graus
    println("${Math.toDegrees(atan2(1.0, 1.0))}")       // 45 gruas
    println("${Math.toDegrees(atan2(1.0, 0.0))}")       // 90 graus
    println("${Math.toDegrees(atan2(1.0, -1.0))}")      // quadrante 2
    println("${Math.toDegrees(atan2(0.0, -1.0))}")
    println("${Math.toDegrees(atan2(-1.0, -1.0))}")     // quadrante 3
    println("${Math.toDegrees(atan2(-1.0, 0.0))}")      //
    println("${Math.toDegrees(atan2(-1.0, 1.0))}")      // quadrante 4
}


fun main() {
    checkAtan2()
}