package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import java.util.Stack

/**
 *  144
 *  https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
class PreorderTraversal {
    private val list = mutableListOf<Int>()
    fun preorderTraversal(root: TreeNode?): List<Int> {
        constantSpaceTraversal(root)
        return list
    }

    private fun traversal(root: TreeNode?) {
        if (root == null) return
        list.add(root.`val`)
        traversal(root.left)
        traversal(root.right)
    }

    private fun stackTraversal(root: TreeNode?) {
        val stack = Stack<TreeNode>()
        var node = root

        while (node != null || stack.isNotEmpty()) {
            if (node != null) {
                list.add(node.`val`)
                stack.push(node)
                node = node.left
            } else {
                val prevNode = stack.pop()
                node = prevNode.right
            }
        }
    }

    private fun constantSpaceTraversal(root: TreeNode?) {
        var node = root

        while (node != null) {

            if (node.left != null) {
                var currentNode = node.left
                while (currentNode?.right != null && currentNode.right != node) {
                    currentNode = currentNode.right
                }
                if (currentNode?.right == null) {
                    currentNode?.right = node
                    list.add(node.`val`)
                    node = node.left
                } else {
                    currentNode.right = null
                    node = node.right
                }
            } else {
                list.add(node.`val`)
                node = node.right
            }
        }
    }
}