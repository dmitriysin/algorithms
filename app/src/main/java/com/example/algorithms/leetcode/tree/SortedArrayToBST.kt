package com.example.algorithms.leetcode.tree

import com.example.algorithms.infrastructure.TreeNode
import kotlin.math.abs
import kotlin.math.max

/**
 * 108
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class SortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return construct(nums, 0, nums.lastIndex)
    }

    private fun construct(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val m = (start + end) / 2
        val node = TreeNode(nums[m])
        node.left = construct(nums, start, m - 1)
        node.right = construct(nums, m + 1, end)
        return node
    }
}