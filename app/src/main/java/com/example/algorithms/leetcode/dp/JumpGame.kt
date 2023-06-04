package com.example.algorithms.leetcode.dp

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) return true
        val dp = arrayOfNulls<Boolean>(nums.size)
        dp[nums.lastIndex] = false
        jump(0, nums, dp)
        return requireNotNull(dp[nums.lastIndex])
    }

    private fun jump(index: Int, nums: IntArray, dp: Array<Boolean?>) {
        for (i in 1..nums[index]) {
            if ((index + i) >= nums.lastIndex) {
                dp[nums.lastIndex] = true
                return
            } else {
                if (dp[index + i] == null) {
                    jump(index + i, nums, dp)
                }
            }
            dp[index] = false
        }
    }

    fun canJump1(nums: IntArray): Boolean {
        if (nums.size == 1) return true

        var possibleJump = nums.lastIndex
        var i = nums.lastIndex - 1
        while (i >= 0) {
            if (nums[i] >= possibleJump - i) possibleJump = i
            i--
        }
        return possibleJump == 0
    }
}