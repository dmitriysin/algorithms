package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
 * 110
 * https://leetcode.com/problems/balanced-binary-tree/
 */
class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return depth(root) != -1
    }

    private fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val left = depth(node.left)
        val right = depth(node.right)
        return when {
            left == -1 || right == -1 || abs(left - right) > 1 -> -1
            else -> 1 + max(left, right)
        }
    }
}