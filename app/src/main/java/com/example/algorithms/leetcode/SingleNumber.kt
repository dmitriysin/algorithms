package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/single-number/description/
 */
class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        val set = HashSet<Int>()
            for(i in nums.indices) {
                if(set.contains(nums[i])) {
                    set.remove(nums[i])
                } else {
                    set.add(nums[i])
                }
            }
        return set.first()
    }
}