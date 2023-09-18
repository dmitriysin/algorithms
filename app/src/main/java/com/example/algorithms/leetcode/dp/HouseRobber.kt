package com.example.algorithms.leetcode.dp

/**
 * 198
 * https://leetcode.com/problems/house-robber/
 */
class HouseRobber {
    fun rob(nums: IntArray): Int {
        val dp = arrayOfNulls<Int>(nums.size)
        return calculate(nums, 0, dp)
    }

    private fun calculate(nums: IntArray, i: Int, dp: Array<Int?>): Int {
        if (i !in nums.indices) return 0

        dp[i]?.let { return it }

        dp[i] = Math.max(nums[i] + calculate(nums, (i + 2), dp), calculate(nums, (i + 1), dp))

        return requireNotNull(dp[i])
    }
}