package src.com.br.java.cp4book.adhoc.math.exec521

/*
    https://mathworld.wolfram.com/CircleDivisionbyChords.html

    ----------------------------------------------------------------------
    https://en.wikipedia.org/wiki/Dividing_a_circle_into_areas

    Problema
    dividir um circulo em areas por meio de poligonos inscritos
    de n-lados de forma a maximizar o numero de REGIOES/AREAS criadas pelas
    arestas e diagonais desse poligono.

    Entenda como REGIOES uma forma geometrica formada por 3 pontos conforme
    desenha-se o poligono inscrito no ciruclo (veja a imagem das areas
    dentro do ciruclo no link da wiki) ou ate mesmo uma regiao do circulo
    formado por uma reta traçada a partir de 2 pontos no circulo, formando uma corda/

    Esse problema tambem eh conhecido como Moser's circle problem
    ----------------------------------------------------------------------

    O numero possivel de regioes eh dado pela forma

    r = C(n, 4) + C(n, 2) + 1
    dando a sequencia para n > 1
    1, 2, 4, 8, 16, 31, 57, 99, 163, 256,

 */

private fun binomial(n: Long, p: Long): Long {
    var acc = 1L
    // C(n, p) = C(n, n - p) lembrando do triangulo de pascal
    val cP = if (p > n - p) {
        n - p
    } else {
        p
    }
    for (i in 0 until cP) {
        acc *= (n - i)
        acc /= (i + 1)
    }

    return acc
}

private fun seq(points: Long): String {
    return buildString {
        for (qPoints in 1 .. points){
            val r = binomial(qPoints, 4) + binomial(qPoints, 2) + 1
            if (qPoints > 1) {
                this.append("\n$qPoints:$r")
            } else {
                this.append("$qPoints:$r")
            }
        }
    }
}

// https://mathworld.wolfram.com/CircleDivisionbyChords.html

private fun formulaCircleByChord(p: Long): Long  {
    val p2 = p*p
    val p3 = p2*p
    val p4 = p3*p
    return (p4 - (6 * p3) + (23 * p2) - (18 * p - 24)) / 24L
}

private fun checkFormula() {
    val result = (1..100L).joinToString("\n") { "$it: ${formulaCircleByChord(it)}" }

    println(result)
}


fun main() {
    //println(seq(100))
    checkFormula()
}