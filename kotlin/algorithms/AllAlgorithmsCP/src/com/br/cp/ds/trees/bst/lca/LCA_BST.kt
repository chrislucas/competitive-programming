package src.com.br.cp.ds.trees.bst.lca

/*
    https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

private class TreeNode<T : Comparable<T>>(var value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {

    private val isLeaf: Boolean
        get() = left == null && right == null
}

fun main() {

}