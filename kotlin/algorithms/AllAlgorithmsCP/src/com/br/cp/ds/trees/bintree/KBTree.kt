package src.com.br.cp.ds.trees.bintree

import java.util.LinkedList
import java.util.Queue

/*
    https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
    https://www.geeksforgeeks.org/binary-tree-set-2-properties/
    Propriedades de uma bin tree
    https://www.geeksforgeeks.org/binary-tree-set-3-types-of-binary-tree/
    Tipos de btree
    1 - full BTree: Uma BTree eh full se todos os nos tem 0 ou 2 filhos
    2 - Complete BTree: Uma Btree é complete se todos os nivels estao completos, com excessao
    do ultimo nivel e o ultimo nivel tem todas os nós a esquerda possiveis
        - T0do nivel deve estar completamente preenchido
        - T0do o no folha deve ter um nó a esquerda
        - No penultimo nivel os nós podem nao ter nós a direita, uma BTree completa nao precisa
        ser uma Full BTree

        Um exemplo pratico de uma Complete BTree é uma BinaryHeap
    3 - Perfetc BTree: Uma Perfect BTree é uma que todos os nós internos tem 2 filhos e todas
    os nos folhas estao no mesmo nivel

    4 - Balanced BTree:
    Uma BTree está balanceada se sua altura for O(log n) onde n é a quantidade de nós.
    A arvore AVL mantem o tamanho da arvore em O(log n) com um mecanismo que mantem a diferenca
    entre a altura das subarvores da esquerda e direita de no máximo 1

        - Arvores Red-Black mantem a altura em O(logn) mantendo o numero de nós Blacks em cada
        caminho do nó raiz ate a folha o mesmo ...
        - Balanced Breet possui uma boa performance por prover operacoes de pesquisa, insercao e deleção
        em O(logn)

    Propriedades
    https://www.geeksforgeeks.org/binary-tree-set-2-properties/

    1 - Numero maximo dde nos em cada i-esimo nivel é 2 ^ i
    2 - Numero maximo de nos para um BTree com altura h é (2 ^ h) - 1
        - e no minimo 2 ^ (h - 1)
    3 - Numa BTree com N nodes, a altura minima possivel é log (n + 1) na base 2
        -
    4 - Uma BTrre com L folhas tem no minimo (log L base 2) + 1 niveis

    6 - Numa BTree nao vazia, se N é o total de nós e E o total de arestas entao E = N - 1
        - Todo no numa BTree tem 1 unico no parente com excecao do nó raiz
        - Se o total de nós é N entao removendo o nó raiz sobram  n-1 nós com parentes
        - Como ha somente uma aresta entre 2 nós (pai - filho) o total de arestas de uma arvore
        nao vazia é de n-1

 */

class KBTree<T : Comparable<T>>(value: T) {

    data class Node<T>(var value: T, var le: Node<T>? = null, var ri: Node<T>? = null)

    private var root: Node<T>? = Node(value)

    private val <T> Node<T>.isLeaf: Boolean
        get() = this.le == null && this.ri == null

    fun isFull(): Boolean {
        fun isFull(node: Node<T>?): Boolean {
            return if (node != null) {
                if (node.isLeaf) {
                    true
                } else if (node.le != null && node.ri != null) {
                    val p = isFull(node.le)
                    val q = isFull(node.ri)
                    p && q
                } else {
                    false
                }
            } else {
                // empty tree |subtree
                true
            }
        }

        /*
            https://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
         */
        fun isFullII(node: Node<T>?): Boolean {
            return if (node == null || node.isLeaf) {
                true
            } else if (node.le != null && node.ri != null) {
                val p = isFullII(node.le)
                val q = isFullII(node.ri)
                p && q
            } else {
                false
            }
        }

        return isFull(root)
    }

    /*
        https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/?ref=lbp
     */
    fun insertInOrder(value: T) {
        fun insert(node: Node<T>, value: T) {
            val queue: Queue<Node<T>> = LinkedList()
            queue.add(node)
            while (queue.isNotEmpty()) {
                val temp = queue.poll()
                if (temp.le == null) {
                    temp.le = Node(value)
                    break
                } else {
                    queue += temp.le
                }

                if (temp.ri == null) {
                    temp.ri = Node(value)
                    break
                } else {
                    queue += temp.ri
                }
            }
        }
        if (root != null) {
            insert(root!!, value)
        } else {
            root = Node(value)
        }
    }

    fun insert(value: T) {
        fun insert(node: Node<T>?, data: T): Node<T> {
            return if (node == null) {
                Node(data)
            } else if (node.value > data) {
                node.le = insert(node.le, data)
                node
            } else {
                node.ri = insert(node.ri, data)
                node
            }
        }
        root = insert(root, value)
    }

