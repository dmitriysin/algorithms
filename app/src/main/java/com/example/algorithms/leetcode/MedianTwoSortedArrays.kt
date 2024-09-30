package com.example.algorithms.leetcode

class MedianTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var i = 0
        var j = 0
        val resArray = mutableListOf<Int>()
        while (i < nums1.size || j < nums2.size) {
            if (i in nums1.indices && j in nums2.indices) {
                if (nums1[i] <= nums2[j]) {
                    resArray.add(nums1[i++])
                } else {
                    resArray.add(nums2[j++])
                }

            } else if (i in nums1.indices) {
                resArray.add(nums1[i++])
            } else if (j in nums2.indices) {
                resArray.add(nums2[j++])
            }
        }
        val median = if (resArray.lastIndex % 2 == 0) {
            resArray[resArray.lastIndex / 2].toDouble()
        } else {
            (resArray[resArray.lastIndex / 2] + resArray[(resArray.lastIndex / 2 + 1)]).toDouble().div(2)
        }
        return median
    }
}