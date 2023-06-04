package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import kotlin.math.max

class MaximumDepth {

    var n = 0
    fun maxDepth(root: TreeNode?): Int {
        search(root, 0)
        return n
    }

    private fun search(node: TreeNode?, k: Int) {
        if (node == null) {
            n = max(n, k)
            return
        }
        search(node.left, k + 1)
        search(node.right, k + 1)
    }
}