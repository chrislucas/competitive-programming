package com.br.algorithms.montyhall

import com.br.algorithms.ext.randomRange

data class GameResult(
    val numberGame: Int,
    val prizedDoor: Int,
    val firstChoice: Int,
    val secondChoice: Int,
    val hasChange: Boolean,
    val hasWon: Boolean
)

private fun simulationWithPercentageChange(quantityGames: Int, percentageToChangeChoose: Double): List<GameResult> {
    val qGamesShouldChangeChoice = (quantityGames * percentageToChangeChoose / 100.0).toInt()

    println("************************************************************************************************")
    println("Quantidade de simulacoes: $quantityGames - Quantidade de trocas: $qGamesShouldChangeChoice")

    val results = simulationGames(quantityGames, percentageToChangeChoose)

    val gamesHasChange = results.filter { it.hasChange }
    val qGamesWonWithChange = gamesHasChange
        .filter { it.hasWon }
        .count()
/*
    println(
        "Mudancas Realizadas: ${gamesHasChange.size}." +
                " Mudancas que resultaram em vitoria: $qGamesWonWithChange - ${qGamesWonWithChange * 1.0 / gamesHasChange.size}"
    )

 */

    val qGamesWonWithoutChange = results
        .filter { !it.hasChange && it.hasWon }
        .count()

    val qLostGame = results.filter { !it.hasWon }.count()
    val percentageLost = qLostGame * 1.0 / quantityGames

    val percentageGamesWonWithChange = qGamesWonWithChange * 1.0 / quantityGames
    val percentageGamesWonWithoutChange = qGamesWonWithoutChange * 1.0 / quantityGames

    println(
        "Jogos perdidos no total $qLostGame\n" +
                "Porcentagem de perdas: $percentageLost" +
                "Games vencidos sem troca: $qGamesWonWithoutChange\n" +
                "Games vencidos com troca: $qGamesWonWithChange" +
                "Porcentagem de Games vencidos com troca: $percentageGamesWonWithChange\n" +
                "Porcentagem de Games vencidos sem troca: $percentageGamesWonWithoutChange\n"
    )
    println("************************************************************************************************")

    return results
}

private fun simulationGames(quantityGames: Int, percentageToChangeChoose: Double): List<GameResult> {
    val qGamesShouldChangeChoice = (quantityGames * percentageToChangeChoose / 100.0).toInt()
    val rangeGame = 1..quantityGames
    val gameThatShouldChangeChoice = rangeGame.randomRange(qGamesShouldChangeChoice)
    val results = mutableListOf<GameResult>()

    for (i in rangeGame) {
        val prizedDoor = fromOneToThree
        val playerChoice = fromOneToThree
        val presenterChoice = choosingLastDoor(prizedDoor, playerChoice)
        val change = gameThatShouldChangeChoice.contains(i)
        val newChoice = if (change) {
            choosingLastDoor(playerChoice, presenterChoice)
        } else {
            playerChoice
        }
        results.add(GameResult(i, prizedDoor, playerChoice, newChoice, change, prizedDoor == newChoice))
    }

    return results
}

private fun simulationFromTenToNGames(quantityGames: Int) {
    var g = 10
    while (g < quantityGames) {
        for (i in 50..100) {
            simulationWithPercentageChange(
                g,
                i * 1.0
            )
        }
        g *= 10
    }
}

private fun List<GameResult>.testGamesItChangedAndWon() {
    val qGamesWonWithChange = this.filter { it.hasChange }
        .filter { it.hasWon }
        .count()
}


private fun List<GameResult>.testGamesItChangedAndLost() {
    val qGamesLoseWithChange = this.filter { it.hasChange }
        .filter { !it.hasWon }
        .count()
}

private fun List<GameResult>.testGamesItNotChangedAndWon() {
    val qGamesLoseWithoutChange = this.filter { it.hasChange }
        .filter { !it.hasChange && it.hasWon }
        .count()
}

private fun List<GameResult>.testGamesItNotChangedAndLost() {
    val qGamesLoseWithoutChange = this.filter { it.hasChange }
        .filter { !it.hasChange && !it.hasWon }
        .count()
}


private fun allTestsGames(quantityGames: Int) {
    var g = 10
    while (g < quantityGames) {
        for (i in 50..100) {
            val result = simulationGames(
                g,
                i * 1.0
            )
            result.testGamesItChangedAndLost()
            result.testGamesItChangedAndWon()
            result.testGamesItNotChangedAndLost()
            result.testGamesItNotChangedAndWon()
        }
        g *= 10
    }

}

fun main() {
    simulationFromTenToNGames(1000000)
}