package src.com.br.cp.ds.trees.judgonline.bst.leetcode

import src.com.br.cp.ds.trees.bst.Tree

// https://leetcode.com/problems/binary-tree-level-order-traversal/

class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun TreeNode.insert(value: Int): TreeNode {

    fun insert(root: TreeNode?, value: Int): TreeNode {
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


class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        return listOf()
    }
}


fun main() {
    val solution = Solution()
}