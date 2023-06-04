package com.example.algorithms.sort

class Insertion {

    /**
     * [1,0,3,2]
     * [0,1,3,2]
     * [0,1,3,2]
     */
    fun sort(nums: IntArray) {
        var i = 0
        while (i + 1 < nums.size) {
            var j = i + 1
            while (j - 1 >= 0) {
                if (nums[j - 1] > nums[j]) {
                    val num = nums[j - 1]
                    nums[j - 1] = nums[j]
                    nums[j] = num
                }
                j--
            }
            i++
        }
    }
}