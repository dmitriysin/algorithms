package com.example.algorithms.leetcode.backtracking


/**
 * 17
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class LetterCombinations {
    fun letterCombinations(digits: String): List<String> {
        val map = mapOf(
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z')
        )
        val nums = digits.toCharArray()
        val charArrs = List(nums.size) { requireNotNull(map[nums[it]]) }

        if (digits.isEmpty()) return listOf()
        val arr = List(charArrs.first().size) { charArrs.first()[it].toString() }

        return combine(arr, charArrs, 1)
    }

    private fun combine(
        prevCombination: List<String>,
        charArrs: List<List<Char>>,
        arrNum: Int
    ): List<String> {
        if (arrNum > charArrs.lastIndex) return prevCombination
        val res = mutableListOf<String>()
        for (char in prevCombination) {
            for (sChar in charArrs[arrNum]) {
                res.add(char + sChar)
            }
        }
        return combine(res, charArrs, arrNum + 1)
    }
}