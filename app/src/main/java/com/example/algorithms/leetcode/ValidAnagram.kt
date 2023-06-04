package com.example.algorithms.leetcode

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val map = HashMap<Char, Int>().apply {
            for (char in s) {
                put(char, getOrDefault(char, 0) + 1)
            }
        }
        for (char in t) {
            if (map.contains(char).not()) {
                return false
            } else {
                map[char] = requireNotNull(map[char]) - 1
            }
        }
        for (entry in map) {
            if (entry.value != 0) return false
        }

        return true
    }
}