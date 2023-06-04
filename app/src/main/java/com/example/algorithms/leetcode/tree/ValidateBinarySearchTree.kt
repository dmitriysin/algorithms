package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun validate(node: TreeNode?, min: Long, max: Long): Boolean {
        return when {
            node == null -> true
            node.`val` <= min || node.`val` >= max -> false
            else -> validate(node.left, min, node.`val`.toLong())
                    && validate(node.right, node.`val`.toLong(), max)
        }
    }
}