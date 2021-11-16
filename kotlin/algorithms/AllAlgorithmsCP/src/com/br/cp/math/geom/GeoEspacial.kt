package src.com.br.cp.math.geom

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.sqrt

object Cubo {
    fun diagonalDaBase(lado: Double) = lado * sqrt(2.0)

    fun diagonalDoCubo(lado: Double) = lado * sqrt(3.0)

    fun areaTotal(lado: Double) = 6 * lado * lado

    fun volume(lado: Double) = lado * lado * lado
}


object Paralelpipedo {

    // d
    fun diagonalDaBase(comprimento: Double, largura: Double) =
        sqrt(comprimento * comprimento + largura * largura)

    // D
    fun diagonalDoParalelepipedo(comprimento: Double, largura: Double, altura: Double) =
        sqrt(comprimento * comprimento + largura * largura + altura * altura)

    fun areaTotal(c: Double, l: Double, a: Double) = 2 * (c * l + l * a + c * a)

    fun volume(comprimento: Double, largura: Double, altura: Double) = comprimento * largura * altura
}

object Esfera {
    // 4/3 * PI * r^3
    fun volume(raio: Double) = 4.0 / 3.0 * PI * (raio * raio * raio)

    fun areaSuperficie(r: Double) = 4 * PI * (r * r)
}

object Cilindro {
    // pi * r^2 * h
    fun volume(raio: Double, h: Double) = PI * (raio * raio) * h

    fun areaSuperficie(h: Double, r: Double) = 2 * PI * h + 2 * PI * (r * r)
}

/*
    https://en.wikipedia.org/wiki/Cone
    https://mundoeducacao.uol.com.br/matematica/cone.htm
    https://www.todamateria.com.br/cone/
    https://matematicabasica.net/cone/
    https://mundoeducacao.uol.com.br/matematica/cone.htm

    https://www.uel.br/projetos/matessencial/basico/geometria/cones.html

    Volume de um cone
    https://www.cuemath.com/measurement/volume-of-cone/

    Tipos de cone
    obliquo:
        - quando o vertice nao esta alinhado com o centro da base
        - O segmento que liga o vertice ao centro da base deixa de ser a altura do cone,
        diferente do cone reto
    reto:
        - quando o vertice e o centro do curculo que forma a base do cone formam
        um angulo reto,
        - ou seja o segmento que liga o vertice ao centro do base
        é a altura

    Elementos do cone:
        - Conhecido como corpo redondo ou solido de revolucao por suas caracterisitcas
            - base circular
            - Por ser construido a partir da rotacao de um triangulo (revolucao de um triangulo)
        - Geratriz
            - semiretas que ligam a vertice (topo) a extremidade da circuferencia da base
    tronco do cone
 */

object ConeObliquo {
    fun volumeComAltura(raioBase: Double, h: Double) =
        1.0 / 3.0 * PI * raioBase * raioBase * h
}

object ConeReto {
    fun comprimentoDoLado(raioBase: Double, h: Double) = sqrt(raioBase*raioBase + h*h)

    fun altura(raioBase: Double, lado: Double) = sqrt(abs(raioBase*raioBase - lado*lado))

    fun raio(lado: Double, h: Double) = sqrt(abs(lado*lado - h*h))

    // pitaguras c^2 = a^2 + b ^ 2 ou c = sqrt(a*a + b*b)
    fun geratriz(h: Double, raioBase: Double) = sqrt(h * h + raioBase * raioBase)

    fun areaBase(raioBase: Double) = PI * raioBase * raioBase

    fun areaLateralComAltura(raioBase: Double, h: Double) = PI * raioBase * geratriz(h, raioBase)

    fun areaLateralComLado(raioBase: Double, lado: Double) = PI * raioBase * lado

    fun areaTotalComAltura(raioBase: Double, h: Double) = areaBase(raioBase) + areaLateralComAltura(raioBase, h)

    // PI * r^2 +  PI * r * s == PI * r * (r + s)
    fun areaTotalComLado(raioBase: Double, lado: Double) =  PI * raioBase * raioBase + areaLateralComLado(raioBase, lado)

    /*
        Volume de um cone reto usando pitagoras
        s = lado ou a geratriz de um cone reto
        s^2 = h^2 + r^2 // pitagoras
        assim
        s = sqrt(h*h + r*r) //

        // se tivermos os valores r e s podemos descobrir a altura do cone
        h = sqrt (abs(r^2 - s^2))
        (1/3) * PI * r^2 * h
     */
    fun volumeComLado(raioBase: Double, lado: Double) =
        (1.0 / 3.0) * PI * raioBase * raioBase * sqrt(abs(raioBase * raioBase - lado * lado))

    fun volumeComAltura(raioBase: Double, h: Double) =
        1.0 / 3.0 * PI * raioBase * raioBase * h

}

object ConeEquilatero {

    // no Cone equilatero a geratriz eh a medida do diametro da base
    fun geratriz(raioBase: Double) = raioBase * raioBase

    // https://matematicabasica.net/cone/
    fun altura(raioBase: Double) = raioBase * sqrt(3.0)

    // PI * R * g
    fun areaLateral(raioBase: Double) = PI * raioBase * geratriz(raioBase)

    fun areaBase(raioBase: Double) = PI * raioBase * raioBase

    fun areaTotal(raioBase: Double) = PI * raioBase * (geratriz(raioBase) + raioBase)

    fun areaTotal2(raioBase: Double) = areaBase(raioBase) + areaLateral(raioBase)

    fun volume(raioBase: Double) = 1.0 / 3.0 * PI * raioBase * raioBase * altura(raioBase)

}

/*
    https://www.varsitytutors.com/hotmath/hotmath_help/topics/surface-area-of-a-pyramid.html/
 */
object Piramide {

}