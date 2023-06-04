package com.example.algorithms.leetcode

/**
 * 128
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
class LongestSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var result = 0
        for (num in nums) {
            if (set.contains(num)) {
                var count = 1
                var j = num - 1
                var k = num + 1
                while (set.contains(j)) {
                    count++
                    set.remove(j--)
                }
                while (set.contains(k)) {
                    count++
                    set.remove(k++)
                }
                if (count > result) result = count
            }
        }
        return result
    }
}

