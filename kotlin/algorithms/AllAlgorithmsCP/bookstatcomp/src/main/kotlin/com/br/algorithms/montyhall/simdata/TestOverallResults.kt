package com.br.algorithms.montyhall.simdata

fun List<GameResult>.testOverallResults() {
    val qWins = this.filter {  it.hasWon }.count()
    val percentageOfWins = qWins * 100.0 / this.size
    val qLoses = this.size - qWins
    val percentageOfLoses = 1.0 - percentageOfWins

    println("Quantidade de vitorias: $qWins" +
            "Percentual de vitoriais: $percentageOfWins" +
            "Quantidade de perdas: $qLoses" +
            "Percentual de perdas: $percentageOfLoses")
}