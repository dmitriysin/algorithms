package com.example.algorithms.leetcode

/**
 *219
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
class ContainsDuplicateII {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        var i = 0
        while (i < nums.size) {
            val prevIndex = map[nums[i]]
            if (prevIndex != null && (i - prevIndex) <= k) return true
            map[nums[i]] = i++
        }
        return false
    }
}