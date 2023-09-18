package com.example.algorithms.leetcode.backtracking

/**
 * 39
 * https://leetcode.com/problems/combination-sum/
 */
class CombinationSum {
    val res = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        var i = 0
        while (i < candidates.size) {
            combine(candidates, target, i++, listOf(), 0)
        }
        return res
    }

    private fun combine(
        candidates: IntArray,
        target: Int,
        index: Int,
        possibleRes: List<Int>,
        sum: Int
    ) {
        var num = candidates[index]
        val sumNumbers = mutableListOf<Int>().apply { addAll(possibleRes) }
        while (num + sum <= target) {
            sumNumbers.add(candidates[index])
            if (num + sum == target) {
                res.add(sumNumbers)
                return
            }
            var j = index + 1
            while (j < candidates.size) {
                combine(candidates, target, j++, sumNumbers, sum + num)
            }
            num += candidates[index]
        }
    }
}