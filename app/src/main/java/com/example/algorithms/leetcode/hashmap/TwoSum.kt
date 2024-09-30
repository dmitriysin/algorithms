package com.example.algorithms.leetcode.hashmap

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        val res = mutableListOf<Int>()

        for (n in nums.withIndex()) {
            if(map.containsKey(target-n.value)) {
                return intArrayOf(map[target-n.value]!!, n.index)
            }
            map[n.value] = n.index
        }
        return res.toIntArray()
    }
}