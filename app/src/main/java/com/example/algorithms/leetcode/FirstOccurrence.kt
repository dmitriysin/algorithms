package com.example.algorithms.leetcode

/**
 * e
 */
class FirstOccurrence {
    fun strStr(haystack: String, needle: String): Int {
        var i = 0
        while (i < haystack.length) {
            if (haystack[i] == needle[0]) {
                if (i + needle.length > haystack.length) return -1

                var j = 0
                while (j < needle.length && haystack[i + j] == needle[j]) {
                    j++
                }
                if (j == needle.length) return i

            }
            i++
        }
        return -1
    }
}