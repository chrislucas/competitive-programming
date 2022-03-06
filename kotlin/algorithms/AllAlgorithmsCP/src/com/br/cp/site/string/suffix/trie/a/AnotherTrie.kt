package src.com.br.cp.site.string.suffix.trie.a


/**
 * https://github.com/chrislucas/java-tries-suffixant/blob/master/TreeTrie/src/structure/ImplTrieAlphabetic.java
 */
class Trie {

    private val ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    private val MAP_ALPHA = ALPHA.associate { c -> c to c - 'A' }

    inner class Node(val char: Char = ' ', var isTheEnd: Boolean = false) {
        private val children = Array(ALPHA.length) { Node() }
        operator fun set(p: Int, c: Node) {
            children[p] = c
        }

        operator fun get(p: Int) = children[p]
    }

    private val root = Node()

    fun insert(word: String) {
        var leaf = root
        for (idx in word.indices) {
            val c = word[idx]
            val index = MAP_ALPHA[c]!!
            if (leaf[index].char == ' ') {
                leaf[index] = Node(c)
            }
            leaf = leaf[index]
        }
        leaf.isTheEnd = true
    }

    fun find(word: String): Boolean {
        var leaf = root
        for (idx in word.indices) {
            val c = word[idx]
            val index = MAP_ALPHA[c]!!
            if (leaf[index].char == ' ')
                return false
            leaf = leaf[index]
        }
        return true
    }
}


private fun checkTrie() {
    val keys = arrayOf(
        arrayOf("the", "a", "there", "answer", "any", "by", "bye", "their"),
        arrayOf("Manoela", "Bruna", "Amanda", "Amara", "manoele")
    )

    val search = arrayOf(
        arrayOf("the", "these", "their"),
        arrayOf(
            "Amanda", "Bruna", "Natalia", "marina", "amara", "manoela", "manoel", "Amara"
        )
    )
    val trie = Trie()
    val idx = 0
    keys[idx].forEach { key ->
        trie.insert(key)
    }
    search[idx].forEach { word ->
        if (trie.find(word)) {
            println("$word Found")
        } else {
            println("$word Not found")
        }
    }
}


fun main() {
    checkTrie()
}