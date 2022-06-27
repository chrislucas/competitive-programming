package src.com.br.cp.ds.trees.bintree

/*
    https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
    https://www.geeksforgeeks.org/deletion-binary-tree/
 */

class TreeNode<T : Comparable<T>>(val value: T, var le: TreeNode<T>? = null, var ri: TreeNode<T>? = null)  {
    fun insert(value: T) {
        fun insert(root: TreeNode<T>, value: T) {

        }

        insert(this, value)
    }
}



fun main() {

}