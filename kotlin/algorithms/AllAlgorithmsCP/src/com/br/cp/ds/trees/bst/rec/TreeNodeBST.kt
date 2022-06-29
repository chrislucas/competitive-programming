package src.com.br.cp.ds.trees.bst.rec

import java.lang.Integer.max
import java.util.*


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

private class TreeNode<T : Comparable<T>>(var value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null)

private fun <T : Comparable<T>> TreeNode<T>.insert(value: T): TreeNode<T> {
    fun insert(root: TreeNode<T>?, value: T): TreeNode<T> {
        return if (root != null) {
            if (root.value < value) {
                root.right = insert(root.right, value)
            } else {
                root.left = insert(root.left, value)
            }
            root
        } else {
            TreeNode(value)
        }
    }
    return insert(this, value)
}

private val <T : Comparable<T>> TreeNode<T>.isLeaf: Boolean
    get() = left == null && right == null


private fun <T : Comparable<T>> TreeNode<T>.transversal(type: String = "in"): String {
    val buffer = StringBuilder()
    fun preOrder(root: TreeNode<T>?, buffer: StringBuilder) {
        if (root != null) {
            if (buffer.isEmpty()) {
                buffer.append("${root.value}")
            } else {
                buffer.append(", ${root.value}")
            }
            preOrder(root.left, buffer)
            preOrder(root.right, buffer)
        }
    }

    fun inOrder(root: TreeNode<T>?, buffer: StringBuilder) {
        if (root != null) {
            inOrder(root.left, buffer)
            if (buffer.isEmpty()) {
                buffer.append("${root.value}")
            } else {
                buffer.append(", ${root.value}")
            }
            inOrder(root.right, buffer)
        }
    }

    fun posOrder(root: TreeNode<T>?, buffer: StringBuilder) {
        if (root != null) {
            posOrder(root.left, buffer)
            posOrder(root.right, buffer)
            if (buffer.isEmpty()) {
                buffer.append("${root.value}")
            } else {
                buffer.append(", ${root.value}")
            }
        }
    }

    when (type) {
        "in" -> {
            inOrder(this, buffer)
        }
        "pre" -> {
            preOrder(this, buffer)
        }
        else -> {
            posOrder(this, buffer)
        }
    }

    return buffer.toString()
}


private fun <T : Comparable<T>> TreeNode<T>.has(value: T): Boolean {
    fun has(root: TreeNode<T>?, value: T): Boolean {
        return if (root != null) {
            if (root.value == value) {
                true
            } else if (root.value > value) {
                has(root.left, value)

            } else {
                has(root.right, value)
            }
        } else {
            false
        }
    }
    return has(this, value)
}


private fun <T : Comparable<T>> TreeNode<T>.deleteValue(value: T): TreeNode<T> {
    fun inOrderSuccessor(root: TreeNode<T>): T {
        var minValue = root.value
        var cpy: TreeNode<T>? = root.left
        while (cpy != null) {
            if (minValue > cpy.value) {
                minValue = cpy.value
            }
            cpy = cpy.left
        }
        return minValue
    }

    fun deleteValue(node: TreeNode<T>?, value: T): TreeNode<T>? {
        return if (node == null) {
            null
        } else if (value < node.value) {
            node.left = deleteValue(node.left, value)
            node
        } else if (value > node.value) {
            node.right = deleteValue(node.right, value)
            node
        } else {
            if (node.left == null) {
                node.right
            } else if (node.right == null) {
                node.left
            } else {
                node.right?.let {
                    node.value = inOrderSuccessor(it)
                    node.right = deleteValue(it, value)
                }
                node
            }
        }
    }

    deleteValue(this, value)
    return this
}

// https://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/

private fun <T : Comparable<T>> TreeNode<T>.deleteAll() {
    fun postOrderDelete(node: TreeNode<T>?): TreeNode<T>? {
        return if (node != null) {
            if (node.isLeaf) {
                return null
            }
            node.left = postOrderDelete(node.left)
            node.right = postOrderDelete(node.right)
            return null
        } else {
            null
        }
    }
    postOrderDelete(this)
}

private fun <T : Comparable<T>> Array<T>.toBinarySearchTree(): TreeNode<T>? {
    return if (this.isNotEmpty()) {
        val tree = TreeNode(this[0])
        for (i in 1 until this.size) {
            tree.insert(this[i])
        }
        tree
    } else {
        null
    }
}


