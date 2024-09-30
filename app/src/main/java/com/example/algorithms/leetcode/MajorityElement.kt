package com.example.algorithms.leetcode

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
            if (map.getOrDefault(num, 0) > nums.size / 2) return num
        }
        return -1
    }
}