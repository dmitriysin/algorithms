package com.example.algorithms.leetcode.array


/**
 * 334
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
class IncreasingTripletSubsequence {
    /**
     * [6,8,7,1,9]
     */
    fun increasingTriplet(nums: IntArray): Boolean {
        var min = Int.MAX_VALUE
        var mid = Int.MAX_VALUE
        for (n in nums) {
            when {
                n < min -> min = n
                n in (min + 1) until mid -> mid = n
                n > mid -> return true
            }
        }
        return false
    }
}