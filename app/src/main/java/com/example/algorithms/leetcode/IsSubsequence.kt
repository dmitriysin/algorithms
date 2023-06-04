package com.example.algorithms.leetcode

/**
 * 392
 * https://leetcode.com/problems/is-subsequence/
 */
class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while (i < s.length) {
            while (j < t.length && s[i] != t[j]) j++
            if (i <= s.lastIndex && j > t.lastIndex) return false
            i++
            j++
        }
        return true
    }
}