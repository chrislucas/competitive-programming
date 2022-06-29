package src.com.br.cp.ds.trees.bst.levelordertransversal

import java.util.*


/*
    https://www.geeksforgeeks.org/level-order-tree-traversal/\

    Level order transversal de uma Tree é uma "busca em largura"  numa arvore
 */

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

    private fun height(): Int {
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

    fun recLevelOrder(): MutableList<T> {
        fun currentLevelOrder(node: Node<T>?, order: MutableList<T>, level: Int) {
            if (node != null) {
                if (level == 1) {
                    order.add(node.value)
                } else if (level > 1) {
                    currentLevelOrder(node.le, order, level - 1)
                    currentLevelOrder(node.ri, order, level - 1)
                }
            }
        }
        val h = height()
        val levelOrder = mutableListOf<T>()
        for (i in 1..h) {
            currentLevelOrder(root, levelOrder, i)
        }
        return levelOrder
    }

    fun mapRecLevelOrder(): Map<Int, List<T>> {

        fun mapLevelOrder(node: Node<T>?, map: MutableMap<Int, MutableList<T>>, level: Int, currentLevel: Int) {
            if (node != null) {
                if (currentLevel == 1) {
                    map[level]?.add(node.value)
                } else if(currentLevel > 1) {
                    mapLevelOrder(node.le, map, level, currentLevel - 1)
                    mapLevelOrder(node.ri, map, level, currentLevel - 1)
                }
            }
        }

        val map = mutableMapOf<Int, MutableList<T>>()
        val h = height()
        for(i in 1 .. h) {
            map[i] = mutableListOf()
            mapLevelOrder(root, map, i, i)
        }
        return map
    }

    fun itLevelOrder() : MutableList<T>  {
        val queue = LinkedList<Node<T>?>()
        val levelOrder = mutableListOf<T>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            temp?.run {
                levelOrder.add(value)
                le?.let { queue.add(it) }
                ri?.let { queue.add(it) }
            }
        }
        return levelOrder
    }

    fun itLevelOrderII() : MutableList<T>  {
        val queue = LinkedList<Node<T>?>()
        val levelOrder = mutableListOf<T>()
        var temp = root
        while (temp != null) {
            levelOrder.add(temp.value)
            temp.le?.let { queue.add(it) }
            temp.ri?.let { queue.add(it) }
            temp = queue.poll()
        }
        return levelOrder
    }
    /*
        TODO pensar em como incrementar a variavel level nesse algoritmo iterativeo
     */

    fun mapItLevelIOrder() : Map<Int, List<T>> {
        val queue = LinkedList<Node<T>?>()
        val levelOrder = mutableMapOf<Int, MutableList<T>>()
        var level = 1
        queue.add(root)
        levelOrder[level] = mutableListOf()
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            temp?.run {
                levelOrder[level]?.add(value)
                le?.let { queue.add(it) }
                ri?.let { queue.add(it) }
            }
            /*
                Se o tamanho da fila for 1 ou multiplo de 2 podemos adicionar mais
                um nivel na arvore
             */
            if (queue.size == 1 || queue.size % 2 == 0) {
                level += 1
                levelOrder[level] = mutableListOf()
            }
        }
        return levelOrder
    }
}

private fun <T : Comparable<T>> Array<T>.toBST(): BSTree<T>? {
    return if (this.isNotEmpty()) {
        val tree = BSTree(this[0])
        for (i in 1 until this.size) {
            tree.insert(this[i])
        }
        tree
    } else {
        null
    }
}

val data = arrayOf(
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

private fun checkLevelOrder() {
    data[0].toBST()?.let {
        val a = it.recLevelOrder()
        val b = it.mapRecLevelOrder()
        val c = it.itLevelOrder()
        val d = it.itLevelOrderII()
        val e = it.mapItLevelIOrder()
        println("$a\n$b\n$c\n$d\n$e")
    }

    println("*********************************************************")

    data.forEach {
        val tree = it.toBST()
        val a = tree?.recLevelOrder()
        val b = tree?.mapRecLevelOrder()
        val c = tree?.itLevelOrder()
        val d = tree?.itLevelOrderII()
        val e = tree?.mapItLevelIOrder()
        println("$a\n$b\n$c\n$d\n$e")
        println("*********************************************************")
    }
}


fun main() {
    checkLevelOrder()
}