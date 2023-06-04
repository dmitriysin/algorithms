package com.example.algorithms.leetcode

class FirstUniqueCharacter {

    /**
     * dddccdbba
     */

    fun firstUniqChar(s: String): Int {
        val map = HashMap<Char, Int>()
        var i = 0
        while (i < s.length) {
            if (map.contains(s[i]).not()) {
                map[s[i]] = 1
            } else {
                map[s[i]] = requireNotNull(map[s[i]]) + 1
            }
            i++
        }
        for ((index, char) in s.withIndex()) {
            if (map[char] == 1) return index
        }
        return -1
    }
}