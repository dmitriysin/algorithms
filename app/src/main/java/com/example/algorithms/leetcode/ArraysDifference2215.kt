package com.example.algorithms.leetcode

class ArraysDifference2215 {

    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        return listOf(findDiff(nums1, nums2), findDiff(nums2, nums1))
    }

    fun findDiff(nums1: IntArray, nums2: IntArray): List<Int> {
        var add = true
        val diff = mutableListOf<Int>()
        for(n in nums1) {
                for (m in nums2) {
                    if(n == m)  {
                        add = false
                        break
                    }
                }
            for (k in diff) {
                if(k == n) {
                    add = false
                    break
                }
            }
            if(add) diff.add(n)
            add = true
        }
        return diff
    }

    fun findDiff2() {

    }
}