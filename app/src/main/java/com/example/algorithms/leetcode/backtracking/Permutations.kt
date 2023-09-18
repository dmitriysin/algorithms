package com.example.algorithms.leetcode.backtracking

/**
 * 46
 * https://leetcode.com/problems/permutations/
 */
class Permutations {
    
    private val res: MutableList<List<Int>> = mutableListOf()
    fun permute(nums: IntArray): List<List<Int>> {
        calculate(0, nums, listOf())
        return res
    }

    private fun calculate(start: Int, nums: IntArray, combine: List<Int>) {
        var i = start
        while (i < nums.size) {
            val n = nums[start]
            val n1 = nums[i]
            nums[start] = n1
            nums[i] = n
            calculate(start + 1, nums, combine + n1)
            nums[i] = n1
            nums[start] = n
            i++
        }
        if (combine.size == nums.size) {
            res.add(combine)
        }
    }
}