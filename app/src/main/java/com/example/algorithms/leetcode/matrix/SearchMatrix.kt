package com.example.algorithms.leetcode.matrix

/**
 * 74
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
class SearchMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (arr in matrix) {
            if (arr.first() <= target && arr.last() >= target) {
                return search(arr, target)
            }
        }
        return false
    }

    fun search(nums: IntArray, target: Int): Boolean {
        var i = 0
        var j = nums.lastIndex
        while (i <= j) {
            val n = (i + j) / 2
            when (target.compareTo(nums[n])) {
                0 -> return true
                -1 -> j = n - 1
                1 -> i = n + 1
            }
        }
        return false
    }
}