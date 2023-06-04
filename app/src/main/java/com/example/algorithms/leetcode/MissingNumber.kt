package com.example.algorithms.leetcode

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val set = HashSet<Int>().apply {
            for (num in nums) {
                add(num)
            }
        }
        var i = 0
        while (i <= nums.size) {
            if (!set.contains(i)) return i
            i++
        }
        return -1
    }

    /**
     * 1+2+3+4+5+6+7+...+n = n(n+1)/2
     * [0,1,2,4,5,7,6,9,8,10]
     */
    fun solution(nums: IntArray): Int {
        var i = 0
        var sum = 0
        while (i < nums.size) sum += nums[i++]

        val n = nums.size
        val nSum = n * (n + 1) / 2

        return nSum - sum
    }
}