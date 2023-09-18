package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

/**
 * 114
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class FlattenToLinkedList {
    private val stack = ArrayDeque<TreeNode>()
    fun flatten(root: TreeNode?) {
        flat(root, null)
    }

    private fun flat(root: TreeNode?, prev: TreeNode?) {
        if (root == null) {
            if (stack.isEmpty()) {
                return
            }
            val node = stack.removeLast()
            prev?.right = node
            flat(node, prev)
        }
        val right = root?.right
        val left = root?.left
        root?.right = left
        root?.left = null
        right?.let { stack.add(it) }
        flat(left, root)
    }
}