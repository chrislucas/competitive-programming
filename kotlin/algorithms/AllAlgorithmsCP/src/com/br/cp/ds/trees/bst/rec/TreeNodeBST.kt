package src.com.br.cp.ds.trees.bst.rec

class TreeNode<T : Comparable<T>>(val value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null)

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

fun <T : Comparable<T>> TreeNode<T>.preOrder(): String {
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
    preOrder(this, buffer)
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

fun <T:Comparable<T>> TreeNode<T>.delete(value: T): TreeNode<T>? {
    fun delete(root: TreeNode<T>?, value: T): TreeNode<T>? {
        if (root == null) {
            return null
        } else {
           return root
        }
    }
    return delete(this, value)
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

    println(root.preOrder())
    println(root.has(40))
    println(root.has(40))
    println(root.has(10))

    val tree = arrayOf(50, 30, 70, 20, 40, 60, 80).toBinarySearchTree()
    println(tree?.preOrder())
    println(tree?.has(30))
    println(tree?.has(10))
}


fun main() {
    checkInsert()
}