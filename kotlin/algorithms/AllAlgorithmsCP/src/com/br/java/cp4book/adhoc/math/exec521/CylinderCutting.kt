package src.com.br.java.cp4book.adhoc.math.exec521

/*
    https://mathworld.wolfram.com/CylinderCutting.html
 */


private fun cylinderCuttingFormula(n: Long) = (n*n*n + 5*n + 6) / 6


private fun check() {
    val message = (1 .. 100L).joinToString("\n") {
        String.format("%d => %d", it, cylinderCuttingFormula(it))
    }

    println(message)
}


fun main() {
    check()
}