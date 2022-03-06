package src.com.br.cp.site.string.suffix.trie


/**
 *
 * Fonte
 * https://github.com/chrislucas/java-tries-suffixant/blob/master/TreeTrie/src/structure/ImplTrie.java
 * https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 */


class TrieHash {

    class Node(val char: Char = ' ', var isLeaf: Boolean = false) {
        val prefixTree = hashMapOf<Char, Node>()
        var countPrefix = 0
    }

    private val root = Node()

    fun insert(word: String) {
        var tree = root.prefixTree
        var counter = 0
        for(c in word) {
            val node: Node = if(tree.containsKey(c)) {
                val node = tree[c]!!
                node
            } else {
                val node = Node(c)
                node
            }
            node.countPrefix += 1
            tree = node.prefixTree
            if(counter == word.length)
                node.isLeaf = true
            counter += 1
        }
    }

    fun find(word: String) {

    }
 }


private fun checkTrieHash() {
    val trie = TrieHash()
}



fun main() {

}