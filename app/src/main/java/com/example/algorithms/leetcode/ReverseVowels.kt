package com.example.algorithms.leetcode

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
class ReverseVowels {
    fun reverseVowels(s: String): String {
        val vowelsSet = HashSet<Char>().apply {
            add('a')
            add('e')
            add('i')
            add('o')
            add('u')
            add('A')
            add('E')
            add('I')
            add('O')
            add('U')
        }

        var i = 0
        var j = s.lastIndex
        val result = s.toCharArray()

        while (i < j) {
            val left = s[i]
            val right = s[j]
            when {
                vowelsSet.contains(left).not() && vowelsSet.contains(right).not() -> {
                    i++
                    j--
                }
                vowelsSet.contains(left) && vowelsSet.contains(right).not() -> {
                    j--
                }
                vowelsSet.contains(left).not() && vowelsSet.contains(right) -> {
                    i++
                }
                vowelsSet.contains(left) && vowelsSet.contains(right) -> {
                    result[i] = s[j]
                    result[j] = s[i]
                    i++
                    j--
                }
            }
        }
        return String(result)
    }
}