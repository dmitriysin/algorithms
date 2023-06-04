package com.example.algorithms.leetcode

class MergeSortedArray {

    /**
     * [1,3,5,0,0,0]
     *
     * [2,4,6]
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1
        if (n == 0) return
        while (k >= 0) {
            when {
                i >= 0 && j >= 0 -> {
                    if (nums1[i] > nums2[j]) {
                        nums1[k] = nums1[i--]
                    } else {
                        nums1[k] = nums2[j--]
                    }
                }
                i >= 0 && j < 0 -> {
                    nums1[k] = nums1[i--]
                }
                i < 0 && j >= 0 -> {
                    nums1[k] = nums2[j--]
                }
            }
            k--
        }
    }
}