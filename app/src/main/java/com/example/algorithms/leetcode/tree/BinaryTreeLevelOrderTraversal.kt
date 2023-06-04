package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import java.util.LinkedList

/**
 * 102
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()
        val res = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            res += queue.toList().map { it.`val` }
            for (i in queue.indices) {
                val node = queue.poll()
                node?.left?.let { queue.add(it) }
                node?.right?.let { queue.add(it) }
            }
        }
        return res
    }
}