package src.com.br.cp.ds.trees.bst


class Tree<T : Comparable<T>> {

    data class Node<T : Comparable<T>>(var value: T, var left: Node<T>? = null, var right: Node<T>? = null)

    private var root: Node<T>? = null

    private val <T : Comparable<T>> Node<T>.isLeaf: Boolean
        get() = this.left == null && this.right == null

    fun insert(data: T) {
        fun insert(node: Node<T>?, data: T): Node<T> {
            return if (node == null) {
                Node(data)
            } else if (node.value > data) {
                val newNode = insert(node.left, data)
                node.left = newNode
                node
            } else {
                val newNode = insert(node.right, data)
                node.right = newNode
                node
            }
        }

        if (root == null) {
            root = Node(data)
        } else {
            root?.let { node ->
                root = if (node.value > data) {
                    insert(node, data)
                } else {
                    insert(node, data)
                }
            }
        }
    }

    operator fun get(data: T): Node<T>? {
        fun get(node: Node<T>?, data: T): Node<T>? {
            return if (node == null) {
                node
            } else if (node.value < data) {
                get(node.right, data)
            } else if (node.value > data) {
                get(node.left, data)
            } else {
                node
            }
        }
        return get(root, data)
    }

    fun hasItem(data: T): Boolean {
        fun hasItem(node: Node<T>?, data: T): Boolean {
            return if (node == null) {
                false
            } else if (node.value < data) {
                hasItem(node.right, data)
            } else if (node.value > data) {
                hasItem(node.left, data)
            } else {
                true
            }
        }
        return hasItem(root, data)
    }

    fun delete(data: T): Tree<T> {

        fun minValue(node: Node<T>): T {
            var min = node.value
            var copy: Node<T>? = node.left
            while (copy != null) {
                if (copy.value < min)
                    min = copy.value
                copy = copy.left
            }
            return min
        }

        fun delete(node: Node<T>?, data: T): Node<T>? {
            return if (node == null) {
                null
            } else if (node.value < data) {
                node.right = delete(node.right, data)
                node
            } else if (node.value > data) {
                node.left = delete(node.left, data)
                node
            } else {
                val newNode = if (node.isLeaf) {
                    null
                } else if (node.left == null) { // possui um no filho a direita
                    node.right
                } else if (node.right == null) { // possui um no ffilho a esquerda
                    node.left
                } else {
                    node    // possui 2 nós filhos
                }

                if (newNode != null) {
                    newNode.right?.let {
                        it.value = minValue(it)
                        it.right = delete(it.right, it.value)
                    }
                }
                newNode
            }
        }
        delete(root, data)
        return this
    }

    fun remove(data: T): Tree<T> {
        val cTree = this
        fun minValue(node: Node<T>): T {
            var min = node.value
            var copy: Node<T>? = node.left
            while (copy != null) {
                if (copy.value < min)
                    min = copy.value
                copy = copy.left
            }
            return min
        }

        fun removeValue(node: Node<T>?, data: T): Node<T>? {
            return if (node == null) {
                null
            } else if (node.value < data) {
                node.right = removeValue(node.right, data)
                node
            } else if (node.value > data) {
                node.left = removeValue(node.left, data)
                node
            } else {
                val newNode = if (node.isLeaf) {
                    null
                } else if (node.left == null) { // possui um no filho a direita
                    node.right
                } else if (node.right == null) { // possui um no ffilho a esquerda
                    node.left
                } else {
                    node    // possui 2 nós filhos
                }
                if (newNode != null) {
                    newNode.right?.let {
                        newNode.value = minValue(it)
                        newNode.right = removeValue(newNode.right, newNode.value)
                    }
                }
                newNode
            }
        }

        removeValue(cTree.root, data)
        return cTree
    }

