package com.example.algorithms.leetcode.hashmap

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var i = 0
        var j = 0
        val map = mutableMapOf<Int, List<Set<Int>>>()
        while (i <= nums.lastIndex - 1) {
            j = i + 1
            while (j <= nums.lastIndex) {
                val num = nums[i] + nums[j]
                if (map.containsKey(num)) {
                    map[num] = map[num]!! + listOf(setOf(i, j))
                } else {
                    map[num] = listOf(setOf(i, j))
                }
                j++
            }
            i++
        }
        i = 0
        val res = mutableSetOf<List<Int>>()
        while (i <= nums.lastIndex) {
            val list = map[-nums[i]]
            if (list != null) {
                val validSets = validSets(list, i)
                for (set in validSets) {
                    val listRes = mutableListOf<Int>()
                    for (m in set) {
                        listRes.add(nums[m])
                    }
                    listRes.add(nums[i])
                    res.add(listRes.apply { sort() })
                }
            }
            i++
        }

        return res.transformRes()
    }

    private fun Set<List<Int>>.transformRes(): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        for (set in this) {
            res.add(set.toList())
        }

        return res
    }

    private fun validSets(list: List<Set<Int>>, i: Int): List<Set<Int>> {
        val res = mutableListOf<Set<Int>>()
        for (set in list) {
            if (!set.contains(i)) res.add(set)
        }
        return res.toList()
    }
}