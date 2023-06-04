package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
class PalindromeValid {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.lastIndex
        var isPalindrome = true
        while (i < j) {
            while (s[i].isLetterOrDigit().not()) {
                if (i == s.lastIndex) break
                i++
            }
            while (s[j].isLetterOrDigit().not()) {
                if (j == 0) break
                j--
            }
            if (i > j) return isPalindrome
            if (s[i].equals(s[j], ignoreCase = true)) {
                i++
                j--
                isPalindrome = true
            } else {
                return false
            }
        }
        return isPalindrome
    }
}
