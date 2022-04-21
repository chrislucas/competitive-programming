package src.com.br.kotlin.sequences


/**
 * https://stackoverflow.com/questions/66377331/how-do-you-iterate-a-for-loop-with-multiplication-or-division-kotlin
 */

// increasing rangeTo
infix fun IntRange.step(next: (Int) -> Int) =
    generateSequence(first, next).takeWhile { if (first < last) it <= last else it >= last }


// decreasing downTo
infix fun IntProgression.step(next: (Int) -> Int) = (first..last).step(next)


private fun checkStepForward() {
    /*
    for (i in 1 until 1000 step {it * 10}) {
        println(i)
    }
     */

    (1..1000 step { it * 10 })
        .joinToString(" ")
        .let {
            println(it)
        }
}

private fun checkStepDown() {
    /*
    for (i in 1000 downTo 1 step { it / 10 }) {
        println(i)
    }
     */

    (1000 downTo 1 step { it / 10 })
        .joinToString(" ")
        .let {
            println(it)
        }
}


fun main() {
    checkStepForward()
    checkStepDown()
}