package src.com.br.cp.ds.trees.bst.rec


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

class TreeNode<T : Comparable<T>>(var value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null)

fun <T : Comparable<T>> TreeNode<T>.insert(value: T): TreeNode<T> {
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

val <T : Comparable<T>> TreeNode<T>.isLeaf: Boolean
    get() = left == null && right == null

fun <T : Comparable<T>> TreeNode<T>.transversal(type: String): String {
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
            preOrder(root.left, buffer)
            if (buffer.isEmpty()) {
                buffer.append("${root.value}")
            } else {
                buffer.append(", ${root.value}")
            }
            preOrder(root.right, buffer)
        }
    }

    fun posOrder(root: TreeNode<T>?, buffer: StringBuilder) {
        if (root != null) {
            preOrder(root.left, buffer)
            preOrder(root.right, buffer)
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

fun <T : Comparable<T>> TreeNode<T>.has(value: T): Boolean {
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

fun <T : Comparable<T>> TreeNode<T>.deleteValue(value: T): TreeNode<T>? {
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
fun <T : Comparable<T>> TreeNode<T>.deleteAll() {
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
    data.forEach {
        val tree = it.toBinarySearchTree()
        val a = tree?.transversal("in")
        val b = tree?.transversal("pre")
        val c = tree?.transversal("pos")
        println("$a\n$b\n$c")
    }
}

private fun checkDeleteAll() {
    val tree = data[0].toBinarySearchTree()
    tree?.deleteAll()
    println(tree)
}


fun main() {
    //checkInsert()
    //checkDeleteValue()
    //checkTransversal()
    checkDeleteAll()
}