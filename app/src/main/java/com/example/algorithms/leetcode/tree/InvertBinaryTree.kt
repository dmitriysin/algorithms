package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import java.util.LinkedList
import java.util.Stack

/**
 * 226
 * https://leetcode.com/problems/invert-binary-tree/
 */
class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        invertTree(root.left)
        invertTree(root.right)
        val tmp = root.right
        root.right = root.left
        root.left = tmp
        return root
    }
}