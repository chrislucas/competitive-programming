package src.com.br.cp.site.codesignal.kotlin.tutorial.collectionsutils

/*
    ZIP
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/
 */



/*
    https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/unzip.html
 */
fun checkZip() {
    val alphabetic = 'a'..'z'
    val length = 1..alphabetic.count()
    println(alphabetic.zip(length))

    println("Infix: ${alphabetic zip length}")
}

/*
   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/unzip.html

 */
fun checkUnzip() {
    println(listOf(1 to 'a', 2 to 'b', 3 to 'c').unzip())
    println(arrayOf(1 to 'a', 2 to 'b', 3 to 'c').unzip())
}


fun main() {
    //checkZip()
    checkUnzip()
}