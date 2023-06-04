package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/two-sum/
 */
internal class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var i = 0
        var j = 1
        while (nums[i] + nums[j] != target) {
            if (j == nums.lastIndex) {
                i++
                j = i + 1
            } else {
                j++
            }
        }
        return intArrayOf(i, j)
    }
}