package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/ransom-note/description/
 */
class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = HashMap<Char, Int>()
        for (char in magazine) {
            val count = map.getOrDefault(char, 0)
            map[char] = count + 1
        }
        for (char in ransomNote) {
            val count = map.getOrDefault(char, 0)
            if (count == 0) {
                return false
            } else {
                map[char] = count - 1
            }
        }
        return true
    }
}