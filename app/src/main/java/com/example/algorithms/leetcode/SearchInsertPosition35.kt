package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/search-insert-position/
 */
object SearchInsertPosition35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var endIndex = nums.size - 1

        if (startIndex == endIndex) {
            return when {
                nums[endIndex] == target -> endIndex
                nums[endIndex] > target -> endIndex
                else -> endIndex + 1
            }
        }

        while (startIndex < endIndex && endIndex > 0) {
            val half = (startIndex + endIndex) / 2
            if (nums[half] == target) return half

            if (nums[half] < target) {
                startIndex = half + 1
            } else {
                endIndex = half - 1
            }
        }

        if (endIndex < 0) endIndex = 0

        return if (nums[endIndex] >= target) endIndex else endIndex + 1
    }
}