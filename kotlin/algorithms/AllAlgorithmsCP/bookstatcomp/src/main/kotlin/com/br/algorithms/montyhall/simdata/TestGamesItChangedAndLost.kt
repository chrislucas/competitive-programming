package com.br.algorithms.montyhall.simdata

fun List<GameResult>.testGamesItChangedAndLost() {

    val gamesItChange = this.filter { it.hasChange }

    val gamesItChangedAndLost = gamesItChange.filter { !it.hasWon }
    val qGamesLoseWithChange = gamesItChangedAndLost.count()
    val overallPercentageGamesLoseWithChange = qGamesLoseWithChange * 1.0 / gamesItChange.size


    val percentageOfExchange = gamesItChange.size * 100.0 / this.size

    val gamesItChangeAndWin = gamesItChange.filter { it.hasWon }
    val qGamesWonWithChange = gamesItChangeAndWin.count()
    val overallPercentageGamesWinWithExchange = qGamesWonWithChange * 1.0 / gamesItChange.size


    println("Jogador escolher trocar e perdeu." +
            "Quantidade de jogos: ${this.size}" +
            "Percentual de troca: $percentageOfExchange" +
            "Quantidade de jogos que houve troca: ${gamesItChange.size}" +
            "Quantidade de jogos perdidos: $qGamesLoseWithChange\n" +
            "Percentual de jogos perdidos em relacao ao total de simulacoes: $overallPercentageGamesLoseWithChange\n" +

            "Quantidade de jogos ganhos: $qGamesWonWithChange\n" +
            "Percentual de jogos ganhos: $overallPercentageGamesWinWithExchange\n")

    // this.testOverallResults()
}
