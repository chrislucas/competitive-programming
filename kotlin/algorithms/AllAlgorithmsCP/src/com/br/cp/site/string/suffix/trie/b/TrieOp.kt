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

        operator fun set(p: Int, c: TrieNode?) {
            children[p] = c
        }

        operator fun get(p: Int) = children[p]

        override fun toString(): String = "$char"


        fun isEmpty(): Boolean = children.all { it == null }
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

    fun remove(word: String) {
        remove(root, word, 0)
    }

    private fun remove(node: TrieNode?, word: String, depth: Int): TrieNode? {
        if (node == null) {
            return null
        }
        // se o ultimo caracter da "palavra" estiver sendo processado
        if (depth == word.length) {
            // se esse no e o ultimo da arvore ele deixara de se-lo por sera removido
            if (node.isEnd) {
                node.isEnd = false
            }
            // Ao remover esse no esse ramo da arvore passa a ser vazio ? se sim retorne null
            // senao retorne o proprio no
            return if (node.isEmpty()) null else node
        }

        val idx = MAP_ALPHA[word[depth]]!!
        // se nao eh o ultimo caracter, percorra a string de forma recursiva
        node[idx] = remove(node[idx], word, depth + 1)

        if (node.isEmpty() && !node.isEnd)
            return null

        return node
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

private fun checkTrieDelete() {
    val keys = arrayOf("the", "a", "there", "an", "answer", "any", "by", "bye", "their", "hero", "heroplane")
    val trie = Trie()
    keys.forEach { key -> trie.insert(key) }

    println(trie.remove("about"))
    println("************************************************************")
    println(trie.remove("heroplane"))
    println(trie.search("hero"))
    println("************************************************************")
    println(trie.remove("answer"))
    println(trie.search("an"))
    println(trie.search("any"))
    println(trie.search("a"))
    println("************************************************************")
    trie.remove("ani") // error

}


fun main() {
    checkTrieDelete()
}