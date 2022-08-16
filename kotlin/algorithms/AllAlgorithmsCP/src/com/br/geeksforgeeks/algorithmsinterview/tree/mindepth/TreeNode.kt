package src.com.br.geeksforgeeks.algorithmsinterview.tree.mindepth



/*
    https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
    Modelo para usar em competicoes

    Dado uma arvore binaria encontre a  profundidade minima. A  profundidade minima e numero de nos
    que encontrados no menor  caminho partindo do no RAIZ ate o no mais proximo que seja uma folha

 */

class TreeNode<T : Comparable<T>>(value: T? = null) {

    data class Node<T>(val value: T, var le: Node<T>? = null, var ri: Node<T>? = null) {
        fun isLeaf() = le == null && ri == null
    }

    var root: Node<T>? = null

    init {
        if (value != null) {
            root = Node(value)
        }
    }

    fun insert(value: T): TreeNode<T> {
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


    fun minimumDepth() : Int {
        fun minimumDepth(node: Node<T>?): Int {
            return if (node == null) {
                0
            }
            else if(node.isLeaf()) {
                1
            } else {
                0
            }
        }
        
        return minimumDepth(root)
    }

}

private val cases = arrayOf(
    arrayOf(1)
)


private fun <T : Comparable<T>> Array<T>.toBST(): TreeNode<T>? {
    return if (this.isNotEmpty()) {
        val tree = TreeNode<T>()
        for (i in 0 until this.size) {
            tree.insert(this[i])
        }
        tree
    } else {
        null
    }
}

private fun checkCase1() {
    val tree = TreeNode(1)
    tree.root?.le = TreeNode.Node(2)
    tree.root?.ri = TreeNode.Node(3)
    tree.root?.le?.le = TreeNode.Node(4)
    tree.root?.le?.ri = TreeNode.Node(5)

    tree.minimumDepth()
}


fun main() {
    println(0xff)
}