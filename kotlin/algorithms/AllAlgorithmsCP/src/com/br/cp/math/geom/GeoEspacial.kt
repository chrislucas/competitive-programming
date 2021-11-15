package src.com.br.cp.math.geom

import kotlin.math.PI
import kotlin.math.sqrt

object Cubo {
    fun diagonalDaBase(lado: Double) = lado * sqrt(2.0)

    fun diagonalDoCubo(lado: Double) = lado * sqrt(3.0)

    fun areaTotal(lado: Double) = 6 * lado * lado

    fun volume(lado: Double) = lado * lado * lado
}


object Paralelpipedo {

    // d
    fun diagonalDaBase(comprimento: Double, largura: Double) = sqrt(comprimento * comprimento + largura * largura)

    // D
    fun diagonalDoParalelepipedo(comprimento: Double, largura: Double, altura: Double) =
        sqrt(comprimento * comprimento + largura * largura + altura * altura)

    fun areaTotal(c: Double, l: Double, a: Double) = 2 * (c * l + l * a + c * a)

    fun volume(comprimento: Double, largura: Double, altura: Double) = comprimento * largura * altura
}

object Esfera {
    // 4/3 * PI * r^3
    fun volume(raio: Double) = 4.0 / 3.0 * PI * (raio * raio * raio)
}

object Cilindro {
    // pi * r^2 * h
    fun volume(raio: Double, h: Double) = PI * (raio * raio) * h
}