    // primeiro as folhas a esquerda, depois as raiz/subraiz por ultimo as folhas a direita
    // a navegacao tras os items em ordem crescente
    fun inOrder(): String {
        val buffer = StringBuilder()
        fun inOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                inOrder(node.left, buffer)
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
                inOrder(node.right, buffer)
            }
        }
        inOrder(root, buffer)
        return buffer.toString()
    }

    // a ideia e ter um resultado invertido da navegacao inorder
    // que essa navegacao traga os elementos na ordem decrescente
    fun reverserInOrder(): String {
        val buffer = StringBuilder()
        fun transversal(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                transversal(node.right, buffer)
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
                transversal(node.left, buffer)
            }
        }
        transversal(root, buffer)
        return buffer.toString()
    }

    // primeiro a raiz/subraiz, depois as fiolhas a esquerda e por ultimo as folhas da direita
    fun preOrder(): String {
        val buffer = StringBuilder()
        fun preOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
                preOrder(node.left, buffer)
                preOrder(node.right, buffer)
            }
        }
        preOrder(root, buffer)
        return buffer.toString()
    }

    // primerio as folhas depois a esquerda/direita e por ultimo a raiz/subraiz
    fun posOrder(): String {
        val buffer = StringBuilder()
        fun posOrder(node: Node<T>?, buffer: StringBuilder) {
            if (node != null) {
                posOrder(node.left, buffer)
                posOrder(node.right, buffer)
                if (buffer.isEmpty()) {
                    buffer.append(node.value)
                } else {
                    buffer.append(" ", node.value)
                }
            }
        }
        posOrder(root, buffer)
        return buffer.toString()
    }

    /*
         https://stackoverflow.com/questions/2597637/finding-height-in-binary-search-tree
     */
    fun height(): Int {
        fun height(node: Node<T>?): Int {
            return if (node == null) {
                0
            } else {
                val l = height(node.left)
                val r = height(node.right)
                Integer.max(l, r) + 1
            }
        }
        return height(root)
    }
}

private fun <T : Comparable<T>> Array<T>.toBinarySearchTree(): Tree<T> =
    this.run {
        val tree = Tree<T>()
        forEach { tree.insert(it) }
        tree
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

private fun String.splitAndJoinTo(
    del: String = "",
    appendable: Appendable = StringBuilder(),
    separator: String = "|"
): String {
    return this.split(del).joinTo(appendable, separator).toString()
}

private fun checkTransversalAllData() {
    data.forEach { data ->
        val tree = data.toBinarySearchTree()
        println(tree.inOrder())
        println(tree.preOrder())
        println(tree.posOrder())
        println()
    }
}

private fun <T : Comparable<T>> checkTransversal(tree: Tree<T>) {
    println(tree.inOrder())
    println(tree.reverserInOrder())
    println(tree.preOrder())
    println(tree.posOrder())
}

private fun checkOperatorGet() {
    data.forEach {
        val tree = it.toBinarySearchTree()
        println(tree[40])
    }
}

private fun checkIfHasItem() {
    data[0].let {
        val tree = it.toBinarySearchTree()
        println(tree.hasItem(40))
    }
}

private fun checkTransversal() {
    checkTransversal(data[0].toBinarySearchTree())
    println("")
    checkTransversal(data[5].toBinarySearchTree())
}

private fun checkDeleteNode() {

    val tree0 = data[0].toBinarySearchTree()
    println("Deleting 40: ${tree0.delete(40).preOrder()}")

    val tree1 = data[0].toBinarySearchTree()
    println("Deleting 20: ${tree1.delete(20).preOrder()}")

    val tree2 = data[0].toBinarySearchTree()
    println("Deleting 30: ${tree2.delete(30).preOrder()}")

    val tree3 = data[0].toBinarySearchTree()
    println("Deleting 50 ${tree3.delete(50).preOrder()}")

    val tree4 = data[1].toBinarySearchTree()
    println("Deleting 20 ${tree4.delete(20).preOrder()}")

    val tree5 = data[2].toBinarySearchTree()
    println("Deleting 40 ${tree5.delete(40).preOrder()}")
}

private fun checkDeleteNodesInSameBST() {
    val tree = data[0].toBinarySearchTree()
    println(tree.delete(20).preOrder())
    println(tree.delete(30).preOrder())
    println(tree.delete(50).preOrder())
}

private fun checkDeleteNodeWithCopy() {
    val tree = data[0].toBinarySearchTree()
    val cpTree = tree.remove(20)
    println(cpTree.preOrder())
    println(tree.preOrder())

    val tree1 = data[0].toBinarySearchTree()
    val cpTree1 = tree.remove(30)
    println(cpTree1.preOrder())
    println(tree1.preOrder())

    val tree2 = data[0].toBinarySearchTree()
    val cpTree2 = tree.remove(50)
    println(cpTree2.preOrder())
    println(tree2.preOrder())
}

fun main() {
    //checkTransversalAllData()
    //checkIfHasItem()
    //checkTransversal()
    checkDeleteNode()
    checkDeleteNodesInSameBST()
    //checkDeleteNodeWithCopy()
}