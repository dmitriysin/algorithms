package com.example.algorithms.leetcode

/**
 * 209
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class MinSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var res = 0
        var i = 0
        var j = 0
        var sum = 0
        while (i < nums.size) {
            sum += nums[i++]
            while (sum >= target) {
                res = if (res != 0) {
                    Math.min(res, i - j)
                } else i - j

                sum -= nums[j++]
            }
        }
        return res
    }
}