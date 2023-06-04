package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        for (num in nums) {
            set.add(num)
        }
        return set.size != nums.size
    }
}