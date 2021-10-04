package src.com.br

/**
 * fonte
 * https://twitter.com/kotlin/status/1438836637929295881
 * */

class Action {
    companion object
}

fun <T> Action.Companion.execute(fn: () -> T): T = fn()


fun main() {
    Action.execute {
        println(0xff)
    }
}