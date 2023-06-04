package com.example.algorithms.leetcode

class MoveZeroes {

    /**
     * [1,0,1]
     * [1,0,0,3,5,0,10]
     * [1,3,0,0,5,0,10]
     * [0,1,0,3,5,10,0]
     */
    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var j = 0
        while (i + 1 < nums.size) {
            if (nums[i + 1] != 0 && nums[j] == 0) {
                nums[j] = nums[i + 1]
                nums[i + 1] = 0
                j++
            }
            if (nums[j] != 0) j++
            i++
        }
    }

    fun moveZeroes1(nums: IntArray): Unit {
        var i = nums.lastIndex
        while (i >= 0) {
            if (nums[i] == 0) {
                var j = i
                while (j + 1 < nums.size && nums[j + 1] != 0) {
                    nums[j] = nums[j + 1]
                    nums[j + 1] = 0
                    j++
                }
            }
            i--
        }
    }
}