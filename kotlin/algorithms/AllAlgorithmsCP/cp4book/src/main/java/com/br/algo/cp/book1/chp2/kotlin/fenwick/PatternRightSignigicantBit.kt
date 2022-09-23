package com.br.algo.cp.book1.chp2.kotlin.fenwick

private fun lookTheRsbPattern() {
    fun rsb(value: Int) = value and -value

    fun Int.bin(): String {
        val builder = StringBuilder()
        return if (this == 0) {
            "0"
        } else {
            var cp = this
            while (cp > 0) {
                builder.append(if (cp and 1 == 1) "1" else "0")
                cp = cp shr 1
            }
            builder.reverse().toString()
        }
    }


    val mapStringRsb = mutableMapOf<Pair<Int, String>, Pair<Int, String>>()
    for (i in 0..(1 shl 11)) {
        val rsb = rsb(i)
        mapStringRsb[i to "ith-bin=${i.bin()}"] = rsb to "rsb-bin=${rsb.bin()}"
    }
    println(mapStringRsb.values)

}

fun main() {
   // lookTheRsbPattern()
}