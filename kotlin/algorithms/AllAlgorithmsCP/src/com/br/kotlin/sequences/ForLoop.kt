package src.com.br.kotlin.sequences


/**
 * https://stackoverflow.com/questions/66377331/how-do-you-iterate-a-for-loop-with-multiplication-or-division-kotlin
 */

// increasing rangeTo
infix fun IntRange.step(next: (Int) -> Int) =
    generateSequence(first, next).takeWhile { if (first < last) it <= last else it >= last }


// decreasing downTo
infix fun IntProgression.step(next: (Int) -> Int) = (first..last).step(next)


fun main() {

}