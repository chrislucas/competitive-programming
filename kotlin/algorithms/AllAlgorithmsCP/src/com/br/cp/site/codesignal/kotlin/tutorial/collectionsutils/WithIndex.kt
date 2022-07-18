package src.com.br.cp.site.codesignal.kotlin.tutorial.collectionsutils

/*
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/with-index.html
 */

private fun checkWithIndex() {

    val alpha = 'a'..'z'
    val rs1 = with(alpha) {
        (1..this.count() zip this).withIndex()
    }
    println(rs1)

    val rs2 = with(alpha) {
        this.zip(1..this.count()).withIndex()
    }
    println("\n$rs2")

    val rs3 = with(alpha) {
        this.zip(1..this.count()).withIndex()
    }
    println("\n$rs3")

    val rs4 = with(alpha) {
        this zip(1..this.count()).withIndex()
    }
    println("\n$rs4")

    val rs5 = with(alpha) {
        1..this.count() zip(this).withIndex()
    }
    println("\n$rs5")


}


fun main() {
    checkWithIndex()
}