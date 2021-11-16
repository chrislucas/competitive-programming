package src.com.br.cp.book.cphandbook.chp10.cbuiltin.bitint

import java.math.BigInteger

typealias BigInt = BigInteger

val BigInt.popcount: Int
    get() {
        return 0
    }


private fun checkpopcount() {
    val p = BigInt("1023")
    println(p.popcount)
}

fun main() {
    checkpopcount()
}