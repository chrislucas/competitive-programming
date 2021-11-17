package src.com.br.cp.math.geom.plana

import kotlin.math.sqrt

object Quadrado {
    fun area(lado: Long) = lado * lado
    fun diagonal(lado: Long) = lado * sqrt(2.0)
}

object Retangulo {
    fun area(base: Long, lado: Long) = base * lado
}


object Triangulo {
    fun area(base: Long, altura: Long) = base * altura / 2

    /*
        https://mundoeducacao.uol.com.br/matematica/formula-heron.htm
        https://byjus.com/maths/heron-formula/
    */
    fun heronFormula(a: Double, b: Double, c: Double) {
        fun semiPerimiter(a: Double, b: Double, c: Double) = (a + b + c) / 2.0

        val s = semiPerimiter(a, b, c)
    }
}

/*
    https://www.todamateria.com.br/trapezio/

    b = Base menor
    h = altura
    l = lado
    B = base maior

    Tipos de trapezio:

    Retangulo = Apresenta 2 angulos de 90 graus
    Usoceles = Ou simetrico, apresenta 2 lados congruentes e 2 lados diferentes
    Escaleno = todos os lados diferentes

    https://brasilescola.uol.com.br/matematica/quadrilateros-e-trapezio.htm

 */
object Trapezio {

    fun area(baseMaior: Double, baseMenor: Double, h: Double) =
        ((baseMenor + baseMaior) * h) / 2.0

    fun perimetro(baseMaior: Double, baseMenor: Double, ladoA: Double, ladoB: Double) =
        baseMaior + baseMenor + ladoA + ladoB

    /*
        Base Media
        Quando um segmento de reta corta o trapezio em 2 figuras,
        temos a chamada base media.

        Esse segmento eh paraledo as bases dp trapezio


                ----------
               -------------    => segmento no ponto medio do trapezio. paralelo as bases b e B
             ----------------

     */

    fun baseMedia(baseMaior: Double, baseMenor: Double) = (baseMaior + baseMenor) / 2.0

    /*
        Area abaixo da base media
     */
    fun areaAbaixoBaseMedia(baseMaior: Double, baseMenor: Double, h: Double): Double {
        val baseMedia = (baseMaior + baseMenor) / 2.0
        return ((baseMedia + baseMaior) * h) / 2.0
    }

    /*
        Area acima da base media
     */

    fun areaAcimaBaseMedia(baseMaior: Double, baseMenor: Double, h: Double): Double {
        val baseMedia = (baseMaior + baseMenor) / 2.0
        return ((baseMenor + baseMedia) * h) / 2.0
    }

}