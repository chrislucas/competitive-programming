package com.br.algorithms.montyhall

import com.br.algorithms.ext.string
import com.br.algorithms.montyhall.utils.choosingADifferentDoor
import com.br.algorithms.montyhall.utils.choosingLastDoor
import com.br.algorithms.montyhall.utils.choosingPrizedDoor

private fun testChoosingNumbers() {
    while (true) {
        if (readLine() != "s")
            break
        val prizedDoor = choosingPrizedDoor
        val doorChosenByPresenter = choosingADifferentDoor(prizedDoor)
        val q = choosingLastDoor(prizedDoor, doorChosenByPresenter)
        println("Last: $q, Presenter: $doorChosenByPresenter, Prized: $prizedDoor")
    }
}

private fun simulation() {
    fun playerNeverChange(): Double {
        var acc = 0
        for (x in 0..999) {
            val prizedDoor = choosingPrizedDoor
            val doorChosenByPlayer = choosingPrizedDoor
            //val doorChosenByPresenter = choosingADifferentDoor(prizedDoor)
            if (prizedDoor == doorChosenByPlayer) {
                acc += 1
            }
            //println("Player: $doorChosenByPlayer, Presenter: $doorChosenByPresenter, Prized: $prizedDoor")
        }
        return acc * 1.0 / 1000
    }

    val size = 100
    var result = Array(size) { 0.0 }
    for (i in 0 until size) {
        result[i] = playerNeverChange()
    }

    var value = result.run { this.filter { it >= .5 }.count() * 1.0 / this.size }
    println(">= 0.5 = $value\n${result.string}")

    fun playerAlwaysChange(): Double {
        var acc = 0.0
        for (x in 0..999) {
            val prizedDoor = choosingPrizedDoor
            val doorChosenByPlayer = choosingPrizedDoor
            val doorChosenByPresenter = choosingADifferentDoor(prizedDoor)
            val newDoorChosenByPlayer = choosingADifferentDoor(doorChosenByPlayer)
            if (prizedDoor == newDoorChosenByPlayer) {
                acc += 1
            }
        }
        return acc * 1.0 / 1000
    }

    result = Array(size) { 0.0 }
    for (i in 0 until size) {
        result[i] = playerAlwaysChange()
    }

    value = result.run { this.filter { it >= .5 }.count() * 1.0 / this.size }
    println(">= 0.5 = $value\n${result.string}")
}


fun main() {
    simulation()
}