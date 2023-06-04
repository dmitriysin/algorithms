package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

/**
 * 100
 * https://leetcode.com/problems/same-tree/
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return when {
            p == null || q == null -> p == q
            p.`val` != q.`val` -> false
            else -> isSameTree(q.left, p.left) && isSameTree(q.right, p.right)
        }
    }
}