/*
    // https://www.geeksforgeeks.org/find-deepest-node-binary-tree/
    TODO implementar esse algoritmo melhor
 */
private fun <T : Comparable<T>> TreeNode<T>.deepest(): TreeNode<T>? {

    /*
        Usamos uma travessia in-order e passamos o nivel da arvore em que estamos
        TODO implementacao incompleta
     */
    fun find1(node: TreeNode<T>?, level: Int, maxLevel: Int): TreeNode<T>? {
        return if (node != null) {
            find1(node.left, level + 1, maxLevel)
            if (level > maxLevel) {
                return node
            }
            find1(node.right, level, max(level, maxLevel))
        } else {
            null
        }
    }

    fun height(node: TreeNode<T>?): Int {
        return if (node == null) {
            0
        } else {
            val l = height(node.left)
            val r = height(node.right)
            max(l, r) + 1
        }
    }

    /*
        Achar a altura da arvore e entao achar o node no nivel mais abaixo em relacao a altura
     */
    fun find2(node: TreeNode<T>?, level: Int): TreeNode<T>? {
        return if (node == null) {
            null
        } else {
            if (level == 1) {
                node
            } else if (level > 1) {
                find2(node.left, level - 1)
                find2(node.right, level - 1)
            } else {
                null
            }
        }
    }

    fun find3(node: TreeNode<T>?): TreeNode<T>? {
       return if (node != null) {
            val queue : Queue<TreeNode<T>> = LinkedList()
            var tmp: TreeNode<T>? = null
            queue.add(node)
            while (queue.isNotEmpty()) {
                tmp = queue.poll()
                if (tmp.left != null)
                    queue.add(tmp.left)
                if (tmp.right != null)
                    queue.add(tmp.right)
            }
            tmp
        } else {
            null
        }
    }

    val a = find1(this, 0, 0)
    val b = find2(this, height(this))
    val c = find3(this)

    println(a)
    println(b)
    println(c)

    return null
}

/*
    https://stackoverflow.com/questions/2597637/finding-height-in-binary-search-tree
 */
private fun <T : Comparable<T>> TreeNode<T>.height(): Int {

    fun height(node: TreeNode<T>?): Int {
        return if (node == null) {
           0
        } else {
            val l = height(node.left)
            val r = height(node.right)
            max(l, r) + 1
        }
    }

    return height(this)
}

private fun checkInsert() {
    val root = TreeNode(50)
    root.insert(30)
        .insert(40)
        .insert(20)
        .insert(70)

    println(root.transversal("pre"))
    println(root.has(40))
    println(root.has(40))
    println(root.has(10))

    val tree = arrayOf(50, 30, 70, 20, 40, 60, 80).toBinarySearchTree()
    println(tree?.transversal("pre"))
    println(tree?.has(30))
    println(tree?.has(10))
}

private fun checkDeleteValue() {
    val tree = data[0].toBinarySearchTree()
    // deletando um no folha
    tree?.deleteValue(40)?.transversal("in").let { println(it) }
    // deletando um no que possui 2 nos filos
    tree?.deleteValue(70)?.transversal("in").let { println(it) }
}

private fun checkTransversal() {
    data[0].let {
        val tree = it.toBinarySearchTree()
        val a = tree?.transversal("in")
        val b = tree?.transversal("pre")
        val c = tree?.transversal("pos")
        println("In: $a\nPre: $b\nPos: $c")
    }
    println("******************************************************************")

    data.forEach {
        val tree = it.toBinarySearchTree()
        val a = tree?.transversal("in")
        val b = tree?.transversal("pre")
        val c = tree?.transversal("pos")
        println("In: $a\nPre: $b\nPos: $c")
        println("******************************************************************")
    }
}

private fun checkDeleteAll() {
    val tree = data[0].toBinarySearchTree()
    tree?.deleteAll()
    println(tree)
}

private fun checkHeight() {
    data.forEach {
        val tree = it.toBinarySearchTree()
        println(tree?.transversal("pre"))
        println(tree?.height())
        println("******************************************************************")
    }
}

private fun checkDeepest() {
    val tree = data[0].toBinarySearchTree()
    tree?.deepest()
}


fun main() {
    //checkInsert()
    //checkDeleteValue()
    //checkTransversal()
    //checkDeleteAll()
    //checkHeight()
    checkDeepest()
}