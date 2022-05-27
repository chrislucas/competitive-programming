package src.com.br.cp.recursion.dp.knapsack


data class Item(val v: Int, val w: Int)


fun bottomUp(items: Array<Item>, capacity: Int): Int {
    val state = Array(capacity + 1) { Array(items.size) { 0 } }

    return state[capacity][items.size - 1]
}

val cases = arrayOf(
    arrayOf(Item(60, 10), Item(100, 20), Item(120, 30)) to 50,
    arrayOf(Item(1, 10), Item(2, 15), Item(3, 40)) to 60
)

fun checkBottomop() {
    cases.forEach { (items, capacitity) ->
        println(bottomUp(items, capacitity))
    }
}


fun main() {

}