package com.example.algorithms.leetcode

class Duplicates {
    fun notDuplicateCount(nums: IntArray): Int {
        val numbers = listOf("one", "two", "three", "four")
        var j = 0
        for (i in nums.indices) {
            if (nums[i] != nums[j]) {
                j++
                nums[j] = nums[i]
            }
        }
        return j+1
    }
}