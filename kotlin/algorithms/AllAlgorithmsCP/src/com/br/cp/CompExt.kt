package src.com.br.cp

import src.com.br.kotlin.sequences.step

// https://stackoverflow.com/questions/66377331/how-do-you-iterate-a-for-loop-with-multiplication-or-division-kotlin
// increasing rangeTo
infix fun IntRange.step(next: (Int) -> Int) =
    generateSequence(first, next).takeWhile { if (first < last) it <= last else it >= last }

private val increase = (1..1000 step { it * 10 })
    .joinToString(" ")
    .let {
        println(it)
    }

// decreasing downTo
infix fun IntProgression.step(next: (Int) -> Int) = (first..last).step(next)

private val decrease =
    (1000 downTo 1 step { it / 10 })
        .joinToString(" ")
        .let {
            println(it)
        }