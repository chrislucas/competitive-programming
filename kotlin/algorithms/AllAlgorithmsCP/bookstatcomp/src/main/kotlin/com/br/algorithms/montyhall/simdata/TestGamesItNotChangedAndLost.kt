package com.br.algorithms.montyhall.simdata

fun List<GameResult>.testGamesItNotChangedAndLost() {
    val games = this.filter { !it.hasChange && !it.hasWon }
    val qGamesLoseWithoutChange = games.count()
}