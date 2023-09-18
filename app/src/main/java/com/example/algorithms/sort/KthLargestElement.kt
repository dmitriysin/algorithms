package com.example.algorithms.sort

/**
 * 215
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
class KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var p = 0
        var end = nums.lastIndex
        nums.shuffle()
        while (true) {
            val index = partition(nums, p, end)
            if (index > nums.size - k) end = index - 1
            else if (index < nums.size - k) p = index + 1
            else return nums[index]
        }
    }

    private fun partition(nums: IntArray, p: Int, end: Int): Int {
        var i = p + 1
        if (i !in nums.indices) return p
        var j = end
        while (true) {
            while (nums[i] <= nums[p]) {
                i++
                if (i > end) break
            }
            while (nums[j] > nums[p]) {
                j--
                if (j < i) break
            }

            if (j < i) break
            exchange(nums, i, j)
        }
        exchange(nums, p, j)
        return j
    }

    private fun exchange(nums: IntArray, i: Int, j: Int) {
        val n = nums[i]
        nums[i] = nums[j]
        nums[j] = n
    }
}

