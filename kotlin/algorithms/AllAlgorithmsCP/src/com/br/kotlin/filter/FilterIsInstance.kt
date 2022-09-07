package src.com.br.kotlin.filter

/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter-is-instance.html
 */

abstract class Vehicle(open val description: String)

data class Car(override val description: String) : Vehicle(description)

data class Motocycle(override val description: String) : Vehicle(description)

private val vehicles = listOf(
    Car("Carro A"), Car("Carro B"), Motocycle("Moto A")
)

private fun checkFilterIsInstance() {
    println(vehicles.filterIsInstance<Motocycle>())
}


fun main() {
    checkFilterIsInstance()
}