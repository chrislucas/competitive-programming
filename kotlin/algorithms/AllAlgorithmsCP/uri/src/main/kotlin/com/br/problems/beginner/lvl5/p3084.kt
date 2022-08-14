package com.br.problems.beginner.lvl5

/*
    https://www.beecrowd.com.br/judge/en/problems/view/3084
    DONE
 */


// para casos de teste ate EOF


private fun runUntilEndOfFile(fn: (String) -> Unit) {

    fun runWhiteTruth(fn: () -> Boolean) {
        while (true) {
            if (!fn()) {
                break
            }
        }
    }

    runWhiteTruth {
        readLine()?.let {
            fn(it)
            true

        } ?: false
    }
}

fun main(args: Array<String>) {
    runUntilEndOfFile {
        val (angleHours, angleMinutes) = it.split(" ").map(String::toInt)
        val p = angleHours / 30
        val q = (angleMinutes / 30.0 * 5).toInt()
        println(String.format("%02d:%02d",p , q))
    }
}