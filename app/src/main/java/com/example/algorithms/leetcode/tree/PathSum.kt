package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

class PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return calculate(root, targetSum, 0)
    }

    private fun calculate(root: TreeNode?, targetSum: Int, sum: Int): Boolean {
        if (root == null) return false
        if ((root.`val` + sum) == targetSum && root.left == null && root.right == null) return true
        return calculate(root.left, targetSum, sum + root.`val`)
                || calculate(root.right, targetSum, sum + root.`val`)
    }
}