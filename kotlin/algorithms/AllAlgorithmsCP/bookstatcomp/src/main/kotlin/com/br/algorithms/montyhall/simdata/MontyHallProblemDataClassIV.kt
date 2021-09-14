package com.br.algorithms.montyhall.simdata

import com.br.algorithms.ext.randomRange
import com.br.algorithms.montyhall.utils.choosingLastDoor
import com.br.algorithms.montyhall.utils.fromOneToThree

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

    val qGamesWonWithoutChange = results
        .filter { !it.hasChange && it.hasWon }
        .count()

    val qLostGame = results.filter { !it.hasWon }.count()
    val percentageLost = qLostGame * 1.0 / quantityGames

    val percentageGamesWonWithChange = qGamesWonWithChange * 1.0 / quantityGames
    val percentageGamesWonWithoutChange = qGamesWonWithoutChange * 1.0 / quantityGames

    println(
        "Jogos perdidos no total $qLostGame\n" +
                "Porcentagem de perdas: $percentageLost\n" +
                "Games vencidos sem troca: $qGamesWonWithoutChange\n" +
                "Games vencidos com troca: $qGamesWonWithChange\n" +
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

private fun allTestsGames(quantityGames: Int, fn: (List<GameResult>) -> Unit) {
    var g = 10
    while (g < quantityGames) {
        for (i in 50..100) {
            val result = simulationGames(
                g,
                i * 1.0
            )

            fn(result)
        }
        g *= 10
    }
}

private const val qGames = 1000000

private fun test1() {
    simulationFromTenToNGames(qGames)
}

private fun test2() {
    allTestsGames(qGames) { result ->
        result.testGamesItChangedAndLost()
    }
}

fun main() {

    // test1()

    test2()

/*
    allTestsGames(qGames) { result ->
        result.testGamesItChangedAndWon()
    }

    allTestsGames(qGames) { result ->
        result.testGamesItNotChangedAndLost()
    }

    allTestsGames(qGames) { result ->
        result.testGamesItNotChangedAndWon()
    }
 */
}