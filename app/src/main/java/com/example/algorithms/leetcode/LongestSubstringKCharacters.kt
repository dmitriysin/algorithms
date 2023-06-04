package com.example.algorithms.leetcode

import kotlin.math.max

class LongestSubstringKCharacters {
    fun longestSubstring(s: String, k: Int): Int {
        val map = HashMap<Char, Int>()
        for (char in s) {
            map[char] = map.getOrDefault(char, 0) + 1
        }

        var res = 0
        var length = 0
        for (char in s) {
            if (requireNotNull(map[char]) >= k) length++
            else {
                res = max(res, length)
                length = 0
            }
        }
        return res
    }
}