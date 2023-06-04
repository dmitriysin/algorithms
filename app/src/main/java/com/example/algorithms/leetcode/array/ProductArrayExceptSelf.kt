package com.example.algorithms.leetcode.array


/**
 * 238
 * https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&id=top-interview-150
 */
class ProductArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val forward = IntArray(nums.size)
        forward[0] = nums[0]
        val backward = IntArray(nums.size)
        backward[backward.lastIndex] = nums.last()

        for (i in 1..nums.lastIndex) {
            forward[i] = forward[i - 1] * nums[i]
        }
        for (i in nums.lastIndex - 1 downTo 0) {
            backward[i] = backward[i + 1] * nums[i]
        }

        val res = IntArray(nums.size)
        res[0] = backward[1]
        res[res.lastIndex] = forward[res.lastIndex - 1]
        for (i in 1 until nums.lastIndex) {
            res[i] = forward[i - 1] * backward[i + 1]
        }
        return res
    }
}