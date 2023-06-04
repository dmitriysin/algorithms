package com.example.algorithms.leetcode

class LongestSubstring3 {

    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Int, Char>()
        val charsArray = s.toCharArray()

        var left = 0
        var right = 0
        var maxLength = 0
        while (right < charsArray.size) {
            val value = charsArray[right]
            if (map.containsValue(value)) {
                val mapSize = right - left
                maxLength = mapSize.takeIf { maxLength < mapSize } ?: maxLength

                while (map.containsValue(value)) {
                    map.remove(left)
                    left++
                }
            }
            map[right] = value
            right++
        }
        return maxLength.takeIf { maxLength > right - left } ?: (right - left)
    }
}

