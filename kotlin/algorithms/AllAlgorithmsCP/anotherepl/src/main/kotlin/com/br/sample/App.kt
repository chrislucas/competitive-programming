package com.br.sample

/**
 * https://www.youtube.com/watch?v=_7nISfpofec&t=181
 */

private inline fun runWhiteTruth(fn: () -> Boolean) {
    while (true) {
        if (!fn()) {
            break
        }
    }
}

private fun <T> process(data: String, fn: (String) -> T? = { null }) {
    fn(data)
}

fun main() {
    runWhiteTruth {
        print("> ")
        readLine()?.let {
            if (it == "/q") {
                println("bye!")
                false
            } else {
                process(it) { 12 }
                true
            }
        } ?: false
    }
}