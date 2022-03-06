package src.com.br.cp.site.string.suffix.trie.b


/*
    https://www.geeksforgeeks.org/trie-insert-and-search/
    TRIE = Is an efficient information  reTRIEval data structure
 */

//val ALPHA = ('A' .. 'Z').joinToString("") + ('a' .. 'z').joinToString("")


class Trie {

    private val ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    private val MAP_ALPHA = ALPHA.associate { c -> c to c - 'A' }

    inner class TrieNode(private val char: Char = ' ', var isEnd: Boolean = false) {
        private val children = Array<TrieNode?>(ALPHA.length) { null }

        operator fun set(p: Int, c: TrieNode) { children[p] = c }

        operator fun get(p: Int) = children[p]

        override fun toString(): String = "$char"
    }

    private val root = TrieNode()

    fun insert(key: String) {
        var leaf: TrieNode? = root
        key.forEach { c ->
            val index = MAP_ALPHA[c]!!
            if (leaf?.get(index) == null) {
                leaf?.set(index, TrieNode(c))
            }
            leaf = leaf?.get(index)
        }
        leaf?.isEnd = true
    }

    fun search(key: String): Boolean {
        var leaf: TrieNode? = root
        key.forEach { c ->
            val index = MAP_ALPHA[c]!!
            if (leaf == null || leaf?.get(index) == null)
                return false
            leaf = leaf?.get(index)
        }
        return leaf?.isEnd ?: false
    }
}

private fun checkTrie() {
    val keys = arrayOf("the", "a", "there", "answer", "any", "by", "bye", "their")
    val trie = Trie()
    keys.forEach { key -> trie.insert(key) }
    arrayOf("the", "these", "their").forEach { word ->
        if (trie.search(word)) {
            println("$word Found")
        } else {
            println("$word Not found")
        }
    }
}


fun main() {
    checkTrie()
}