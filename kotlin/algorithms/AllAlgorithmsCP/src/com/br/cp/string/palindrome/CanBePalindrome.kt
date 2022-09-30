package src.com.br.cp.string.palindrome

/*
    https://www.geeksforgeeks.org/check-characters-given-string-can-rearranged-form-palindrome/
 */

private fun canBePalindrome(str: String): Boolean {

    fun s1(str: String): Boolean {
        val map = mutableMapOf<Char, Int>()

        str.associateTo(map) {
            map[it]?.let { value -> Pair(it, value + 1) } ?: Pair(it, 1)
        }

        //println(map)
        return map.values.filter { it % 2 == 1 }.size <= 1
    }

    fun s2(str: String): Boolean {
        var bit = 0

        fun unset(value: Int) = value and (value - 1) == 0

        for (c: Char in str) {
            val value = c - 'a'
            val mask = 1 shl value
            bit = bit xor mask
        }

        return unset(bit)
    }

    return s1(str) && s2(str)
}


fun main() {
    println(canBePalindrome("aabb"))
    println(canBePalindrome("geeksogeeks"))
    println(canBePalindrome("geeksforgeeks"))
    println(canBePalindrome("aabbc"))
    println(canBePalindrome("aabbccc"))
    println(canBePalindrome("aabbcccdddd")) // abddcccddba
    println(canBePalindrome("aabbcccddd")) // abddcccddba - false
}