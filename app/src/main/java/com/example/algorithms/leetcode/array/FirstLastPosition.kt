package com.example.algorithms.leetcode.array

/**
 * 34
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
class FirstLastPosition {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val position = search(0, nums.lastIndex, nums, target)
        if (position == -1) return intArrayOf(-1, -1)

        var r = position
        while (r + 1 <= nums.lastIndex && nums[r + 1] == target) {
            r = search(r + 1, nums.lastIndex, nums, target)
        }

        var l = position
        while (l - 1 >= 0 && nums[l - 1] == target) {
            l = search(0, l - 1, nums, target)
        }

        return intArrayOf(l, r)
    }

    fun search(i: Int, j: Int, nums: IntArray, target: Int): Int {
        val mid = (i + j) / 2
        return when {
            i > j -> -1
            nums[mid] == target -> mid
            nums[mid] < target -> search(mid + 1, j, nums, target)
            else -> search(i, mid - 1, nums, target)
        }
    }
}