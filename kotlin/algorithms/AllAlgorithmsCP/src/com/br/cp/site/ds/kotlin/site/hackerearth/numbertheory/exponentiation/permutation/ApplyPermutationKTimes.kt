package src.com.br.cp.site.ds.kotlin.site.hackerearth.numbertheory.exponentiation.permutation

/*

    Applying a permutation K times
    https://cp-algorithms.com/algebra/binary-exp.html#effective-computation-of-fibonacci-numbers

 */


private fun <V> permutationKTimes(sequence: MutableList<V>, permutation: MutableList<Int>, k: Int) {

    fun <V> applyPermutation(sequence: MutableList<V>, permutation: MutableList<Int>): MutableList<V> =
        MutableList(sequence.size) { idx -> sequence[permutation[idx]] }

    var acc = k
    var cpSequence = sequence
    var cpPermutation = permutation
    while (acc > 0) {
        if (acc and 1 == 1) {
            cpSequence = applyPermutation(cpSequence, cpPermutation)
        }
        cpPermutation = applyPermutation(cpPermutation, cpPermutation)
        acc = acc shr 1
    }
}


fun main() {

}