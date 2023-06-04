package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode

class BinaryTreeFromPreorderAndInorder {
    /**
     * [25,15,50,10,22,35,70,4,12,18,24,31,44,66,90] - tree
     * [4,10,12,15,18,22,24,25,31,35,44,50,66,70,90] - inorder
     * [25,15,10,4,12,22,18,24,50,35,31,44,70,66,90] - preorder
     * [10,15,22,25,35,50,70]
     * [90,]
     */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return create(preorder, inorder, 0, preorder.lastIndex, 0)
    }

    private fun create(preorder: IntArray, inorder: IntArray, start: Int, end: Int, index: Int): TreeNode? {
        if (start > end || (index in preorder.indices).not()) return null
        val node = TreeNode(preorder[index])
        var position = start
        for (i in start..end) {
            if (preorder[index] == inorder[i]) position = i
        }
        node.left = create(preorder, inorder, start, position - 1, index + 1)
        node.right = create(preorder, inorder, position + 1, end, index + 1 + position - start)
        return node
    }
}
