package com.example.algorithms.leetcode.priorityheap

/**
 * 215
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
class KthLargestElementArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var i = nums.lastIndex / 2
        while (i >= 0) sink(nums, i--)

        for (m in k downTo 2) {
            nums[0] = Int.MIN_VALUE
            exchange(nums, 0, nums.lastIndex)
            sink(nums, 0)
        }
        return nums[0]
    }

    private fun sink(nums: IntArray, k: Int) {
        var i = k
        while (2 * i + 1 < nums.size) {
            if (heapOrder(nums, i)) break
            val max = maxIndex(nums, 2 * i + 1, 2 * i + 2)
            exchange(nums, i, max)
            i = max
        }
    }

    private fun maxIndex(nums: IntArray, i: Int, j: Int): Int {
        return i.takeIf { j !in nums.indices || nums[i] > nums[j] } ?: j
    }

    private fun exchange(nums: IntArray, i: Int, j: Int) {
        val n = nums[i]
        nums[i] = nums[j]
        nums[j] = n
    }

    private fun heapOrder(nums: IntArray, i: Int): Boolean {
        return when {
            nums[i] > nums[2 * i + 1] && 2 * i + 2 !in nums.indices -> true
            nums[i] > nums[2 * i + 1] && nums[i] > nums[2 * i + 2] -> true
            else -> false
        }
    }
}
