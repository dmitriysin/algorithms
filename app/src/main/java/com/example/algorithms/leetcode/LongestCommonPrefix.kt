package com.example.algorithms.leetcode

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = strs[0]

        var strsArrIndex = 1
        while (strsArrIndex < strs.size) {
            val string = strs[strsArrIndex]
            var index = 0
            val prefixSize = prefix.length
            while (index < prefixSize) {
                if (index < string.length) {
                    if (prefix[index] != string[index]) {
                        prefix = prefix.substring(0, index)
                        index = prefixSize
                    } else {
                        index++
                    }
                } else {
                    prefix = prefix.substring(0, index)
                    index = prefixSize
                }
            }
            strsArrIndex++
        }
        return prefix
    }
}