package src.com.br.cp.bitwise

fun Int.isBitSet(nth: Int) = this and ( 1 shl (nth - 1)) > 0

// usando shift right
fun Int.checkBitSet(nth: Int) = this shr (nth - 1) and 1 > 0

fun main() {

    println(7.isBitSet(3))
    println(7.checkBitSet(3))
    println(6.isBitSet(3))
    println(6.checkBitSet(3))
    println(6.isBitSet(2))
    println(6.checkBitSet(2))
    println(6.isBitSet(1))
    println(6.checkBitSet(1))
}