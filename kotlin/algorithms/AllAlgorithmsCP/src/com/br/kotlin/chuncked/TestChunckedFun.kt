package src.com.br.kotlin.chuncked

//  https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/chunked.html


private fun checkHowToChunkIntProgression() {
    val data = (1 .. 20).chunked(6)
    println(data)
}

private fun checkChunkString() {
    println(('a' .. 'z').joinToString("").chunked(12))
}

private fun checkChunkDNAString() {
    val codonTable = mapOf("ATT" to "Isoleucine", "CAA" to "Glutamine", "CGC" to "Arginine", "GGC" to "Glycine")
    val dnaFragment = "ATTCGCGGCCGCCAA"

    val proteins = dnaFragment.chunked(3) {
        codonTable[it.toString()] ?: "$it: Not Found"
    }

    println(proteins)
}

fun main() {
    checkChunkDNAString()
}