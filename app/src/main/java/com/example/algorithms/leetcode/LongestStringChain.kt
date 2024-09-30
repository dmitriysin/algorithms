package com.example.algorithms.leetcode

class LongestStringChain {
    fun longestStrChain(words: Array<String>): Int {
        val set = HashSet<String>()

        for (w in words) set.add(w)
        var res = 0
        for (word in words) {
            var i = 1
            while (i < word.length) {
                val newWord = word.substring(0, i - 1) + word.substring(i + 1, word.length)
                if (set.contains(newWord)) {
                    set.remove(newWord)
                    res++
                }
                i++
            }
        }
        return -1
    }
}