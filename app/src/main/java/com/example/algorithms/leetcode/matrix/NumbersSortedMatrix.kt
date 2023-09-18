package com.example.algorithms.leetcode.matrix

/**
 * 1351
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 */
class NumbersSortedMatrix {
    fun countNegatives(grid: Array<IntArray>): Int {
        var res = 0
        for (arr in grid) {
            if (arr.last() < 0) {
                val i = findNegativeIndex(arr, 0, arr.lastIndex)
                res += arr.size - i
            }
        }
        return res
    }

    private fun findNegativeIndex(nums: IntArray, start: Int, end: Int): Int {
        val mid = (start + end) / 2
        return when {
            start > end -> -1
            nums[mid] < 0 && (mid == 0 || nums[mid - 1] >= 0) -> mid
            nums[mid] >= 0 && nums[mid + 1] < 0 -> mid + 1
            nums[mid] < 0 -> findNegativeIndex(nums, start, mid - 1)
            else -> findNegativeIndex(nums, mid + 1, end)
        }
    }
}