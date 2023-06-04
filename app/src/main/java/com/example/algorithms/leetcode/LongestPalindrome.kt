package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
class LongestPalindrome {
    fun longestPalindrome(s: String): Int {
        var longest = 0
        val map = HashMap<Char, Int>()
        for (char in s) {
            val count = map.getOrDefault(char, 0)
            map[char] = count + 1
            if ((count + 1) % 2 == 0) {
                longest += 2
            }
        }
        if (longest != s.length) longest++
        return longest
    }
}