    /*
        https://www.javatpoint.com/insertion-in-binary-search-tree
     */
    fun iterativeInsert(value: T) {
        if (root == null) {
            root = Node(value)
        } else {
            var parent: Node<T>? = null
            var temp = root
            while (temp != null) {
                parent = temp
                temp = if (parent.value > value) {
                    temp.le
                } else {
                    temp.ri
                }
            }
            parent?.run {
                if (this.value > value) {
                    this.le = Node(value)
                } else {
                    this.ri = Node(value)
                }
            }
        }
    }

    /*
        https://www.geeksforgeeks.org/level-order-tree-traversal/\
        level order transversal
     */
    fun listLevelOrderTransversal(): MutableList<T> {
        val queue: Queue<Node<T>?> = LinkedList()
        val levelOrder = mutableListOf<T>()
        queue += root
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            temp?.run {
                levelOrder += value
                le?.let { queue += it }
                ri?.let { queue += it }
            }
        }
        return levelOrder
    }

    fun mapLevelOrderTransversal(): Map<Int, List<T>> {
        fun mapLevelOrder(node: Node<T>?, map: MutableMap<Int, MutableList<T>>, level: Int, currentLevel: Int) {
            if (node != null) {
                if (currentLevel == 1) {
                    map[level]?.add(node.value)
                } else if (currentLevel > 1) {
                    mapLevelOrder(node.le, map, level, currentLevel - 1)
                    mapLevelOrder(node.ri, map, level, currentLevel - 1)
                }
            }
        }

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

        val map = mutableMapOf<Int, MutableList<T>>()
        val h = height()
        for (i in 1..h) {
            map[i] = mutableListOf()
            mapLevelOrder(root, map, i, i)
        }
        return map
    }

    fun transversal(order: String = "in"): MutableList<T> {
        fun inOrder(): MutableList<T> {
            fun inOrder(node: Node<T>?, buffer: MutableList<T>) {
                if (node != null) {
                    inOrder(node.le, buffer)
                    buffer += node.value
                    inOrder(node.ri, buffer)
                }
            }
            val buffer = mutableListOf<T>()
            inOrder(root, buffer)
            return buffer
        }

        fun preOrder(): MutableList<T> {
            fun preOder(node: Node<T>?, buffer: MutableList<T>) {
                if (node != null) {
                    buffer += node.value
                    preOder(node.le, buffer)
                    preOder(node.ri, buffer)
                }
            }
            val buffer = mutableListOf<T>()
            preOder(root, buffer)
            return buffer
        }

        fun posOrder(): MutableList<T> {
            fun posOrder(node: Node<T>?, buffer: MutableList<T>) {
                if (node != null) {
                    posOrder(node.le, buffer)
                    posOrder(node.ri, buffer)
                    buffer += node.value
                }
            }
            val buffer = mutableListOf<T>()
            posOrder(root, buffer)
            return buffer
        }

        return when (order) {
            "in" -> {
                inOrder()
            }
            "pre" -> {
                preOrder()
            }
            else -> {
                posOrder()
            }
        }
    }

    /*
        https://www.geeksforgeeks.org/deletion-binary-tree/
     */

    fun delete(value: T) {

    }

    /*
        Enumaration
        https://www.geeksforgeeks.org/enumeration-of-binary-trees/
     */

    /*
        https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
     */

    fun diameter() {

    }
}

fun <T : Comparable<T>> Array<T>.toBTree(): KBTree<T>? {
    return if (isNotEmpty()) {
        val tree = KBTree(this[0]);
        for (i in 1 until this.size) {
            tree.insertInOrder(this[i])
        }
        tree
    } else {
        null
    }
}


val testCases = arrayOf(
    arrayOf(10, 11, 7, 9, 15, 8, 12)
)

private fun checkIsFull() {
    testCases.forEach {
        val tree = it.toBTree()
        println(tree?.isFull())
    }
}


private fun checkInsertInOrder() {
    testCases.forEach {
        val tree = it.toBTree()
        println(tree?.transversal())
        println(tree?.transversal("pre"))
        println(tree?.transversal("pos"))
        println(tree?.listLevelOrderTransversal())
        println(tree?.mapLevelOrderTransversal())
    }
}

private fun checkInsert() {
    testCases.forEach { values ->
        val tree = KBTree(values[0])
        for (i in 1 until values.size) {
            tree.insert(values[i])
        }
        println(tree.transversal())
        println(tree.transversal("pre"))
        println(tree.transversal("pos"))
        println(tree.listLevelOrderTransversal())
        println(tree.mapLevelOrderTransversal())
    }
}

private fun checkIterativeInsert() {
    testCases.forEach { values ->
        val tree = KBTree(values[0])
        for (i in 1 until values.size) {
            tree.iterativeInsert(values[i])
        }
        println(tree.transversal())
        println(tree.transversal("pre"))
        println(tree.transversal("pos"))
        println(tree.listLevelOrderTransversal())
        println(tree.mapLevelOrderTransversal())
    }
}

private fun checkInsertMethods() {
    //checkInsertInOrder()
    println("************************************")
    checkInsert()
    println("************************************")
    checkIterativeInsert()
    println("************************************")

}


fun main() {
    checkInsertMethods()
}