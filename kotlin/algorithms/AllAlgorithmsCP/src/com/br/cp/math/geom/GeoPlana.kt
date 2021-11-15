package src.com.br.cp.math.geom

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
}