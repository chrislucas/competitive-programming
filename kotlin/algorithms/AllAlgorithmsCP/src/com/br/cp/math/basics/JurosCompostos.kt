package src.com.br.cp.math.basics

import kotlin.math.pow

/**
 * https://mundoeducacao.uol.com.br/matematica/juros-compostos.htm
 * https://www.idinheiro.com.br/calculadoras/calculadora-juros-compostos/#
 *
 * m = montante
 * c = capital aplicado
 * i = taxa de juros compontos
 * n = tempo de aplicacao
 * j = juros compostos
 *
 * m = c (1 + i) ^ n
 *
 * m = c + j
 * j = m - c
 *
 */


fun jurosCompostos(capitalInicial: Double, taxaDeJuros: Double, tempo: Int): Double {
    return capitalInicial * (taxaDeJuros + 1).pow(tempo * 1.0)
}
