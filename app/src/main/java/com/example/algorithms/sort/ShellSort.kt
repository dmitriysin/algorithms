package com.example.algorithms.sort

class ShellSort {
    fun sort(nums: IntArray) {
        var h = 1
        while (h < nums.size / 3) h = 3 * h + 1
        var i = h
        while (h >= 1) {
            while (i + h < nums.size) {
                var j = i + h
                while (j - h >= 0) {
                    if (nums[j - h] > nums[j]) {
                        val num = nums[j - h]
                        nums[j - h] = nums[j]
                        nums[j] = num
                    }
                    j--
                }
                i++
            }
            h /= 3
        }
    }
}