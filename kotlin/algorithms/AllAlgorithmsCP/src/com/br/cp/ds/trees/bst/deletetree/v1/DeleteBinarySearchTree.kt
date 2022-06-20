package src.com.br.cp.ds.trees.bst.deletetree.v1

// uamos a navegacao posorder para deletar uma arvore
// https://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/

class Tree<T : Comparable<T>>(value: T) {

    data class Node<T : Comparable<T>>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null)

    private var root: Node<T>? = Node(value)

    private val <T : Comparable<T>> Node<T>.isLeaf: Boolean
        get() = this.le == null && this.ri == null

    fun insert(value: T): Tree<T> {
        fun insert(node: Node<T>?, value: T): Node<T> {
            return if (node != null) {
                if (node.value > value) {
                    node.le = insert(node.le, value)
                } else {
                    node.ri = insert(node.ri, value)
                }
                node
            } else {
                Node(value)
            }
        }
        root = insert(root, value)
        return this
    }

    fun inOrder(): List<Node<T>> {
        val buffer = mutableListOf<Node<T>>()
        fun inOrder(node: Node<T>?, buffer: MutableList<Node<T>>) {
            if (node != null) {
                inOrder(node.le, buffer)
                buffer.add(node)
                inOrder(node.ri, buffer)
            }
        }
        inOrder(root, buffer)
        return buffer
    }

    fun deleteTree() {
        fun postOrderDelete(node: Node<T>?): Node<T>? {
            if (node != null) {
                if (node.isLeaf) {
                    return null
                }
                node.le = postOrderDelete(node.le)
                node.ri = postOrderDelete(node.ri)
                return null
            } else {
                return null
            }
        }
        root = postOrderDelete(root)
    }

    /*
        https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
     */
    fun deleteValue(value: T): Tree<T> {
        fun minNode(node: Node<T>): T {
            var cNode: Node<T>? = node
            var minValue = node.value
            while (cNode?.le != null) {
                if (cNode.value < minValue) {
                    minValue = cNode.value
                }
                cNode = cNode.le
            }
            return minValue
        }
        /*
            https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
            1 - se o No a ser deletado nao tem filhos, delete-o
            2 - se o no tem um filho. copie-o para substituir o no pai pelo filho
            3 - se o no tem 2 filhos busque o sucessor inorder do no
                - Note que fazer isso so eh necessario quando o no filho a direta existe
                - O inorder-successor estara do lado direito entao basta buscar o menor no/valor desse no filho a direita
                - o menor no vai estar sempre a esquerda, lado onde os nos menores que a raiz ficam
         */
        fun deleteValue(node: Node<T>?, value: T): Node<T>? {
            return if (node == null) {
                null
            } else if (value < node.value) {
                node.le = deleteValue(node.le, value)
                node
            } else if (value > node.value) {
                node.ri = deleteValue(node.ri, value)
                node
            } else {
               return if (node.le == null) {
                    node.ri
                } else if (node.ri == null) {
                    node.le
                } else {
                    // possui 2 nos filhos, entao buscamos o inorder-successor no lado direito
                    node.ri?.let {
                        // recuperamos o valor do inorder-successor e definimos como o novo valor do no pai
                        node.value = minNode(it)
                        // deletamos o no indorder
                        node.ri = deleteValue(it, value)
                    }
                    node
                }
            }
        }
        deleteValue(root, value)
        return this
    }
}

private val data = arrayOf(
    arrayOf(50, 30, 70, 20, 40, 60, 80),
    arrayOf(50, 30, 70, 20, 40, 60, 80, 10, 25),            // teste remover o 20
    arrayOf(50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 41),    // teste remover o 40
    arrayOf(100, 20, 500, 10, 30, 40),
    arrayOf(50, 30, 20, 40, 70, 60, 80),
    arrayOf(8, 3, 10, 1, 6, 4, 7, 14, 13),
    arrayOf(30, 50, 15, 20, 10, 40, 60),
    arrayOf(1, 2, 3, 4, 5),
    arrayOf(25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90),
)

private fun <T : Comparable<T>> Array<T>.toBST(): Tree<T>? {
    return if (this.isNotEmpty()) {
        val tree = Tree(this[0])
        for (i in 1 until this.size) {
            tree.insert(this[i])
        }
        tree
    } else {
        null
    }
}

private fun createAndCheckDelete() {
    val tree = Tree(10)
    tree.insert(8)
        .insert(9)
        .insert(7)
        .insert(14)
        .insert(12)
        .insert(15)
        .deleteTree()
}

private fun checkConvertArrayToBST() {
    data.forEach {
        val tree = it.toBST()
        println(tree?.inOrder())
    }
}

private fun checkDeleteValue() {
    val tree = data[0].toBST()
    tree?.deleteValue(40)?.inOrder().let { println(it) }
}


fun main() {
    //createAndCheckDelete()
    checkDeleteValue()
}


