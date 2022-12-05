package src.com.br.sites.adventofcode.v2022.days

/*
    https://adventofcode.com/2022/day/1
    DONE
 */

private inline fun <T> readValue(transform: (String) -> T) = transform(readLine()!!)


fun main() {
    var max = 0
    var acc = 0
    while (true) {
        val line = readLine()
        if (line == null) {
            break
        } else {
            if (line.isNotEmpty()) {
                val value = line.toInt()
                acc += value
                if (acc > max) {
                    max = acc
                }
            } else {
                println("max: $max")
                acc = 0
            }
        }
    }
}