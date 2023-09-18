package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

class BinaryTreePaths {
    private val arrow = "->"
    private val res = mutableListOf<String>()
    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return res
        val s = "${root.`val`}"
        if (root.left == null && root.right == null) {
            res.add(s)
            return res
        }
        findPath(root.right, s)
        findPath(root.left, s)
        return res
    }

    private fun findPath(root: TreeNode?, prevPath: String) {
        if (root == null) return
        StringBuilder(StringBuilder())
        val path = prevPath + "$arrow${root.`val`}"
        if (root.left == null && root.right == null) {
            res.add(path)
            return
        }
        findPath(root.right, path)
        findPath(root.left, path)
    }
}