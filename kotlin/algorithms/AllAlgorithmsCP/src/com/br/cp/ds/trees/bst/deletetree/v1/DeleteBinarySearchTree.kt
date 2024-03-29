package src.com.br.cp.ds.trees.bst.deletetree.v1



// uamos a navegacao posorder para deletar uma arvore
// https://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/
//  Modelo para usar em competicoes

class BSTree<T : Comparable<T>>(value: T) {

    data class Node<T : Comparable<T>>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null)

    private var root: Node<T>? = Node(value)

    private val <T : Comparable<T>> Node<T>.isLeaf: Boolean
        get() = this.le == null && this.ri == null

    fun insert(value: T): BSTree<T> {
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

    fun inOrder(): List<String> {
        val buffer = mutableListOf<String>()
        fun inOrder(node: Node<T>?, buffer: MutableList<String>) {
            if (node != null) {
                inOrder(node.le, buffer)
                buffer.add("${node.value}")
                inOrder(node.ri, buffer)
            }
        }
        inOrder(root, buffer)
        return buffer
    }

    fun transversal(type: String = "in"): String {
        val buffer = StringBuilder()
        fun preOrder(root: Node<T>?, buffer: StringBuilder) {
            if (root != null) {
                if (buffer.isEmpty()) {
                    buffer.append("${root.value}")
                } else {
                    buffer.append(", ${root.value}")
                }
                preOrder(root.le, buffer)
                preOrder(root.ri, buffer)
            }
        }

        fun inOrder(root: Node<T>?, buffer: StringBuilder) {
            if (root != null) {
                inOrder(root.le, buffer)
                if (buffer.isEmpty()) {
                    buffer.append("${root.value}")
                } else {
                    buffer.append(", ${root.value}")
                }
                inOrder(root.ri, buffer)
            }
        }

        fun posOrder(root: Node<T>?, buffer: StringBuilder) {
            if (root != null) {
                posOrder(root.le, buffer)
                posOrder(root.ri, buffer)
                if (buffer.isEmpty()) {
                    buffer.append("${root.value}")
                } else {
                    buffer.append(", ${root.value}")
                }
            }
        }

        when (type) {
            "in" -> {
                inOrder(root, buffer)
            }
            "pre" -> {
                preOrder(root, buffer)
            }
            else -> {
                posOrder(root, buffer)
            }
        }

        return buffer.toString()
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
    fun deleteValue(value: T): BSTree<T> {
        fun minNode(node: Node<T>): T {
            var minValue = node.value
            var cNode: Node<T>? = node.le
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
                if (node.le == null) {
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

    /*
         https://stackoverflow.com/questions/2597637/finding-height-in-binary-search-tree
     */
    fun height(): Int {
        fun height(node: Node<T>?): Int {
            return if (node == null) {
                0
            } else {
                val l = height(node.le)
                val r = height(node.ri)
                Integer.max(l, r) + 1
            }
        }
        return height(root)
    }
}

private fun <T : Comparable<T>> Array<T>.toBST(): BSTree<T>? {
    return if (this.isNotEmpty()) {
        val BSTree = BSTree(this[0])
        for (i in 1 until this.size) {
            BSTree.insert(this[i])
        }
        BSTree
    } else {
        null
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

private fun createAndCheckDelete() {
    val BSTree = BSTree(10)
    BSTree.insert(8)
        .insert(9)
        .insert(7)
        .insert(14)
        .insert(12)
        .insert(15)
        .deleteTree()
    println(BSTree)
}

private fun checkConvertArrayToBST() {
    data.forEach {
        val tree = it.toBST()
        println(tree?.inOrder())
    }
}

private fun checkDeleteValue() {
    val tree = data[0].toBST()
    // deletando um no folha
    tree?.deleteValue(40)?.inOrder().let { println(it) }
    // deletando um no que possui 2 nos filos
    tree?.deleteValue(70)?.inOrder().let { println(it) }
}

private fun checkTransversal() {

    data[0].let {
        val tree = it.toBST()
        val a = tree?.transversal("in")
        val b = tree?.transversal("pre")
        val c = tree?.transversal("pos")
        println("In: $a\nPre: $b\nPos: $c")
    }
    println("******************************************************************")

    data.forEach {
        val tree = it.toBST()
        val a = tree?.transversal("in")
        val b = tree?.transversal("pre")
        val c = tree?.transversal("pos")
        println("In: $a\nPre: $b\nPos: $c")
        println("******************************************************************")
    }
}


fun main() {
    //createAndCheckDelete()
    //checkDeleteValue()
    checkTransversal()
}


