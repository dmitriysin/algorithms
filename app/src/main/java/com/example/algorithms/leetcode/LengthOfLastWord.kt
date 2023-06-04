package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var i = s.lastIndex
        while (i >= 0) {
            if (s[i] == ' ') {
                i--
            } else {
                var j = 0
                while (i >= 0 && s[i] != ' ') {
                    i--
                    j++
                }
                return j
            }
        }
        return s.length
    }
}