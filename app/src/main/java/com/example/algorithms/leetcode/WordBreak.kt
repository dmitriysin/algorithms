package com.example.algorithms.leetcode

/**
 * 139
 * https://leetcode.com/problems/word-break/
 */
class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val set = HashSet<String>(wordDict)
        val cache = arrayOfNulls<Boolean>(s.length)
        return search(s, set, cache)
    }

    private fun search(s: String, set: HashSet<String>, cache: Array<Boolean?>): Boolean {
        if (s == "") return true
        var i = 1
        while (i <= s.length) {
            if (set.contains(s.substring(0, i))) {
                when {
                    cache[s.length - i] == true -> return true
                    cache[s.length - i] == null -> {
                        if (search(s.substring(i, s.length), set, cache)) {
                            cache[s.length - i] = true
                            return true
                        } else {
                            cache[s.length - i] = false
                        }
                    }
                }
            }
            i++
        }
        return false
    }
}