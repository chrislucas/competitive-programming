package com.br.algorithms.montyhall.simdata

fun List<GameResult>.testGamesItChangedAndWon() {
    val games = this.filter { it.hasChange && it.hasWon }
    val qGamesWonWithChange = games.count()

    val percentGamesWonWithChange = qGamesWonWithChange * 1.0 / games.size
    val qGamesLost = this.size - games.size

    println(
        "Quantidade de perdas: $qGamesLost\n" +
                "Porcentagem de ganhos: $percentGamesWonWithChange\n" +
                "Porcentagem de perdas: ${1.0 - percentGamesWonWithChange}\n"
    )
}