package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import java.util.Stack


/**
 * 94
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
class InorderTraversal {
    val list = mutableListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        inorderRecursion(root)
        return list
    }

    private fun inorderRecursion(root: TreeNode?) {
        if (root == null) return
        inorderTraversal(root.left)
        list.add(root.`val`)
        inorderTraversal(root.right)
    }

    private fun inorder(root: TreeNode?) {
        val stack = Stack<TreeNode>()
        var node = root

        while (stack.isNotEmpty() || node != null) {
            node = if (node != null) {
                stack.push(node)
                node.left
            } else {
                val popped = stack.pop()
                list.add(popped.`val`)
                popped?.right
            }
        }
    }
}