package com.example.algorithms.leetcode

class NumberGoodPairs {
    fun numIdenticalPairs(nums: IntArray): Int {
        val map = HashMap<Int, MutableList<Int>>()

        var i = 0
        while (i < nums.size) {
            map[nums[i]]?.let {
                it.add(i)
            } ?: kotlin.run { map[nums[i]] = mutableListOf(i) }
            i++
        }

        var res = 0
        for (entry in map) {
            val value = entry.value
            var i = 0
            while (i < value.size) {
                res += value.lastIndex - i++
            }

        }
        return res
    }
}