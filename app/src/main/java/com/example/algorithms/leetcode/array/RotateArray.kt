package com.example.algorithms.leetcode.array

/**
 * 189
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&id=top-interview-150
 */
class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.size == k) return

        val n = k.takeIf { k < nums.size } ?: (k % nums.size)

        val helper = IntArray(n) { nums[nums.size - n + it] }

        var i = nums.lastIndex - n
        while (i >= 0) {
            nums[i + n] = nums[i--]
        }

        var j = 0
        while (j < helper.size) {
            nums[j] = helper[j++]
        }
    }
}