package src.com.br.cp.site.ds.kotlin.fenwick.countinversion

/*
    https://www.geeksforgeeks.org/count-inversions-of-size-three-in-a-give-array/
    TODO estudar bem o algoritmo
 */
private fun Array<Int>.countTripleInversion(): Int {

    var inv = 0
    for (i in this.indices) {
        var less = 0
        var great = 0

        // quantos a direta sao menores
        for (j in i + 1 until this.size) {
            if (this[i] > this[j]) {
                less += 1
            }
        }

        // quantos a questar sao maiores
        for (j in i-1 downTo 0) {
            if (this[i] < this[j]) {
                great += 1
            }
        }

        inv += less * great
    }
    return inv
}


class BitCoutingTripleInversions(private val values: Array<Int>) {

    val tree = Array(values.size + 1) { 0 }
}


private fun checkApproachI() {
    arrayOf(
        arrayOf(8, 4, 2, 1),
        arrayOf(9, 6, 4, 5, 8)
    ).forEach { case ->
        println(case.countTripleInversion())
    }
}


fun main() {
    checkApproachI()
}