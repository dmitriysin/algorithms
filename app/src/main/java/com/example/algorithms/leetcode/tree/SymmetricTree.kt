package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode


/**
 * 101
 */
class SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean {
        return compare(root?.left, root?.right)
    }

    private fun compare(left: TreeNode?, right: TreeNode?): Boolean {
        return when {
            left == null || right == null -> left == right
            left.`val` != right.`val` -> false
            else -> compare(left.left, right.right) && compare(left.right, right.left)
        }
    }
}