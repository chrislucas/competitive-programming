package src.com.br.cp.site.string.suffix.trie


/**
 *
 * Fonte
 * https://github.com/chrislucas/java-tries-suffixant/blob/master/TreeTrie/src/structure/ImplTrie.java
 * https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 */


class TrieHash {

    class Node(val char: Char = ' ', var end: Boolean = false) {
        val prefixTree = hashMapOf<Char, Node>()
        var countPrefix = 0

        operator fun set(idx: Int, node: Node) {}

        override fun toString(): String = "value: $char"

        fun isLeaf(): Boolean = false
    }

    private val root = Node()

    fun insert(word: String) {
        var tree = root.prefixTree
        var counter = 0
        for (c in word) {
            val node: Node = if (tree.containsKey(c)) {
                val node = tree[c]!!
                node
            } else {
                val node = Node(c)
                node
            }
            node.countPrefix += 1
            tree = node.prefixTree
            if (counter == word.length)
                node.end = true
            counter += 1
        }
    }

    fun find(word: String): Node? {
        var tree: HashMap<Char, Node>? = root.prefixTree
        var node: Node? = null
        for (c in word) {
            if (tree?.containsKey(c) == true) {
                node = tree[c]
                tree = node?.prefixTree
            } else {
                return null
            }
        }
        return node
    }

    fun remove(word: String) = remove(root, word, 0)

    fun remove(node: Node?, word: String, idx: Int): Node? {
        if (node == null) {
            return null
        }
        if (idx == word.length) {

        }
        //node[idx] = remove(node, word, idx + 1)

        if (node.isLeaf() && !node.end)
            return null

        return node
    }
}


private fun checkTrieHash() {
    val trie = TrieHash()
}

fun main() {
    checkTrieHash()
}