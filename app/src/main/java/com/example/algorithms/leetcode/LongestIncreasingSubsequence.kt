package com.example.algorithms.leetcode

/**
 * 300 https://leetcode.com/problems/longest-increasing-subsequence/
 */
class LongestIncreasingSubsequence {
    private var res = 0
    fun lengthOfLIS(nums: IntArray): Int {
        var i = 0
        while (i < nums.size) {
            var j = i + 1
            while (j < nums.size) {
                val a = nums[i]
                val b = nums[j]
                if (nums[j] > nums[i]) {
                    search(nums, i, j)
                }
                j++
            }
            i++
        }
        return res
    }

    private fun search(nums: IntArray, first: Int, start: Int, prevCount: Int = 1) {
        var max = nums[first]
        var count = prevCount
        var i = start
        while (i < nums.size) {
            val n = nums[i]
            if (nums[i] > max) {
                count++
                max = nums[i]
            }
           i++
        }
        if (count > res) {
            res = count
        }
    }

    val arr1 = intArrayOf(0, 1, 0, 3, 2, 3)

    fun fregw() {

    }
}