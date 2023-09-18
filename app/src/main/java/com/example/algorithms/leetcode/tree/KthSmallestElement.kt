package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

/**
 * 230
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
class KthSmallestElement {
    var i = 0
    var res = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        find(root, k)
        return res
    }

    private fun find(root: TreeNode?, k: Int) {
        if (root == null) return
        find(root.left, k)
        i++
        if (i == k) {
            res = root.`val`
            return
        }
        find(root.right, k)
    }
}