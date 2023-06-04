package com.example.algorithms.leetcode

import kotlin.system.measureTimeMillis

class IntersectionTwoArrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        val numsL = if (nums1.size >= nums2.size) {
            nums1
        } else {
            nums2
        }
        val numsS = if (nums1.size < nums2.size) {
            nums1
        } else {
            nums2
        }
        for (num in numsS) {
            map[num] = (map.getOrDefault(num, 0) + 1)
        }

        val list = ArrayList<Int>()
        var i = 0
        while (i < numsL.size) {
            val mapValue = map[numsL[i]]
            if (mapValue != null && mapValue > 0) {
                list.add(numsL[i])
                map[numsL[i]] = mapValue - 1
            }
            i++
        }
        return list.toIntArray()
    }

    fun measure(nums1: IntArray, nums2: IntArray) = measureTimeMillis {
        intersect(nums1, nums2)
    }
}