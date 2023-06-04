package com.example.algorithms.leetcode


/**
 * https://leetcode.com/problems/word-pattern/
 */
class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val spl = s.split(' ')
        var i = 0
        val map = HashMap<Char, String>()
        val values = HashSet<String>()
        if (pattern.length != spl.size) return false
        while (i < pattern.length) {
            if (map.contains(pattern[i])) {
                if (map[pattern[i]] != spl[i]) return false
            } else {
                map[pattern[i]] = spl[i]
                values.add(spl[i])
            }
            i++
        }
        if (values.size != map.size) return false
        return true
    }
}