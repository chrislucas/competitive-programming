package src.com.br.cp.site.string.suffix.tree

/**
 * https://cp-algorithms.com/string/suffix-tree-ukkonen.html
 *
 */


class Node(val le: Int = 0, val ri: Int = 0, val par: Int = -1, val link: Int = 0) {

    val next = mutableMapOf<Char, Int>()

    val len: Int
        get() =  ri - le

    fun set(char: Char): Int {
        if (!next.contains(char)) {
            next[char] = -1
        }
        return next[char]!!
    }
}

class State(val v: Int = 0, val pos: Int = 0)


val state = State()


private fun go(state: State, le: Int, ri: Int) {
    while (le < ri) {

    }
}



fun main() {

}