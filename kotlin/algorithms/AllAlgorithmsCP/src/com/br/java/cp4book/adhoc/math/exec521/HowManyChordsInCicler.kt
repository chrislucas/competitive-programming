package src.com.br.java.cp4book.adhoc.math.exec521

/*
    https://www.quora.com/How-many-chords-can-be-formed-from-8-points-in-a-circle
 */

private fun nCr(n: Long, p: Long): Long {
    var acc = 1L

    return acc
}


private fun countChords(points: Long): Long = nCr(points, 2)


private fun checkCountChords() {
    val message = (1 .. 100L).joinToString("\n") {
        String.format("%d => %d", it, countChords(it))
    }

    println(message)
}


fun main() {
    checkCountChords()
}