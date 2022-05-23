package src.com.br.cp.recursion.dp

/**
 *
 * Ugly number é o numero cujos fatores primos sao somente 2, 3 e 5
 * {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15}
 *
 * Encontrar o nth ugly number da sequencia usando PD
 *
 * https://www.geeksforgeeks.org/ugly-numbers/
 */


fun simpleIsUglyNumber(n: Long): Boolean {
    fun gcd(a: Long, b: Long): Long {
        var ca = a
        var cb = b
        while (ca % cb > 0) {
            val res = ca % cb
            ca = cb
            cb = res
        }
        return cb
    }

    var no = n
    no = gcd(no, 2)
    no = gcd(no, 3)
    no = gcd(no, 5)

    return no == 1L
}
