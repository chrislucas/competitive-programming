package src.com.br.cp.ds.sites.geeksforgeeks

/*
    https://kotlinlang.org/docs/iterators.html
 */


fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }
}