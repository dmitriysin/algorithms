package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

/**
 * 404
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 */
class SumLeftLeaves {
    var sum = 0
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        calculate(root)
        return sum
    }

    private fun calculate(root: TreeNode?, leftNode: Boolean = false) {
        if (root == null) return
        if (root.left == null && root.right == null && leftNode) sum += root.`val`
        calculate(root.left, true)
        calculate(root.right)
    }
}