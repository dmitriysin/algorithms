package com.example.algorithms.leetcode.matrix

/**
 * 240
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
class Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (arr in matrix) {
            if (target >= arr.first() && target <= arr.last()) {
                val res = search(0, arr.lastIndex, arr, target)
                if (res) return true
            }
        }
        return false
    }

    private fun search(i: Int, j: Int, nums: IntArray, target: Int): Boolean {
        val mid = (i + j) / 2
        return when {
            j < i -> false
            nums[mid] == target -> true
            target < nums[mid] -> search(i, mid - 1, nums, target)
            else -> search(mid + 1, j, nums, target)
        }
    }
}
