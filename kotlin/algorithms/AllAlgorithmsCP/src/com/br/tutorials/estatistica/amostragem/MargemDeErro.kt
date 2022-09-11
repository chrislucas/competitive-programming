package src.com.br.tutorials.estatistica.amostragem

import java.math.BigDecimal

/**
 * https://pt.wikipedia.org/wiki/Margem_de_erro
 *
 * z-score
 * https://datascience.eu/pt/matematica-e-estatistica/o-que-e-um-z-score/
 * https://datascience.eu/pt/matematica-e-estatistica/tabela-z/
 *
 */


private typealias BigDec = BigDecimal

private fun Array<BigDec>.mean() = this.sumOf { it } / BigDec("$size")

private fun Array<BigDec>.stddev() {

}


fun main() {
    println(arrayOf(BigDec("1.0"), BigDec("2.0"), BigDec("3.0")).mean())
}