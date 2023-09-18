package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import kotlin.math.min

/**
 * 111
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
class MinimumDepth {
    var minDepth = Integer.MAX_VALUE
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        dive(root, 1)
        return minDepth
    }

    private fun dive(root: TreeNode?, path: Int) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            minDepth = min(minDepth, path)
            return
        }
        dive(root.left, path + 1)
        dive(root.right, path + 1)
    }
}